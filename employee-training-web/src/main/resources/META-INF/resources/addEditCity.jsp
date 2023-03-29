<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.aixtor.training.service.CityLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.CityLocalService"%>
<%@page import="com.aixtor.training.model.City"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="init.jsp"%>
<portlet:defineObjects />

<portlet:actionURL name="addEditCity" var="addEditCityURL" >
	<portlet:param name="redirectURL" value="${redirectURL}"/>
</portlet:actionURL>

<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<style>
#validateCityForm label.error {
	margin-left: 10px;
	width: auto;
	color: red;
}
</style>

<h3>Add/Update City</h3>

<form action="${addEditCityURL}" id="validateCityForm" name="addEditCityForm" method="POST">
	
	<input name="cityId" type="hidden" value="${selectedCity.cityId}"/>
	
	<div class="form-row">
		<div class="form-group col-md-6">
			<label>City Name</label>
			<input type="text" class="form-control" name="cityName"  value="${selectedCity.cityName}" />
		</div>
		<div class="form-group col-md-6">
			<label>State</label>
			 <select class="form-control" name="stateId">
				<option value="${selectedCity.getStateId()}"> ${selectedCity.getStateId()} </option>
				<c:forEach items="${stateList}" var="state">
					<option value="${state.getStateId()}"> ${state.getStateName() } </option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<button class="btn btn-primary col-md-2" type="submit" > Submit </button>
</form>

<script>
$(document).ready(function () {
	$('#validateCityForm').validate({
		rules : {
			cityName : 'required',
			stateId : 'required',
		},
		messages : {
			cityName : 'City Name is required',
			stateId : 'State is required',
		}
	});
	
});
</script>