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

import com.aixtor.training.exception.NoSuchDepartmentException;
import com.aixtor.training.model.Department;
import com.aixtor.training.service.base.DepartmentLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.SystemException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.aixtor.training.model.Department",
	service = AopService.class
)
public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {

	@Override
	public Department findByDepartmentId(long departmentId) throws NoSuchDepartmentException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department findByDepartmentName(String departmentName) throws NoSuchDepartmentException, SystemException {
		return departmentPersistence.findByDepartmentName(departmentName);
	}

	
}