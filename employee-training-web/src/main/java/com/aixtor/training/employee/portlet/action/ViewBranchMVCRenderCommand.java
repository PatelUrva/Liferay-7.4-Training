package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Branch;
import com.aixtor.training.service.BranchLocalService;
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
	    	"javax.portlet.name=BranchPortlet",
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewBranchMVCRenderCommand implements MVCRenderCommand {

	private static Log log=LogFactoryUtil.getLog(ViewBranchMVCRenderCommand.class);

	@Reference
	BranchLocalService branchLocalService;
	
	@Reference
	StateLocalService stateLocalService;

	@Reference
	CounterLocalService count;
	
	/**
	 * @return branchList on page load and update record 
	 */
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		// 1. Using branchLocalService getting the details of all branches in a list
		List<Branch> branchList = branchLocalService.getBranches(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.BRANCH_LIST, branchList);
		
		// 2. Getting the action value that is generated on RenderURL
		String action = ParamUtil.getString(renderRequest, "action");
		
		// 3. Getting branchId of the branch selected for updating the record
		long branchId = ParamUtil.getLong(renderRequest, EmployeeConstants.BRANCH_ID);
		
		// 4. Setting the isEdit flag to false
		boolean isEdit = Boolean.FALSE;
		
		log.info("ViewBranchMVCRender >>> Action :: " + action);
		
		// 5. Validating if the action variable is empty or not 
		if(Validator.isNotNull(action)) {
			
			// 6. Retrieving the current url to be redirected after the task is done
			String redirectURL = ParamUtil.getString(renderRequest,EmployeeConstants.REDIRECT_URL);
			
			// 7. Validating if the action variable value is edit or not :: If edit than update the branch based on branchId
			if ("edit".equalsIgnoreCase(action) && branchId > 0) {
				try {
					
					// 8. Getting the branch details based on branchId
					Branch selectedBranch = branchLocalService.getBranch(branchId);
					
					// 9. Setting the renderRequest value as selectedBranch record details
					renderRequest.setAttribute(EmployeeConstants.SELECTED_BRANCH, selectedBranch);
					
					// 10. Setting the isEdit flag to true
					isEdit = Boolean.TRUE;
					
				} catch (PortalException e) {
					log.error("ViewBranchMVCRender >>> render ::" +e);
				}
			}
			
			renderRequest.setAttribute("redirectURL", redirectURL);
			renderRequest.setAttribute("isEdit", isEdit);
			
			// 11. Redirect to AddEditBranch jsp page where data is displayed of the branchId selected for updation
			return "/addEditBranch.jsp";
		}else {
			
			// 12. If action value is not edit :: then redirect to branchView page :: viewing the list of branch
			return "/branchView.jsp";
		}
	}
}
