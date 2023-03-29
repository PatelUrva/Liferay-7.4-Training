package com.aixtor.web.content.preferences.portlet;

import com.aixtor.web.content.preference.WebContentConfiguration;
import com.aixtor.web.content.preferences.action.WebContentPreferencesAction;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * 
 * @author Urva Patel
 *
 */

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=WebContentPreferences",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=WebContentPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class WebContentPreferencesPortlet extends MVCPortlet {

	WebContentConfiguration webContentConfiguration;
	private static Log log = LogFactoryUtil.getLog(WebContentPreferencesAction.class);
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		String webContent = webContentConfiguration.webContent();
		log.info("WebContent: " +webContent );
		
    	renderRequest.setAttribute(WebContentConfiguration.class.getName(), webContentConfiguration);
        renderRequest.setAttribute("webContent",webContentConfiguration.webContent());
        
		super.render(renderRequest, renderResponse);
	}
	
	@Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        webContentConfiguration = ConfigurableUtil.createConfigurable(WebContentConfiguration.class, properties);
    }
}
