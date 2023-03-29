package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Employee;
import com.aixtor.training.service.BranchLocalService;
import com.aixtor.training.service.DepartmentLocalService;
import com.aixtor.training.service.DesignationLocalService;
import com.aixtor.training.service.EmployeeLocalService;
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
	    	"javax.portlet.name=EmployeePortlet",
	        "mvc.command.name=addEditEmployee",
	        "javax.portlet.display-name=Employee Display Form",
	    }, 
	    service = MVCActionCommand.class
)
public class AddEditEmployeeMVCActionCommand extends BaseMVCActionCommand{

	private static Log log = LogFactoryUtil.getLog(AddEditEmployeeMVCActionCommand.class);

	@Reference
	EmployeeLocalService employeeLocalService;

	@Reference
	DepartmentLocalService departmentLocalService;
	
	@Reference
	DesignationLocalService designationLocalService;
	
	@Reference
	BranchLocalService branchLocalService;
	
	@Reference
	CounterLocalService counterLocalService;
	
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// 1. Retrieving employeeId from the employee record user selected
		long employeeId = ParamUtil.getLong(actionRequest,EmployeeConstants.EMPLOYEE_ID, GetterUtil.DEFAULT_LONG);
		
		// 2. Retrieving the current url to be redirected after the task is done
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

		// 3. Retrieving all the data of the employee form to be saved or updated in the database
		String employeeName = ParamUtil.getString(actionRequest, EmployeeConstants.EMPLOYEE_NAME);
		String employeeMobile = ParamUtil.getString(actionRequest, EmployeeConstants.EMPLOYEE_MOBILE);
		String employeeEmail = ParamUtil.getString(actionRequest, EmployeeConstants.EMPLOYEE_EMAIL);
		long branchId = ParamUtil.getLong(actionRequest,EmployeeConstants.BRANCH_ID);
		long departmentId = ParamUtil.getLong(actionRequest,EmployeeConstants.DEPARTMENT_ID);
		long designationId = ParamUtil.getLong(actionRequest,EmployeeConstants.DESIGNATION_ID);
		
		
		// 4. Initalizing and declaring the entity Employee
		Employee employee = null;
		
		/*
		 * 5. Validating if the employeeId is Empty or Not :: If the employeeId is not null the employeeData will be updated 
		 *		based on employeeId
		*/
		try {
			if (employeeId > 0) {
				employee = employeeLocalService.getEmployee(employeeId);
				employee.setEmployeeName(employeeName);
				employee.setEmployeeMobile(employeeMobile);
				employee.setEmployeeEmail(employeeEmail);
				employee.setBranchId(branchId);
				employee.setDepartmentId(departmentId);
				employee.setDesignationId(designationId);
			} else {
				
				// 6. If the employeeId is empty then the data will be added as the new record entered
				employee = employeeLocalService.createEmployee(counterLocalService.increment());
				employee.setEmployeeName(employeeName);
				employee.setEmployeeMobile(employeeMobile);
				employee.setEmployeeEmail(employeeEmail);
				employee.setBranchId(branchId);
				employee.setDepartmentId(departmentId);
				employee.setDesignationId(designationId);	
			}
			
			/*
			* 7. Using the updateEmployee method of employeeLocalService as it performs both adding and updating transactions in 
				database
			 */
			employeeLocalService.updateEmployee(employee);
			
		} catch (Exception e) {
			log.error("AddEditEmployeeMVCAction >>> doProcessAction >> Exception Occured:: " +e);
		}
		
		// 8. Redirecting back to the previous url
		actionResponse.sendRedirect(redirectURL);
	}
}
