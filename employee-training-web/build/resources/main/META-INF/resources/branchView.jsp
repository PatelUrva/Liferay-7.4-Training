<%@page import="com.aixtor.training.employee.bean.ViewCustomBranchBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.aixtor.training.employee.constants.EmployeeConstants"%>
<%@ include file="init.jsp" %>

<%
	String currentURL=PortalUtil.getCurrentURL(renderRequest);
%>

<portlet:renderURL var="addBranchRenderURL">
    <portlet:param name="action" value="add"/>
    <portlet:param name="redirectURL" value="${currentURL}"/>
</portlet:renderURL>

<portlet:resourceURL id="/download/branchPDF" var="branchPDFResourceURL" />

<liferay-portlet:actionURL name="sendMail" var="sendMailActionURL" />

<div class = "btn-group">
	<button type = "button" class = "btn btn-default">
		<a href="${addBranchRenderURL}" class="btn  btn-primary btn-default">
	        <i class="fa-solid fa-plus"></i> Add Branch 
	    </a>
	</button>
    <button type = "button" id="GetFile" class = "btn btn-default">
    	<a href="${branchPDFResourceURL}" class="btn  btn-primary btn-default">
	        <i class="fa-solid fa-download"></i> Download Branch PDF 
	    </a>
    </button>
    
    <form action="${sendMailActionURL}" method="post">
    	<div style="margin-left:50px;padding-top:10px">
	   		<input type="email" name="emailId" required /> 
	    	<button style="padding-top:5px" type="submit" class="btn btn-primary btn-default">
	    		<i class="fa-solid fa-paper-plane-top"></i> Send Email
	    	</button>
	    </div>
    </form>
    
</div>


<%
 List<ViewCustomBranchBean> branchList = (List<ViewCustomBranchBean>) renderRequest.getAttribute(EmployeeConstants.BRANCH_LIST);
%>

<liferay-ui:search-container 
	total="${branchList.size()}" 
	var="searchContainer" 
	delta="2" 
	deltaConfigurable="true" 
  	emptyResultsMessage="Oops. There Are No Branches To Display, Please add Branch">
  
	 <liferay-ui:search-container-results 
	 	results="<%= ListUtil.subList(branchList, searchContainer.getStart(),searchContainer.getEnd())%>" />	
		  <liferay-ui:search-container-row className="com.aixtor.training.employee.bean.ViewCustomBranchBean" modelVar="branch" keyProperty="branchId" >
			  
			  <liferay-portlet:renderURL var="editBranch">
			  		<portlet:param name="action" value="edit"/>
			  		<portlet:param name="branchId" value="<%= String.valueOf(branch.getBranchId())%>" />
			  		<portlet:param name="redirectURL" value="${currentURL}"/>
			  </liferay-portlet:renderURL>
			  
			  
			  <liferay-portlet:actionURL name="deleteBranch" var="deleteBranchActionURL">
			  		<portlet:param name="branchId" value="<%= String.valueOf(branch.getBranchId())%>" />
			  </liferay-portlet:actionURL>
			  
			   <liferay-ui:search-container-column-text name="Branch Name" property="branchName"/>
			   <liferay-ui:search-container-column-text name="Country" property="country"/>
			   <liferay-ui:search-container-column-text name="State" property="state"/>
			   <liferay-ui:search-container-column-text name="City" property="city"/>
			   <liferay-ui:search-container-column-text name="Address1" property="address1"/>
			   <liferay-ui:search-container-column-text name="Address2" property="address2"/>
			   <liferay-ui:search-container-column-text name="Pincode" property="pincode"/>
		 	   <liferay-ui:search-container-column-text name="Action">
		 	   		<a  href="${editBranch}">
		 	   			<i class="fa-solid fa-pen-to-square"></i>
		 	   		</a> &nbsp;
		 	   		<a href="${deleteBranchActionURL}">
		 	   			<i class="fa-solid fa-trash"></i>
		 	   		</a>
		 	   		
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	   
	 
	 	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>
 
