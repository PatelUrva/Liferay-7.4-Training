package com.aixtor.training.employee.portlet;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.City;
import com.aixtor.training.model.State;
import com.aixtor.training.service.CityLocalService;
import com.aixtor.training.service.StateLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.requires-namespaced-parameters=false", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=City Form", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/departmentView.jsp", 
		"javax.portlet.name=CityPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
}, service = Portlet.class)

public class CityPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(CityPortlet.class);

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	CityLocalService cityLocalService;

	@Reference
	StateLocalService stateLocalService;

	/**
	 * @return List of states and cities on Page load
	 */

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		// 1. Using cityLocalService getting the details of all cities in a list
		List<City> cityList = cityLocalService.getCities(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.CITY_LIST, cityList);

		// 2. Using stateLocalService getting the details of all states in a list
		List<State> stateList = stateLocalService.getStates(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.STATE_LIST, stateList);

		super.render(renderRequest, renderResponse);
	}

	/**
	 * @return City deleted based on city Id selected by the user
	 * @param requesting cityId from the selected city
	 * @param response deleting city based on cityId
	 */
	@ProcessAction(name = "deleteCity")
	public void deleteCity(ActionRequest request, ActionResponse response) {

		// 1. Using ParamUtil and request get the selected city Id
		long cityId = ParamUtil.getLong(request, EmployeeConstants.CITY_ID, GetterUtil.DEFAULT_LONG);

		try {
			// 2. Using deleteCity method of cityLocalService deleting city
			cityLocalService.deleteCity(cityId);
		} catch (PortalException e) {
			log.error(e.getMessage(), e);
		}
	}
}
