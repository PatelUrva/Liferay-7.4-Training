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

import com.aixtor.training.exception.NoSuchCityException;
import com.aixtor.training.model.City;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityUtil
 * @generated
 */
@ProviderType
public interface CityPersistence extends BasePersistence<City> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CityUtil} to access the city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cities
	 */
	public java.util.List<City> findByUuid(String uuid);

	/**
	 * Returns a range of all the cities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of matching cities
	 */
	public java.util.List<City> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the cities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cities
	 */
	public java.util.List<City> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cities
	 */
	public java.util.List<City> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first city in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the first city in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns the last city in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the last city in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns the cities before and after the current city in the ordered set where uuid = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public City[] findByUuid_PrevAndNext(
			long cityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Removes all the cities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cities
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the city where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByUUID_G(String uuid, long groupId)
		throws NoSuchCityException;

	/**
	 * Returns the city where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the city where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the city where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the city that was removed
	 */
	public City removeByUUID_G(String uuid, long groupId)
		throws NoSuchCityException;

	/**
	 * Returns the number of cities where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cities
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the cities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cities
	 */
	public java.util.List<City> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the cities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of matching cities
	 */
	public java.util.List<City> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the cities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cities
	 */
	public java.util.List<City> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cities
	 */
	public java.util.List<City> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first city in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the first city in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns the last city in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the last city in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns the cities before and after the current city in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public City[] findByUuid_C_PrevAndNext(
			long cityId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Removes all the cities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of cities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cities
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the cities where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @return the matching cities
	 */
	public java.util.List<City> findBycityName(String cityName);

	/**
	 * Returns a range of all the cities where cityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param cityName the city name
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of matching cities
	 */
	public java.util.List<City> findBycityName(
		String cityName, int start, int end);

	/**
	 * Returns an ordered range of all the cities where cityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param cityName the city name
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cities
	 */
	public java.util.List<City> findBycityName(
		String cityName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cities where cityName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param cityName the city name
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cities
	 */
	public java.util.List<City> findBycityName(
		String cityName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findBycityName_First(
			String cityName,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the first city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchBycityName_First(
		String cityName,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns the last city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findBycityName_Last(
			String cityName,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the last city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchBycityName_Last(
		String cityName,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns the cities before and after the current city in the ordered set where cityName = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public City[] findBycityName_PrevAndNext(
			long cityId, String cityName,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Removes all the cities where cityName = &#63; from the database.
	 *
	 * @param cityName the city name
	 */
	public void removeBycityName(String cityName);

	/**
	 * Returns the number of cities where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @return the number of matching cities
	 */
	public int countBycityName(String cityName);

	/**
	 * Returns all the cities where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching cities
	 */
	public java.util.List<City> findBystateId(long stateId);

	/**
	 * Returns a range of all the cities where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of matching cities
	 */
	public java.util.List<City> findBystateId(long stateId, int start, int end);

	/**
	 * Returns an ordered range of all the cities where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cities
	 */
	public java.util.List<City> findBystateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cities where stateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param stateId the state ID
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cities
	 */
	public java.util.List<City> findBystateId(
		long stateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first city in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findBystateId_First(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the first city in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchBystateId_First(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns the last city in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public City findBystateId_Last(
			long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Returns the last city in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public City fetchBystateId_Last(
		long stateId,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns the cities before and after the current city in the ordered set where stateId = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public City[] findBystateId_PrevAndNext(
			long cityId, long stateId,
			com.liferay.portal.kernel.util.OrderByComparator<City>
				orderByComparator)
		throws NoSuchCityException;

	/**
	 * Removes all the cities where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public void removeBystateId(long stateId);

	/**
	 * Returns the number of cities where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching cities
	 */
	public int countBystateId(long stateId);

	/**
	 * Caches the city in the entity cache if it is enabled.
	 *
	 * @param city the city
	 */
	public void cacheResult(City city);

	/**
	 * Caches the cities in the entity cache if it is enabled.
	 *
	 * @param cities the cities
	 */
	public void cacheResult(java.util.List<City> cities);

	/**
	 * Creates a new city with the primary key. Does not add the city to the database.
	 *
	 * @param cityId the primary key for the new city
	 * @return the new city
	 */
	public City create(long cityId);

	/**
	 * Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityId the primary key of the city
	 * @return the city that was removed
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public City remove(long cityId) throws NoSuchCityException;

	public City updateImpl(City city);

	/**
	 * Returns the city with the primary key or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public City findByPrimaryKey(long cityId) throws NoSuchCityException;

	/**
	 * Returns the city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city, or <code>null</code> if a city with the primary key could not be found
	 */
	public City fetchByPrimaryKey(long cityId);

	/**
	 * Returns all the cities.
	 *
	 * @return the cities
	 */
	public java.util.List<City> findAll();

	/**
	 * Returns a range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @return the range of cities
	 */
	public java.util.List<City> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cities
	 */
	public java.util.List<City> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator);

	/**
	 * Returns an ordered range of all the cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cities
	 * @param end the upper bound of the range of cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cities
	 */
	public java.util.List<City> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<City>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cities.
	 *
	 * @return the number of cities
	 */
	public int countAll();

}