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
	
	
	public List<Object[]> getEmployeesByAllEntity(String searchData){
		log.info("EmployeeLocalServiceImpl >>> getEmployeesByAllEntity :: " +searchData+ "\n");
		return employeeFinder.getEmployeesByAllEntity(searchData);
	}
	
	public List<Object[]> getAllEmployees(){
		return employeeFinder.getAllEmployees();
	}
	
	public List<Object[]> getAllBranches(){
		return employeeFinder.getAllBranches();
	}
	
	public List<Employee> findByBranchId(long branchId) {
		return employeePersistence.findBybranchId(branchId);
	}
	
	public List<Employee> findByDesignationId(long designationId) {
		return employeePersistence.findBydesignationId(designationId);
	}
	
	public List<Employee> findByDepartmentId(long departmentId) {
		return employeePersistence.findBydepartmentId(departmentId);
	}
	
	public List<Employee> findByEmployeeId(long employeeId) {
		return employeePersistence.findByemployeeId(employeeId);
	}

}