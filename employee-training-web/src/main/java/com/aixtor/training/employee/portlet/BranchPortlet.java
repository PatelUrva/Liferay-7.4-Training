package com.aixtor.training.employee.portlet;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.api.EmployeeApi;
import com.aixtor.training.employee.bean.ViewCustomBranchBean;
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.service.BranchLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.requires-namespaced-parameters=false", 
		"javax.portlet.display-name=Branch Form",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/branchView.jsp",
		"javax.portlet.name="+EmployeeConstants.BRANCH_PORTLET, 
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
}, service = Portlet.class)

public class BranchPortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(BranchPortlet.class);

	@Reference
	private BranchLocalService branchLocalService;
	
	@Reference
	private CountryLocalService countryLocalService;

	@Reference
	private CounterLocalService count;
	
	@Reference
	private EmployeeApi employeeApi;
	
	
	/**
	 * @return List of branches and countries on Page load
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		// 1. Using branchLocalService getting the details of all branches in a list
		List<Object[]> branches = branchLocalService.getAllBranches();
		
		// 2. Creating ArrayList of customEmployeeBean to stored the searchList and retrieve the data element by element
		List<ViewCustomBranchBean> branchList = new ArrayList<>();
		
		// 3. Traversing to all the records available in the Employee entity
		for (Object[] obj : branches) {
			
			// 4. Getting values from object
			long branchId = GetterUtil.getLong(obj[0]);
			String branchName = String.valueOf(obj[1]);
			String country = String.valueOf(obj[2]);
			String state = String.valueOf(obj[3]);
			String city = String.valueOf(obj[4]);
			String address1 = String.valueOf(obj[5]);
			String address2 = String.valueOf(obj[6]);
			int pincode = (Integer) obj[7];
			long countryId = 0;
			long stateId = 0;
			long cityId = 0;
			
			// 5. Calling setCustomBean method for setting values in ViewEmployeeCustomBean
			ViewCustomBranchBean viewCustomBranchBean = employeeApi.setBranchBean(branchId, branchName,
					country, state, city, address1, address2, pincode, countryId, stateId, cityId);
					
			// 6. Adding the customBean object in the ArrayList
			branchList.add(viewCustomBranchBean);
		}				
		renderRequest.setAttribute(EmployeeConstants.BRANCH_LIST, branchList);
		
		/* 2. Using countryLocalService getting the details of all Country in a list
		* from Liferay Country management out of the box
		*/
		List<Country> countryList = countryLocalService.getCountries(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.COUNTRY_LIST, countryList);
		
		super.render(renderRequest, renderResponse);
	}

	
	/**
	 * @return Branch deleted based on branch Id selected by the user
	 * @param requesting branchId from the selected branch
	 * @param response deleting branch based on branchId
	 */
	@ProcessAction(name = "deleteBranch")
	public void deleteBranch(ActionRequest request, ActionResponse response) {

		// 1. Using ParamUtil and request get the selected branch Id
		long branchId = ParamUtil.getLong(request, EmployeeConstants.BRANCH_ID, GetterUtil.DEFAULT_LONG);

		try {
			// 2. Using deleteBranch method of branchLocalService deleting branch
			branchLocalService.deleteBranch(branchId);
		} catch (PortalException e) {
			log.error("BranchPortlet >>> Delete Branch Method :: " + e.getMessage(), e);
		}
	}

	
	/**
	 * @author Urva Patel
	 * @return mail sent to given mail id by user
	 * @param request 
	 * @param response
	 */
	@ProcessAction(name = "sendMail")
	public void sendMail(ActionRequest request, ActionResponse response) {
		
		String mailSubject =  EmployeeConstants.MAIL_SUBJECT;
		String senderMailAddress = EmployeeConstants.SENDER_MAIL;
	    String receiverMailAddress = ParamUtil.getString(request,EmployeeConstants.RECEIVER_MAIL);
	    
	    try {
	    	// 1. Creating object of MailMessage for using its mail methods
			MailMessage mailMessage = employeeApi.sendMail(mailSubject, senderMailAddress, receiverMailAddress);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			// 2. If exeception occurred while sending mail
			log.error("BranchPortlet >>> sendMail() >>> Mail Sending Error :: "+e); 
		}
	}
}
