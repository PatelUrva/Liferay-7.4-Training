package com.aixtor.training.loginpre;

/**
 * @author Urva Patel
 */

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		 "key=login.events.pre"
	},
	service = LifecycleAction.class
)
public class LoginPreAction implements LifecycleAction  {
	
	private static Log log = LogFactoryUtil.getLog(LoginPreAction.class);
	
	@Reference
	private GroupLocalService groupLocalService;
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		
		log.info("LoginPreAction >>> Inside processLifecycleEvent()");
		
		// 1. Getting request details in HttpServletRequest
		HttpServletRequest httpServletRequest = lifecycleEvent.getRequest();
		
		try {
			
			// 2. Fetching currently logged in user details
			User user = PortalUtil.getUser(httpServletRequest);
			long userId = user.getUserId();
			log.info("LoginPreAction >>> Inside processLifecycleEvent() >>> userId : " +userId);
			
			// 3. Fetching currently logged in user site details
			long[] groupId = user.getGroupIds();
			log.info("LoginPreAction >>> Inside processLifecycleEvent() >>> groupId : " +groupId);
		
			for (long selectGroupId : groupId) {
				// 4. Based on groupId fetching siteName 
				Group group = groupLocalService.getGroup(selectGroupId);
				log.info("LoginPreAction >>> Inside processLifecycleEvent() >>> siteFullPath : " +group.getName() + "\n");
				log.info("LoginPreAction >>> Inside processLifecycleEvent() >>> siteName : " +group.getNameCurrentValue() + "\n");
			}
			
		} catch (PortalException e) {
			log.info("LoginPreAction >>> Error Occured : " +e);
		}
	}

}