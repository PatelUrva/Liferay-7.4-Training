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

package com.aixtor.training.service.persistence;

import com.aixtor.training.model.State;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the state service. This utility wraps <code>com.aixtor.training.service.persistence.impl.StatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatePersistence
 * @generated
 */
public class StateUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(State state) {
		getPersistence().clearCache(state);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, State> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<State> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<State> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<State> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<State> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static State update(State state) {
		return getPersistence().update(state);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static State update(State state, ServiceContext serviceContext) {
		return getPersistence().update(state, serviceContext);
	}

	/**
	 * Returns all the states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching states
	 */
	public static List<State> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<State> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<State> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<State> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<State> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<State> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public static State findByUuid_First(
			String uuid, OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchByUuid_First(
		String uuid, OrderByComparator<State> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public static State findByUuid_Last(
			String uuid, OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchByUuid_Last(
		String uuid, OrderByComparator<State> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static State[] findByUuid_PrevAndNext(
			long stateId, String uuid,
			OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findByUuid_PrevAndNext(
			stateId, uuid, orderByComparator);
	}

	/**
	 * Removes all the states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching states
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the state where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public static State findByUUID_G(String uuid, long groupId)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the state that was removed
	 */
	public static State removeByUUID_G(String uuid, long groupId)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching states
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching states
	 */
	public static List<State> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<State> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<State> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<State> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<State> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<State> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static State findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<State> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static State findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<State> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static State[] findByUuid_C_PrevAndNext(
			long stateId, String uuid, long companyId,
			OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findByUuid_C_PrevAndNext(
			stateId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching states
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the states where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @return the matching states
	 */
	public static List<State> findBystateName(String stateName) {
		return getPersistence().findBystateName(stateName);
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
	public static List<State> findBystateName(
		String stateName, int start, int end) {

		return getPersistence().findBystateName(stateName, start, end);
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
	public static List<State> findBystateName(
		String stateName, int start, int end,
		OrderByComparator<State> orderByComparator) {

		return getPersistence().findBystateName(
			stateName, start, end, orderByComparator);
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
	public static List<State> findBystateName(
		String stateName, int start, int end,
		OrderByComparator<State> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBystateName(
			stateName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public static State findBystateName_First(
			String stateName, OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findBystateName_First(
			stateName, orderByComparator);
	}

	/**
	 * Returns the first state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchBystateName_First(
		String stateName, OrderByComparator<State> orderByComparator) {

		return getPersistence().fetchBystateName_First(
			stateName, orderByComparator);
	}

	/**
	 * Returns the last state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public static State findBystateName_Last(
			String stateName, OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findBystateName_Last(
			stateName, orderByComparator);
	}

	/**
	 * Returns the last state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchBystateName_Last(
		String stateName, OrderByComparator<State> orderByComparator) {

		return getPersistence().fetchBystateName_Last(
			stateName, orderByComparator);
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
	public static State[] findBystateName_PrevAndNext(
			long stateId, String stateName,
			OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findBystateName_PrevAndNext(
			stateId, stateName, orderByComparator);
	}

	/**
	 * Removes all the states where stateName = &#63; from the database.
	 *
	 * @param stateName the state name
	 */
	public static void removeBystateName(String stateName) {
		getPersistence().removeBystateName(stateName);
	}

	/**
	 * Returns the number of states where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @return the number of matching states
	 */
	public static int countBystateName(String stateName) {
		return getPersistence().countBystateName(stateName);
	}

	/**
	 * Returns all the states where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the matching states
	 */
	public static List<State> findBycountryId(long countryId) {
		return getPersistence().findBycountryId(countryId);
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
	public static List<State> findBycountryId(
		long countryId, int start, int end) {

		return getPersistence().findBycountryId(countryId, start, end);
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
	public static List<State> findBycountryId(
		long countryId, int start, int end,
		OrderByComparator<State> orderByComparator) {

		return getPersistence().findBycountryId(
			countryId, start, end, orderByComparator);
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
	public static List<State> findBycountryId(
		long countryId, int start, int end,
		OrderByComparator<State> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycountryId(
			countryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public static State findBycountryId_First(
			long countryId, OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findBycountryId_First(
			countryId, orderByComparator);
	}

	/**
	 * Returns the first state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchBycountryId_First(
		long countryId, OrderByComparator<State> orderByComparator) {

		return getPersistence().fetchBycountryId_First(
			countryId, orderByComparator);
	}

	/**
	 * Returns the last state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public static State findBycountryId_Last(
			long countryId, OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findBycountryId_Last(
			countryId, orderByComparator);
	}

	/**
	 * Returns the last state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	public static State fetchBycountryId_Last(
		long countryId, OrderByComparator<State> orderByComparator) {

		return getPersistence().fetchBycountryId_Last(
			countryId, orderByComparator);
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
	public static State[] findBycountryId_PrevAndNext(
			long stateId, long countryId,
			OrderByComparator<State> orderByComparator)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findBycountryId_PrevAndNext(
			stateId, countryId, orderByComparator);
	}

	/**
	 * Removes all the states where countryId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 */
	public static void removeBycountryId(long countryId) {
		getPersistence().removeBycountryId(countryId);
	}

	/**
	 * Returns the number of states where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the number of matching states
	 */
	public static int countBycountryId(long countryId) {
		return getPersistence().countBycountryId(countryId);
	}

	/**
	 * Caches the state in the entity cache if it is enabled.
	 *
	 * @param state the state
	 */
	public static void cacheResult(State state) {
		getPersistence().cacheResult(state);
	}

	/**
	 * Caches the states in the entity cache if it is enabled.
	 *
	 * @param states the states
	 */
	public static void cacheResult(List<State> states) {
		getPersistence().cacheResult(states);
	}

	/**
	 * Creates a new state with the primary key. Does not add the state to the database.
	 *
	 * @param stateId the primary key for the new state
	 * @return the new state
	 */
	public static State create(long stateId) {
		return getPersistence().create(stateId);
	}

	/**
	 * Removes the state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the state
	 * @return the state that was removed
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	public static State remove(long stateId)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().remove(stateId);
	}

	public static State updateImpl(State state) {
		return getPersistence().updateImpl(state);
	}

	/**
	 * Returns the state with the primary key or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state
	 * @return the state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	public static State findByPrimaryKey(long stateId)
		throws com.aixtor.training.exception.NoSuchStateException {

		return getPersistence().findByPrimaryKey(stateId);
	}

	/**
	 * Returns the state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state
	 * @return the state, or <code>null</code> if a state with the primary key could not be found
	 */
	public static State fetchByPrimaryKey(long stateId) {
		return getPersistence().fetchByPrimaryKey(stateId);
	}

	/**
	 * Returns all the states.
	 *
	 * @return the states
	 */
	public static List<State> findAll() {
		return getPersistence().findAll();
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
	public static List<State> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<State> findAll(
		int start, int end, OrderByComparator<State> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<State> findAll(
		int start, int end, OrderByComparator<State> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the states from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of states.
	 *
	 * @return the number of states
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StatePersistence getPersistence() {
		return _persistence;
	}

	private static volatile StatePersistence _persistence;

}