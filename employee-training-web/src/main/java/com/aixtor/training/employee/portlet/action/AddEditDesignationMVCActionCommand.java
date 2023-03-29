package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Designation;
import com.aixtor.training.service.DesignationLocalService;
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
	    	"javax.portlet.name=DesignationPortlet",
	        "mvc.command.name=addEditDesignation",
	    }, 
	    service = MVCActionCommand.class
)
public class AddEditDesignationMVCActionCommand extends BaseMVCActionCommand{

	private static Log log = LogFactoryUtil.getLog(AddEditDesignationMVCActionCommand.class);

	@Reference
	DesignationLocalService designationLocalService;

	@Reference
	CounterLocalService counterLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// 1. Retrieving designationId from the designation record user selected
		long designationId = ParamUtil.getLong(actionRequest, EmployeeConstants.DESIGNATION_ID, GetterUtil.DEFAULT_LONG);
		
		// 2. Retrieving the current url to be redirected after the task is done
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

		// 3. Retrieving all the data of the designation form to be saved or updated in the database
		String designationName = ParamUtil.getString(actionRequest, EmployeeConstants.DESIGNATION_NAME);
		
		// 4. Initalizing and declaring the entity Designation
		Designation designation = null;
		
		/*
		 * 5. Validating if the designationId is Empty or Not :: If the designationId is not null the designationData will be 
		 * updated based on designationId
		 */
		try {
			if (designationId > 0) {
				designation = designationLocalService.getDesignation(designationId);
				designation.setDesignationName(designationName);
			} else {
				
				// 6. If the designationId is empty then the data will be added as the new record entered
				designation = designationLocalService.createDesignation(counterLocalService.increment());
				designation.setDesignationName(designationName);
			}
			/*
			* 7. Using the updateDesignation method of designationLocalService as it performs both adding and updating 
			* transactions in database
			 */
			designationLocalService.updateDesignation(designation);
		} catch (Exception e) {
			log.error("AddEditDesignationMVCAction >>> doProcessAction >> Exception Occured:: " +e);
		}
		// 8. Redirecting back to the previous url
		actionResponse.sendRedirect(redirectURL);
	}

}
