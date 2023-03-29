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

import com.aixtor.training.exception.NoSuchDesignationException;
import com.aixtor.training.model.Designation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the designation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DesignationUtil
 * @generated
 */
@ProviderType
public interface DesignationPersistence extends BasePersistence<Designation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DesignationUtil} to access the designation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching designations
	 */
	public java.util.List<Designation> findByUuid(String uuid);

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
	public java.util.List<Designation> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Designation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

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
	public java.util.List<Designation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the designations before and after the current designation in the ordered set where uuid = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation[] findByUuid_PrevAndNext(
			long designationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of designations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching designations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the designation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByUUID_G(String uuid, long groupId)
		throws NoSuchDesignationException;

	/**
	 * Returns the designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the designation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the designation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the designation that was removed
	 */
	public Designation removeByUUID_G(String uuid, long groupId)
		throws NoSuchDesignationException;

	/**
	 * Returns the number of designations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching designations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching designations
	 */
	public java.util.List<Designation> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<Designation> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Designation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

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
	public java.util.List<Designation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

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
	public Designation[] findByUuid_C_PrevAndNext(
			long designationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of designations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching designations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the designations where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @return the matching designations
	 */
	public java.util.List<Designation> findBydesignationName(
		String designationName);

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
	public java.util.List<Designation> findBydesignationName(
		String designationName, int start, int end);

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
	public java.util.List<Designation> findBydesignationName(
		String designationName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

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
	public java.util.List<Designation> findBydesignationName(
		String designationName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findBydesignationName_First(
			String designationName,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the first designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchBydesignationName_First(
		String designationName,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the last designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation
	 * @throws NoSuchDesignationException if a matching designation could not be found
	 */
	public Designation findBydesignationName_Last(
			String designationName,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Returns the last designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching designation, or <code>null</code> if a matching designation could not be found
	 */
	public Designation fetchBydesignationName_Last(
		String designationName,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

	/**
	 * Returns the designations before and after the current designation in the ordered set where designationName = &#63;.
	 *
	 * @param designationId the primary key of the current designation
	 * @param designationName the designation name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation[] findBydesignationName_PrevAndNext(
			long designationId, String designationName,
			com.liferay.portal.kernel.util.OrderByComparator<Designation>
				orderByComparator)
		throws NoSuchDesignationException;

	/**
	 * Removes all the designations where designationName = &#63; from the database.
	 *
	 * @param designationName the designation name
	 */
	public void removeBydesignationName(String designationName);

	/**
	 * Returns the number of designations where designationName = &#63;.
	 *
	 * @param designationName the designation name
	 * @return the number of matching designations
	 */
	public int countBydesignationName(String designationName);

	/**
	 * Caches the designation in the entity cache if it is enabled.
	 *
	 * @param designation the designation
	 */
	public void cacheResult(Designation designation);

	/**
	 * Caches the designations in the entity cache if it is enabled.
	 *
	 * @param designations the designations
	 */
	public void cacheResult(java.util.List<Designation> designations);

	/**
	 * Creates a new designation with the primary key. Does not add the designation to the database.
	 *
	 * @param designationId the primary key for the new designation
	 * @return the new designation
	 */
	public Designation create(long designationId);

	/**
	 * Removes the designation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation that was removed
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation remove(long designationId)
		throws NoSuchDesignationException;

	public Designation updateImpl(Designation designation);

	/**
	 * Returns the designation with the primary key or throws a <code>NoSuchDesignationException</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation
	 * @throws NoSuchDesignationException if a designation with the primary key could not be found
	 */
	public Designation findByPrimaryKey(long designationId)
		throws NoSuchDesignationException;

	/**
	 * Returns the designation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param designationId the primary key of the designation
	 * @return the designation, or <code>null</code> if a designation with the primary key could not be found
	 */
	public Designation fetchByPrimaryKey(long designationId);

	/**
	 * Returns all the designations.
	 *
	 * @return the designations
	 */
	public java.util.List<Designation> findAll();

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
	public java.util.List<Designation> findAll(int start, int end);

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
	public java.util.List<Designation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator);

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
	public java.util.List<Designation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Designation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the designations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of designations.
	 *
	 * @return the number of designations
	 */
	public int countAll();

}