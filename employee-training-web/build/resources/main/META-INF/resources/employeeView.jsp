<%@ include file="init.jsp" %>
<script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>

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
	        <i class="fa-solid fa-plus"></i> Add Employee 
	    </a>
	</button>
    <button type = "button" class="btn btn-default">
    	<a href="${employeePDFResourceURL}" class="btn btn-primary btn-default">
	        <i class="fa-solid fa-download"></i> Download PDF 
	    </a>
    </button>
    <button type = "button" class="btn btn-default">
    	<a href="${employeeXLSXResourceURL}" class="btn btn-primary btn-default">
	        <i class="fa-solid fa-download"></i> Download XLSX 
	    </a>
    </button>
    <form action="${searchEmployeeActionURL}" method="post">
    	<div style="margin-left:50px;padding-top:10px">
	    	<input type="date" name="fromDate" />
	    	<input type="date" name="toDate" />
	   		<input type="text" name="searchText" /> 
	    	<button style="padding-top:5px" type="submit" class="btn btn-primary btn-default">
	    		<i class="fa-solid fa-magnifying-glass"></i> Search
	    	</button>
	    </div>
    </form>
    
</div>


<liferay-ui:search-container 
	total="${totalSize}" 
	searchContainer="${employeeContainer}" 
	delta="${delta}" 
	iteratorURL="${portletURL}"
	deltaConfigurable="true" 
  	emptyResultsMessage="Oops! There Are No Employees To Display, Please add Employee">
  
	 <liferay-ui:search-container-results  results="${employeeList}" />	
		
		  <liferay-ui:search-container-row className="com.aixtor.training.employee.bean.ViewCustomEmployeeBean" modelVar="employee" keyProperty="employeeId" >
			  
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
			   <liferay-ui:search-container-column-text name="Branch" property="branchName"/>
			   <liferay-ui:search-container-column-text name="Department" property="departmentName"/>
			   <liferay-ui:search-container-column-text name="Designation" property="designationName"/>
		 	   <liferay-ui:search-container-column-text name="Action">
		 	   		<a  href="${editEmployee}">
		 	   			<i class="fa-solid fa-pen-to-square"></i> 
		 	   		</a> &nbsp;
		 	   		<a href="${deleteEmployeeActionURL}">
		 	   			<i class="fa-solid fa-trash"></i>
		 	   		</a>
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	  
		  
	 <liferay-ui:search-iterator searchContainer="${employeeContainer}" />
	 
</liferay-ui:search-container>