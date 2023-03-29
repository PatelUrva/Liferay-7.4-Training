package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.City;
import com.aixtor.training.service.CityLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=CityPortlet",
	        "mvc.command.name=addEditCity",
	    }, 
	    service = MVCActionCommand.class
)
public class AddEditCityMVCActionCommand extends BaseMVCActionCommand{

	private static Log log = LogFactoryUtil.getLog(AddEditCityMVCActionCommand.class);

	@Reference
	CityLocalService cityLocalService;

	@Reference
	CounterLocalService counterLocalService;
	
	/**
	 * @return adding and editing city record in the database
	 */
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// 1. Retrieving cityId from the branch record user selected
		long cityId = ParamUtil.getLong(actionRequest, EmployeeConstants.CITY_ID, GetterUtil.DEFAULT_LONG);
		
		// 2. Retrieving the current url to be redirected after the task is done
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

		// 3. Retrieving all the data of the city form to be saved or updated in the database
		String cityName = ParamUtil.getString(actionRequest,EmployeeConstants.CITY_NAME);
		long stateId = ParamUtil.getLong(actionRequest,EmployeeConstants.STATE_ID);
		
		// 4. Initalizing and declaring the entity City
		City city = null;
		
		try {
			
			/*
			 * 5. Validating if the cityId is Empty or Not :: If the cityId is not null the cityData will be updated 
			 *		based on cityId
			 */
			if (cityId > 0) {
				city = cityLocalService.getCity(cityId);
				city.setCityName(cityName);
				city.setStateId(stateId);
			} else {
				
				// 6. If the cityId is empty then the data will be added as the new record enterd
				city = cityLocalService.createCity(counterLocalService.increment());
				city.setCityName(cityName);
				city.setStateId(stateId);
			}
			
			/*
			 * 7. Using the updateCity method of cityLocalService as it performs both adding and updating transactions in 
				database
			 */
			cityLocalService.updateCity(city);
		} catch (Exception e) {
			log.error("AddEditCityMVCAction >>> doProcessAction >> Exception Occured:: " +e);
		}
		
		// 8. Redirecting back to the previous url
		actionResponse.sendRedirect(redirectURL);
	}
	
}
