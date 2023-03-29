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

import com.aixtor.training.exception.NoSuchStateException;
import com.aixtor.training.model.State;
import com.aixtor.training.model.StateTable;
import com.aixtor.training.model.impl.StateImpl;
import com.aixtor.training.model.impl.StateModelImpl;
import com.aixtor.training.service.persistence.StatePersistence;
import com.aixtor.training.service.persistence.StateUtil;
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
 * The persistence implementation for the state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {StatePersistence.class, BasePersistence.class})
public class StatePersistenceImpl
	extends BasePersistenceImpl<State> implements StatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StateUtil</code> to access the state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StateImpl.class.getName();

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
	 * Returns all the states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching states
	 */
	@Override
	public List<State> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @return the range of matching states
	 */
	@Override
	public List<State> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching states
	 */
	@Override
	public List<State> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<State> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the states where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching states
	 */
	@Override
	public List<State> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<State> orderByComparator, boolean useFinderCache) {

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

		List<State> list = null;

		if (useFinderCache) {
			list = (List<State>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (State state : list) {
					if (!uuid.equals(state.getUuid())) {
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

			sb.append(_SQL_SELECT_STATE_WHERE);

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
				sb.append(StateModelImpl.ORDER_BY_JPQL);
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

				list = (List<State>)QueryUtil.list(
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
	 * Returns the first state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	@Override
	public State findByUuid_First(
			String uuid, OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		State state = fetchByUuid_First(uuid, orderByComparator);

		if (state != null) {
			return state;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the first state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchByUuid_First(
		String uuid, OrderByComparator<State> orderByComparator) {

		List<State> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	@Override
	public State findByUuid_Last(
			String uuid, OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		State state = fetchByUuid_Last(uuid, orderByComparator);

		if (state != null) {
			return state;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the last state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchByUuid_Last(
		String uuid, OrderByComparator<State> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<State> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the states before and after the current state in the ordered set where uuid = &#63;.
	 *
	 * @param stateId the primary key of the current state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	@Override
	public State[] findByUuid_PrevAndNext(
			long stateId, String uuid,
			OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		uuid = Objects.toString(uuid, "");

		State state = findByPrimaryKey(stateId);

		Session session = null;

		try {
			session = openSession();

			State[] array = new StateImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, state, uuid, orderByComparator, true);

			array[1] = state;

			array[2] = getByUuid_PrevAndNext(
				session, state, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected State getByUuid_PrevAndNext(
		Session session, State state, String uuid,
		OrderByComparator<State> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATE_WHERE);

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
			sb.append(StateModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(state)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<State> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (State state :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(state);
		}
	}

	/**
	 * Returns the number of states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching states
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "state.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(state.uuid IS NULL OR state.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the state where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	@Override
	public State findByUUID_G(String uuid, long groupId)
		throws NoSuchStateException {

		State state = fetchByUUID_G(uuid, groupId);

		if (state == null) {
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

			throw new NoSuchStateException(sb.toString());
		}

		return state;
	}

	/**
	 * Returns the state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchByUUID_G(
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

		if (result instanceof State) {
			State state = (State)result;

			if (!Objects.equals(uuid, state.getUuid()) ||
				(groupId != state.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_STATE_WHERE);

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

				List<State> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					State state = list.get(0);

					result = state;

					cacheResult(state);
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
			return (State)result;
		}
	}

	/**
	 * Removes the state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the state that was removed
	 */
	@Override
	public State removeByUUID_G(String uuid, long groupId)
		throws NoSuchStateException {

		State state = findByUUID_G(uuid, groupId);

		return remove(state);
	}

	/**
	 * Returns the number of states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching states
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STATE_WHERE);

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
		"state.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(state.uuid IS NULL OR state.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"state.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching states
	 */
	@Override
	public List<State> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @return the range of matching states
	 */
	@Override
	public List<State> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching states
	 */
	@Override
	public List<State> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<State> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the states where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching states
	 */
	@Override
	public List<State> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<State> orderByComparator, boolean useFinderCache) {

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

		List<State> list = null;

		if (useFinderCache) {
			list = (List<State>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (State state : list) {
					if (!uuid.equals(state.getUuid()) ||
						(companyId != state.getCompanyId())) {

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

			sb.append(_SQL_SELECT_STATE_WHERE);

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
				sb.append(StateModelImpl.ORDER_BY_JPQL);
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

				list = (List<State>)QueryUtil.list(
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
	 * Returns the first state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	@Override
	public State findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		State state = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (state != null) {
			return state;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the first state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<State> orderByComparator) {

		List<State> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	@Override
	public State findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		State state = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (state != null) {
			return state;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the last state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<State> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<State> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the states before and after the current state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param stateId the primary key of the current state
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	@Override
	public State[] findByUuid_C_PrevAndNext(
			long stateId, String uuid, long companyId,
			OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		uuid = Objects.toString(uuid, "");

		State state = findByPrimaryKey(stateId);

		Session session = null;

		try {
			session = openSession();

			State[] array = new StateImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, state, uuid, companyId, orderByComparator, true);

			array[1] = state;

			array[2] = getByUuid_C_PrevAndNext(
				session, state, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected State getByUuid_C_PrevAndNext(
		Session session, State state, String uuid, long companyId,
		OrderByComparator<State> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_STATE_WHERE);

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
			sb.append(StateModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(state)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<State> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (State state :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(state);
		}
	}

	/**
	 * Returns the number of states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching states
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_STATE_WHERE);

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
		"state.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(state.uuid IS NULL OR state.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"state.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBystateName;
	private FinderPath _finderPathWithoutPaginationFindBystateName;
	private FinderPath _finderPathCountBystateName;

	/**
	 * Returns all the states where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @return the matching states
	 */
	@Override
	public List<State> findBystateName(String stateName) {
		return findBystateName(
			stateName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the states where stateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param stateName the state name
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @return the range of matching states
	 */
	@Override
	public List<State> findBystateName(String stateName, int start, int end) {
		return findBystateName(stateName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the states where stateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param stateName the state name
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching states
	 */
	@Override
	public List<State> findBystateName(
		String stateName, int start, int end,
		OrderByComparator<State> orderByComparator) {

		return findBystateName(stateName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the states where stateName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param stateName the state name
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching states
	 */
	@Override
	public List<State> findBystateName(
		String stateName, int start, int end,
		OrderByComparator<State> orderByComparator, boolean useFinderCache) {

		stateName = Objects.toString(stateName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBystateName;
				finderArgs = new Object[] {stateName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBystateName;
			finderArgs = new Object[] {
				stateName, start, end, orderByComparator
			};
		}

		List<State> list = null;

		if (useFinderCache) {
			list = (List<State>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (State state : list) {
					if (!stateName.equals(state.getStateName())) {
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

			sb.append(_SQL_SELECT_STATE_WHERE);

			boolean bindStateName = false;

			if (stateName.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATENAME_STATENAME_3);
			}
			else {
				bindStateName = true;

				sb.append(_FINDER_COLUMN_STATENAME_STATENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStateName) {
					queryPos.add(stateName);
				}

				list = (List<State>)QueryUtil.list(
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
	 * Returns the first state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	@Override
	public State findBystateName_First(
			String stateName, OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		State state = fetchBystateName_First(stateName, orderByComparator);

		if (state != null) {
			return state;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateName=");
		sb.append(stateName);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the first state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchBystateName_First(
		String stateName, OrderByComparator<State> orderByComparator) {

		List<State> list = findBystateName(stateName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	@Override
	public State findBystateName_Last(
			String stateName, OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		State state = fetchBystateName_Last(stateName, orderByComparator);

		if (state != null) {
			return state;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stateName=");
		sb.append(stateName);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the last state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchBystateName_Last(
		String stateName, OrderByComparator<State> orderByComparator) {

		int count = countBystateName(stateName);

		if (count == 0) {
			return null;
		}

		List<State> list = findBystateName(
			stateName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the states before and after the current state in the ordered set where stateName = &#63;.
	 *
	 * @param stateId the primary key of the current state
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	@Override
	public State[] findBystateName_PrevAndNext(
			long stateId, String stateName,
			OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		stateName = Objects.toString(stateName, "");

		State state = findByPrimaryKey(stateId);

		Session session = null;

		try {
			session = openSession();

			State[] array = new StateImpl[3];

			array[0] = getBystateName_PrevAndNext(
				session, state, stateName, orderByComparator, true);

			array[1] = state;

			array[2] = getBystateName_PrevAndNext(
				session, state, stateName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected State getBystateName_PrevAndNext(
		Session session, State state, String stateName,
		OrderByComparator<State> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATE_WHERE);

		boolean bindStateName = false;

		if (stateName.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATENAME_STATENAME_3);
		}
		else {
			bindStateName = true;

			sb.append(_FINDER_COLUMN_STATENAME_STATENAME_2);
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
			sb.append(StateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStateName) {
			queryPos.add(stateName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(state)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<State> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the states where stateName = &#63; from the database.
	 *
	 * @param stateName the state name
	 */
	@Override
	public void removeBystateName(String stateName) {
		for (State state :
				findBystateName(
					stateName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(state);
		}
	}

	/**
	 * Returns the number of states where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @return the number of matching states
	 */
	@Override
	public int countBystateName(String stateName) {
		stateName = Objects.toString(stateName, "");

		FinderPath finderPath = _finderPathCountBystateName;

		Object[] finderArgs = new Object[] {stateName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATE_WHERE);

			boolean bindStateName = false;

			if (stateName.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATENAME_STATENAME_3);
			}
			else {
				bindStateName = true;

				sb.append(_FINDER_COLUMN_STATENAME_STATENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStateName) {
					queryPos.add(stateName);
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

	private static final String _FINDER_COLUMN_STATENAME_STATENAME_2 =
		"state.stateName = ?";

	private static final String _FINDER_COLUMN_STATENAME_STATENAME_3 =
		"(state.stateName IS NULL OR state.stateName = '')";

	private FinderPath _finderPathWithPaginationFindBycountryId;
	private FinderPath _finderPathWithoutPaginationFindBycountryId;
	private FinderPath _finderPathCountBycountryId;

	/**
	 * Returns all the states where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the matching states
	 */
	@Override
	public List<State> findBycountryId(long countryId) {
		return findBycountryId(
			countryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the states where countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @return the range of matching states
	 */
	@Override
	public List<State> findBycountryId(long countryId, int start, int end) {
		return findBycountryId(countryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the states where countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching states
	 */
	@Override
	public List<State> findBycountryId(
		long countryId, int start, int end,
		OrderByComparator<State> orderByComparator) {

		return findBycountryId(countryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the states where countryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param countryId the country ID
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching states
	 */
	@Override
	public List<State> findBycountryId(
		long countryId, int start, int end,
		OrderByComparator<State> orderByComparator, boolean useFinderCache) {

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

		List<State> list = null;

		if (useFinderCache) {
			list = (List<State>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (State state : list) {
					if (countryId != state.getCountryId()) {
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

			sb.append(_SQL_SELECT_STATE_WHERE);

			sb.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(countryId);

				list = (List<State>)QueryUtil.list(
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
	 * Returns the first state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	@Override
	public State findBycountryId_First(
			long countryId, OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		State state = fetchBycountryId_First(countryId, orderByComparator);

		if (state != null) {
			return state;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("countryId=");
		sb.append(countryId);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the first state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchBycountryId_First(
		long countryId, OrderByComparator<State> orderByComparator) {

		List<State> list = findBycountryId(countryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	@Override
	public State findBycountryId_Last(
			long countryId, OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		State state = fetchBycountryId_Last(countryId, orderByComparator);

		if (state != null) {
			return state;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("countryId=");
		sb.append(countryId);

		sb.append("}");

		throw new NoSuchStateException(sb.toString());
	}

	/**
	 * Returns the last state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	@Override
	public State fetchBycountryId_Last(
		long countryId, OrderByComparator<State> orderByComparator) {

		int count = countBycountryId(countryId);

		if (count == 0) {
			return null;
		}

		List<State> list = findBycountryId(
			countryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the states before and after the current state in the ordered set where countryId = &#63;.
	 *
	 * @param stateId the primary key of the current state
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	@Override
	public State[] findBycountryId_PrevAndNext(
			long stateId, long countryId,
			OrderByComparator<State> orderByComparator)
		throws NoSuchStateException {

		State state = findByPrimaryKey(stateId);

		Session session = null;

		try {
			session = openSession();

			State[] array = new StateImpl[3];

			array[0] = getBycountryId_PrevAndNext(
				session, state, countryId, orderByComparator, true);

			array[1] = state;

			array[2] = getBycountryId_PrevAndNext(
				session, state, countryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected State getBycountryId_PrevAndNext(
		Session session, State state, long countryId,
		OrderByComparator<State> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STATE_WHERE);

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
			sb.append(StateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(countryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(state)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<State> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the states where countryId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 */
	@Override
	public void removeBycountryId(long countryId) {
		for (State state :
				findBycountryId(
					countryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(state);
		}
	}

	/**
	 * Returns the number of states where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the number of matching states
	 */
	@Override
	public int countBycountryId(long countryId) {
		FinderPath finderPath = _finderPathCountBycountryId;

		Object[] finderArgs = new Object[] {countryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STATE_WHERE);

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
		"state.countryId = ?";

	public StatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(State.class);

		setModelImplClass(StateImpl.class);
		setModelPKClass(long.class);

		setTable(StateTable.INSTANCE);
	}

	/**
	 * Caches the state in the entity cache if it is enabled.
	 *
	 * @param state the state
	 */
	@Override
	public void cacheResult(State state) {
		entityCache.putResult(StateImpl.class, state.getPrimaryKey(), state);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {state.getUuid(), state.getGroupId()}, state);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the states in the entity cache if it is enabled.
	 *
	 * @param states the states
	 */
	@Override
	public void cacheResult(List<State> states) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (states.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (State state : states) {
			if (entityCache.getResult(StateImpl.class, state.getPrimaryKey()) ==
					null) {

				cacheResult(state);
			}
		}
	}

	/**
	 * Clears the cache for all states.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StateImpl.class);

		finderCache.clearCache(StateImpl.class);
	}

	/**
	 * Clears the cache for the state.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(State state) {
		entityCache.removeResult(StateImpl.class, state);
	}

	@Override
	public void clearCache(List<State> states) {
		for (State state : states) {
			entityCache.removeResult(StateImpl.class, state);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(StateImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StateImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(StateModelImpl stateModelImpl) {
		Object[] args = new Object[] {
			stateModelImpl.getUuid(), stateModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, stateModelImpl);
	}

	/**
	 * Creates a new state with the primary key. Does not add the state to the database.
	 *
	 * @param stateId the primary key for the new state
	 * @return the new state
	 */
	@Override
	public State create(long stateId) {
		State state = new StateImpl();

		state.setNew(true);
		state.setPrimaryKey(stateId);

		String uuid = _portalUUID.generate();

		state.setUuid(uuid);

		state.setCompanyId(CompanyThreadLocal.getCompanyId());

		return state;
	}

	/**
	 * Removes the state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the state
	 * @return the state that was removed
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	@Override
	public State remove(long stateId) throws NoSuchStateException {
		return remove((Serializable)stateId);
	}

	/**
	 * Removes the state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the state
	 * @return the state that was removed
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	@Override
	public State remove(Serializable primaryKey) throws NoSuchStateException {
		Session session = null;

		try {
			session = openSession();

			State state = (State)session.get(StateImpl.class, primaryKey);

			if (state == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(state);
		}
		catch (NoSuchStateException noSuchEntityException) {
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
	protected State removeImpl(State state) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(state)) {
				state = (State)session.get(
					StateImpl.class, state.getPrimaryKeyObj());
			}

			if (state != null) {
				session.delete(state);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (state != null) {
			clearCache(state);
		}

		return state;
	}

	@Override
	public State updateImpl(State state) {
		boolean isNew = state.isNew();

		if (!(state instanceof StateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(state.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(state);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in state proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom State implementation " +
					state.getClass());
		}

		StateModelImpl stateModelImpl = (StateModelImpl)state;

		if (Validator.isNull(state.getUuid())) {
			String uuid = _portalUUID.generate();

			state.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (state.getCreateDate() == null)) {
			if (serviceContext == null) {
				state.setCreateDate(date);
			}
			else {
				state.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!stateModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				state.setModifiedDate(date);
			}
			else {
				state.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(state);
			}
			else {
				state = (State)session.merge(state);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(StateImpl.class, stateModelImpl, false, true);

		cacheUniqueFindersCache(stateModelImpl);

		if (isNew) {
			state.setNew(false);
		}

		state.resetOriginalValues();

		return state;
	}

	/**
	 * Returns the state with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the state
	 * @return the state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	@Override
	public State findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStateException {

		State state = fetchByPrimaryKey(primaryKey);

		if (state == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return state;
	}

	/**
	 * Returns the state with the primary key or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state
	 * @return the state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	@Override
	public State findByPrimaryKey(long stateId) throws NoSuchStateException {
		return findByPrimaryKey((Serializable)stateId);
	}

	/**
	 * Returns the state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state
	 * @return the state, or <code>null</code> if a state with the primary key could not be found
	 */
	@Override
	public State fetchByPrimaryKey(long stateId) {
		return fetchByPrimaryKey((Serializable)stateId);
	}

	/**
	 * Returns all the states.
	 *
	 * @return the states
	 */
	@Override
	public List<State> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @return the range of states
	 */
	@Override
	public List<State> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of states
	 */
	@Override
	public List<State> findAll(
		int start, int end, OrderByComparator<State> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the states.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of states
	 * @param end the upper bound of the range of states (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of states
	 */
	@Override
	public List<State> findAll(
		int start, int end, OrderByComparator<State> orderByComparator,
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

		List<State> list = null;

		if (useFinderCache) {
			list = (List<State>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STATE;

				sql = sql.concat(StateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<State>)QueryUtil.list(
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
	 * Removes all the states from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (State state : findAll()) {
			remove(state);
		}
	}

	/**
	 * Returns the number of states.
	 *
	 * @return the number of states
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STATE);

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
		return "stateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the state persistence.
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

		_finderPathWithPaginationFindBystateName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystateName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"stateName"}, true);

		_finderPathWithoutPaginationFindBystateName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystateName",
			new String[] {String.class.getName()}, new String[] {"stateName"},
			true);

		_finderPathCountBystateName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystateName",
			new String[] {String.class.getName()}, new String[] {"stateName"},
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

		_setStateUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setStateUtilPersistence(null);

		entityCache.removeCache(StateImpl.class.getName());
	}

	private void _setStateUtilPersistence(StatePersistence statePersistence) {
		try {
			Field field = StateUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, statePersistence);
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

	private static final String _SQL_SELECT_STATE =
		"SELECT state FROM State state";

	private static final String _SQL_SELECT_STATE_WHERE =
		"SELECT state FROM State state WHERE ";

	private static final String _SQL_COUNT_STATE =
		"SELECT COUNT(state) FROM State state";

	private static final String _SQL_COUNT_STATE_WHERE =
		"SELECT COUNT(state) FROM State state WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "state.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No State exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No State exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StatePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}