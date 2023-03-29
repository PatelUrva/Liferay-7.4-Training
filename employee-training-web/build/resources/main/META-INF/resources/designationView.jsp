<%@page import="com.aixtor.training.service.DesignationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.aixtor.training.model.Designation"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%
	String currentURL=PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="addDesignationRenderURL">
    <portlet:param name="action" value="add"/>
    <portlet:param name="redirectURL" value="<%=currentURL %>"/>
</portlet:renderURL>

<portlet:resourceURL id="/download/designationPDF" var="desigantionPDFResourceURL" />

<div class = "btn-group">
	<button type = "button" class = "btn btn-default">
		<a href="${addDesignationRenderURL}" class="btn  btn-primary btn-default">
	        <i class="glyphicon glyphicon-plus"> Add Designation </i>
	    </a>
	</button>
    <button type = "button" class = "btn btn-default">
    	<a href="${desigantionPDFResourceURL}" class="btn  btn-primary btn-default">
	        <i class="glyphicon glyphicon-plus"> Download Designation PDF </i>
	    </a>
    </button>
</div>

<%
 List<Designation> designationList = DesignationLocalServiceUtil.getDesignations(-1,-1);
 System.out.println(designationList.size());
%>

<liferay-ui:search-container 
	total="${designationList.size()}" 
	var="searchContainer" 
	delta="2" 
	deltaConfigurable="false" 
  	emptyResultsMessage="Oops. There Are No Designation To Display, Please add Designation">
  
	 <liferay-ui:search-container-results results="<%= ListUtil.subList(designationList, searchContainer.getStart(),searchContainer.getEnd())%>" />	
		  <liferay-ui:search-container-row className="com.aixtor.training.model.Designation" modelVar="designation" keyProperty="designationId" >
			  
			  <liferay-portlet:renderURL var="editDesignation">
			  		<portlet:param name="action" value="edit"/>
			  		<portlet:param name="designationId" value="<%= String.valueOf(designation.getDesignationId())%>" />
			  		<portlet:param name="redirectURL" value="${currentURL}"/>
			  </liferay-portlet:renderURL>
			  
			  
			  <liferay-portlet:actionURL name="deleteDesignation" var="deleteDesignationActionURL">
			  		<portlet:param name="designationId" value="<%= String.valueOf(designation.getDesignationId())%>" />
			  </liferay-portlet:actionURL>
			  
			   <liferay-ui:search-container-column-text name="Designation Name" property="designationName"/>
			   <liferay-ui:search-container-column-text name="Action">
		 	   		<a  href="${editDesignation}">Edit</a> &nbsp;
		 	   		<a href="${deleteDesignationActionURL}">Delete</a>
		 	   		
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	   
	 
	 	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>