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
 * This class is a wrapper for {@link Designation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Designation
 * @generated
 */
public class DesignationWrapper
	extends BaseModelWrapper<Designation>
	implements Designation, ModelWrapper<Designation> {

	public DesignationWrapper(Designation designation) {
		super(designation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("designationId", getDesignationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("designationName", getDesignationName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long designationId = (Long)attributes.get("designationId");

		if (designationId != null) {
			setDesignationId(designationId);
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

		String designationName = (String)attributes.get("designationName");

		if (designationName != null) {
			setDesignationName(designationName);
		}
	}

	@Override
	public Designation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this designation.
	 *
	 * @return the company ID of this designation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this designation.
	 *
	 * @return the create date of this designation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the designation ID of this designation.
	 *
	 * @return the designation ID of this designation
	 */
	@Override
	public long getDesignationId() {
		return model.getDesignationId();
	}

	/**
	 * Returns the designation name of this designation.
	 *
	 * @return the designation name of this designation
	 */
	@Override
	public String getDesignationName() {
		return model.getDesignationName();
	}

	/**
	 * Returns the group ID of this designation.
	 *
	 * @return the group ID of this designation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this designation.
	 *
	 * @return the modified date of this designation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this designation.
	 *
	 * @return the primary key of this designation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this designation.
	 *
	 * @return the user ID of this designation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this designation.
	 *
	 * @return the user name of this designation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this designation.
	 *
	 * @return the user uuid of this designation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this designation.
	 *
	 * @return the uuid of this designation
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
	 * Sets the company ID of this designation.
	 *
	 * @param companyId the company ID of this designation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this designation.
	 *
	 * @param createDate the create date of this designation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the designation ID of this designation.
	 *
	 * @param designationId the designation ID of this designation
	 */
	@Override
	public void setDesignationId(long designationId) {
		model.setDesignationId(designationId);
	}

	/**
	 * Sets the designation name of this designation.
	 *
	 * @param designationName the designation name of this designation
	 */
	@Override
	public void setDesignationName(String designationName) {
		model.setDesignationName(designationName);
	}

	/**
	 * Sets the group ID of this designation.
	 *
	 * @param groupId the group ID of this designation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this designation.
	 *
	 * @param modifiedDate the modified date of this designation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this designation.
	 *
	 * @param primaryKey the primary key of this designation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this designation.
	 *
	 * @param userId the user ID of this designation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this designation.
	 *
	 * @param userName the user name of this designation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this designation.
	 *
	 * @param userUuid the user uuid of this designation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this designation.
	 *
	 * @param uuid the uuid of this designation
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
	protected DesignationWrapper wrap(Designation designation) {
		return new DesignationWrapper(designation);
	}

}