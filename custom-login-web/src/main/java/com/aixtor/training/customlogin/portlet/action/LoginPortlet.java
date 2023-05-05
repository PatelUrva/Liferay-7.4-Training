package com.aixtor.training.customlogin.portlet.action;

import com.aixtor.training.customlogin.constants.LoginConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.requires-namespaced-parameters=false", 
		"javax.portlet.display-name=Login Form",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LoginConstants.LOGIN_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
}, service = Portlet.class)

public class LoginPortlet extends MVCPortlet {

}
