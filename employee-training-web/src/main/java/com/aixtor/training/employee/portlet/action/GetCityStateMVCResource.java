package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.employee.helper.EmployeeHelper;
import com.aixtor.training.model.City;
import com.aixtor.training.service.CityLocalService;
import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name="+EmployeeConstants.BRANCH_PORTLET,
	        "mvc.command.name=/get/states-city",
	    }, 
	    service = MVCResourceCommand.class
)
public class GetCityStateMVCResource extends BaseMVCResourceCommand {
	

	@Reference
	CityLocalService cityLocalService;
	
	@Reference
	EmployeeHelper employeeHelper;
	
	/**
	 * @return cityList based on stateId selected
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		// 1. Retrieving stateId from the state record user selected
		long stateId = ParamUtil.getLong(resourceRequest, EmployeeConstants.STATE_ID);
		
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray responseArray = JSONFactoryUtil.createJSONArray();
		
		// 2. Using finder method of City Entity getting list based on stateId selected
		List<City> getCityList = cityLocalService.findByStateId(stateId);
		
		JSONObject jsonObject = null;
		
		// 3. Using foreach loop setting cityList details in jsonObject created
		for (City city : getCityList) {
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put(EmployeeConstants.CITY_NAME, city.getCityName());
			jsonObject.put(EmployeeConstants.CITY_ID, city.getCityId());
			responseArray.put(jsonObject);
		}	
		PrintWriter writer = null;
		try {
			
			// 4. Converting the jsonArray data to jsonToString with status
			
			responseObj.put(EmployeeConstants.DATA, responseArray.toJSONString());
			responseObj.put(EmployeeConstants.STATUS, EmployeeConstants.SUCCESS);
			
		} catch (IOException e) {
			
			responseObj.put(EmployeeConstants.STATUS,EmployeeConstants.ERROR);
			responseObj.put(EmployeeConstants.MESSAGE, "Error occured while fetching cities from states.");
			
		} finally {
			writer = resourceResponse.getWriter();
			writer.close();
		}
		
	}

}