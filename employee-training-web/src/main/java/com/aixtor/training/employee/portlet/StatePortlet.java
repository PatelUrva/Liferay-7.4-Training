package com.aixtor.training.employee.portlet;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.State;
import com.aixtor.training.service.StateLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryLocalService;
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

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=State Form",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/departmentView.jsp",
		"javax.portlet.name="+EmployeeConstants.STATE_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class StatePortlet extends MVCPortlet {
	
	private static Log log=LogFactoryUtil.getLog(StatePortlet.class);
	
	@Reference
	CounterLocalService counterLocalService;
	
	@Reference
	StateLocalService stateLocalService;
	
	@Reference
	CountryLocalService countryLocalService;
	
	/**
	 * @return stateList and countryList on Page load
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// 1. Using stateLocalService getting the states in a list
		List<State> stateList = stateLocalService.getStates(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.STATE_LIST, stateList);
		
		// 2. Using countryLocalService getting the countries in a list
		List<Country> countryList = countryLocalService.getCountries(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.COUNTRY_LIST, countryList);
		
		super.render(renderRequest, renderResponse);
	}
	
	/**
	 * @return State deleted based on stateId selected by the user
	 * @param requesting stateId from the selected state
	 * @param response deleting state based on stateId
	 */
	@ProcessAction(name = "deleteState")
	public void deleteState(ActionRequest request, ActionResponse response) {
		
		// 1. Using ParamUtil and request get the selected stateId
		long stateId = ParamUtil.getLong(request,EmployeeConstants.STATE_ID, GetterUtil.DEFAULT_LONG);
        
		try {
			// 2. Using deleteState method of stateLocalService deleting state
			stateLocalService.deleteState(stateId);
		} catch (PortalException e) {
			log.error(e.getMessage(), e);
		}
	}
}
