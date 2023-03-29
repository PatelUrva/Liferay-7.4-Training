<%@page import="com.aixtor.training.service.StateLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.StateLocalService"%>
<%@page import="com.aixtor.training.model.State"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%
	String currentURL=PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="addStateRenderURL">
    <portlet:param name="action" value="add"/>
    <portlet:param name="redirectURL" value="<%=currentURL %>"/>
</portlet:renderURL>


<div class="mb-5">
    <a href="${addStateRenderURL}" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"> Add State </i>
    </a>
</div>

<%
 List<State> stateList = StateLocalServiceUtil.getStates(-1,-1);
 System.out.println(stateList.size());
%>

<liferay-ui:search-container 
	total="${stateList.size()}" 
	var="searchContainer" 
	delta="2" 
	deltaConfigurable="false" 
  	emptyResultsMessage="Oops. There Are No States To Display, Please add States">
  
	 <liferay-ui:search-container-results results="<%= ListUtil.subList(stateList, searchContainer.getStart(),searchContainer.getEnd())%>" />	
		  <liferay-ui:search-container-row className="com.aixtor.training.model.State" modelVar="state" keyProperty="stateId" >
			  
			  <liferay-portlet:renderURL var="editState">
			  		<portlet:param name="action" value="edit"/>
			  		<portlet:param name="stateId" value="${String.valueOf(state.getStateId())}" />
			  		<portlet:param name="redirectURL" value="${currentURL}"/>
			  </liferay-portlet:renderURL>
			  
			  
			  <liferay-portlet:actionURL name="deleteState" var="deleteStateActionURL">
			  		<portlet:param name="stateId" value="${String.valueOf(state.getStateId())}" />
			  </liferay-portlet:actionURL>
			  
			   <liferay-ui:search-container-column-text name="State Name" property="stateName"/>
			   <liferay-ui:search-container-column-text name="Country Id" property="countryId"/>
		 	   <liferay-ui:search-container-column-text name="Action">
		 	   		<a  href="${editState}">Edit</a> &nbsp;
		 	   		<a href="${deleteStateActionURL}">Delete</a>
		 	   		
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	   
	 
	 	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>