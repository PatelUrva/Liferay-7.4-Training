package com.aixtor.portal.color.preferences.portlet;

import com.aixtor.portal.color.preference.ColorConfiguration;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

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
 * @author Urva Patel
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ColorPreferences",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=ColorPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ColorPreferencesPortlet extends MVCPortlet {
	
	ColorConfiguration colorConfiguration;
	 
    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
    	
    	System.out.println("color: " + colorConfiguration.color());
    	renderRequest.setAttribute(ColorConfiguration.class.getName(), colorConfiguration);
        renderRequest.setAttribute("color",colorConfiguration.color());
        
        super.render(renderRequest, renderResponse);
    }
 
    @Activate
    @Modified
    protected void activate(Map<String, Object> properties) {
        colorConfiguration = ConfigurableUtil.createConfigurable(ColorConfiguration.class, properties);
    }
}