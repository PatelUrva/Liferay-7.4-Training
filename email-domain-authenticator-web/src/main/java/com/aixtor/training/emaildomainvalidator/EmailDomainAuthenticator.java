package com.aixtor.training.emaildomainvalidator;

/**
 * @author Urva Patel
 */

import com.aixtor.training.emaildomainvalidator.api.EmaillDomainValidatorApi;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.Authenticator;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
	immediate = true,
	property = {"key=auth.pipeline.post"},
	service = Authenticator.class
)
public class EmailDomainAuthenticator implements Authenticator {
	
	@Reference
	private EmaillDomainValidatorApi emailDomainValidatorApi;
	
	@Reference
	private UserLocalService userLocalService;
	
	private static final Log log = LogFactoryUtil.getLog(EmailDomainAuthenticator.class);

	/**
	 * @return validated email address authenticated by emailAddress
	 */
	@Override
	public int authenticateByEmailAddress(long companyId, String emailAddress, String password,
			Map<String, String[]> headerMap, Map<String, String[]> parameterMap) throws AuthException {

		log.info("EmailDomainAuthenticator >>> authenticateByEmailAddress() :: " + emailAddress+ "\n");
		
		return validateDomain(emailAddress);
	}

	/**
	 * @return validated email address authenticated by screeName
	 */
	@Override
	public int authenticateByScreenName(long companyId, String screenName, String password,
			Map<String, String[]> headerMap, Map<String, String[]> parameterMap) throws AuthException {
		
		String emailAddress = userLocalService.fetchUserByScreenName(companyId, screenName).getEmailAddress();
		log.info("EmailDomainAuthenticator >>> authenticateByScreenName() :: " + emailAddress+ "\n");
		
		return validateDomain(emailAddress);
	}

	/**
	 * @return validated email address authenticated by userId
	 */
	@Override
	public int authenticateByUserId(long companyId, long userId, String password, Map<String, String[]> headerMap,
			Map<String, String[]> parameterMap) throws AuthException {
		
		String emailAddress = userLocalService.fetchUserById(userId).getEmailAddress();
		log.info("EmailDomainAuthenticator >>> authenticateByUserId() :: " + emailAddress+ "\n");
		
		return validateDomain(emailAddress);
	}
	
	/**
	 * 
	 * @param emailAddress
	 * @return authenticated login
	 * @throws AuthException
	 */
	private int validateDomain(String emailAddress) throws AuthException {
		
		// 1. Checks if emailAdress is null or not
		if (Validator.isNull(emailAddress)) {
			String msg = "Email Address is null. Cannot Authenticate user !!";
			log.error(msg);
			
			throw new AuthException(msg);
		}
		
		// 2. Check the email domain provided using customAPI call
		if(emailDomainValidatorApi.isValidEmailDomain(emailAddress)) {
			log.info("EmailDomainAuthenticator >>> validateDomain() :: Valid email domain");
			return Authenticator.SUCCESS;
		}
		
		String msg = "Email Address domain is not valid. Cannot Authenticate user with email address : " + emailAddress;
		log.error(msg);			
		throw new AuthException(msg);
	}
}