<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.aixtor.training.service.StateLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.StateLocalService"%>
<%@page import="com.aixtor.training.model.State"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="init.jsp"%>
<portlet:defineObjects />

<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<style>
#validateStateForm label.error {
	margin-left: 10px;
	width: auto;
	color: red;
}
</style>

<portlet:actionURL name="addEditState" var="addEditStateURL" >
	<portlet:param name="redirectURL" value="${redirectURL}"/>
</portlet:actionURL>

<h3>Add/Update State</h3>

<form action="${addEditStateURL}" id="validateStateForm" name="addEditStateForm" method="POST">
	
	<input name="stateId" type="hidden" value="${selectedState.stateId}"/>
	
	<div class="form-row">
		<div class="form-group col-md-6">
			<label>State Name</label>
			<input type="text" class="form-control" name="stateName"  value="${selectedState.stateName}" />
		</div>
		<div class="form-group col-md-6">
			<label>Country</label>
			 <select class="form-control" name="countryId">
				<option value="${selectedState.getCountryId()}"> ${selectedState.getCountryId()} </option>
				<c:forEach items="${countryList}" var="country">
					<option value="${country.getCountryId()}"> ${country.getName() } </option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<button class="btn btn-primary col-md-2" type="submit" > Submit </button>
</form>

<script>
$(document).ready(function () {
	$('#validateStateForm').validate({
		rules : {
			stateName : 'required',
			countryId : 'required',
		},
		messages : {
			stateName : 'State Name is required',
			countryId : 'Country is required',
		}
	});
	
});
</script>