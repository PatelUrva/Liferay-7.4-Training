<%@page import="com.liferay.portal.kernel.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.aixtor.training.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.aixtor.training.model.Employee"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%
	String currentURL=PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="addEmployeeRenderURL">
    <portlet:param name="action" value="add"/>
    <portlet:param name="redirectURL" value="${currentURL}"/>
</portlet:renderURL>

<portlet:resourceURL id="/download/employeePDF" var="employeePDFResourceURL" />

<portlet:resourceURL id="/download/employeeXLSX" var="employeeXLSXResourceURL" />

<liferay-portlet:actionURL name="searchEmployee" var="searchEmployeeActionURL" />

<div class = "btn-group">
	<button type = "button" class="btn btn-default">
		<a href="${addEmployeeRenderURL}" class="btn  btn-primary btn-default">
	        <i class="glyphicon glyphicon-plus"> Add Employee </i>
	    </a>
	</button>
    <button type = "button" class="btn btn-default">
    	<a href="${employeePDFResourceURL}" class="btn btn-primary btn-default">
	        <i class="glyphicon glyphicon-plus"> Download PDF </i>
	    </a>
    </button>
    <button type = "button" class="btn btn-default">
    	<a href="${employeeXLSXResourceURL}" class="btn btn-primary btn-default">
	        <i class="glyphicon glyphicon-plus"> Download XLSX </i>
	    </a>
    </button>
    <form action="${searchEmployeeActionURL}" method="post">
    	<div style="margin-left:50px;padding-top:10px">
	    	<input type="date" name="fromDate" />
	    	<input type="date" name="toDate" />
	   		<input type="text" name="searchText" /> 
	    	<button style="padding-top:5px" type="submit" class="btn btn-primary btn-default">
	    		Search
	    	</button>
	    </div>
    </form>
    
</div>

<%

List<Employee> employeeList = (List<Employee>)renderRequest.getAttribute("employeeList");
String fromSearch = (String) renderRequest.getAttribute("fromSearch");

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("fromSearch", fromSearch);

SearchContainer<Employee> employeeContainer= new SearchContainer<Employee>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 4, portletURL, null, null);
employeeList = ListUtil.subList(employeeList, employeeContainer.getStart(), employeeContainer.getEnd());
String cur = Integer.toString(employeeContainer.getCur());
String delta = Integer.toString(employeeContainer.getDelta());
int	totalSize = EmployeeLocalServiceUtil.getEmployeesCount();
%>

<liferay-ui:search-container 
	total="<%= totalSize %>" 
	searchContainer="<%= employeeContainer %>" 
	delta="2" 
	iteratorURL="<%= portletURL %>"
	deltaConfigurable="false" 
  	emptyResultsMessage="Oops! There Are No Employees To Display, Please add Employee">
  
	 <liferay-ui:search-container-results  results="<%= employeeList  %>" />	
		
		  <liferay-ui:search-container-row className="com.aixtor.training.model.Employee" modelVar="employee" keyProperty="employeeId" >
			  
			  <liferay-portlet:renderURL var="editEmployee">
			  		<portlet:param name="action" value="edit"/>
			  		<portlet:param name="employeeId" value="<%= String.valueOf(employee.getEmployeeId())%>" />
			  		<portlet:param name="redirectURL" value="${currentURL}"/>
			  </liferay-portlet:renderURL>
			  
			  <liferay-portlet:actionURL name="deleteEmployee" var="deleteEmployeeActionURL">
			  		<portlet:param name="employeeId" value="<%= String.valueOf(employee.getEmployeeId())%>" />
			  </liferay-portlet:actionURL>
			  
			   <liferay-ui:search-container-column-text name="Employee Name" property="employeeName"/>
			   <liferay-ui:search-container-column-text name="Mobile Number" property="employeeMobile"/>
			   <liferay-ui:search-container-column-text name="Email" property="employeeEmail"/>
			   <liferay-ui:search-container-column-text name="Branch" property="branchId"/>
			   <liferay-ui:search-container-column-text name="Department" property="departmentId"/>
			   <liferay-ui:search-container-column-text name="Designation" property="designationId"/>
		 	   <liferay-ui:search-container-column-text name="Action">
		 	   		<a  href="${editEmployee}">Edit</a> &nbsp;
		 	   		<a href="${deleteEmployeeActionURL}">Delete</a>
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	  
		  
	 <liferay-ui:search-iterator searchContainer="<%=employeeContainer %>"  markupView="lexicon" />
	 
</liferay-ui:search-container>