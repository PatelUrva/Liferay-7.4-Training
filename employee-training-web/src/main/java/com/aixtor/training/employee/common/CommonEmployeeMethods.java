package com.aixtor.training.employee.common;

import com.aixtor.training.employee.bean.ViewCustomBranchBean;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.bean.ViewCustomEmployeeBean;
import com.aixtor.training.employee.portlet.BranchMail;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class CommonEmployeeMethods {
	
	/**
	 * @author Urva Patel
	 * @param employeeId
	 * @param employeeName
	 * @param employeeMobile
	 * @param employeeEmail
	 * @param branchName
	 * @param departmentName
	 * @param designationName
	 * @return viewCustomEmployeeBean 
	 */
	public static ViewCustomEmployeeBean setNewCustomBean(long employeeId, String employeeName, String employeeMobile, 
			String employeeEmail, String branchName, String departmentName, 
				String designationName){
		
		ViewCustomEmployeeBean viewCustomEmployeeBean = new ViewCustomEmployeeBean();
		
		// 2. Setting SQL values to custommBean
		viewCustomEmployeeBean.setEmployeeId(employeeId);
		viewCustomEmployeeBean.setEmployeeName(employeeName);
		viewCustomEmployeeBean.setEmployeeMobile(employeeMobile);
		viewCustomEmployeeBean.setEmployeeEmail(employeeEmail);
		viewCustomEmployeeBean.setBranchName(branchName);
		viewCustomEmployeeBean.setDepartmentName(departmentName);
		viewCustomEmployeeBean.setDesignationName(designationName);
		
		return viewCustomEmployeeBean;
	}
	

	/**
	 * @author Urva Patel
	 * @param branchId
	 * @param branchName
	 * @param country
	 * @param state
	 * @param city
	 * @param address1
	 * @param address2
	 * @param pincode
	 * @return ViewCustomBranchBean
	 */
	public static ViewCustomBranchBean setBranchBean(long branchId, String branchName, String country, String state,String city, String address1, String address2, int pincode){
		
		ViewCustomBranchBean viewCustomBranchBean = new ViewCustomBranchBean();
		
		// 2. Setting SQL values to custommBean
		viewCustomBranchBean.setBranchId(branchId);
		viewCustomBranchBean.setBranchName(branchName);
		viewCustomBranchBean.setCountry(country);
		viewCustomBranchBean.setState(state);
		viewCustomBranchBean.setCity(city);
		viewCustomBranchBean.setAddress1(address1);
		viewCustomBranchBean.setAddress2(address2);
		viewCustomBranchBean.setPincode(pincode);
		
		return viewCustomBranchBean;
	}
	
	/**
	 * @author Urva Patel
	 * @param mailSubject
	 * @param senderMailAddress
	 * @param receiverMailAddress
	 * @return 
	 * @throws AddressException 
	 */
	public static MailMessage sendMail(String mailSubject, String senderMailAddress, String receiverMailAddress) throws AddressException {
		
		MailMessage mailMessage = BranchMail.getInstance();
		
		mailMessage.setBody("Hello from Urva Patel");
		mailMessage.setSubject(mailSubject);
		mailMessage.setFrom(new InternetAddress(senderMailAddress));
		mailMessage.setTo(new InternetAddress(receiverMailAddress));
		
		// 9. Using sendEmail() of MailServiceUtil sending mail and checking configuration
		MailServiceUtil.sendEmail(mailMessage);
		
		return mailMessage;
		
	}
}
