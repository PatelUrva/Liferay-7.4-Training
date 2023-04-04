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

import com.aixtor.training.exception.NoSuchBranchException;
import com.aixtor.training.model.Branch;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the branch service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BranchUtil
 * @generated
 */
@ProviderType
public interface BranchPersistence extends BasePersistence<Branch> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BranchUtil} to access the branch persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the branches where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching branches
	 */
	public java.util.List<Branch> findByUuid(String uuid);

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
	public java.util.List<Branch> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Branch> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

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
	public java.util.List<Branch> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the first branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the last branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the last branch in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the branches before and after the current branch in the ordered set where uuid = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	public Branch[] findByUuid_PrevAndNext(
			long branchId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Removes all the branches where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of branches where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching branches
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the branch where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBranchException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findByUUID_G(String uuid, long groupId)
		throws NoSuchBranchException;

	/**
	 * Returns the branch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the branch where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the branch where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the branch that was removed
	 */
	public Branch removeByUUID_G(String uuid, long groupId)
		throws NoSuchBranchException;

	/**
	 * Returns the number of branches where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching branches
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the branches where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching branches
	 */
	public java.util.List<Branch> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Branch> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Branch> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

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
	public java.util.List<Branch> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the first branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the last branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the last branch in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

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
	public Branch[] findByUuid_C_PrevAndNext(
			long branchId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Removes all the branches where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of branches where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching branches
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the branches where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @return the matching branches
	 */
	public java.util.List<Branch> findBybranchName(String branchName);

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
	public java.util.List<Branch> findBybranchName(
		String branchName, int start, int end);

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
	public java.util.List<Branch> findBybranchName(
		String branchName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

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
	public java.util.List<Branch> findBybranchName(
		String branchName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findBybranchName_First(
			String branchName,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the first branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchBybranchName_First(
		String branchName,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the last branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findBybranchName_Last(
			String branchName,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the last branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchBybranchName_Last(
		String branchName,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the branches before and after the current branch in the ordered set where branchName = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param branchName the branch name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	public Branch[] findBybranchName_PrevAndNext(
			long branchId, String branchName,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Removes all the branches where branchName = &#63; from the database.
	 *
	 * @param branchName the branch name
	 */
	public void removeBybranchName(String branchName);

	/**
	 * Returns the number of branches where branchName = &#63;.
	 *
	 * @param branchName the branch name
	 * @return the number of matching branches
	 */
	public int countBybranchName(String branchName);

	/**
	 * Returns all the branches where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the matching branches
	 */
	public java.util.List<Branch> findBycountryId(long countryId);

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
	public java.util.List<Branch> findBycountryId(
		long countryId, int start, int end);

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
	public java.util.List<Branch> findBycountryId(
		long countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

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
	public java.util.List<Branch> findBycountryId(
		long countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findBycountryId_First(
			long countryId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the first branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchBycountryId_First(
		long countryId,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the last branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findBycountryId_Last(
			long countryId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the last branch in the ordered set where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchBycountryId_Last(
		long countryId,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the branches before and after the current branch in the ordered set where countryId = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param countryId the country ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	public Branch[] findBycountryId_PrevAndNext(
			long branchId, long countryId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Removes all the branches where countryId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 */
	public void removeBycountryId(long countryId);

	/**
	 * Returns the number of branches where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the number of matching branches
	 */
	public int countBycountryId(long countryId);

	/**
	 * Returns all the branches where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching branches
	 */
	public java.util.List<Branch> findBystateId(long stateId);

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
	public java.util.List<Branch> findBystateId(
		long stateId, int start, int end);

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
	public java.util.List<Branch> findBystateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

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
	public java.util.List<Branch> findBystateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findBystateId_First(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the first branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchBystateId_First(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the last branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findBystateId_Last(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the last branch in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchBystateId_Last(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the branches before and after the current branch in the ordered set where stateId = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	public Branch[] findBystateId_PrevAndNext(
			long branchId, long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Removes all the branches where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public void removeBystateId(long stateId);

	/**
	 * Returns the number of branches where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching branches
	 */
	public int countBystateId(long stateId);

	/**
	 * Returns all the branches where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the matching branches
	 */
	public java.util.List<Branch> findBycityId(long cityId);

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
	public java.util.List<Branch> findBycityId(long cityId, int start, int end);

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
	public java.util.List<Branch> findBycityId(
		long cityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

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
	public java.util.List<Branch> findBycityId(
		long cityId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findBycityId_First(
			long cityId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the first branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchBycityId_First(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the last branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch
	 * @throws NoSuchBranchException if a matching branch could not be found
	 */
	public Branch findBycityId_Last(
			long cityId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Returns the last branch in the ordered set where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching branch, or <code>null</code> if a matching branch could not be found
	 */
	public Branch fetchBycityId_Last(
		long cityId,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

	/**
	 * Returns the branches before and after the current branch in the ordered set where cityId = &#63;.
	 *
	 * @param branchId the primary key of the current branch
	 * @param cityId the city ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	public Branch[] findBycityId_PrevAndNext(
			long branchId, long cityId,
			com.liferay.portal.kernel.util.OrderByComparator<Branch>
				orderByComparator)
		throws NoSuchBranchException;

	/**
	 * Removes all the branches where cityId = &#63; from the database.
	 *
	 * @param cityId the city ID
	 */
	public void removeBycityId(long cityId);

	/**
	 * Returns the number of branches where cityId = &#63;.
	 *
	 * @param cityId the city ID
	 * @return the number of matching branches
	 */
	public int countBycityId(long cityId);

	/**
	 * Caches the branch in the entity cache if it is enabled.
	 *
	 * @param branch the branch
	 */
	public void cacheResult(Branch branch);

	/**
	 * Caches the branches in the entity cache if it is enabled.
	 *
	 * @param branches the branches
	 */
	public void cacheResult(java.util.List<Branch> branches);

	/**
	 * Creates a new branch with the primary key. Does not add the branch to the database.
	 *
	 * @param branchId the primary key for the new branch
	 * @return the new branch
	 */
	public Branch create(long branchId);

	/**
	 * Removes the branch with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param branchId the primary key of the branch
	 * @return the branch that was removed
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	public Branch remove(long branchId) throws NoSuchBranchException;

	public Branch updateImpl(Branch branch);

	/**
	 * Returns the branch with the primary key or throws a <code>NoSuchBranchException</code> if it could not be found.
	 *
	 * @param branchId the primary key of the branch
	 * @return the branch
	 * @throws NoSuchBranchException if a branch with the primary key could not be found
	 */
	public Branch findByPrimaryKey(long branchId) throws NoSuchBranchException;

	/**
	 * Returns the branch with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param branchId the primary key of the branch
	 * @return the branch, or <code>null</code> if a branch with the primary key could not be found
	 */
	public Branch fetchByPrimaryKey(long branchId);

	/**
	 * Returns all the branches.
	 *
	 * @return the branches
	 */
	public java.util.List<Branch> findAll();

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
	public java.util.List<Branch> findAll(int start, int end);

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
	public java.util.List<Branch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator);

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
	public java.util.List<Branch> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Branch>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the branches from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of branches.
	 *
	 * @return the number of branches
	 */
	public int countAll();

}