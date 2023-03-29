package com.aixtor.portal.color.preferences.action;

/**
 * @author Urva Patel
 */
import com.aixtor.portal.color.preference.ColorConfiguration;
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

@Component(
	configurationPid = "com.aixtor.portal.color.preference.ColorConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL, 
	immediate = true,
	property = "javax.portlet.name=ColorPortlet",
	service = ConfigurationAction.class
)

public class ColorPreferencesAction extends DefaultConfigurationAction {

	private volatile ColorConfiguration colorConfiguration;
	private static Log log = LogFactoryUtil.getLog(ColorPreferencesAction.class);
	
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		
		String color = ParamUtil.getString(actionRequest, "color");
		PortletPreferences ppPortletPreferences = actionRequest.getPreferences();
		ppPortletPreferences.setValue("color", color);
		ppPortletPreferences.store();
		
		log.info(ppPortletPreferences.getValue("color", "urva"));

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		colorConfiguration = Configurable.createConfigurable(ColorConfiguration.class, properties);
	}

}
