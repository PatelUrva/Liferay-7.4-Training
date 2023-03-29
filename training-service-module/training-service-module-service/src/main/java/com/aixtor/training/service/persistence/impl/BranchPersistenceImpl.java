/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.aixtor.training.service.persistence.impl;

import com.aixtor.training.exception.NoSuchBranchException;
import com.aixtor.training.model.Branch;
import com.aixtor.training.model.BranchTable;
import com.aixtor.training.model.impl.BranchImpl;
import com.aixtor.training.model.impl.BranchModelImpl;
import com.aixtor.training.service.persistence.BranchPersistence;
import com.aixtor.training.service.persistence.BranchUtil;
import com.aixtor.training.service.persistence.impl.constants.FOOPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the branch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {BranchPersistence.class, BasePersistence.class})
public class BranchPersistenceImpl
	extends BasePersistenceImpl<Branch> implements BranchPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BranchUtil</code> to access the branch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BranchImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the branches where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching branches
	 */
	@Override
	public List<Branch> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the branches where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @return the range of matching branches
	 */
	@Override
	public List<Branch> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the branches where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the branches where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Branch> list = null;

		if (useFinderCache) {
			list = (List<Branch>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Branch branch : list) {
					if (!uuid.equals(branch.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BRANCH_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Branch>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findByUuid_First(
			String uuid, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchByUuid_First(uuid, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the first branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchByUuid_First(
		String uuid, OrderByComparator<Branch> orderByComparator) {

		List<Branch> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findByUuid_Last(
			String uuid, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchByUuid_Last(uuid, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the last branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchByUuid_Last(
		String uuid, OrderByComparator<Branch> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Branch> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the branches before and after the current branch in the ordered set where uuid = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch[] findByUuid_PrevAndNext(
			long branchId, String uuid,
			OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		uuid = Objects.toString(uuid, "");

		Branch branch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			Branch[] array = new BranchImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, branch, uuid, orderByComparator, true);

			array[1] = branch;

			array[2] = getByUuid_PrevAndNext(
				session, branch, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Branch getByUuid_PrevAndNext(
		Session session, Branch branch, String uuid,
		OrderByComparator<Branch> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BRANCH_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(branch)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Branch> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the branches where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Branch branch :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(branch);
		}
	}

	/**
	 * Returns the number of branches where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching branches
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRANCH_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "branch.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(branch.uuid IS NULL OR branch.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the branch where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBranchException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findByUUID_G(String uuid, long groupId)
		throws NoSuchBranchException {

		Branch branch = fetchByUUID_G(uuid, groupId);

		if (branch == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBranchException(sb.toString());
		}

		return branch;
	}

	/**
	 * Returns the branch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the branch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Branch) {
			Branch branch = (Branch)result;

			if (!Objects.equals(uuid, branch.getUuid()) ||
				(groupId != branch.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BRANCH_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Branch> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Branch branch = list.get(0);

					result = branch;

					cacheResult(branch);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Branch)result;
		}
	}

	/**
	 * Removes the branch where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the branch that was removed
	 */
	@Override
	public Branch removeByUUID_G(String uuid, long groupId)
		throws NoSuchBranchException {

		Branch branch = findByUUID_G(uuid, groupId);

		return remove(branch);
	}

	/**
	 * Returns the number of branches where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching branches
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BRANCH_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"branch.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(branch.uuid IS NULL OR branch.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"branch.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the branches where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching branches
	 */
	@Override
	public List<Branch> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the branches where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @return the range of matching branches
	 */
	@Override
	public List<Branch> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the branches where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the branches where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Branch> list = null;

		if (useFinderCache) {
			list = (List<Branch>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Branch branch : list) {
					if (!uuid.equals(branch.getUuid()) ||
						(companyId != branch.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_BRANCH_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Branch>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the first branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Branch> orderByComparator) {

		List<Branch> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the last branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Branch> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Branch> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the branches before and after the current branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch[] findByUuid_C_PrevAndNext(
			long branchId, String uuid, long companyId,
			OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		uuid = Objects.toString(uuid, "");

		Branch branch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			Branch[] array = new BranchImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, branch, uuid, companyId, orderByComparator, true);

			array[1] = branch;

			array[2] = getByUuid_C_PrevAndNext(
				session, branch, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Branch getByUuid_C_PrevAndNext(
		Session session, Branch branch, String uuid, long companyId,
		OrderByComparator<Branch> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BRANCH_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(branch)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Branch> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the branches where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Branch branch :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(branch);
		}
	}

	/**
	 * Returns the number of branches where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching branches
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BRANCH_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"branch.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(branch.uuid IS NULL OR branch.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"branch.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBybranchName;
	private FinderPath _finderPathWithoutPaginationFindBybranchName;
	private FinderPath _finderPathCountBybranchName;

	/**
	 * Returns all the branches where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @return the matching branches
	 */
	@Override
	public List<Branch> findBybranchName(String branchName) {
		return findBybranchName(
			branchName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the branches where branchName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param branchName the branch name
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @return the range of matching branches
	 */
	@Override
	public List<Branch> findBybranchName(
		String branchName, int start, int end) {

		return findBybranchName(branchName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the branches where branchName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param branchName the branch name
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findBybranchName(
		String branchName, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return findBybranchName(
			branchName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the branches where branchName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param branchName the branch name
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findBybranchName(
		String branchName, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		branchName = Objects.toString(branchName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBybranchName;
				finderArgs = new Object[] {branchName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBybranchName;
			finderArgs = new Object[] {
				branchName, start, end, orderByComparator
			};
		}

		List<Branch> list = null;

		if (useFinderCache) {
			list = (List<Branch>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Branch branch : list) {
					if (!branchName.equals(branch.getBranchName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BRANCH_WHERE);

			boolean bindBranchName = false;

			if (branchName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BRANCHNAME_BRANCHNAME_3);
			}
			else {
				bindBranchName = true;

				sb.append(_FINDER_COLUMN_BRANCHNAME_BRANCHNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBranchName) {
					queryPos.add(branchName);
				}

				list = (List<Branch>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findBybranchName_First(
			String branchName, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchBybranchName_First(branchName, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("branchName=");
		sb.append(branchName);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the first branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchBybranchName_First(
		String branchName, OrderByComparator<Branch> orderByComparator) {

		List<Branch> list = findBybranchName(
			branchName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findBybranchName_Last(
			String branchName, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchBybranchName_Last(branchName, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("branchName=");
		sb.append(branchName);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the last branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchBybranchName_Last(
		String branchName, OrderByComparator<Branch> orderByComparator) {

		int count = countBybranchName(branchName);

		if (count == 0) {
			return null;
		}

		List<Branch> list = findBybranchName(
			branchName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the branches before and after the current branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch[] findBybranchName_PrevAndNext(
			long branchId, String branchName,
			OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		branchName = Objects.toString(branchName, "");

		Branch branch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			Branch[] array = new BranchImpl[3];

			array[0] = getBybranchName_PrevAndNext(
				session, branch, branchName, orderByComparator, true);

			array[1] = branch;

			array[2] = getBybranchName_PrevAndNext(
				session, branch, branchName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Branch getBybranchName_PrevAndNext(
		Session session, Branch branch, String branchName,
		OrderByComparator<Branch> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BRANCH_WHERE);

		boolean bindBranchName = false;

		if (branchName.isEmpty()) {
			sb.append(_FINDER_COLUMN_BRANCHNAME_BRANCHNAME_3);
		}
		else {
			bindBranchName = true;

			sb.append(_FINDER_COLUMN_BRANCHNAME_BRANCHNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindBranchName) {
			queryPos.add(branchName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(branch)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Branch> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the branches where branchName = &#63; from the database.
	 *
	 * @param branchName the branch name
	 */
	@Override
	public void removeBybranchName(String branchName) {
		for (Branch branch :
				findBybranchName(
					branchName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(branch);
		}
	}

	/**
	 * Returns the number of branches where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @return the number of matching branches
	 */
	@Override
	public int countBybranchName(String branchName) {
		branchName = Objects.toString(branchName, "");

		FinderPath finderPath = _finderPathCountBybranchName;

		Object[] finderArgs = new Object[] {branchName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRANCH_WHERE);

			boolean bindBranchName = false;

			if (branchName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BRANCHNAME_BRANCHNAME_3);
			}
			else {
				bindBranchName = true;

				sb.append(_FINDER_COLUMN_BRANCHNAME_BRANCHNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindBranchName) {
					queryPos.add(branchName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BRANCHNAME_BRANCHNAME_2 =
		"branch.branchName = ?";

	private static final String _FINDER_COLUMN_BRANCHNAME_BRANCHNAME_3 =
		"(branch.branchName IS NULL OR branch.branchName = '')";

	private FinderPath _finderPathWithPaginationFindBycountryId;
	private FinderPath _finderPathWithoutPaginationFindBycountryId;
	private FinderPath _finderPathCountBycountryId;

	/**
	 * Returns all the branches where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the matching branches
	 */
	@Override
	public List<Branch> findBycountryId(long countryId) {
		return findBycountryId(
			countryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the branches where countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @return the range of matching branches
	 */
	@Override
	public List<Branch> findBycountryId(long countryId, int start, int end) {
		return findBycountryId(countryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the branches where countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findBycountryId(
		long countryId, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return findBycountryId(countryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the branches where countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findBycountryId(
		long countryId, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycountryId;
				finderArgs = new Object[] {countryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycountryId;
			finderArgs = new Object[] {
				countryId, start, end, orderByComparator
			};
		}

		List<Branch> list = null;

		if (useFinderCache) {
			list = (List<Branch>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Branch branch : list) {
					if (countryId != branch.getCountryId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BRANCH_WHERE);

			sb.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(countryId);

				list = (List<Branch>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findBycountryId_First(
			long countryId, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchBycountryId_First(countryId, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("countryId=");
		sb.append(countryId);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the first branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchBycountryId_First(
		long countryId, OrderByComparator<Branch> orderByComparator) {

		List<Branch> list = findBycountryId(countryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findBycountryId_Last(
			long countryId, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchBycountryId_Last(countryId, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("countryId=");
		sb.append(countryId);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the last branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchBycountryId_Last(
		long countryId, OrderByComparator<Branch> orderByComparator) {

		int count = countBycountryId(countryId);

		if (count == 0) {
			return null;
		}

		List<Branch> list = findBycountryId(
			countryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the branches before and after the current branch in the ordered set where countryId = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch[] findBycountryId_PrevAndNext(
			long branchId, long countryId,
			OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			Branch[] array = new BranchImpl[3];

			array[0] = getBycountryId_PrevAndNext(
				session, branch, countryId, orderByComparator, true);

			array[1] = branch;

			array[2] = getBycountryId_PrevAndNext(
				session, branch, countryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Branch getBycountryId_PrevAndNext(
		Session session, Branch branch, long countryId,
		OrderByComparator<Branch> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BRANCH_WHERE);

		sb.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(countryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(branch)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Branch> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the branches where countryId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 */
	@Override
	public void removeBycountryId(long countryId) {
		for (Branch branch :
				findBycountryId(
					countryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(branch);
		}
	}

	/**
	 * Returns the number of branches where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the number of matching branches
	 */
	@Override
	public int countBycountryId(long countryId) {
		FinderPath finderPath = _finderPathCountBycountryId;

		Object[] finderArgs = new Object[] {countryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRANCH_WHERE);

			sb.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(countryId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COUNTRYID_COUNTRYID_2 =
		"branch.countryId = ?";

	private FinderPath _finderPathWithPaginationFindBystateId;
	private FinderPath _finderPathWithoutPaginationFindBystateId;
	private FinderPath _finderPathCountBystateId;

	/**
	 * Returns all the branches where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching branches
	 */
	@Override
	public List<Branch> findBystateId(long stateId) {
		return findBystateId(
			stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the branches where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @return the range of matching branches
	 */
	@Override
	public List<Branch> findBystateId(long stateId, int start, int end) {
		return findBystateId(stateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the branches where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findBystateId(
		long stateId, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return findBystateId(stateId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the branches where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findBystateId(
		long stateId, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBystateId;
				finderArgs = new Object[] {stateId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBystateId;
			finderArgs = new Object[] {stateId, start, end, orderByComparator};
		}

		List<Branch> list = null;

		if (useFinderCache) {
			list = (List<Branch>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Branch branch : list) {
					if (stateId != branch.getStateId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BRANCH_WHERE);

			sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

				list = (List<Branch>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findBystateId_First(
			long stateId, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchBystateId_First(stateId, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the first branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchBystateId_First(
		long stateId, OrderByComparator<Branch> orderByComparator) {

		List<Branch> list = findBystateId(stateId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findBystateId_Last(
			long stateId, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchBystateId_Last(stateId, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateId=");
		sb.append(stateId);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the last branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchBystateId_Last(
		long stateId, OrderByComparator<Branch> orderByComparator) {

		int count = countBystateId(stateId);

		if (count == 0) {
			return null;
		}

		List<Branch> list = findBystateId(
			stateId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the branches before and after the current branch in the ordered set where stateId = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch[] findBystateId_PrevAndNext(
			long branchId, long stateId,
			OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			Branch[] array = new BranchImpl[3];

			array[0] = getBystateId_PrevAndNext(
				session, branch, stateId, orderByComparator, true);

			array[1] = branch;

			array[2] = getBystateId_PrevAndNext(
				session, branch, stateId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Branch getBystateId_PrevAndNext(
		Session session, Branch branch, long stateId,
		OrderByComparator<Branch> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BRANCH_WHERE);

		sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(stateId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(branch)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Branch> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the branches where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	@Override
	public void removeBystateId(long stateId) {
		for (Branch branch :
				findBystateId(
					stateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(branch);
		}
	}

	/**
	 * Returns the number of branches where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching branches
	 */
	@Override
	public int countBystateId(long stateId) {
		FinderPath finderPath = _finderPathCountBystateId;

		Object[] finderArgs = new Object[] {stateId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRANCH_WHERE);

			sb.append(_FINDER_COLUMN_STATEID_STATEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(stateId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATEID_STATEID_2 =
		"branch.stateId = ?";

	private FinderPath _finderPathWithPaginationFindBycityId;
	private FinderPath _finderPathWithoutPaginationFindBycityId;
	private FinderPath _finderPathCountBycityId;

	/**
	 * Returns all the branches where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the matching branches
	 */
	@Override
	public List<Branch> findBycityId(long cityId) {
		return findBycityId(cityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the branches where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @return the range of matching branches
	 */
	@Override
	public List<Branch> findBycityId(long cityId, int start, int end) {
		return findBycityId(cityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the branches where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findBycityId(
		long cityId, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return findBycityId(cityId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the branches where cityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param cityId the city ID
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching branches
	 */
	@Override
	public List<Branch> findBycityId(
		long cityId, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycityId;
				finderArgs = new Object[] {cityId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycityId;
			finderArgs = new Object[] {cityId, start, end, orderByComparator};
		}

		List<Branch> list = null;

		if (useFinderCache) {
			list = (List<Branch>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Branch branch : list) {
					if (cityId != branch.getCityId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BRANCH_WHERE);

			sb.append(_FINDER_COLUMN_CITYID_CITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BranchModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cityId);

				list = (List<Branch>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findBycityId_First(
			long cityId, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchBycityId_First(cityId, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cityId=");
		sb.append(cityId);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the first branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchBycityId_First(
		long cityId, OrderByComparator<Branch> orderByComparator) {

		List<Branch> list = findBycityId(cityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	@Override
	public Branch findBycityId_Last(
			long cityId, OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = fetchBycityId_Last(cityId, orderByComparator);

		if (branch != null) {
			return branch;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("cityId=");
		sb.append(cityId);

		sb.append("}");

		throw new NoSuchBranchException(sb.toString());
	}

	/**
	 * Returns the last branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	@Override
	public Branch fetchBycityId_Last(
		long cityId, OrderByComparator<Branch> orderByComparator) {

		int count = countBycityId(cityId);

		if (count == 0) {
			return null;
		}

		List<Branch> list = findBycityId(
			cityId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the branches before and after the current branch in the ordered set where cityId = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch[] findBycityId_PrevAndNext(
			long branchId, long cityId,
			OrderByComparator<Branch> orderByComparator)
		throws NoSuchBranchException {

		Branch branch = findByPrimaryKey(branchId);

		Session session = null;

		try {
			session = openSession();

			Branch[] array = new BranchImpl[3];

			array[0] = getBycityId_PrevAndNext(
				session, branch, cityId, orderByComparator, true);

			array[1] = branch;

			array[2] = getBycityId_PrevAndNext(
				session, branch, cityId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Branch getBycityId_PrevAndNext(
		Session session, Branch branch, long cityId,
		OrderByComparator<Branch> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BRANCH_WHERE);

		sb.append(_FINDER_COLUMN_CITYID_CITYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BranchModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(cityId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(branch)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Branch> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the branches where cityId = &#63; from the database.
	 *
	 * @param cityId the city ID
	 */
	@Override
	public void removeBycityId(long cityId) {
		for (Branch branch :
				findBycityId(
					cityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(branch);
		}
	}

	/**
	 * Returns the number of branches where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the number of matching branches
	 */
	@Override
	public int countBycityId(long cityId) {
		FinderPath finderPath = _finderPathCountBycityId;

		Object[] finderArgs = new Object[] {cityId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BRANCH_WHERE);

			sb.append(_FINDER_COLUMN_CITYID_CITYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(cityId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CITYID_CITYID_2 =
		"branch.cityId = ?";

	public BranchPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Branch.class);

		setModelImplClass(BranchImpl.class);
		setModelPKClass(long.class);

		setTable(BranchTable.INSTANCE);
	}

	/**
	 * Caches the branch in the entity cache if it is enabled.
	 *
	 * @param branch the branch
	 */
	@Override
	public void cacheResult(Branch branch) {
		entityCache.putResult(BranchImpl.class, branch.getPrimaryKey(), branch);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {branch.getUuid(), branch.getGroupId()}, branch);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the branches in the entity cache if it is enabled.
	 *
	 * @param branches the branches
	 */
	@Override
	public void cacheResult(List<Branch> branches) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (branches.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Branch branch : branches) {
			if (entityCache.getResult(
					BranchImpl.class, branch.getPrimaryKey()) == null) {

				cacheResult(branch);
			}
		}
	}

	/**
	 * Clears the cache for all branches.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BranchImpl.class);

		finderCache.clearCache(BranchImpl.class);
	}

	/**
	 * Clears the cache for the branch.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Branch branch) {
		entityCache.removeResult(BranchImpl.class, branch);
	}

	@Override
	public void clearCache(List<Branch> branches) {
		for (Branch branch : branches) {
			entityCache.removeResult(BranchImpl.class, branch);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BranchImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BranchImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(BranchModelImpl branchModelImpl) {
		Object[] args = new Object[] {
			branchModelImpl.getUuid(), branchModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, branchModelImpl);
	}

	/**
	 * Creates a new branch with the primary key. Does not add the branch to the database.
	 *
	 * @param branchId the primary key for the new branch
	 * @return the new branch
	 */
	@Override
	public Branch create(long branchId) {
		Branch branch = new BranchImpl();

		branch.setNew(true);
		branch.setPrimaryKey(branchId);

		String uuid = _portalUUID.generate();

		branch.setUuid(uuid);

		branch.setCompanyId(CompanyThreadLocal.getCompanyId());

		return branch;
	}

	/**
	 * Removes the branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param branchId the primary key of the branch
	 * @return the branch that was removed
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch remove(long branchId) throws NoSuchBranchException {
		return remove((Serializable)branchId);
	}

	/**
	 * Removes the branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the branch
	 * @return the branch that was removed
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch remove(Serializable primaryKey) throws NoSuchBranchException {
		Session session = null;

		try {
			session = openSession();

			Branch branch = (Branch)session.get(BranchImpl.class, primaryKey);

			if (branch == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBranchException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(branch);
		}
		catch (NoSuchBranchException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Branch removeImpl(Branch branch) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(branch)) {
				branch = (Branch)session.get(
					BranchImpl.class, branch.getPrimaryKeyObj());
			}

			if (branch != null) {
				session.delete(branch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (branch != null) {
			clearCache(branch);
		}

		return branch;
	}

	@Override
	public Branch updateImpl(Branch branch) {
		boolean isNew = branch.isNew();

		if (!(branch instanceof BranchModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(branch.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(branch);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in branch proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Branch implementation " +
					branch.getClass());
		}

		BranchModelImpl branchModelImpl = (BranchModelImpl)branch;

		if (Validator.isNull(branch.getUuid())) {
			String uuid = _portalUUID.generate();

			branch.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (branch.getCreateDate() == null)) {
			if (serviceContext == null) {
				branch.setCreateDate(date);
			}
			else {
				branch.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!branchModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				branch.setModifiedDate(date);
			}
			else {
				branch.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(branch);
			}
			else {
				branch = (Branch)session.merge(branch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(BranchImpl.class, branchModelImpl, false, true);

		cacheUniqueFindersCache(branchModelImpl);

		if (isNew) {
			branch.setNew(false);
		}

		branch.resetOriginalValues();

		return branch;
	}

	/**
	 * Returns the branch with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the branch
	 * @return the branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBranchException {

		Branch branch = fetchByPrimaryKey(primaryKey);

		if (branch == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBranchException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return branch;
	}

	/**
	 * Returns the branch with the primary key or throws a <code>NoSuchBranchException</code> if it could not be found.
	 *
	 * @param branchId the primary key of the branch
	 * @return the branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	@Override
	public Branch findByPrimaryKey(long branchId) throws NoSuchBranchException {
		return findByPrimaryKey((Serializable)branchId);
	}

	/**
	 * Returns the branch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param branchId the primary key of the branch
	 * @return the branch, or <code>null</code> if a branch with the primary key could not be found
	 */
	@Override
	public Branch fetchByPrimaryKey(long branchId) {
		return fetchByPrimaryKey((Serializable)branchId);
	}

	/**
	 * Returns all the branches.
	 *
	 * @return the branches
	 */
	@Override
	public List<Branch> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @return the range of branches
	 */
	@Override
	public List<Branch> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of branches
	 */
	@Override
	public List<Branch> findAll(
		int start, int end, OrderByComparator<Branch> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the branches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BranchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of branches
	 * @param end the upper bound of the range of branches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of branches
	 */
	@Override
	public List<Branch> findAll(
		int start, int end, OrderByComparator<Branch> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Branch> list = null;

		if (useFinderCache) {
			list = (List<Branch>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BRANCH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BRANCH;

				sql = sql.concat(BranchModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Branch>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the branches from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Branch branch : findAll()) {
			remove(branch);
		}
	}

	/**
	 * Returns the number of branches.
	 *
	 * @return the number of branches
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BRANCH);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "branchId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BRANCH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BranchModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the branch persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindBybranchName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBybranchName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"branchName"}, true);

		_finderPathWithoutPaginationFindBybranchName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBybranchName",
			new String[] {String.class.getName()}, new String[] {"branchName"},
			true);

		_finderPathCountBybranchName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybranchName",
			new String[] {String.class.getName()}, new String[] {"branchName"},
			false);

		_finderPathWithPaginationFindBycountryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycountryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"countryId"}, true);

		_finderPathWithoutPaginationFindBycountryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycountryId",
			new String[] {Long.class.getName()}, new String[] {"countryId"},
			true);

		_finderPathCountBycountryId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycountryId",
			new String[] {Long.class.getName()}, new String[] {"countryId"},
			false);

		_finderPathWithPaginationFindBystateId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystateId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"stateId"}, true);

		_finderPathWithoutPaginationFindBystateId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystateId",
			new String[] {Long.class.getName()}, new String[] {"stateId"},
			true);

		_finderPathCountBystateId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystateId",
			new String[] {Long.class.getName()}, new String[] {"stateId"},
			false);

		_finderPathWithPaginationFindBycityId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycityId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"cityId"}, true);

		_finderPathWithoutPaginationFindBycityId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycityId",
			new String[] {Long.class.getName()}, new String[] {"cityId"}, true);

		_finderPathCountBycityId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycityId",
			new String[] {Long.class.getName()}, new String[] {"cityId"},
			false);

		_setBranchUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBranchUtilPersistence(null);

		entityCache.removeCache(BranchImpl.class.getName());
	}

	private void _setBranchUtilPersistence(
		BranchPersistence branchPersistence) {

		try {
			Field field = BranchUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, branchPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BRANCH =
		"SELECT branch FROM Branch branch";

	private static final String _SQL_SELECT_BRANCH_WHERE =
		"SELECT branch FROM Branch branch WHERE ";

	private static final String _SQL_COUNT_BRANCH =
		"SELECT COUNT(branch) FROM Branch branch";

	private static final String _SQL_COUNT_BRANCH_WHERE =
		"SELECT COUNT(branch) FROM Branch branch WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "branch.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Branch exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Branch exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BranchPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}