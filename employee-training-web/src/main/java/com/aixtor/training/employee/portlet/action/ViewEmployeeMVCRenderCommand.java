package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.api.EmployeeApi;
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Branch;
import com.aixtor.training.model.Department;
import com.aixtor.training.model.Designation;
import com.aixtor.training.service.BranchLocalService;
import com.aixtor.training.service.DepartmentLocalService;
import com.aixtor.training.service.DesignationLocalService;
import com.aixtor.training.service.EmployeeLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
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
	    	"javax.portlet.name="+EmployeeConstants.EMPLOYEE_PORTLET,
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewEmployeeMVCRenderCommand implements MVCRenderCommand {

	private static Log log=LogFactoryUtil.getLog(ViewEmployeeMVCRenderCommand.class);

	@Reference
	private EmployeeLocalService employeeLocalService;
	
	@Reference
	private BranchLocalService branchLocalService;
	
	@Reference
	private DepartmentLocalService departmentLocalService;
	
	@Reference
	private DesignationLocalService designationLocalService;
	
	@Reference
	private CounterLocalService count;
	
	@Reference
	private EmployeeApi employeeApi;
	
	/**
	 * @return employeeList on page load and update record
	 */
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		

		// 1. Using branchLocalService getting the details of all branches in a list
		List<Branch> branchList = branchLocalService.getBranches(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.BRANCH_LIST, branchList);
				
		// 2. Using designationLocalService getting the details of all designation in a list
		List<Designation> designationList = designationLocalService.getDesignations(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.DESIGNATION_LIST, designationList);
				
		// 3. Using departmentLocalService getting the details of all departments in a list
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.DEPARTMENT_LIST, departmentList);
				
		// 4. Getting the action value that is generated on RenderURL
		String action = ParamUtil.getString(renderRequest, EmployeeConstants.ACTION);
		
		// 5. Getting employeeId of the employee selected for updating the record
		long employeeId = ParamUtil.getLong(renderRequest, EmployeeConstants.EMPLOYEE_ID);
		
		// 6. Setting the isEdit flag to false
		boolean isEdit = Boolean.FALSE;
		
		// 7. Validating if the action variable is empty or not
		if(Validator.isNotNull(action)) {
			
			// 8. Retrieving the current url to be redirected after the task is done
			String redirectURL = ParamUtil.getString(renderRequest, EmployeeConstants.REDIRECT_URL);
			
			// 9. Validating if the action variable value is edit or not :: If edit than update the employee based on employeeId
			isEdit = employeeApi.getEmployee(renderRequest, action, employeeId, isEdit);
			
			renderRequest.setAttribute(EmployeeConstants.REDIRECT_URL, redirectURL);
			renderRequest.setAttribute(EmployeeConstants.IS_EDIT, isEdit);
			
			// 10. Redirect to AddEditEmployee jsp page where data is displayed of the employeeId selected for updation
			return "/addEditEmployee.jsp";
		}else {
			
			// 11. If action value is not edit :: then redirect to employeeView page :: viewing the list of employee
			return "/employeeView.jsp";
		}
		
	}

}
