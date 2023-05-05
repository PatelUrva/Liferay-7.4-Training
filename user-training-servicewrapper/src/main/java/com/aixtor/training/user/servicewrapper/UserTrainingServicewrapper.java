package com.aixtor.training.user.servicewrapper;

/**
 * @author Urva Patel
 */

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class UserTrainingServicewrapper extends JournalArticleLocalServiceWrapper {
	
	private static Log log = LogFactoryUtil.getLog(UserTrainingServicewrapper.class);

	// 1. Constructor of class 
	public UserTrainingServicewrapper() {
		super(null);
	}
	
	
	/**
	 * @author Urva Patel
	 * @return web content Added
	 * Description:- Overriding addArticle method of JournalArticle
	 */
	@Override
	public JournalArticle addArticle(String externalReferenceCode, long userId, long groupId, long folderId,
			Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String content, String ddmStructureKey,
			String ddmTemplateKey, ServiceContext serviceContext) throws PortalException {

		log.info("UserTrainingServicewrapper >>> addArticle() >>> Web Content  Added");
		
		return super.addArticle(externalReferenceCode, userId, groupId, folderId, titleMap, descriptionMap, content,
				ddmStructureKey, ddmTemplateKey, serviceContext);
	}
	
	/**
	 * @author Urva Patel
	 * @return web content deleted
	 * Description:- Overriding deleteArticle method of JournalArticle
	 */
	@Override
	public JournalArticle deleteArticle(JournalArticle article, String articleURL, ServiceContext serviceContext)
			throws PortalException {
		log.info("UserTrainingServicewrapper >>> deleteArticle() >>> Web Content Deleted");
		return super.deleteArticle(article, articleURL, serviceContext);
	}
	
}