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

import com.aixtor.training.model.Designation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the designation service. This utility wraps <code>com.aixtor.training.service.persistence.impl.DesignationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationPersistence
 * @generated
 */
public class DesignationUtil {

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
	public static void clearCache(Designation designation) {
		getPersistence().clearCache(designation);
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
	public static Map<Serializable, Designation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Designation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Designation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Designation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Designation update(Designation designation) {
		return getPersistence().update(designation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Designation update(
		Designation designation, ServiceContext serviceContext) {

		return getPersistence().update(designation, serviceContext);
	}

	/**
	 * Returns all the designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching designations
	 */
	public static List<Designation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Designation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Designation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Designation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByUuid_First(
			String uuid, OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByUuid_First(
		String uuid, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByUuid_Last(
			String uuid, OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByUuid_Last(
		String uuid, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Designation[] findByUuid_PrevAndNext(
			long designationId, String uuid,
			OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByUuid_PrevAndNext(
			designationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the designations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching designations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the designation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByUUID_G(String uuid, long groupId)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the designation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the designation that was removed
	 */
	public static Designation removeByUUID_G(String uuid, long groupId)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of designations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching designations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching designations
	 */
	public static List<Designation> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Designation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Designation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<Designation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static Designation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static Designation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static Designation[] findByUuid_C_PrevAndNext(
			long designationId, String uuid, long companyId,
			OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			designationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the designations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching designations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the designations where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @return the matching designations
	 */
	public static List<Designation> findByDesignationName(
		String designationName) {

		return getPersistence().findByDesignationName(designationName);
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
	public static List<Designation> findByDesignationName(
		String designationName, int start, int end) {

		return getPersistence().findByDesignationName(
			designationName, start, end);
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
	public static List<Designation> findByDesignationName(
		String designationName, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByDesignationName(
			designationName, start, end, orderByComparator);
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
	public static List<Designation> findByDesignationName(
		String designationName, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDesignationName(
			designationName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationName_First(
			String designationName,
			OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationName_First(
			designationName, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationName_First(
		String designationName,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationName_First(
			designationName, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationName_Last(
			String designationName,
			OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationName_Last(
			designationName, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationName_Last(
		String designationName,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationName_Last(
			designationName, orderByComparator);
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
	public static Designation[] findByDesignationName_PrevAndNext(
			long designationId, String designationName,
			OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationName_PrevAndNext(
			designationId, designationName, orderByComparator);
	}

	/**
	 * Removes all the designations where designationName = &#63; from the database.
	 *
	 * @param designationName the designation name
	 */
	public static void removeByDesignationName(String designationName) {
		getPersistence().removeByDesignationName(designationName);
	}

	/**
	 * Returns the number of designations where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @return the number of matching designations
	 */
	public static int countByDesignationName(String designationName) {
		return getPersistence().countByDesignationName(designationName);
	}

	/**
	 * Returns all the designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the matching designations
	 */
	public static List<Designation> findByDesignationId(long designationId) {
		return getPersistence().findByDesignationId(designationId);
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
	public static List<Designation> findByDesignationId(
		long designationId, int start, int end) {

		return getPersistence().findByDesignationId(designationId, start, end);
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
	public static List<Designation> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findByDesignationId(
			designationId, start, end, orderByComparator);
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
	public static List<Designation> findByDesignationId(
		long designationId, int start, int end,
		OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByDesignationId(
			designationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationId_First(
			long designationId,
			OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationId_First(
			designationId, orderByComparator);
	}

	/**
	 * Returns the first designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationId_First(
		long designationId, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationId_First(
			designationId, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public static Designation findByDesignationId_Last(
			long designationId,
			OrderByComparator<Designation> orderByComparator)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByDesignationId_Last(
			designationId, orderByComparator);
	}

	/**
	 * Returns the last designation in the ordered set where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public static Designation fetchByDesignationId_Last(
		long designationId, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().fetchByDesignationId_Last(
			designationId, orderByComparator);
	}

	/**
	 * Removes all the designations where designationId = &#63; from the database.
	 *
	 * @param designationId the designation ID
	 */
	public static void removeByDesignationId(long designationId) {
		getPersistence().removeByDesignationId(designationId);
	}

	/**
	 * Returns the number of designations where designationId = &#63;.
	 *
	 * @param designationId the designation ID
	 * @return the number of matching designations
	 */
	public static int countByDesignationId(long designationId) {
		return getPersistence().countByDesignationId(designationId);
	}

	/**
	 * Caches the designation in the entity cache if it is enabled.
	 *
	 * @param designation the designation
	 */
	public static void cacheResult(Designation designation) {
		getPersistence().cacheResult(designation);
	}

	/**
	 * Caches the designations in the entity cache if it is enabled.
	 *
	 * @param designations the designations
	 */
	public static void cacheResult(List<Designation> designations) {
		getPersistence().cacheResult(designations);
	}

	/**
	 * Creates a new designation with the primary key. Does not add the designation to the database.
	 *
	 * @param designationId the primary key for the new designation
	 * @return the new designation
	 */
	public static Designation create(long designationId) {
		return getPersistence().create(designationId);
	}

	/**
	 * Removes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation that was removed
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation remove(long designationId)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().remove(designationId);
	}

	public static Designation updateImpl(Designation designation) {
		return getPersistence().updateImpl(designation);
	}

	/**
	 * Returns the designation with the primary key or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public static Designation findByPrimaryKey(long designationId)
		throws com.aixtor.training.exception.NoSuchDesignationException {

		return getPersistence().findByPrimaryKey(designationId);
	}

	/**
	 * Returns the designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation, or <code>null</code> if a designation with the primary key could not be found
	 */
	public static Designation fetchByPrimaryKey(long designationId) {
		return getPersistence().fetchByPrimaryKey(designationId);
	}

	/**
	 * Returns all the designations.
	 *
	 * @return the designations
	 */
	public static List<Designation> findAll() {
		return getPersistence().findAll();
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
	public static List<Designation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Designation> findAll(
		int start, int end, OrderByComparator<Designation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Designation> findAll(
		int start, int end, OrderByComparator<Designation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the designations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of designations.
	 *
	 * @return the number of designations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DesignationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile DesignationPersistence _persistence;

}