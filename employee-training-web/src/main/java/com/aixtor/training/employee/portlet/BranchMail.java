package com.aixtor.training.employee.portlet;

/**
 * @author Urva Patel
 */

import com.liferay.mail.kernel.model.MailMessage;

public class BranchMail extends MailMessage {

	private static MailMessage mailInstance;
	
	private BranchMail() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @author Urva Patel
	 * @return mailInstance
	 */
	public static synchronized MailMessage getInstance() {
		if(mailInstance == null) {
			mailInstance = new MailMessage();
			System.out.println("check instance :: "+ mailInstance);
		}
		return mailInstance;
		
	}
	
	
}
