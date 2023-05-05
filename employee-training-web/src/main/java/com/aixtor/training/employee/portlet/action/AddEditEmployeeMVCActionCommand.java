package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.api.EmployeeApi;
import com.aixtor.training.employee.constants.EmployeeConstants;
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
	    	"javax.portlet.name="+EmployeeConstants.EMPLOYEE_PORTLET,
	        "mvc.command.name=addEditEmployee",
	        "javax.portlet.display-name=Employee Display Form",
	    }, 
	    service = MVCActionCommand.class
)
public class AddEditEmployeeMVCActionCommand extends BaseMVCActionCommand{

	private static Log log = LogFactoryUtil.getLog(AddEditEmployeeMVCActionCommand.class);

	@Reference
	private EmployeeApi employeeAPI;
	
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// 1. Retrieving employeeId from the employee record user selected
		long employeeId = ParamUtil.getLong(actionRequest,EmployeeConstants.EMPLOYEE_ID, GetterUtil.DEFAULT_LONG);
		
		// 2. Retrieving the current url to be redirected after the task is done
		String redirectURL = ParamUtil.getString(actionRequest, EmployeeConstants.REDIRECT_URL);

		// 3. Retrieving all the data of the employee form to be saved or updated in the database
		String employeeName = ParamUtil.getString(actionRequest, EmployeeConstants.EMPLOYEE_NAME);
		String employeeMobile = ParamUtil.getString(actionRequest, EmployeeConstants.EMPLOYEE_MOBILE);
		String employeeEmail = ParamUtil.getString(actionRequest, EmployeeConstants.EMPLOYEE_EMAIL);
		long branchId = ParamUtil.getLong(actionRequest,EmployeeConstants.BRANCH_ID);
		long departmentId = ParamUtil.getLong(actionRequest,EmployeeConstants.DEPARTMENT_ID);
		long designationId = ParamUtil.getLong(actionRequest,EmployeeConstants.DESIGNATION_ID);
		
		/*
		 * 4. Validating if the employeeId is Empty or Not :: If the employeeId is not null the employeeData will be updated 
		 *		based on employeeId
		*/
		try {
			if (employeeId > 0) {
				// 4. If the employeeId is not empty then the data will be updated 
				employeeAPI.updateEmployeeDetails(employeeId, employeeName, employeeMobile, employeeEmail,
						branchId, departmentId, designationId);
			} else {
				
				// 5. If the employeeId is empty then the data will be added as the new record entered
				employeeAPI.addEmployeeDetails(employeeName, employeeMobile, employeeEmail, branchId, departmentId,
						designationId);
			}
	
			
		} catch (Exception e) {
			log.error("AddEditEmployeeMVCAction >>> doProcessAction >> Exception Occured:: " +e);
		}
		
		// 7. Redirecting back to the previous url
		actionResponse.sendRedirect(redirectURL);
	}
}
