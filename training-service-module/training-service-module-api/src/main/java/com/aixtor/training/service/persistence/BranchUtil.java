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

import com.aixtor.training.model.Branch;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the branch service. This utility wraps <code>com.aixtor.training.service.persistence.impl.BranchPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BranchPersistence
 * @generated
 */
public class BranchUtil {

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
	public static void clearCache(Branch branch) {
		getPersistence().clearCache(branch);
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
	public static Map<Serializable, Branch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Branch> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Branch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Branch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Branch update(Branch branch) {
		return getPersistence().update(branch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Branch update(Branch branch, ServiceContext serviceContext) {
		return getPersistence().update(branch, serviceContext);
	}

	/**
	 * Returns all the branches where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching branches
	 */
	public static List<Branch> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Branch> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Branch> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Branch> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findByUuid_First(
			String uuid, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchByUuid_First(
		String uuid, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findByUuid_Last(
			String uuid, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchByUuid_Last(
		String uuid, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Branch[] findByUuid_PrevAndNext(
			long branchId, String uuid,
			OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findByUuid_PrevAndNext(
			branchId, uuid, orderByComparator);
	}

	/**
	 * Removes all the branches where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of branches where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching branches
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the branch where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBranchException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findByUUID_G(String uuid, long groupId)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the branch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the branch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the branch where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the branch that was removed
	 */
	public static Branch removeByUUID_G(String uuid, long groupId)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of branches where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching branches
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the branches where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching branches
	 */
	public static List<Branch> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Branch> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Branch> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<Branch> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static Branch findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static Branch findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static Branch[] findByUuid_C_PrevAndNext(
			long branchId, String uuid, long companyId,
			OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findByUuid_C_PrevAndNext(
			branchId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the branches where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of branches where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching branches
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the branches where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @return the matching branches
	 */
	public static List<Branch> findBybranchName(String branchName) {
		return getPersistence().findBybranchName(branchName);
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
	public static List<Branch> findBybranchName(
		String branchName, int start, int end) {

		return getPersistence().findBybranchName(branchName, start, end);
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
	public static List<Branch> findBybranchName(
		String branchName, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return getPersistence().findBybranchName(
			branchName, start, end, orderByComparator);
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
	public static List<Branch> findBybranchName(
		String branchName, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBybranchName(
			branchName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findBybranchName_First(
			String branchName, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBybranchName_First(
			branchName, orderByComparator);
	}

	/**
	 * Returns the first branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchBybranchName_First(
		String branchName, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchBybranchName_First(
			branchName, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findBybranchName_Last(
			String branchName, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBybranchName_Last(
			branchName, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchBybranchName_Last(
		String branchName, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchBybranchName_Last(
			branchName, orderByComparator);
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
	public static Branch[] findBybranchName_PrevAndNext(
			long branchId, String branchName,
			OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBybranchName_PrevAndNext(
			branchId, branchName, orderByComparator);
	}

	/**
	 * Removes all the branches where branchName = &#63; from the database.
	 *
	 * @param branchName the branch name
	 */
	public static void removeBybranchName(String branchName) {
		getPersistence().removeBybranchName(branchName);
	}

	/**
	 * Returns the number of branches where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @return the number of matching branches
	 */
	public static int countBybranchName(String branchName) {
		return getPersistence().countBybranchName(branchName);
	}

	/**
	 * Returns all the branches where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the matching branches
	 */
	public static List<Branch> findBycountryId(long countryId) {
		return getPersistence().findBycountryId(countryId);
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
	public static List<Branch> findBycountryId(
		long countryId, int start, int end) {

		return getPersistence().findBycountryId(countryId, start, end);
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
	public static List<Branch> findBycountryId(
		long countryId, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return getPersistence().findBycountryId(
			countryId, start, end, orderByComparator);
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
	public static List<Branch> findBycountryId(
		long countryId, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycountryId(
			countryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findBycountryId_First(
			long countryId, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBycountryId_First(
			countryId, orderByComparator);
	}

	/**
	 * Returns the first branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchBycountryId_First(
		long countryId, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchBycountryId_First(
			countryId, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findBycountryId_Last(
			long countryId, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBycountryId_Last(
			countryId, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchBycountryId_Last(
		long countryId, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchBycountryId_Last(
			countryId, orderByComparator);
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
	public static Branch[] findBycountryId_PrevAndNext(
			long branchId, long countryId,
			OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBycountryId_PrevAndNext(
			branchId, countryId, orderByComparator);
	}

	/**
	 * Removes all the branches where countryId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 */
	public static void removeBycountryId(long countryId) {
		getPersistence().removeBycountryId(countryId);
	}

	/**
	 * Returns the number of branches where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the number of matching branches
	 */
	public static int countBycountryId(long countryId) {
		return getPersistence().countBycountryId(countryId);
	}

	/**
	 * Returns all the branches where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching branches
	 */
	public static List<Branch> findBystateId(long stateId) {
		return getPersistence().findBystateId(stateId);
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
	public static List<Branch> findBystateId(long stateId, int start, int end) {
		return getPersistence().findBystateId(stateId, start, end);
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
	public static List<Branch> findBystateId(
		long stateId, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return getPersistence().findBystateId(
			stateId, start, end, orderByComparator);
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
	public static List<Branch> findBystateId(
		long stateId, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBystateId(
			stateId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findBystateId_First(
			long stateId, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBystateId_First(stateId, orderByComparator);
	}

	/**
	 * Returns the first branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchBystateId_First(
		long stateId, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchBystateId_First(
			stateId, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findBystateId_Last(
			long stateId, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBystateId_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchBystateId_Last(
		long stateId, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchBystateId_Last(stateId, orderByComparator);
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
	public static Branch[] findBystateId_PrevAndNext(
			long branchId, long stateId,
			OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBystateId_PrevAndNext(
			branchId, stateId, orderByComparator);
	}

	/**
	 * Removes all the branches where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public static void removeBystateId(long stateId) {
		getPersistence().removeBystateId(stateId);
	}

	/**
	 * Returns the number of branches where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching branches
	 */
	public static int countBystateId(long stateId) {
		return getPersistence().countBystateId(stateId);
	}

	/**
	 * Returns all the branches where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the matching branches
	 */
	public static List<Branch> findBycityId(long cityId) {
		return getPersistence().findBycityId(cityId);
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
	public static List<Branch> findBycityId(long cityId, int start, int end) {
		return getPersistence().findBycityId(cityId, start, end);
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
	public static List<Branch> findBycityId(
		long cityId, int start, int end,
		OrderByComparator<Branch> orderByComparator) {

		return getPersistence().findBycityId(
			cityId, start, end, orderByComparator);
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
	public static List<Branch> findBycityId(
		long cityId, int start, int end,
		OrderByComparator<Branch> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycityId(
			cityId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findBycityId_First(
			long cityId, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBycityId_First(cityId, orderByComparator);
	}

	/**
	 * Returns the first branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchBycityId_First(
		long cityId, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchBycityId_First(cityId, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public static Branch findBycityId_Last(
			long cityId, OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBycityId_Last(cityId, orderByComparator);
	}

	/**
	 * Returns the last branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public static Branch fetchBycityId_Last(
		long cityId, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().fetchBycityId_Last(cityId, orderByComparator);
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
	public static Branch[] findBycityId_PrevAndNext(
			long branchId, long cityId,
			OrderByComparator<Branch> orderByComparator)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findBycityId_PrevAndNext(
			branchId, cityId, orderByComparator);
	}

	/**
	 * Removes all the branches where cityId = &#63; from the database.
	 *
	 * @param cityId the city ID
	 */
	public static void removeBycityId(long cityId) {
		getPersistence().removeBycityId(cityId);
	}

	/**
	 * Returns the number of branches where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the number of matching branches
	 */
	public static int countBycityId(long cityId) {
		return getPersistence().countBycityId(cityId);
	}

	/**
	 * Caches the branch in the entity cache if it is enabled.
	 *
	 * @param branch the branch
	 */
	public static void cacheResult(Branch branch) {
		getPersistence().cacheResult(branch);
	}

	/**
	 * Caches the branches in the entity cache if it is enabled.
	 *
	 * @param branches the branches
	 */
	public static void cacheResult(List<Branch> branches) {
		getPersistence().cacheResult(branches);
	}

	/**
	 * Creates a new branch with the primary key. Does not add the branch to the database.
	 *
	 * @param branchId the primary key for the new branch
	 * @return the new branch
	 */
	public static Branch create(long branchId) {
		return getPersistence().create(branchId);
	}

	/**
	 * Removes the branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param branchId the primary key of the branch
	 * @return the branch that was removed
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	public static Branch remove(long branchId)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().remove(branchId);
	}

	public static Branch updateImpl(Branch branch) {
		return getPersistence().updateImpl(branch);
	}

	/**
	 * Returns the branch with the primary key or throws a <code>NoSuchBranchException</code> if it could not be found.
	 *
	 * @param branchId the primary key of the branch
	 * @return the branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	public static Branch findByPrimaryKey(long branchId)
		throws com.aixtor.training.exception.NoSuchBranchException {

		return getPersistence().findByPrimaryKey(branchId);
	}

	/**
	 * Returns the branch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param branchId the primary key of the branch
	 * @return the branch, or <code>null</code> if a branch with the primary key could not be found
	 */
	public static Branch fetchByPrimaryKey(long branchId) {
		return getPersistence().fetchByPrimaryKey(branchId);
	}

	/**
	 * Returns all the branches.
	 *
	 * @return the branches
	 */
	public static List<Branch> findAll() {
		return getPersistence().findAll();
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
	public static List<Branch> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Branch> findAll(
		int start, int end, OrderByComparator<Branch> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Branch> findAll(
		int start, int end, OrderByComparator<Branch> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the branches from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of branches.
	 *
	 * @return the number of branches
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BranchPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BranchPersistence _persistence;

}