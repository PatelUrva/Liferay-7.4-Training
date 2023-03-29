package com.aixtor.training.lifecycle.portlet;

import com.aixtor.training.lifecycle.constants.LifecycleComponentPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

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
		"javax.portlet.display-name=LifecycleComponent",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LifecycleComponentPortletKeys.LIFECYCLECOMPONENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LifecycleComponentPortlet extends MVCPortlet {
	
	@Override
	public void init() throws PortletException {
		System.out.println("============ Initialization =============");
		super.init();
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		System.out.println("============ Rendering ===============");
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void destroy() {
		System.out.println("============= Destroyed ==============");
		super.destroy();
	}
}