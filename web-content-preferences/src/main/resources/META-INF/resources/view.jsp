<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@ include file="init.jsp"%>
<%@taglib prefix="liferay-journal" uri="http://liferay.com/tld/journal" %>
<p>
	<b><liferay-ui:message key="webcontentpreferences.caption"/></b>
</p>

<%
	long groupId = themeDisplay.getScopeGroupId();
	System.out.println("Group :"+groupId);
	System.out.println("Article :"+webContent);
%>

 <br>
 <liferay-journal:journal-article articleId="<%= webContent %>" groupId="<%= groupId %>"> </liferay-journal:journal-article>
<p>
    Web Content:<%=webContent %>
</p>