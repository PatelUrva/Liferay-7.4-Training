<%@page import="com.aixtor.training.service.BranchLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.aixtor.training.model.Branch"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
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
	        <i class="glyphicon glyphicon-plus"> Add Branch </i>
	    </a>
	</button>
    <button type = "button" id="GetFile" class = "btn btn-default">
    	<a href="${branchPDFResourceURL}" class="btn  btn-primary btn-default">
	        <i class="glyphicon glyphicon-plus"> Download Branch PDF </i>
	    </a>
    </button>
    
    <form action="${sendMailActionURL}" method="post">
    	<div style="margin-left:50px;padding-top:10px">
	   		<input type="email" name="emailId" /> 
	    	<button style="padding-top:5px" type="submit" class="btn btn-primary btn-default">
	    		Send Email
	    	</button>
	    </div>
    </form>
    
</div>


<%
 List<Branch> branchList = BranchLocalServiceUtil.getBranches(-1,-1);
 System.out.println(branchList.size());
%>

<liferay-ui:search-container 
	total="${branchList.size()}" 
	var="searchContainer" 
	delta="2" 
	deltaConfigurable="false" 
  	emptyResultsMessage="Oops. There Are No Branches To Display, Please add Branch">
  
	 <liferay-ui:search-container-results 
	 	results="<%= ListUtil.subList(branchList, searchContainer.getStart(),searchContainer.getEnd())%>" />	
		  <liferay-ui:search-container-row className="com.aixtor.training.model.Branch" modelVar="branch" keyProperty="branchId" >
			  
			  <liferay-portlet:renderURL var="editBranch">
			  		<portlet:param name="action" value="edit"/>
			  		<portlet:param name="branchId" value="<%= String.valueOf(branch.getBranchId())%>" />
			  		<portlet:param name="redirectURL" value="${currentURL}"/>
			  </liferay-portlet:renderURL>
			  
			  
			  <liferay-portlet:actionURL name="deleteBranch" var="deleteBranchActionURL">
			  		<portlet:param name="branchId" value="<%= String.valueOf(branch.getBranchId())%>" />
			  </liferay-portlet:actionURL>
			  
			   <liferay-ui:search-container-column-text name="Branch Name" property="branchName"/>
			   <liferay-ui:search-container-column-text name="Country" property="countryId"/>
			   <liferay-ui:search-container-column-text name="State" property="stateId"/>
			   <liferay-ui:search-container-column-text name="City" property="cityId"/>
			   <liferay-ui:search-container-column-text name="Address1" property="address1"/>
			   <liferay-ui:search-container-column-text name="Address2" property="address2"/>
			   <liferay-ui:search-container-column-text name="Pincode" property="pincode"/>
		 	   <liferay-ui:search-container-column-text name="Action">
		 	   		<a  href="${editBranch}">Edit</a> &nbsp;
		 	   		<a href="${deleteBranchActionURL}">Delete</a>
		 	   		
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	   
	 
	 	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>
 

<script>
$('#GetFile').on('click', function () {
    $.ajax({
        url: '${branchPDFResourceURL}',
        method: 'GET',
        xhrFields: {
            responseType: 'blob'
        },
        success: function (data) {
            var a = document.createElement('a');
            var url = window.URL.createObjectURL(data);
            a.href = url;
            a.download = 'BranchReport.pdf';
            document.body.append(a);
            a.click();
            a.remove();
            window.URL.revokeObjectURL(url);
        }
    });
});
</script>
