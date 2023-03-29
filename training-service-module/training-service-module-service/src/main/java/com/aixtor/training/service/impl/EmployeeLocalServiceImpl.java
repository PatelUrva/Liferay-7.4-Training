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

package com.aixtor.training.service.impl;

import com.aixtor.training.model.Employee;
import com.aixtor.training.service.base.EmployeeLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Urva Patel
 */
@Component(
	property = "model.class.name=com.aixtor.training.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl{
	
	private static Log log = LogFactoryUtil.getLog(EmployeeLocalServiceImpl.class);

	/**
	 * @return designation name by employee name using employeeFinderImpl
	 */
	@Override
	public List<Object[]> getDesignationNameByEmployee() {
		return employeeFinder.getDesignationNameByEmployee();
	}

	/**
	 * @return employee list by designation name using employeeFinderImpl
	 */
	@Override
	public List<Employee> getEmployeeByDesignation(String designationName) {
		return employeeFinder.getEmployeeByDesignation(designationName);
	}

	/**
	 * @return employee list by employee name using employeeFinderImpl
	 */
	@Override
	public List<Object[]> getEmployeeByName(String employeeName) {
		log.info("EmployeeLocalServiceImpl >>> getEmployeeByName >>> " + employeeName);
		return employeeFinder.getEmployeeByName(employeeName);
	}
	
	/**
	 * @return employee list by employeeName, designationName, departmentName, branchName using employeeFinderImpl
	 */
	@Override
	public List<Object[]> getEmployeeByAllEntity(String searchData) {
		log.info("EmployeeLocalServiceImpl >>> getEmployeeByAllEntity >>> " + searchData);
		return employeeFinder.getEmployeeByAllEntity(searchData);
	}
}