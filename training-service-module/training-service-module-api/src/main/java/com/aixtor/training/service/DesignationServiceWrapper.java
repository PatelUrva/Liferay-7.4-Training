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
 * Provides a wrapper for {@link DesignationService}.
 *
 * @author Brian Wing Shun Chan
 * @see DesignationService
 * @generated
 */
public class DesignationServiceWrapper
	implements DesignationService, ServiceWrapper<DesignationService> {

	public DesignationServiceWrapper() {
		this(null);
	}

	public DesignationServiceWrapper(DesignationService designationService) {
		_designationService = designationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _designationService.getOSGiServiceIdentifier();
	}

	@Override
	public DesignationService getWrappedService() {
		return _designationService;
	}

	@Override
	public void setWrappedService(DesignationService designationService) {
		_designationService = designationService;
	}

	private DesignationService _designationService;

}