package com.aixtor.training.customlogin.portlet;

/**
 * @author Urva Patel
 */
import com.aixtor.training.customlogin.constants.LoginConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = {
	        "javax.portlet.name=LoginPortlet",
	        "mvc.command.name=/custom/login"
    },
    service = MVCActionCommand.class
)
public class LoginMVCActionCommand extends BaseMVCActionCommand {
	
	@Reference
	private UserLocalService userLocalService;
	
	/**
	 * @return user logged in
	 */
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		
		// 1. Getting login form data from actionRequest
		String email = ParamUtil.getString(actionRequest, LoginConstants.EMAIL);
		String password = ParamUtil.getString(actionRequest, LoginConstants.PASSWORD);
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, LoginConstants.REMEMBER_ME);
		String authType = LoginConstants.AUTH_TYPE;
		
		// 2. If user is already present then login and redirect to user's home page else throws error
		try {
			AuthenticatedSessionManagerUtil.login(request, response, email, password, rememberMe, authType);
			actionResponse.sendRedirect(themeDisplay.getPathMain());
		}
		catch(Exception e) {
            SessionErrors.add(actionRequest, "error");
        }
		
	}
	

}
