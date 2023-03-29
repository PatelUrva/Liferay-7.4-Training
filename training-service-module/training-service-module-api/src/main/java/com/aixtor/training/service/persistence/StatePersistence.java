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

import com.aixtor.training.exception.NoSuchStateException;
import com.aixtor.training.model.State;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the state service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StateUtil
 * @generated
 */
@ProviderType
public interface StatePersistence extends BasePersistence<State> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StateUtil} to access the state persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching states
	 */
	public java.util.List<State> findByUuid(String uuid);

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
	public java.util.List<State> findByUuid(String uuid, int start, int end);

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
	public java.util.List<State> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

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
	public java.util.List<State> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public State findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the first state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

	/**
	 * Returns the last state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public State findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the last state in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

	/**
	 * Returns the states before and after the current state in the ordered set where uuid = &#63;.
	 *
	 * @param stateId the primary key of the current state
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	public State[] findByUuid_PrevAndNext(
			long stateId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Removes all the states where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of states where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching states
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the state where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public State findByUUID_G(String uuid, long groupId)
		throws NoSuchStateException;

	/**
	 * Returns the state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the state where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the state where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the state that was removed
	 */
	public State removeByUUID_G(String uuid, long groupId)
		throws NoSuchStateException;

	/**
	 * Returns the number of states where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching states
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching states
	 */
	public java.util.List<State> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<State> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<State> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

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
	public java.util.List<State> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public State findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the first state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

	/**
	 * Returns the last state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public State findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the last state in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

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
	public State[] findByUuid_C_PrevAndNext(
			long stateId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Removes all the states where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of states where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching states
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the states where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @return the matching states
	 */
	public java.util.List<State> findBystateName(String stateName);

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
	public java.util.List<State> findBystateName(
		String stateName, int start, int end);

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
	public java.util.List<State> findBystateName(
		String stateName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

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
	public java.util.List<State> findBystateName(
		String stateName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public State findBystateName_First(
			String stateName,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the first state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchBystateName_First(
		String stateName,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

	/**
	 * Returns the last state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public State findBystateName_Last(
			String stateName,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the last state in the ordered set where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchBystateName_Last(
		String stateName,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

	/**
	 * Returns the states before and after the current state in the ordered set where stateName = &#63;.
	 *
	 * @param stateId the primary key of the current state
	 * @param stateName the state name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	public State[] findBystateName_PrevAndNext(
			long stateId, String stateName,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Removes all the states where stateName = &#63; from the database.
	 *
	 * @param stateName the state name
	 */
	public void removeBystateName(String stateName);

	/**
	 * Returns the number of states where stateName = &#63;.
	 *
	 * @param stateName the state name
	 * @return the number of matching states
	 */
	public int countBystateName(String stateName);

	/**
	 * Returns all the states where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the matching states
	 */
	public java.util.List<State> findBycountryId(long countryId);

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
	public java.util.List<State> findBycountryId(
		long countryId, int start, int end);

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
	public java.util.List<State> findBycountryId(
		long countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

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
	public java.util.List<State> findBycountryId(
		long countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public State findBycountryId_First(
			long countryId,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the first state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchBycountryId_First(
		long countryId,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

	/**
	 * Returns the last state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state
	 * @throws NoSuchStateException if a matching state could not be found
	 */
	public State findBycountryId_Last(
			long countryId,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Returns the last state in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching state, or <code>null</code> if a matching state could not be found
	 */
	public State fetchBycountryId_Last(
		long countryId,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

	/**
	 * Returns the states before and after the current state in the ordered set where countryId = &#63;.
	 *
	 * @param stateId the primary key of the current state
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	public State[] findBycountryId_PrevAndNext(
			long stateId, long countryId,
			com.liferay.portal.kernel.util.OrderByComparator<State>
				orderByComparator)
		throws NoSuchStateException;

	/**
	 * Removes all the states where countryId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 */
	public void removeBycountryId(long countryId);

	/**
	 * Returns the number of states where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the number of matching states
	 */
	public int countBycountryId(long countryId);

	/**
	 * Caches the state in the entity cache if it is enabled.
	 *
	 * @param state the state
	 */
	public void cacheResult(State state);

	/**
	 * Caches the states in the entity cache if it is enabled.
	 *
	 * @param states the states
	 */
	public void cacheResult(java.util.List<State> states);

	/**
	 * Creates a new state with the primary key. Does not add the state to the database.
	 *
	 * @param stateId the primary key for the new state
	 * @return the new state
	 */
	public State create(long stateId);

	/**
	 * Removes the state with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stateId the primary key of the state
	 * @return the state that was removed
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	public State remove(long stateId) throws NoSuchStateException;

	public State updateImpl(State state);

	/**
	 * Returns the state with the primary key or throws a <code>NoSuchStateException</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state
	 * @return the state
	 * @throws NoSuchStateException if a state with the primary key could not be found
	 */
	public State findByPrimaryKey(long stateId) throws NoSuchStateException;

	/**
	 * Returns the state with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stateId the primary key of the state
	 * @return the state, or <code>null</code> if a state with the primary key could not be found
	 */
	public State fetchByPrimaryKey(long stateId);

	/**
	 * Returns all the states.
	 *
	 * @return the states
	 */
	public java.util.List<State> findAll();

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
	public java.util.List<State> findAll(int start, int end);

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
	public java.util.List<State> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator);

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
	public java.util.List<State> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<State>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the states from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of states.
	 *
	 * @return the number of states
	 */
	public int countAll();

}