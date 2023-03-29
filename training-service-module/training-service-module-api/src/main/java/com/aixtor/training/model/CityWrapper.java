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

package com.aixtor.training.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link City}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see City
 * @generated
 */
public class CityWrapper
	extends BaseModelWrapper<City> implements City, ModelWrapper<City> {

	public CityWrapper(City city) {
		super(city);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("cityId", getCityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("cityName", getCityName());
		attributes.put("stateId", getStateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long cityId = (Long)attributes.get("cityId");

		if (cityId != null) {
			setCityId(cityId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String cityName = (String)attributes.get("cityName");

		if (cityName != null) {
			setCityName(cityName);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}
	}

	@Override
	public City cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the city ID of this city.
	 *
	 * @return the city ID of this city
	 */
	@Override
	public long getCityId() {
		return model.getCityId();
	}

	/**
	 * Returns the city name of this city.
	 *
	 * @return the city name of this city
	 */
	@Override
	public String getCityName() {
		return model.getCityName();
	}

	/**
	 * Returns the company ID of this city.
	 *
	 * @return the company ID of this city
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this city.
	 *
	 * @return the create date of this city
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this city.
	 *
	 * @return the group ID of this city
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this city.
	 *
	 * @return the modified date of this city
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this city.
	 *
	 * @return the primary key of this city
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the state ID of this city.
	 *
	 * @return the state ID of this city
	 */
	@Override
	public long getStateId() {
		return model.getStateId();
	}

	/**
	 * Returns the user ID of this city.
	 *
	 * @return the user ID of this city
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this city.
	 *
	 * @return the user name of this city
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this city.
	 *
	 * @return the user uuid of this city
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this city.
	 *
	 * @return the uuid of this city
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the city ID of this city.
	 *
	 * @param cityId the city ID of this city
	 */
	@Override
	public void setCityId(long cityId) {
		model.setCityId(cityId);
	}

	/**
	 * Sets the city name of this city.
	 *
	 * @param cityName the city name of this city
	 */
	@Override
	public void setCityName(String cityName) {
		model.setCityName(cityName);
	}

	/**
	 * Sets the company ID of this city.
	 *
	 * @param companyId the company ID of this city
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this city.
	 *
	 * @param createDate the create date of this city
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this city.
	 *
	 * @param groupId the group ID of this city
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this city.
	 *
	 * @param modifiedDate the modified date of this city
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this city.
	 *
	 * @param primaryKey the primary key of this city
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the state ID of this city.
	 *
	 * @param stateId the state ID of this city
	 */
	@Override
	public void setStateId(long stateId) {
		model.setStateId(stateId);
	}

	/**
	 * Sets the user ID of this city.
	 *
	 * @param userId the user ID of this city
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this city.
	 *
	 * @param userName the user name of this city
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this city.
	 *
	 * @param userUuid the user uuid of this city
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this city.
	 *
	 * @param uuid the uuid of this city
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CityWrapper wrap(City city) {
		return new CityWrapper(city);
	}

}