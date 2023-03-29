package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Branch;
import com.aixtor.training.service.BranchLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=BranchPortlet",
	        "mvc.command.name=addEditBranch",
	    }, 
	    service = MVCActionCommand.class
)
public class AddEditBranchMVCActionCommand extends BaseMVCActionCommand{

	private static Log log = LogFactoryUtil.getLog(AddEditBranchMVCActionCommand.class);

	@Reference
	BranchLocalService branchLocalService;

	@Reference
	CounterLocalService counterLocalService;
	
	/**
	 * @return adding and editing branch record in the database
	 */
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// 1. Retrieving branchId from the branch record user selected
		long branchId = ParamUtil.getLong(actionRequest, EmployeeConstants.BRANCH_ID, GetterUtil.DEFAULT_LONG);
		
		// 2. Retrieving the current url to be redirected after the task is done
		String redirectURL = ParamUtil.getString(actionRequest, EmployeeConstants.REDIRECT_URL);

		// 3. Retrieving all the data of the branch form to be saved or updated in the database
		String branchName = ParamUtil.getString(actionRequest, EmployeeConstants.BRANCH_NAME);
		long countryId = ParamUtil.getLong(actionRequest, EmployeeConstants.COUNTRY);
		long stateId = ParamUtil.getLong(actionRequest, EmployeeConstants.STATE_ID);
		long cityId = ParamUtil.getLong(actionRequest, EmployeeConstants.CITY_ID);
		String address1 = ParamUtil.getString(actionRequest, EmployeeConstants.ADDRESS1);
		String address2 = ParamUtil.getString(actionRequest, EmployeeConstants.ADDRESS2);
		int pincode = ParamUtil.getInteger(actionRequest, EmployeeConstants.PINCODE);
		
		// 4. Initalizing and declaring the entity Branch
		Branch branch = null;
		
		try {
			/*
			 * 5. Validating if the branchId is Empty or Not :: If the branchId is not null the branchData will be updated 
			 *		based on branchId
			 */
			if (branchId > 0) {
				branch = branchLocalService.getBranch(branchId);
				branch.setBranchName(branchName);
				branch.setCountryId(countryId);;
				branch.setStateId(stateId);
				branch.setCityId(cityId);
				branch.setAddress1(address1);
				branch.setAddress2(address2);
				branch.setPincode(pincode);
			} else {
				
				// 6. If the branchId is empty then the data will be added as the new record enterd
				branch = branchLocalService.createBranch(counterLocalService.increment());
				branch.setBranchName(branchName);
				branch.setCountryId(countryId);;
				branch.setStateId(stateId);
				branch.setCityId(cityId);
				branch.setAddress1(address1);
				branch.setAddress2(address2);
				branch.setPincode(pincode);
				
			}
			
			/*
			 * 7. Using the updateBranch method of branchLocalService as it performs both adding and updating transactions in 
				database
			 */
			branchLocalService.updateBranch(branch);
		} catch (Exception e) {
			log.error("AddEditBranchMVCAction >>> doProcessAction >> Exception Occured:: " +e);
		}
		
		// 8. Redirecting back to the previous url
		actionResponse.sendRedirect(redirectURL);
	}

}
