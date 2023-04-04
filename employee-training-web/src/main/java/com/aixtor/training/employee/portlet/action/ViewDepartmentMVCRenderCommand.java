package com.aixtor.training.employee.portlet.action;

import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Department;
import com.aixtor.training.service.DepartmentLocalService;
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
	    	"javax.portlet.name=DepartmentPortlet",
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewDepartmentMVCRenderCommand implements MVCRenderCommand {

	private static Log log=LogFactoryUtil.getLog(ViewDepartmentMVCRenderCommand.class);

	@Reference
	DepartmentLocalService departmentLocalService;

	@Reference
	CounterLocalService count;
	
	/**
	 * @return departmentList on page load and update record
	 */
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		// 1. Using departmentLocalService getting the details of all departments in a list
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.DEPARTMENT_LIST, departmentList);
		
		// 2. Getting the action value that is generated on RenderURL
		String action = ParamUtil.getString(renderRequest, EmployeeConstants.ACTION);
		
		// 3. Getting departmentId of the department selected for updating the record
		long departmentId = ParamUtil.getLong(renderRequest,EmployeeConstants.DEPARTMENT_ID);
		
		// 4. Setting the isEdit flag to false
		boolean isEdit = Boolean.FALSE;
		
		log.info("ViewDepartmentMVCRender >>> render >>> Action ::" + action);
		
		// 5. Validating if the action variable is empty or not 
		if(Validator.isNotNull(action)) {
			
			// 6. Retrieving the current url to be redirected after the task is done
			String redirectURL = ParamUtil.getString(renderRequest, EmployeeConstants.REDIRECT_URL);
			
			/*
			 * 7. Validating if the action variable value is edit or not :: If edit than update the department based on
				departmentId	
			 */	
			if (EmployeeConstants.EDIT.equalsIgnoreCase(action) && departmentId > 0) {
				try {
					
					// 8. Getting the department details based on departmentId
					Department selectedDepartment = departmentLocalService.getDepartment(departmentId);
					
					// 9. Setting the renderRequest value as selectedDepartment record details
					renderRequest.setAttribute(EmployeeConstants.SELECTED_DEPARTMENT, selectedDepartment);
					
					// 10. Setting the isEdit flag to true
					isEdit = Boolean.TRUE;
				} catch (PortalException e) {
					log.error("ViewDepartmentMVCRender >>> render ::" +e);
				}
			}
			renderRequest.setAttribute(EmployeeConstants.REDIRECT_URL, redirectURL);
			renderRequest.setAttribute(EmployeeConstants.IS_EDIT, isEdit);
			
			// 11. Redirect to AddEditDepartment jsp page where data is displayed of the departmentId selected for updation
			return "/addEditDepartment.jsp";
			
		}else {
			
			// 12. If action value is not edit :: then redirect to departmentView page :: viewing the list of department
			return "/departmentView.jsp";
		}
		
	}

	
}
