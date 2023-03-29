package com.aixtor.web.content.preference;

/**
 * 
 * @author Urva Patel
 *
 */

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;
import java.util.stream.Collectors;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "com.aixtor.web.content.preference.WebContentConfiguration")
public interface WebContentConfiguration {

	static Log log = LogFactoryUtil.getLog(WebContentConfiguration.class);
	
	List<JournalArticle> article = JournalArticleLocalServiceUtil.getArticlesByStructureId(42127, "89004", -1, -1, null);

	List<String> articleNames = article.stream().map(x -> x.getUrlTitle()).collect(Collectors.toList());
	List<String> articleIds = article.stream().map(x -> x.getArticleId()).collect(Collectors.toList());
	
	String[] optionValue  = articleNames.toArray(new String[articleNames.size()]);
	String[] optionLabel  = articleIds.toArray(new String[articleIds.size()]);
	
	
	@Meta.AD(
	        name = "webContent", 
	        required = false
	)
	public String webContent();
}
