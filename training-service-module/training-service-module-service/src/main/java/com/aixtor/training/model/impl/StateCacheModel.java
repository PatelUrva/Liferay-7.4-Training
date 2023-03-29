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

import com.aixtor.training.model.State;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing State in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StateCacheModel implements CacheModel<State>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StateCacheModel)) {
			return false;
		}

		StateCacheModel stateCacheModel = (StateCacheModel)object;

		if (stateId == stateCacheModel.stateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", stateId=");
		sb.append(stateId);
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
		sb.append(", stateName=");
		sb.append(stateName);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public State toEntityModel() {
		StateImpl stateImpl = new StateImpl();

		if (uuid == null) {
			stateImpl.setUuid("");
		}
		else {
			stateImpl.setUuid(uuid);
		}

		stateImpl.setStateId(stateId);
		stateImpl.setGroupId(groupId);
		stateImpl.setCompanyId(companyId);
		stateImpl.setUserId(userId);

		if (userName == null) {
			stateImpl.setUserName("");
		}
		else {
			stateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			stateImpl.setCreateDate(null);
		}
		else {
			stateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stateImpl.setModifiedDate(null);
		}
		else {
			stateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (stateName == null) {
			stateImpl.setStateName("");
		}
		else {
			stateImpl.setStateName(stateName);
		}

		stateImpl.setCountryId(countryId);

		stateImpl.resetOriginalValues();

		return stateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		stateId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		stateName = objectInput.readUTF();

		countryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(stateId);

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

		if (stateName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stateName);
		}

		objectOutput.writeLong(countryId);
	}

	public String uuid;
	public long stateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String stateName;
	public long countryId;

}