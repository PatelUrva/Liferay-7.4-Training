<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.aixtor.training.service.DesignationLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.DesignationLocalService"%>
<%@page import="com.aixtor.training.model.Designation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="init.jsp"%>
<portlet:defineObjects />

<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<style>
#validateDesignationForm label.error {
	margin-left: 10px;
	width: auto;
	color: red;
}
</style>

<portlet:actionURL name="addEditDesignation" var="addEditDesignationURL" >
	<portlet:param name="redirectURL" value="${redirectURL}"/>
</portlet:actionURL>

<h3>Add/Update Branch</h3>

<form action="${addEditDesignationURL}" id="validateDesignationForm" name="addEditDesignationForm" method="POST">
	
	<input name="designationId" type="hidden" value="${selectedDesignation.designationId}"/>
	
	<div class="form-group">
		<label>Designation Name</label>
		<input type="text" class="form-control" name="designationName"  value="${selectedDesignation.designationName}" />
	</div>
	
	
	<button class="btn btn-primary col-md-2" type="submit" > Submit </button>
</form>

<script>
$(document).ready(function () {
	$('#validateDesignationForm').validate({
		rules : {
			designationName : 'required',
		},
		messages : {
			designationName : 'Designation Name is required',
		}
	});
	
});
</script>