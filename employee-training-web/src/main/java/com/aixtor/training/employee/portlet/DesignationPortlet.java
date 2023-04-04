package com.aixtor.training.employee.portlet;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Designation;
import com.aixtor.training.service.DesignationLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
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
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Designation Form",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/designationView.jsp",
		"javax.portlet.name=DesignationPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class DesignationPortlet extends MVCPortlet {
	private static Log log=LogFactoryUtil.getLog(DesignationPortlet.class);
	@Reference
	CounterLocalService count;
	
	@Reference
	DesignationLocalService designationLocalService;
	
	/**
	 * @return designation List on Page load
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// 1. Using designationLocalService getting the details of all designations in a list
		List<Designation> designationList = designationLocalService.getDesignations(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.DESIGNATION_LIST, designationList);
		
		super.render(renderRequest, renderResponse);
	}
	
	/**
	 * @return Designation deleted based on designationId selected by the user
	 * @param requesting designationId from the selected designation
	 * @param response deleting designation based on designationId
	 */
	@ProcessAction(name = "deleteDesignation")
	public void deleteDesignation(ActionRequest request, ActionResponse response) {
		
		// 1. Using ParamUtil and request get the selected designationId
		long designationId = ParamUtil.getLong(request, EmployeeConstants.DESIGNATION_ID, GetterUtil.DEFAULT_LONG);
		try {
			// 2. Using deleteDesignation method of designationLocalService deleting designation
			designationLocalService.deleteDesignation(designationId);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
