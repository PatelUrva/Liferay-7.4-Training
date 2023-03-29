<%@page import="com.aixtor.training.service.DepartmentLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.DepartmentLocalService"%>
<%@page import="com.aixtor.training.model.Department"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%
	String currentURL=PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="addDepartmentRenderURL">
    <portlet:param name="action" value="add"/>
    <portlet:param name="redirectURL" value="<%=currentURL %>"/>
</portlet:renderURL>

<portlet:resourceURL id="/download/DepartmentPDF" var="departmentPDFResourceURL" />


<div class = "btn-group">
	<button type = "button" class = "btn btn-default">
		<a href="${addDepartmentRenderURL}" class="btn  btn-primary btn-default">
	        <i class="glyphicon glyphicon-plus"> Add Department </i>
	    </a>
	</button>
    <button type = "button" class = "btn btn-default">
    	<a href="${departmentPDFResourceURL}" class="btn  btn-primary btn-default">
	        <i class="glyphicon glyphicon-plus"> Download Department PDF </i>
	    </a>
    </button>
</div>

<%
 List<Department> departmentList = DepartmentLocalServiceUtil.getDepartments(-1,-1);
 System.out.println(departmentList.size());
%>

<liferay-ui:search-container 
	total="${departmentList.size()}" 
	var="searchContainer" 
	delta="2" 
	deltaConfigurable="false" 
  	emptyResultsMessage="Oops. There Are No Departments To Display, Please add Department">
  
	 <liferay-ui:search-container-results results="<%= ListUtil.subList(departmentList, searchContainer.getStart(),searchContainer.getEnd())%>" />	
		  <liferay-ui:search-container-row className="com.aixtor.training.model.Department" modelVar="department" keyProperty="departmentId" >
			  
			  <liferay-portlet:renderURL var="editDepartment">
			  		<portlet:param name="action" value="edit"/>
			  		<portlet:param name="designationId" value="${String.valueOf(department.getDepartmentId())}" />
			  		<portlet:param name="redirectURL" value="${currentURL}"/>
			  </liferay-portlet:renderURL>
			  
			  
			  <liferay-portlet:actionURL name="deleteDepartment" var="deleteDepartmentActionURL">
			  		<portlet:param name="departmentId" value="${String.valueOf(department.getDepartmentId())}" />
			  </liferay-portlet:actionURL>
			  
			   <liferay-ui:search-container-column-text name="Department Name" property="departmentName"/>
			   <liferay-ui:search-container-column-text name="Department Head" property="departmentHead"/>
		 	   <liferay-ui:search-container-column-text name="Action">
		 	   		<a  href="${editDepartment}">Edit</a> &nbsp;
		 	   		<a href="${deleteDepartmentActionURL}">Delete</a>
		 	   		
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	   
	 
	 	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>