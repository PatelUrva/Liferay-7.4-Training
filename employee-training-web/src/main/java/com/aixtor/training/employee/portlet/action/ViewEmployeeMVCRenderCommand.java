package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Branch;
import com.aixtor.training.model.Department;
import com.aixtor.training.model.Designation;
import com.aixtor.training.model.Employee;
import com.aixtor.training.service.BranchLocalService;
import com.aixtor.training.service.DepartmentLocalService;
import com.aixtor.training.service.DesignationLocalService;
import com.aixtor.training.service.EmployeeLocalService;
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
	    	"javax.portlet.name=EmployeePortlet",
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewEmployeeMVCRenderCommand implements MVCRenderCommand {

	private static Log log=LogFactoryUtil.getLog(ViewEmployeeMVCRenderCommand.class);

	@Reference
	EmployeeLocalService employeeLocalService;
	
	@Reference
	BranchLocalService branchLocalService;
	
	@Reference
	DepartmentLocalService departmentLocalService;
	
	@Reference
	DesignationLocalService designationLocalService;

	@Reference
	CounterLocalService count;
	
	/**
	 * @return employeeList on page load and update record
	 */
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		// 1. Using branchLocalService getting the details of all branches in a list
		List<Branch> branchList = branchLocalService.getBranches(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.BRANCH_LIST, branchList);
		
		// 2. Using departmentLocalService getting the details of all departments in a list
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.DEPARTMENT_LIST, departmentList);
		
		// 3. Using designationLocalService getting the details of all designations in a list
		List<Designation> designationList = designationLocalService.getDesignations(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.DESIGNATION_LIST, designationList);
		
		// 4. Getting the action value that is generated on RenderURL
		String action = ParamUtil.getString(renderRequest, "action");
		
		// 5. Getting employeeId of the employee selected for updating the record
		long employeeId = ParamUtil.getLong(renderRequest, EmployeeConstants.EMPLOYEE_ID);
		
		// 6. Setting the isEdit flag to false
		boolean isEdit = Boolean.FALSE;
		
		log.info("ViewEmployeeMVCRender >>> render >>> Action :: " + action);
		
		// 7. Validating if the action variable is empty or not
		if(Validator.isNotNull(action)) {
			
			// 8. Retrieving the current url to be redirected after the task is done
			String redirectURL = ParamUtil.getString(renderRequest, "redirectURL");
			
			// 9. Validating if the action variable value is edit or not :: If edit than update the employee based on employeeId
			if ("edit".equalsIgnoreCase(action) && employeeId > 0) {
				try {
					
					// 10. Getting the employee details based on employeeId
					Employee selectedEmployee = employeeLocalService.getEmployee(employeeId);
					
					// 11. Setting the renderRequest value as selectedEmployee record details
					renderRequest.setAttribute("selectedEmployee", selectedEmployee);
					
					// 12. Setting the isEdit flag to true
					isEdit = Boolean.TRUE;
					
				} catch (PortalException e) {
					log.error("ViewEmployeeMVCRender >>> render ::" +e);
				}
			}
			renderRequest.setAttribute("redirectURL", redirectURL);
			renderRequest.setAttribute("isEdit", isEdit);
			
			// 13. Redirect to AddEditEmployee jsp page where data is displayed of the employeeId selected for updation
			return "/addEditEmployee.jsp";
		}else {
			
			// 14. If action value is not edit :: then redirect to employeeView page :: viewing the list of employee
			return "/employeeView.jsp";
		}
		
	}

	

}
