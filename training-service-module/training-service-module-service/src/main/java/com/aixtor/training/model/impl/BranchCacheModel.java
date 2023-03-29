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

import com.aixtor.training.model.Branch;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Branch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BranchCacheModel implements CacheModel<Branch>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BranchCacheModel)) {
			return false;
		}

		BranchCacheModel branchCacheModel = (BranchCacheModel)object;

		if (branchId == branchCacheModel.branchId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, branchId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", branchId=");
		sb.append(branchId);
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
		sb.append(", branchName=");
		sb.append(branchName);
		sb.append(", cityId=");
		sb.append(cityId);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", pincode=");
		sb.append(pincode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Branch toEntityModel() {
		BranchImpl branchImpl = new BranchImpl();

		if (uuid == null) {
			branchImpl.setUuid("");
		}
		else {
			branchImpl.setUuid(uuid);
		}

		branchImpl.setBranchId(branchId);
		branchImpl.setGroupId(groupId);
		branchImpl.setCompanyId(companyId);
		branchImpl.setUserId(userId);

		if (userName == null) {
			branchImpl.setUserName("");
		}
		else {
			branchImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			branchImpl.setCreateDate(null);
		}
		else {
			branchImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			branchImpl.setModifiedDate(null);
		}
		else {
			branchImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (branchName == null) {
			branchImpl.setBranchName("");
		}
		else {
			branchImpl.setBranchName(branchName);
		}

		branchImpl.setCityId(cityId);

		if (address1 == null) {
			branchImpl.setAddress1("");
		}
		else {
			branchImpl.setAddress1(address1);
		}

		if (address2 == null) {
			branchImpl.setAddress2("");
		}
		else {
			branchImpl.setAddress2(address2);
		}

		branchImpl.setCountryId(countryId);
		branchImpl.setStateId(stateId);
		branchImpl.setPincode(pincode);

		branchImpl.resetOriginalValues();

		return branchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		branchId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		branchName = objectInput.readUTF();

		cityId = objectInput.readLong();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();

		countryId = objectInput.readLong();

		stateId = objectInput.readLong();

		pincode = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(branchId);

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

		if (branchName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(branchName);
		}

		objectOutput.writeLong(cityId);

		if (address1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address2);
		}

		objectOutput.writeLong(countryId);

		objectOutput.writeLong(stateId);

		objectOutput.writeInt(pincode);
	}

	public String uuid;
	public long branchId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String branchName;
	public long cityId;
	public String address1;
	public String address2;
	public long countryId;
	public long stateId;
	public int pincode;

}