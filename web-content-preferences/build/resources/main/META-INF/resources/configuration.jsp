<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@ include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%=true %>" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true %>" var="configurationRenderURL" />

<%

List<JournalArticle> article = JournalArticleLocalServiceUtil.getArticlesByStructureId(42127, "89004", -1, -1, null);

%>
   
<form action="<%=configurationActionURL %>" method="post" name="fm">
	
	<fieldset>
		<select label="WebContent" name="webContent" value="<%=webContent%>">
			<%
			for (JournalArticle journalArticle : article) {
				String articleId = journalArticle.getArticleId();
				long groupId = journalArticle.getGroupId();
				String articleName = journalArticle.getUrlTitle();
				
			%>
			<option value="<%= articleId %>"> <%= articleName %></option>
			<%
			}
			%>
		</select>
	</fieldset>

	<button-row>
		<button type="submit"></button>
	</button-row>
</form>