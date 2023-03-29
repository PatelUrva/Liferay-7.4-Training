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

import com.aixtor.training.model.City;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the city service. This utility wraps <code>com.aixtor.training.service.persistence.impl.CityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CityPersistence
 * @generated
 */
public class CityUtil {

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
	public static void clearCache(City city) {
		getPersistence().clearCache(city);
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
	public static Map<Serializable, City> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<City> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<City> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<City> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static City update(City city) {
		return getPersistence().update(city);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static City update(City city, ServiceContext serviceContext) {
		return getPersistence().update(city, serviceContext);
	}

	/**
	 * Returns all the cities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cities
	 */
	public static List<City> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<City> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<City> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<City> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first city in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByUuid_First(
			String uuid, OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first city in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByUuid_First(
		String uuid, OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByUuid_Last(
			String uuid, OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByUuid_Last(
		String uuid, OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cities before and after the current city in the ordered set where uuid = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public static City[] findByUuid_PrevAndNext(
			long cityId, String uuid, OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findByUuid_PrevAndNext(
			cityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cities
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the city where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByUUID_G(String uuid, long groupId)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the city where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the city where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the city where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the city that was removed
	 */
	public static City removeByUUID_G(String uuid, long groupId)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of cities where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching cities
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the cities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching cities
	 */
	public static List<City> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<City> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<City> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<City> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first city in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first city in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static City[] findByUuid_C_PrevAndNext(
			long cityId, String uuid, long companyId,
			OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findByUuid_C_PrevAndNext(
			cityId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the cities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of cities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching cities
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the cities where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @return the matching cities
	 */
	public static List<City> findBycityName(String cityName) {
		return getPersistence().findBycityName(cityName);
	}

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
	public static List<City> findBycityName(
		String cityName, int start, int end) {

		return getPersistence().findBycityName(cityName, start, end);
	}

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
	public static List<City> findBycityName(
		String cityName, int start, int end,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().findBycityName(
			cityName, start, end, orderByComparator);
	}

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
	public static List<City> findBycityName(
		String cityName, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycityName(
			cityName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findBycityName_First(
			String cityName, OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findBycityName_First(
			cityName, orderByComparator);
	}

	/**
	 * Returns the first city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchBycityName_First(
		String cityName, OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchBycityName_First(
			cityName, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findBycityName_Last(
			String cityName, OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findBycityName_Last(
			cityName, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchBycityName_Last(
		String cityName, OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchBycityName_Last(
			cityName, orderByComparator);
	}

	/**
	 * Returns the cities before and after the current city in the ordered set where cityName = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param cityName the city name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public static City[] findBycityName_PrevAndNext(
			long cityId, String cityName,
			OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findBycityName_PrevAndNext(
			cityId, cityName, orderByComparator);
	}

	/**
	 * Removes all the cities where cityName = &#63; from the database.
	 *
	 * @param cityName the city name
	 */
	public static void removeBycityName(String cityName) {
		getPersistence().removeBycityName(cityName);
	}

	/**
	 * Returns the number of cities where cityName = &#63;.
	 *
	 * @param cityName the city name
	 * @return the number of matching cities
	 */
	public static int countBycityName(String cityName) {
		return getPersistence().countBycityName(cityName);
	}

	/**
	 * Returns all the cities where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the matching cities
	 */
	public static List<City> findBystateId(long stateId) {
		return getPersistence().findBystateId(stateId);
	}

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
	public static List<City> findBystateId(long stateId, int start, int end) {
		return getPersistence().findBystateId(stateId, start, end);
	}

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
	public static List<City> findBystateId(
		long stateId, int start, int end,
		OrderByComparator<City> orderByComparator) {

		return getPersistence().findBystateId(
			stateId, start, end, orderByComparator);
	}

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
	public static List<City> findBystateId(
		long stateId, int start, int end,
		OrderByComparator<City> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBystateId(
			stateId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first city in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findBystateId_First(
			long stateId, OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findBystateId_First(stateId, orderByComparator);
	}

	/**
	 * Returns the first city in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchBystateId_First(
		long stateId, OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchBystateId_First(
			stateId, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city
	 * @throws NoSuchCityException if a matching city could not be found
	 */
	public static City findBystateId_Last(
			long stateId, OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findBystateId_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the last city in the ordered set where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching city, or <code>null</code> if a matching city could not be found
	 */
	public static City fetchBystateId_Last(
		long stateId, OrderByComparator<City> orderByComparator) {

		return getPersistence().fetchBystateId_Last(stateId, orderByComparator);
	}

	/**
	 * Returns the cities before and after the current city in the ordered set where stateId = &#63;.
	 *
	 * @param cityId the primary key of the current city
	 * @param stateId the state ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public static City[] findBystateId_PrevAndNext(
			long cityId, long stateId,
			OrderByComparator<City> orderByComparator)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findBystateId_PrevAndNext(
			cityId, stateId, orderByComparator);
	}

	/**
	 * Removes all the cities where stateId = &#63; from the database.
	 *
	 * @param stateId the state ID
	 */
	public static void removeBystateId(long stateId) {
		getPersistence().removeBystateId(stateId);
	}

	/**
	 * Returns the number of cities where stateId = &#63;.
	 *
	 * @param stateId the state ID
	 * @return the number of matching cities
	 */
	public static int countBystateId(long stateId) {
		return getPersistence().countBystateId(stateId);
	}

	/**
	 * Caches the city in the entity cache if it is enabled.
	 *
	 * @param city the city
	 */
	public static void cacheResult(City city) {
		getPersistence().cacheResult(city);
	}

	/**
	 * Caches the cities in the entity cache if it is enabled.
	 *
	 * @param cities the cities
	 */
	public static void cacheResult(List<City> cities) {
		getPersistence().cacheResult(cities);
	}

	/**
	 * Creates a new city with the primary key. Does not add the city to the database.
	 *
	 * @param cityId the primary key for the new city
	 * @return the new city
	 */
	public static City create(long cityId) {
		return getPersistence().create(cityId);
	}

	/**
	 * Removes the city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cityId the primary key of the city
	 * @return the city that was removed
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public static City remove(long cityId)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().remove(cityId);
	}

	public static City updateImpl(City city) {
		return getPersistence().updateImpl(city);
	}

	/**
	 * Returns the city with the primary key or throws a <code>NoSuchCityException</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city
	 * @throws NoSuchCityException if a city with the primary key could not be found
	 */
	public static City findByPrimaryKey(long cityId)
		throws com.aixtor.training.exception.NoSuchCityException {

		return getPersistence().findByPrimaryKey(cityId);
	}

	/**
	 * Returns the city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cityId the primary key of the city
	 * @return the city, or <code>null</code> if a city with the primary key could not be found
	 */
	public static City fetchByPrimaryKey(long cityId) {
		return getPersistence().fetchByPrimaryKey(cityId);
	}

	/**
	 * Returns all the cities.
	 *
	 * @return the cities
	 */
	public static List<City> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<City> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<City> findAll(
		int start, int end, OrderByComparator<City> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<City> findAll(
		int start, int end, OrderByComparator<City> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cities.
	 *
	 * @return the number of cities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CityPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CityPersistence _persistence;

}