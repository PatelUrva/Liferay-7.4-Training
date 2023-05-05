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

package com.aixtor.training.service.base;

import com.aixtor.training.model.Employee;
import com.aixtor.training.service.EmployeeService;
import com.aixtor.training.service.EmployeeServiceUtil;
import com.aixtor.training.service.persistence.BranchFinder;
import com.aixtor.training.service.persistence.BranchPersistence;
import com.aixtor.training.service.persistence.CityPersistence;
import com.aixtor.training.service.persistence.DepartmentPersistence;
import com.aixtor.training.service.persistence.DesignationPersistence;
import com.aixtor.training.service.persistence.EmployeeFinder;
import com.aixtor.training.service.persistence.EmployeePersistence;
import com.aixtor.training.service.persistence.StatePersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the employee remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.aixtor.training.service.impl.EmployeeServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.aixtor.training.service.impl.EmployeeServiceImpl
 * @generated
 */
public abstract class EmployeeServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, EmployeeService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>EmployeeService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>EmployeeServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			EmployeeService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		employeeService = (EmployeeService)aopProxy;

		_setServiceUtilService(employeeService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return EmployeeService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Employee.class;
	}

	protected String getModelClassName() {
		return Employee.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = employeePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(EmployeeService employeeService) {
		try {
			Field field = EmployeeServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, employeeService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected BranchPersistence branchPersistence;

	@Reference
	protected BranchFinder branchFinder;

	@Reference
	protected CityPersistence cityPersistence;

	@Reference
	protected DepartmentPersistence departmentPersistence;

	@Reference
	protected DesignationPersistence designationPersistence;

	@Reference
	protected com.aixtor.training.service.EmployeeLocalService
		employeeLocalService;

	protected EmployeeService employeeService;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmployeeFinder employeeFinder;

	@Reference
	protected StatePersistence statePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeeServiceBaseImpl.class);

}