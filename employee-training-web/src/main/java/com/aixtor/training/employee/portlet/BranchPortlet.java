package com.aixtor.training.employee.portlet;

/**
 * @author Urva Patel
 */
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Branch;
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
import java.util.List;

import javax.mail.internet.InternetAddress;
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
		"javax.portlet.name=BranchPortlet", 
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

	/**
	 * @return List of branches and countries on Page load
	 */

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		// 1. Using branchLocalService getting the details of all branches in a list
		List<Branch> branchList = branchLocalService.getBranches(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.BRANCH_LIST, branchList);

		// 2. Using countryLocalService getting the details of all Country in a list
		// from Liferay Country management out of the box

		List<Country> countryList = countryLocalService.getCountries(-1, -1);
		renderRequest.setAttribute(EmployeeConstants.COUNTRY_LIST, countryList);

		super.render(renderRequest, renderResponse);
	}

	/**
	 * @return Branch deleted based on branch Id selected by the user
	 * @param requesting branchId from the selected branch
	 * @param response   deleting branch based on branchId
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
	 * @return mail sent to given mail id by user
	 * @param request 
	 * @param response
	 */
	@ProcessAction(name = "sendMail")
	public void sendMail(ActionRequest request, ActionResponse response) {
		
		// 1. Initalizing mail subject to sent as a subject in Mail
		String mailSubject =  EmployeeConstants.MAIL_SUBJECT;
		
		// 2. Initializing sender mail address
	    String senderMailAddress = EmployeeConstants.SENDER_MAIL;
	    
	    // 3. Getting receiver mail address from textbox
	    String receiverMailAddress = ParamUtil.getString(request,EmployeeConstants.RECEIVER_MAIL);
	    
	    try {
	    	// 4. Creating object of MailMessage for using its mail methods
			MailMessage mailMessage = new MailMessage();
			
			// 5. Setting mail body 
			mailMessage.setBody("Hello from Urva Patel");
			
			// 6. Setting mail subject
			mailMessage.setSubject(mailSubject);
			
			// 7. Setting sender mail address
			mailMessage.setFrom(new InternetAddress(senderMailAddress));
			
			// 8. Setting receiver mail address
			mailMessage.setTo(new InternetAddress(receiverMailAddress));
			
			// 9. Using sendEmail() of MailServiceUtil sending mail and checking configuration
			MailServiceUtil.sendEmail(mailMessage);
			
			// 10. Logger message if mail sent
			log.info("BranchPortlet >>> sendMail() >>> Mail Sent"); 
			
		} catch (Exception e) {
			
			// 11. If exeception occurred while sending mail
			log.error("BranchPortlet >>> sendMail() >>> Mail Sending Error :: "+e); 
		}
	    
	}
}
