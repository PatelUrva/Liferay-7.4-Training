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

package com.aixtor.training.model.impl;

import com.aixtor.training.model.City;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing City in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CityCacheModel implements CacheModel<City>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CityCacheModel)) {
			return false;
		}

		CityCacheModel cityCacheModel = (CityCacheModel)object;

		if (cityId == cityCacheModel.cityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", cityId=");
		sb.append(cityId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", cityName=");
		sb.append(cityName);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public City toEntityModel() {
		CityImpl cityImpl = new CityImpl();

		if (uuid == null) {
			cityImpl.setUuid("");
		}
		else {
			cityImpl.setUuid(uuid);
		}

		cityImpl.setCityId(cityId);
		cityImpl.setGroupId(groupId);
		cityImpl.setCompanyId(companyId);
		cityImpl.setUserId(userId);

		if (userName == null) {
			cityImpl.setUserName("");
		}
		else {
			cityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cityImpl.setCreateDate(null);
		}
		else {
			cityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cityImpl.setModifiedDate(null);
		}
		else {
			cityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (cityName == null) {
			cityImpl.setCityName("");
		}
		else {
			cityImpl.setCityName(cityName);
		}

		cityImpl.setStateId(stateId);

		cityImpl.resetOriginalValues();

		return cityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		cityId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		cityName = objectInput.readUTF();

		stateId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(cityId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (cityName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cityName);
		}

		objectOutput.writeLong(stateId);
	}

	public String uuid;
	public long cityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String cityName;
	public long stateId;

}