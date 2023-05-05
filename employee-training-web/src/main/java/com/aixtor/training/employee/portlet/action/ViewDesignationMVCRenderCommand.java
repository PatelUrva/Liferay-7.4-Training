package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Designation;
import com.aixtor.training.service.DesignationLocalService;
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
	    	"javax.portlet.name="+EmployeeConstants.DESIGNATION_PORTLET,
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewDesignationMVCRenderCommand implements MVCRenderCommand {

	private static Log log=LogFactoryUtil.getLog(ViewDesignationMVCRenderCommand.class);

	@Reference
	DesignationLocalService designationLocalService;

	@Reference
	CounterLocalService count;
	
	/**
	 * @return designationList on page load and update record
	 */
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		// 1. Using designationLocalService getting the details of all designation in a list
		List<Designation> designationList = designationLocalService.getDesignations(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.DESIGNATION_LIST, designationList);
		
		// 2. Getting the action value that is generated on RenderURL
		String action = ParamUtil.getString(renderRequest, EmployeeConstants.ACTION);
		
		// 3. Getting designationId of the designation selected for updating the record
		long designationId = ParamUtil.getLong(renderRequest, EmployeeConstants.DESIGNATION_ID);
		
		// 4. Setting the isEdit flag to false
		boolean isEdit = Boolean.FALSE;
		
		log.info("ViewDesignationMVCRender >>> render >>> Action :: " + action);
		
		// 5. Validating if the action variable is empty or not
		if(Validator.isNotNull(action)) {
			
			// 6. Retrieving the current url to be redirected after the task is done
			String redirectURL = ParamUtil.getString(renderRequest, EmployeeConstants.REDIRECT_URL);
			
			// 7. Validating if the action variable value is edit or not :: If edit than update the designation on designationId
			if (EmployeeConstants.EDIT.equalsIgnoreCase(action) && designationId > 0) {
				try {
					
					// 8. Getting the designation details based on designationId
					Designation selectedDesignation = designationLocalService.getDesignation(designationId);
					
					// 9. Setting the renderRequest value as selectedDesignation record details
					renderRequest.setAttribute(EmployeeConstants.SELECTED_DESIGNATION, selectedDesignation);
					
					// 10. Setting the isEdit flag to true
					isEdit = Boolean.TRUE;
					
				} catch (PortalException e) {
					log.error("ViewDesignationMVCRender >>> render ::" +e);
				}
			}
			renderRequest.setAttribute(EmployeeConstants.REDIRECT_URL, redirectURL);
			renderRequest.setAttribute(EmployeeConstants.IS_EDIT, isEdit);
			
			// 11. Redirect to AddEditDesignation jsp page where data is displayed of the designationId selected for updation
			return "/addEditDesignation.jsp";
		}else {
			
			// 12. If action value is not edit :: then redirect to designationView page :: viewing the list of designation
			return "/designationView.jsp";
		}
		
	}

	
}
