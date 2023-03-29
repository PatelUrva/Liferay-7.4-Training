package com.aixtor.training.portlet;

import com.aixtor.training.constants.EmpComponentPortletKeys;
import com.aixtor.training.empojo.Employee;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Urva Patel
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmpComponent",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmpComponentPortletKeys.EMPCOMPONENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmpComponentPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ArrayList<Employee> emp =new ArrayList<Employee>();

		emp.add(new Employee(1,"Urva",101,"Java"));
		emp.add(new Employee(2,"Adarsh",102,"Liferay"));
		emp.add(new Employee(3,"Sachin",103,"Spring"));
		
		renderRequest.setAttribute("employeeList", emp);
		super.render(renderRequest, renderResponse);
	}
}