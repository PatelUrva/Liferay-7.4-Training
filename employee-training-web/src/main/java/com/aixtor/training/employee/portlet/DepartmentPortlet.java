package com.aixtor.training.employee.portlet;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Department;
import com.aixtor.training.service.DepartmentLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Department Form",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/departmentView.jsp",
		"javax.portlet.name="+EmployeeConstants.DEPARTMENT_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class DepartmentPortlet extends MVCPortlet {
	
	private static Log log=LogFactoryUtil.getLog(DepartmentPortlet.class);
	
	@Reference
	CounterLocalService count;
	
	@Reference
	DepartmentLocalService departmentLocalService;
	
	/**
	 * @return List of Department on Page load
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// 1. Using departmentLocalService getting the details of all departments in a list
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
		renderRequest.setAttribute("departmentList", departmentList);
		
		super.render(renderRequest, renderResponse);
	}
	
	/**
	 * @return Department deleted based on department Id selected by the user
	 * @param requesting departmentId from the selected department
	 * @param response deleting department based on departmentId
	 */
	@ProcessAction(name = "deleteDepartment")
	public void deleteDepartment(ActionRequest request, ActionResponse response) {
		
		// 1. Using ParamUtil and request get the selected department Id
		long departmentId = ParamUtil.getLong(request,EmployeeConstants.DEPARTMENT_ID, GetterUtil.DEFAULT_LONG);
        
		try {
			// 2. Using deleteDepartment method of departmentLocalService deleting department
			departmentLocalService.deleteDepartment(departmentId);
		} catch (PortalException e) {
			log.error(e.getMessage(), e);
		}
	}
}
