package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.City;
import com.aixtor.training.service.CityLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name="+EmployeeConstants.CITY_PORTLET,
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewCityMVCRenderCommand implements MVCRenderCommand {

	private static Log log=LogFactoryUtil.getLog(ViewCityMVCRenderCommand.class);

	@Reference
	CityLocalService cityLocalService;

	@Reference
	CounterLocalService counterLocalService;
	
	/**
	 * @return cityList on page load and update record
	 */
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		// 1. Using cityLocalService getting the details of all cities in a list
		List<City> cityList = cityLocalService.getCities(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.CITY_LIST, cityList);
		
		// 2. Getting the action value that is generated on RenderURL
		String action = ParamUtil.getString(renderRequest, EmployeeConstants.ACTION);
		
		// 3. Getting cityId of the city selected for updating the record
		long cityId = ParamUtil.getLong(renderRequest,EmployeeConstants.CITY_ID);
		
		// 4. Setting the isEdit flag to false
		boolean isEdit = Boolean.FALSE;
		
		log.info("ViewCityMVCRender >>> render >>> Action :: " + action);
		
		// 5. Validating if the action variable is empty or not 
		if(Validator.isNotNull(action)) {
			
			// 6. Retrieving the current url to be redirected after the task is done
			String redirectURL = ParamUtil.getString(renderRequest, EmployeeConstants.REDIRECT_URL);
			
			// 7. Validating if the action variable value is edit or not :: If edit than update the city based on cityId
			if (EmployeeConstants.EDIT.equalsIgnoreCase(action) && cityId > 0) {
				try {
					
					// 8. Getting the city details based on cityId
					City selectedCity = cityLocalService.getCity(cityId);
					
					// 9. Setting the renderRequest value as selectedCity record details
					renderRequest.setAttribute(EmployeeConstants.SELECTED_CITY, selectedCity);
					
					// 10. Setting the isEdit flag to true
					isEdit = Boolean.TRUE;
					
				} catch (PortalException e) {
					log.error("ViewCityMVCRender >>> render ::" +e);
				}
			}
			renderRequest.setAttribute(EmployeeConstants.REDIRECT_URL, redirectURL);
			renderRequest.setAttribute(EmployeeConstants.IS_EDIT, isEdit);
			
			// 11. Redirect to AddEditCity jsp page where data is displayed of the cityId selected for updations
			return "/addEditCity.jsp";
		}else {
			
			// 12. If action value is not edit :: then redirect to cityView page :: viewing the list of city
			return "/cityView.jsp";
		}
		
	}

	
}
