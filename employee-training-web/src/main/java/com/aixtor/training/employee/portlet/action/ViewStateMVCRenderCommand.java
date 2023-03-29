package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.State;
import com.aixtor.training.service.StateLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=StatePortlet",
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewStateMVCRenderCommand implements MVCRenderCommand {

	private static Log log=LogFactoryUtil.getLog(ViewStateMVCRenderCommand.class);

	@Reference
	StateLocalService stateLocalService;

	@Reference
	CounterLocalService count;
	
	/**
	 * @return stateList on page load and update record
	 */
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		// 1. Using stateLocalService getting the details of all states in a list
		List<State> stateList = stateLocalService.getStates(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.STATE_LIST, stateList);
		
		// 2. Getting the action value that is generated on RenderURL
		String action = ParamUtil.getString(renderRequest, "action");
		
		// 3. Getting stateId of the state selected for updating the record
		long stateId = ParamUtil.getLong(renderRequest, EmployeeConstants.STATE_ID);
		
		// 4. Setting the isEdit flag to false
		boolean isEdit = Boolean.FALSE;
		
		log.info("ViewStateMVCRender >>> render >>> Action :: " + action);
		
		// 5. Validating if the action variable is empty or not
		if(Validator.isNotNull(action)) {
			
			// 6. Retrieving the current url to be redirected after the task is done
			String redirectURL = ParamUtil.getString(renderRequest, "redirectURL");
			
			// 7. Validating if the action variable value is edit or not :: If edit than update the state based on stateId
			if ("edit".equalsIgnoreCase(action) && stateId > 0) {
				try {
					
					// 8. Getting the state details based on stateId
					State selectedState = stateLocalService.getState(stateId);
					
					// 9. Setting the renderRequest value as selectedState record details
					renderRequest.setAttribute("selectedState", selectedState);
					
					// 10. Setting the isEdit flag to true
					isEdit = Boolean.TRUE;
					
				} catch (PortalException e) {
					log.error("ViewStateMVCRender >>> render ::" +e);
				}
			}
			renderRequest.setAttribute("redirectURL", redirectURL);
			renderRequest.setAttribute("isEdit", isEdit);
			
			// 11. Redirect to AddEditState jsp page where data is displayed of the stateId selected for updation
			return "/addEditState.jsp";
		}else {
			
			// 12. If action value is not edit :: then redirect to stateView page :: viewing the list of state
			return "/stateView.jsp";
		}
		
	}

	
}
