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

import com.aixtor.training.model.Employee;
import com.aixtor.training.model.EmployeeModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Employee service. Represents a row in the &quot;FOO_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeModelImpl
	extends BaseModelImpl<Employee> implements EmployeeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee model instance should use the <code>Employee</code> interface instead.
	 */
	public static final String TABLE_NAME = "FOO_Employee";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"employeeId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"employeeName", Types.VARCHAR}, {"employeeMobile", Types.VARCHAR},
		{"employeeEmail", Types.VARCHAR}, {"branchId", Types.BIGINT},
		{"departmentId", Types.BIGINT}, {"designationId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("employeeName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("employeeMobile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("employeeEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("branchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("departmentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("designationId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table FOO_Employee (uuid_ VARCHAR(75) null,employeeId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,employeeName VARCHAR(75) null,employeeMobile VARCHAR(75) null,employeeEmail VARCHAR(75) null,branchId LONG,departmentId LONG,designationId LONG)";

	public static final String TABLE_SQL_DROP = "drop table FOO_Employee";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employee.employeeName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY FOO_Employee.employeeName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long BRANCHID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DEPARTMENTID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long DESIGNATIONID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMPLOYEENAME_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public EmployeeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Employee)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Employee, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Employee, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Employee)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Employee, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Employee, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Employee, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Employee, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Employee, Object>>();
		Map<String, BiConsumer<Employee, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Employee, ?>>();

		attributeGetterFunctions.put("uuid", Employee::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Employee, String>)Employee::setUuid);
		attributeGetterFunctions.put("employeeId", Employee::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId", (BiConsumer<Employee, Long>)Employee::setEmployeeId);
		attributeGetterFunctions.put("groupId", Employee::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Employee, Long>)Employee::setGroupId);
		attributeGetterFunctions.put("companyId", Employee::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Employee, Long>)Employee::setCompanyId);
		attributeGetterFunctions.put("userId", Employee::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Employee, Long>)Employee::setUserId);
		attributeGetterFunctions.put("userName", Employee::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Employee, String>)Employee::setUserName);
		attributeGetterFunctions.put("createDate", Employee::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Employee, Date>)Employee::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Employee::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Employee, Date>)Employee::setModifiedDate);
		attributeGetterFunctions.put("employeeName", Employee::getEmployeeName);
		attributeSetterBiConsumers.put(
			"employeeName",
			(BiConsumer<Employee, String>)Employee::setEmployeeName);
		attributeGetterFunctions.put(
			"employeeMobile", Employee::getEmployeeMobile);
		attributeSetterBiConsumers.put(
			"employeeMobile",
			(BiConsumer<Employee, String>)Employee::setEmployeeMobile);
		attributeGetterFunctions.put(
			"employeeEmail", Employee::getEmployeeEmail);
		attributeSetterBiConsumers.put(
			"employeeEmail",
			(BiConsumer<Employee, String>)Employee::setEmployeeEmail);
		attributeGetterFunctions.put("branchId", Employee::getBranchId);
		attributeSetterBiConsumers.put(
			"branchId", (BiConsumer<Employee, Long>)Employee::setBranchId);
		attributeGetterFunctions.put("departmentId", Employee::getDepartmentId);
		attributeSetterBiConsumers.put(
			"departmentId",
			(BiConsumer<Employee, Long>)Employee::setDepartmentId);
		attributeGetterFunctions.put(
			"designationId", Employee::getDesignationId);
		attributeSetterBiConsumers.put(
			"designationId",
			(BiConsumer<Employee, Long>)Employee::setDesignationId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeId = employeeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEmployeeId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("employeeId"));
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getEmployeeName() {
		if (_employeeName == null) {
			return "";
		}
		else {
			return _employeeName;
		}
	}

	@Override
	public void setEmployeeName(String employeeName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeName = employeeName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalEmployeeName() {
		return getColumnOriginalValue("employeeName");
	}

	@JSON
	@Override
	public String getEmployeeMobile() {
		if (_employeeMobile == null) {
			return "";
		}
		else {
			return _employeeMobile;
		}
	}

	@Override
	public void setEmployeeMobile(String employeeMobile) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeMobile = employeeMobile;
	}

	@JSON
	@Override
	public String getEmployeeEmail() {
		if (_employeeEmail == null) {
			return "";
		}
		else {
			return _employeeEmail;
		}
	}

	@Override
	public void setEmployeeEmail(String employeeEmail) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeEmail = employeeEmail;
	}

	@JSON
	@Override
	public long getBranchId() {
		return _branchId;
	}

	@Override
	public void setBranchId(long branchId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_branchId = branchId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalBranchId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("branchId"));
	}

	@JSON
	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_departmentId = departmentId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDepartmentId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("departmentId"));
	}

	@JSON
	@Override
	public long getDesignationId() {
		return _designationId;
	}

	@Override
	public void setDesignationId(long designationId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_designationId = designationId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalDesignationId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("designationId"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Employee.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Employee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Employee toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Employee>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setUuid(getUuid());
		employeeImpl.setEmployeeId(getEmployeeId());
		employeeImpl.setGroupId(getGroupId());
		employeeImpl.setCompanyId(getCompanyId());
		employeeImpl.setUserId(getUserId());
		employeeImpl.setUserName(getUserName());
		employeeImpl.setCreateDate(getCreateDate());
		employeeImpl.setModifiedDate(getModifiedDate());
		employeeImpl.setEmployeeName(getEmployeeName());
		employeeImpl.setEmployeeMobile(getEmployeeMobile());
		employeeImpl.setEmployeeEmail(getEmployeeEmail());
		employeeImpl.setBranchId(getBranchId());
		employeeImpl.setDepartmentId(getDepartmentId());
		employeeImpl.setDesignationId(getDesignationId());

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public Employee cloneWithOriginalValues() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		employeeImpl.setEmployeeId(
			this.<Long>getColumnOriginalValue("employeeId"));
		employeeImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		employeeImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		employeeImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		employeeImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		employeeImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		employeeImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		employeeImpl.setEmployeeName(
			this.<String>getColumnOriginalValue("employeeName"));
		employeeImpl.setEmployeeMobile(
			this.<String>getColumnOriginalValue("employeeMobile"));
		employeeImpl.setEmployeeEmail(
			this.<String>getColumnOriginalValue("employeeEmail"));
		employeeImpl.setBranchId(this.<Long>getColumnOriginalValue("branchId"));
		employeeImpl.setDepartmentId(
			this.<Long>getColumnOriginalValue("departmentId"));
		employeeImpl.setDesignationId(
			this.<Long>getColumnOriginalValue("designationId"));

		return employeeImpl;
	}

	@Override
	public int compareTo(Employee employee) {
		int value = 0;

		value = getEmployeeName().compareTo(employee.getEmployeeName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Employee)) {
			return false;
		}

		Employee employee = (Employee)object;

		long primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Employee> toCacheModel() {
		EmployeeCacheModel employeeCacheModel = new EmployeeCacheModel();

		employeeCacheModel.uuid = getUuid();

		String uuid = employeeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			employeeCacheModel.uuid = null;
		}

		employeeCacheModel.employeeId = getEmployeeId();

		employeeCacheModel.groupId = getGroupId();

		employeeCacheModel.companyId = getCompanyId();

		employeeCacheModel.userId = getUserId();

		employeeCacheModel.userName = getUserName();

		String userName = employeeCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			employeeCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			employeeCacheModel.createDate = createDate.getTime();
		}
		else {
			employeeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			employeeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			employeeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		employeeCacheModel.employeeName = getEmployeeName();

		String employeeName = employeeCacheModel.employeeName;

		if ((employeeName != null) && (employeeName.length() == 0)) {
			employeeCacheModel.employeeName = null;
		}

		employeeCacheModel.employeeMobile = getEmployeeMobile();

		String employeeMobile = employeeCacheModel.employeeMobile;

		if ((employeeMobile != null) && (employeeMobile.length() == 0)) {
			employeeCacheModel.employeeMobile = null;
		}

		employeeCacheModel.employeeEmail = getEmployeeEmail();

		String employeeEmail = employeeCacheModel.employeeEmail;

		if ((employeeEmail != null) && (employeeEmail.length() == 0)) {
			employeeCacheModel.employeeEmail = null;
		}

		employeeCacheModel.branchId = getBranchId();

		employeeCacheModel.departmentId = getDepartmentId();

		employeeCacheModel.designationId = getDesignationId();

		return employeeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Employee)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Employee>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Employee.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _employeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _employeeName;
	private String _employeeMobile;
	private String _employeeEmail;
	private long _branchId;
	private long _departmentId;
	private long _designationId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Employee, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Employee)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("employeeName", _employeeName);
		_columnOriginalValues.put("employeeMobile", _employeeMobile);
		_columnOriginalValues.put("employeeEmail", _employeeEmail);
		_columnOriginalValues.put("branchId", _branchId);
		_columnOriginalValues.put("departmentId", _departmentId);
		_columnOriginalValues.put("designationId", _designationId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("employeeId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("employeeName", 256L);

		columnBitmasks.put("employeeMobile", 512L);

		columnBitmasks.put("employeeEmail", 1024L);

		columnBitmasks.put("branchId", 2048L);

		columnBitmasks.put("departmentId", 4096L);

		columnBitmasks.put("designationId", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Employee _escapedModel;

}