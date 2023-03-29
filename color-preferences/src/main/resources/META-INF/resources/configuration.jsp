
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%=true %>" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true %>" var="configurationRenderURL" />


<aui:form action="<%=configurationActionURL %>" method="post" name="fm">
	
	<aui:fieldset>
		<aui:select label="Color" name="color" value="<%=color%>">
			<aui:option value="white">White</aui:option>
			<aui:option value="red">Red</aui:option>
			<aui:option value="yellow">Yellow</aui:option>
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>
