package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.State;
import com.aixtor.training.service.StateLocalService;
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
	    	"javax.portlet.name=StatePortlet",
	        "mvc.command.name=addEditState",
	    }, 
	    service = MVCActionCommand.class
)
public class AddEditStateMVCActionCommand extends BaseMVCActionCommand{

	private static Log log = LogFactoryUtil.getLog(AddEditStateMVCActionCommand.class);

	@Reference
	StateLocalService stateLocalService;

	@Reference
	CounterLocalService counterLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// 1. Retrieving stateId from the state record user selected
		long stateId = ParamUtil.getLong(actionRequest, EmployeeConstants.STATE_ID, GetterUtil.DEFAULT_LONG);
		
		// 2. Retrieving the current url to be redirected after the task is done
		String redirectURL = ParamUtil.getString(actionRequest, EmployeeConstants.REDIRECT_URL);

		// 3. Retrieving all the data of the state form to be saved or updated in the database
		String stateName = ParamUtil.getString(actionRequest,EmployeeConstants.STATE_NAME);
		long countryId = ParamUtil.getLong(actionRequest, EmployeeConstants.COUNTRY_ID);
		
		State state = null;
		
		/*
		 * 4. Validating if the stateId is Empty or Not :: If the stateId is not null the stateData will be updated 
		 *		based on stateId
		 */
	
		try {
			if (stateId > 0) {
				state = stateLocalService.getState(stateId);
				state.setStateName(stateName);
				state.setCountryId(countryId);
				
			} else {
				
				// 5. If the stateId is empty then the data will be added as the new record entered
				state = stateLocalService.createState(counterLocalService.increment());
				state.setStateName(stateName);
				state.setCountryId(countryId);
			}
			
			/*
			* 6. Using the updateState method of stateLocalService as it performs both adding and updating transactions in 
			*	database
			*/
			stateLocalService.updateState(state);
		} catch (Exception e) {
			log.error("AddEditStateMVCAction >>> doProcessAction >> Exception Occured:: " +e);
		}
		
		// 7. Redirecting back to the previous url
		actionResponse.sendRedirect(redirectURL);
	}
}
