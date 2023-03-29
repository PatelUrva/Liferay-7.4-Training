<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.aixtor.training.service.DepartmentLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.DepartmentLocalService"%>
<%@page import="com.aixtor.training.model.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="init.jsp"%>
<portlet:defineObjects />

<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<style>
#validateDepartmentForm label.error {
	margin-left: 10px;
	width: auto;
	color: red;
}
</style>

<portlet:actionURL name="addEditDepartment" var="addEditDepartmentURL" >
	<portlet:param name="redirectURL" value="${redirectURL}"/>
</portlet:actionURL>

<h3>Add/Update Department</h3>

<form action="${addEditDepartmentURL}" id="validateDepartmentForm" name="addEditDepartmentForm" method="POST">
	
	<input name="departmentId" type="hidden" value="${selectedDepartment.departmentId}"/>
	
	<div class="form-row">
		<div class="form-group col-md-6">
			<label>Department Name</label>
			<input type="text" class="form-control" name="departmentName"  value="${selectedDepartment.departmentName}" />
		</div>
		<div class="form-group col-md-6">
			<label>Department Head</label>
			<input type="text" class="form-control" name="departmentHead"  value="${selectedDepartment.departmentHead}" />
		</div>
	</div>
	
	<button class="btn btn-primary col-md-2" type="submit" > Submit </button>
</form>

<script>
$(document).ready(function () {
	$('#validateDepartmentForm').validate({
		rules : {
			departmentName : 'required',
			departmentHead : 'required',
		},
		messages : {
			departmentName : 'Department Name is required',
			departmentHead : 'Department Head Name is required',
		}
	});
	
});
</script>