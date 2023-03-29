package com.aixtor.web.content.preferences.action;

import com.aixtor.web.content.preference.WebContentConfiguration;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import aQute.bnd.annotation.metatype.Configurable;

/**
 * 
 * @author Urva Patel
 *
 */
@Component(
		configurationPid = "com.aixtor.web.content.preference.WebContentConfiguration",
		configurationPolicy = ConfigurationPolicy.OPTIONAL, 
		immediate = true,
		property = "javax.portlet.name=WebContentPortlet",
		service = ConfigurationAction.class
	)
public class WebContentPreferencesAction extends DefaultConfigurationAction {

	private volatile WebContentConfiguration webContentConfiguration;
	private static Log log = LogFactoryUtil.getLog(WebContentPreferencesAction.class);
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		String webContent = ParamUtil.getString(actionRequest, "webContent");
		PortletPreferences ppPortletPreferences = actionRequest.getPreferences();
		ppPortletPreferences.setValue("webContent", webContent);
		log.info("----------- From Process ActionRequest Web Content ----------- " + webContent);
		ppPortletPreferences.store();
		
		log.info(ppPortletPreferences.getValue("webContent", "urva"));
		
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
	
	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		webContentConfiguration = Configurable.createConfigurable(WebContentConfiguration.class, properties);
	}
	
}
