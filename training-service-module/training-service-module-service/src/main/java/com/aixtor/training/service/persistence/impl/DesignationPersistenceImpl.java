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

import com.aixtor.training.exception.NoSuchDesignationException;
import com.aixtor.training.model.Designation;
import com.aixtor.training.model.DesignationTable;
import com.aixtor.training.model.impl.DesignationImpl;
import com.aixtor.training.model.impl.DesignationModelImpl;
import com.aixtor.training.service.persistence.DesignationPersistence;
import com.aixtor.training.service.persistence.DesignationUtil;
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
 * The persistence implementation for the designation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {DesignationPersistence.class, BasePersistence.class})
public class DesignationPersistenceImpl
	extends BasePersistenceImpl<Designation> implements DesignationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DesignationUtil</code> to access the designation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DesignationImpl.class.getName();

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
	 * Returns all the designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

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

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if (!uuid.equals(designation.getUuid())) {
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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

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
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
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

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByUuid_First(
			String uuid, OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByUuid_First(uuid, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByUuid_First(
		String uuid, OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByUuid_Last(
			String uuid, OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByUuid_Last(uuid, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByUuid_Last(
		String uuid, OrderByComparator<Designation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where uuid = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByUuid_PrevAndNext(
			long designationId, String uuid,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		uuid = Objects.toString(uuid, "");

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, designation, uuid, orderByComparator, true);

			array[1] = designation;

			array[2] = getByUuid_PrevAndNext(
				session, designation, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Designation getByUuid_PrevAndNext(
		Session session, Designation designation, String uuid,
		OrderByComparator<Designation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Designation designation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching designations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"designation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(designation.uuid IS NULL OR designation.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the designation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByUUID_G(String uuid, long groupId)
		throws NoSuchDesignationException {

		Designation designation = fetchByUUID_G(uuid, groupId);

		if (designation == null) {
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

			throw new NoSuchDesignationException(sb.toString());
		}

		return designation;
	}

	/**
	 * Returns the designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByUUID_G(
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

		if (result instanceof Designation) {
			Designation designation = (Designation)result;

			if (!Objects.equals(uuid, designation.getUuid()) ||
				(groupId != designation.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

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

				List<Designation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Designation designation = list.get(0);

					result = designation;

					cacheResult(designation);
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
			return (Designation)result;
		}
	}

	/**
	 * Removes the designation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the designation that was removed
	 */
	@Override
	public Designation removeByUUID_G(String uuid, long groupId)
		throws NoSuchDesignationException {

		Designation designation = findByUUID_G(uuid, groupId);

		return remove(designation);
	}

	/**
	 * Returns the number of designations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching designations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

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
		"designation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(designation.uuid IS NULL OR designation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"designation.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

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

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if (!uuid.equals(designation.getUuid()) ||
						(companyId != designation.getCompanyId())) {

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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

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
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
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

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Designation> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByUuid_C_PrevAndNext(
			long designationId, String uuid, long companyId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		uuid = Objects.toString(uuid, "");

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, designation, uuid, companyId, orderByComparator, true);

			array[1] = designation;

			array[2] = getByUuid_C_PrevAndNext(
				session, designation, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Designation getByUuid_C_PrevAndNext(
		Session session, Designation designation, String uuid, long companyId,
		OrderByComparator<Designation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Designation designation :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching designations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

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
		"designation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(designation.uuid IS NULL OR designation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"designation.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDesignationName;
	private FinderPath _finderPathWithoutPaginationFindByDesignationName;
	private FinderPath _finderPathCountByDesignationName;

	/**
	 * Returns all the designations where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByDesignationName(String designationName) {
		return findByDesignationName(
			designationName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations where designationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationName the designation name
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationName(
		String designationName, int start, int end) {

		return findByDesignationName(designationName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where designationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationName the designation name
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationName(
		String designationName, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByDesignationName(
			designationName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where designationName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationName the designation name
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationName(
		String designationName, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		designationName = Objects.toString(designationName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDesignationName;
				finderArgs = new Object[] {designationName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDesignationName;
			finderArgs = new Object[] {
				designationName, start, end, orderByComparator
			};
		}

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if (!designationName.equals(
							designation.getDesignationName())) {

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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

			boolean bindDesignationName = false;

			if (designationName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_3);
			}
			else {
				bindDesignationName = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignationName) {
					queryPos.add(designationName);
				}

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationName_First(
			String designationName,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationName_First(
			designationName, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationName=");
		sb.append(designationName);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationName_First(
		String designationName,
		OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByDesignationName(
			designationName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationName_Last(
			String designationName,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationName_Last(
			designationName, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationName=");
		sb.append(designationName);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationName_Last(
		String designationName,
		OrderByComparator<Designation> orderByComparator) {

		int count = countByDesignationName(designationName);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByDesignationName(
			designationName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation[] findByDesignationName_PrevAndNext(
			long designationId, String designationName,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		designationName = Objects.toString(designationName, "");

		Designation designation = findByPrimaryKey(designationId);

		Session session = null;

		try {
			session = openSession();

			Designation[] array = new DesignationImpl[3];

			array[0] = getByDesignationName_PrevAndNext(
				session, designation, designationName, orderByComparator, true);

			array[1] = designation;

			array[2] = getByDesignationName_PrevAndNext(
				session, designation, designationName, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Designation getByDesignationName_PrevAndNext(
		Session session, Designation designation, String designationName,
		OrderByComparator<Designation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DESIGNATION_WHERE);

		boolean bindDesignationName = false;

		if (designationName.isEmpty()) {
			sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_3);
		}
		else {
			bindDesignationName = true;

			sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_2);
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
			sb.append(DesignationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDesignationName) {
			queryPos.add(designationName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(designation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Designation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the designations where designationName = &#63; from the database.
	 *
	 * @param designationName the designation name
	 */
	@Override
	public void removeByDesignationName(String designationName) {
		for (Designation designation :
				findByDesignationName(
					designationName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @return the number of matching designations
	 */
	@Override
	public int countByDesignationName(String designationName) {
		designationName = Objects.toString(designationName, "");

		FinderPath finderPath = _finderPathCountByDesignationName;

		Object[] finderArgs = new Object[] {designationName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

			boolean bindDesignationName = false;

			if (designationName.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_3);
			}
			else {
				bindDesignationName = true;

				sb.append(_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDesignationName) {
					queryPos.add(designationName);
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

	private static final String
		_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_2 =
			"designation.designationName = ?";

	private static final String
		_FINDER_COLUMN_DESIGNATIONNAME_DESIGNATIONNAME_3 =
			"(designation.designationName IS NULL OR designation.designationName = '')";

	private FinderPath _finderPathWithPaginationFindByDesignationId;
	private FinderPath _finderPathWithoutPaginationFindByDesignationId;
	private FinderPath _finderPathCountByDesignationId;

	/**
	 * Returns all the designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the matching designations
	 */
	@Override
	public List<Designation> findByDesignationId(long designationId) {
		return findByDesignationId(
			designationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationId(
		long designationId, int start, int end) {

		return findByDesignationId(designationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return findByDesignationId(
			designationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations where designationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param designationId the designation ID
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching designations
	 */
	@Override
	public List<Designation> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDesignationId;
				finderArgs = new Object[] {designationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDesignationId;
			finderArgs = new Object[] {
				designationId, start, end, orderByComparator
			};
		}

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Designation designation : list) {
					if (designationId != designation.getDesignationId()) {
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

			sb.append(_SQL_SELECT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DesignationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationId);

				list = (List<Designation>)QueryUtil.list(
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
	 * Returns the first designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationId_First(
			long designationId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationId_First(
			designationId, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationId=");
		sb.append(designationId);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the first designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationId_First(
		long designationId, OrderByComparator<Designation> orderByComparator) {

		List<Designation> list = findByDesignationId(
			designationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	@Override
	public Designation findByDesignationId_Last(
			long designationId,
			OrderByComparator<Designation> orderByComparator)
		throws NoSuchDesignationException {

		Designation designation = fetchByDesignationId_Last(
			designationId, orderByComparator);

		if (designation != null) {
			return designation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("designationId=");
		sb.append(designationId);

		sb.append("}");

		throw new NoSuchDesignationException(sb.toString());
	}

	/**
	 * Returns the last designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	@Override
	public Designation fetchByDesignationId_Last(
		long designationId, OrderByComparator<Designation> orderByComparator) {

		int count = countByDesignationId(designationId);

		if (count == 0) {
			return null;
		}

		List<Designation> list = findByDesignationId(
			designationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the designations where designationId = &#63; from the database.
	 *
	 * @param designationId the designation ID
	 */
	@Override
	public void removeByDesignationId(long designationId) {
		for (Designation designation :
				findByDesignationId(
					designationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(designation);
		}
	}

	/**
	 * Returns the number of designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the number of matching designations
	 */
	@Override
	public int countByDesignationId(long designationId) {
		FinderPath finderPath = _finderPathCountByDesignationId;

		Object[] finderArgs = new Object[] {designationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DESIGNATION_WHERE);

			sb.append(_FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(designationId);

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

	private static final String _FINDER_COLUMN_DESIGNATIONID_DESIGNATIONID_2 =
		"designation.designationId = ?";

	public DesignationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Designation.class);

		setModelImplClass(DesignationImpl.class);
		setModelPKClass(long.class);

		setTable(DesignationTable.INSTANCE);
	}

	/**
	 * Caches the designation in the entity cache if it is enabled.
	 *
	 * @param designation the designation
	 */
	@Override
	public void cacheResult(Designation designation) {
		entityCache.putResult(
			DesignationImpl.class, designation.getPrimaryKey(), designation);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {designation.getUuid(), designation.getGroupId()},
			designation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the designations in the entity cache if it is enabled.
	 *
	 * @param designations the designations
	 */
	@Override
	public void cacheResult(List<Designation> designations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (designations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Designation designation : designations) {
			if (entityCache.getResult(
					DesignationImpl.class, designation.getPrimaryKey()) ==
						null) {

				cacheResult(designation);
			}
		}
	}

	/**
	 * Clears the cache for all designations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DesignationImpl.class);

		finderCache.clearCache(DesignationImpl.class);
	}

	/**
	 * Clears the cache for the designation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Designation designation) {
		entityCache.removeResult(DesignationImpl.class, designation);
	}

	@Override
	public void clearCache(List<Designation> designations) {
		for (Designation designation : designations) {
			entityCache.removeResult(DesignationImpl.class, designation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DesignationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DesignationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		DesignationModelImpl designationModelImpl) {

		Object[] args = new Object[] {
			designationModelImpl.getUuid(), designationModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, designationModelImpl);
	}

	/**
	 * Creates a new designation with the primary key. Does not add the designation to the database.
	 *
	 * @param designationId the primary key for the new designation
	 * @return the new designation
	 */
	@Override
	public Designation create(long designationId) {
		Designation designation = new DesignationImpl();

		designation.setNew(true);
		designation.setPrimaryKey(designationId);

		String uuid = _portalUUID.generate();

		designation.setUuid(uuid);

		designation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return designation;
	}

	/**
	 * Removes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation that was removed
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation remove(long designationId)
		throws NoSuchDesignationException {

		return remove((Serializable)designationId);
	}

	/**
	 * Removes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the designation
	 * @return the designation that was removed
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation remove(Serializable primaryKey)
		throws NoSuchDesignationException {

		Session session = null;

		try {
			session = openSession();

			Designation designation = (Designation)session.get(
				DesignationImpl.class, primaryKey);

			if (designation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDesignationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(designation);
		}
		catch (NoSuchDesignationException noSuchEntityException) {
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
	protected Designation removeImpl(Designation designation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(designation)) {
				designation = (Designation)session.get(
					DesignationImpl.class, designation.getPrimaryKeyObj());
			}

			if (designation != null) {
				session.delete(designation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (designation != null) {
			clearCache(designation);
		}

		return designation;
	}

	@Override
	public Designation updateImpl(Designation designation) {
		boolean isNew = designation.isNew();

		if (!(designation instanceof DesignationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(designation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(designation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in designation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Designation implementation " +
					designation.getClass());
		}

		DesignationModelImpl designationModelImpl =
			(DesignationModelImpl)designation;

		if (Validator.isNull(designation.getUuid())) {
			String uuid = _portalUUID.generate();

			designation.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (designation.getCreateDate() == null)) {
			if (serviceContext == null) {
				designation.setCreateDate(date);
			}
			else {
				designation.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!designationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				designation.setModifiedDate(date);
			}
			else {
				designation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(designation);
			}
			else {
				designation = (Designation)session.merge(designation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			DesignationImpl.class, designationModelImpl, false, true);

		cacheUniqueFindersCache(designationModelImpl);

		if (isNew) {
			designation.setNew(false);
		}

		designation.resetOriginalValues();

		return designation;
	}

	/**
	 * Returns the designation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the designation
	 * @return the designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDesignationException {

		Designation designation = fetchByPrimaryKey(primaryKey);

		if (designation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDesignationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return designation;
	}

	/**
	 * Returns the designation with the primary key or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	@Override
	public Designation findByPrimaryKey(long designationId)
		throws NoSuchDesignationException {

		return findByPrimaryKey((Serializable)designationId);
	}

	/**
	 * Returns the designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation, or <code>null</code> if a designation with the primary key could not be found
	 */
	@Override
	public Designation fetchByPrimaryKey(long designationId) {
		return fetchByPrimaryKey((Serializable)designationId);
	}

	/**
	 * Returns all the designations.
	 *
	 * @return the designations
	 */
	@Override
	public List<Designation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @return the range of designations
	 */
	@Override
	public List<Designation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of designations
	 */
	@Override
	public List<Designation> findAll(
		int start, int end, OrderByComparator<Designation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the designations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DesignationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of designations
	 * @param end the upper bound of the range of designations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of designations
	 */
	@Override
	public List<Designation> findAll(
		int start, int end, OrderByComparator<Designation> orderByComparator,
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

		List<Designation> list = null;

		if (useFinderCache) {
			list = (List<Designation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DESIGNATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DESIGNATION;

				sql = sql.concat(DesignationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Designation>)QueryUtil.list(
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
	 * Removes all the designations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Designation designation : findAll()) {
			remove(designation);
		}
	}

	/**
	 * Returns the number of designations.
	 *
	 * @return the number of designations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DESIGNATION);

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
		return "designationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DESIGNATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DesignationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the designation persistence.
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

		_finderPathWithPaginationFindByDesignationName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDesignationName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"designationName"}, true);

		_finderPathWithoutPaginationFindByDesignationName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDesignationName",
			new String[] {String.class.getName()},
			new String[] {"designationName"}, true);

		_finderPathCountByDesignationName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDesignationName",
			new String[] {String.class.getName()},
			new String[] {"designationName"}, false);

		_finderPathWithPaginationFindByDesignationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDesignationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"designationId"}, true);

		_finderPathWithoutPaginationFindByDesignationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDesignationId",
			new String[] {Long.class.getName()}, new String[] {"designationId"},
			true);

		_finderPathCountByDesignationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDesignationId",
			new String[] {Long.class.getName()}, new String[] {"designationId"},
			false);

		_setDesignationUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setDesignationUtilPersistence(null);

		entityCache.removeCache(DesignationImpl.class.getName());
	}

	private void _setDesignationUtilPersistence(
		DesignationPersistence designationPersistence) {

		try {
			Field field = DesignationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, designationPersistence);
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

	private static final String _SQL_SELECT_DESIGNATION =
		"SELECT designation FROM Designation designation";

	private static final String _SQL_SELECT_DESIGNATION_WHERE =
		"SELECT designation FROM Designation designation WHERE ";

	private static final String _SQL_COUNT_DESIGNATION =
		"SELECT COUNT(designation) FROM Designation designation";

	private static final String _SQL_COUNT_DESIGNATION_WHERE =
		"SELECT COUNT(designation) FROM Designation designation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "designation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Designation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Designation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DesignationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}