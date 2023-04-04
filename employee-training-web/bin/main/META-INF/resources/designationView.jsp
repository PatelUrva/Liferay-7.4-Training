<%@ include file="init.jsp" %>

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
	        <i class="fa-solid fa-plus"></i> Add Designation
	    </a>
	</button>
    <button type = "button" class = "btn btn-default">
    	<a href="${desigantionPDFResourceURL}" class="btn  btn-primary btn-default">
	        <i class="fa-solid fa-download"></i> Download Designation PDF 
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
	deltaConfigurable="true" 
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
		 	   		<a  href="${editDesignation}">
		 	   			<i class="fa-solid fa-pen-to-square"></i>
		 	   		</a> &nbsp;
		 	   		<a href="${deleteDesignationActionURL}">
		 	   			<i class="fa-solid fa-trash"></i>
		 	   		</a>
		 	   		
		 	   </liferay-ui:search-container-column-text>
		 	   
		 </liferay-ui:search-container-row>	   
	 
	 	<liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>