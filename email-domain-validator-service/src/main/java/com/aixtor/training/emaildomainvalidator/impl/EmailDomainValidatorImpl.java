package com.aixtor.training.emaildomainvalidator.impl;

/**
 * @author Urva Patel
 */

import com.aixtor.training.emaildomainvalidator.api.EmaillDomainValidatorApi;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {},
	service = EmaillDomainValidatorApi.class
)
public class EmailDomainValidatorImpl implements EmaillDomainValidatorApi {

	private static final Log log = LogFactoryUtil.getLog(EmailDomainValidatorImpl.class);

	
	private Set<String> validEmailDomains = new HashSet<String>(Arrays.asList(new String[] {"@liferay.com",
		 "@gmail.com" ,"@aixtor.com"}));
	 
	/**
	 * @return validated emailAddress true or false
	 */
	@Override
	public boolean isValidEmailDomain(String emailAddress) {
		
		// 1. Checks if emailAddress domain provided by user matches the domain required to be authenticated
		if(validEmailDomains.contains(emailAddress.substring(emailAddress.indexOf('@')))) {
			log.info("EmailDomainValidatorImpl >>> isValidEmailDomain() :: Valid email domain");
			return true;
		}
		log.info("EmailDomainValidatorImpl >>> isValidEmailDomain() :: Invalid email domain");
		return false;
	}

}