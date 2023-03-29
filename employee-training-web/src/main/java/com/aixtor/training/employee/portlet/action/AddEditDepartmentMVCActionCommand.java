package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Department;
import com.aixtor.training.service.DepartmentLocalService;
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
	    	"javax.portlet.name=DepartmentPortlet",
	        "mvc.command.name=addEditDepartment",
	    }, 
	    service = MVCActionCommand.class
)
public class AddEditDepartmentMVCActionCommand extends BaseMVCActionCommand{

	private static Log log = LogFactoryUtil.getLog(AddEditDepartmentMVCActionCommand.class);

	@Reference
	DepartmentLocalService departmentLocalService;

	@Reference
	CounterLocalService counterLocalService;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// 1. Retrieving departmentId from the department record user selected
		long departmentId = ParamUtil.getLong(actionRequest, EmployeeConstants.DEPARTMENT_ID, GetterUtil.DEFAULT_LONG);
		
		// 2. Retrieving the current url to be redirected after the task is done
		String redirectURL = ParamUtil.getString(actionRequest, "redirectURL");

		// 3. Retrieving all the data of the department form to be saved or updated in the database
		String departmentName = ParamUtil.getString(actionRequest, EmployeeConstants.DEPARTMENT_NAME);
		String departmentHead = ParamUtil.getString(actionRequest, EmployeeConstants.DEPARTMENT_HEAD);
		
		// 4. Initalizing and declaring the entity Department
		Department department = null;
		
		/*
		 * 5. Validating if the departmentId is Empty or Not :: If the departmentId is not null the departmentData will be 
		 * 		updated based on departmentId
		 */
		try {
			if (departmentId > 0) {
				department = departmentLocalService.getDepartment(departmentId);
				department.setDepartmentName(departmentName);
				department.setDepartmentHead(departmentHead);
			} else {
				
				// 6. If the departmentId is empty then the data will be added as the new record entered
				department = departmentLocalService.createDepartment(counterLocalService.increment());
				department.setDepartmentName(departmentName);
				department.setDepartmentHead(departmentHead);
			}
			
			/*
			* 7. Using the updateDepartment method of departmentLocalService as it performs both adding and updating transactions in 
				in database
			 */
			departmentLocalService.updateDepartment(department);
		} catch (Exception e) {
			log.error("AddEditDepartmentMVCAction >>> doProcessAction >> Exception Occured:: " +e);
		}
		
		// 8. Redirecting back to the previous url
		actionResponse.sendRedirect(redirectURL);
	}

}
