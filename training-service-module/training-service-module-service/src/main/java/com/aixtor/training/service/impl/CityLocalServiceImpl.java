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

import com.aixtor.training.exception.NoSuchCityException;
import com.aixtor.training.model.City;
import com.aixtor.training.service.base.CityLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.aixtor.training.model.City",
	service = AopService.class
)
public class CityLocalServiceImpl extends CityLocalServiceBaseImpl {
	
	public List<City> findByStateId(long stateId) throws SystemException{
		return cityPersistence.findBystateId(stateId);
		
	}
	
	public City findByCityId(long cityId) throws SystemException, NoSuchCityException{
		return null;
	}

}