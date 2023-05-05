package com.aixtor.training.emaildomainvalidator.api;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Urva Patel
 */

@ProviderType
public interface EmaillDomainValidatorApi {
	
	/**
	 * @author Urva Patel
	 * @param emailAddress
	 * @return boolean value for emailAddress domain validated
	 */
	public boolean isValidEmailDomain(String emailAddress);
}