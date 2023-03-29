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

package com.aixtor.training.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DepartmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see DepartmentService
 * @generated
 */
public class DepartmentServiceWrapper
	implements DepartmentService, ServiceWrapper<DepartmentService> {

	public DepartmentServiceWrapper() {
		this(null);
	}

	public DepartmentServiceWrapper(DepartmentService departmentService) {
		_departmentService = departmentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _departmentService.getOSGiServiceIdentifier();
	}

	@Override
	public DepartmentService getWrappedService() {
		return _departmentService;
	}

	@Override
	public void setWrappedService(DepartmentService departmentService) {
		_departmentService = departmentService;
	}

	private DepartmentService _departmentService;

}