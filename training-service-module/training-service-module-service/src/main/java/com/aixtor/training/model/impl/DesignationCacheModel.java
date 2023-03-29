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

import com.aixtor.training.model.Designation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Designation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DesignationCacheModel
	implements CacheModel<Designation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DesignationCacheModel)) {
			return false;
		}

		DesignationCacheModel designationCacheModel =
			(DesignationCacheModel)object;

		if (designationId == designationCacheModel.designationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, designationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", designationId=");
		sb.append(designationId);
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
		sb.append(", designationName=");
		sb.append(designationName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Designation toEntityModel() {
		DesignationImpl designationImpl = new DesignationImpl();

		if (uuid == null) {
			designationImpl.setUuid("");
		}
		else {
			designationImpl.setUuid(uuid);
		}

		designationImpl.setDesignationId(designationId);
		designationImpl.setGroupId(groupId);
		designationImpl.setCompanyId(companyId);
		designationImpl.setUserId(userId);

		if (userName == null) {
			designationImpl.setUserName("");
		}
		else {
			designationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			designationImpl.setCreateDate(null);
		}
		else {
			designationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			designationImpl.setModifiedDate(null);
		}
		else {
			designationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (designationName == null) {
			designationImpl.setDesignationName("");
		}
		else {
			designationImpl.setDesignationName(designationName);
		}

		designationImpl.resetOriginalValues();

		return designationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		designationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		designationName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(designationId);

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

		if (designationName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designationName);
		}
	}

	public String uuid;
	public long designationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String designationName;

}