package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.employee.helper.EmployeeHelper;
import com.aixtor.training.model.State;
import com.aixtor.training.service.StateLocalService;
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
	        "mvc.command.name=/get/country-states",
	    }, 
	    service = MVCResourceCommand.class
)
public class GetStateCountryMVCResource extends BaseMVCResourceCommand {
	
	@Reference
	StateLocalService stateLocalService;
	
	@Reference
	EmployeeHelper employeeHelper;
	
	/**
	 * @return stateList based on countryId selected
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		// 1. Retrieving countryId from the country record user selected
		long countryId = ParamUtil.getLong(resourceRequest, EmployeeConstants.COUNTRY_ID);
		
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray responseArray = JSONFactoryUtil.createJSONArray();
		
		// 2. Using finder method of State Entity getting list based on countryId selected
		List<State> getStateList = stateLocalService.findByCountryId(countryId);
		
		JSONObject jsonObject = null;
		
		// 3. Using foreach loop setting cityList details in jsonObject created
		for (State state : getStateList) {
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put(EmployeeConstants.STATE_NAME, state.getStateName());
			jsonObject.put(EmployeeConstants.STATE_ID, state.getStateId());
			responseArray.put(jsonObject);
		}	
		PrintWriter writer = null;
		try {
			
			// 4. Converting the jsonArray data to jsonToString with status
			
			responseObj.put(EmployeeConstants.DATA, responseArray.toJSONString());
			responseObj.put(EmployeeConstants.STATUS, EmployeeConstants.SUCCESS);
			
		} catch (IOException e) {
			
			responseObj.put(EmployeeConstants.STATUS,EmployeeConstants.ERROR);
			responseObj.put(EmployeeConstants.MESSAGE, "Error occured while fetching states from country.");
			
		} finally {
			writer = resourceResponse.getWriter();
			writer.close();
		}
	}

	
}
