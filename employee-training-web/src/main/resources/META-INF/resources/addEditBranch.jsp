<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.aixtor.training.service.BranchLocalServiceUtil"%>
<%@page import="com.aixtor.training.service.BranchLocalService"%>
<%@page import="com.aixtor.training.model.Branch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ include file="init.jsp"%>
<portlet:defineObjects />

<style>
#validateBranchForm label.error {
	margin-left: 10px;
	width: auto;
	color: red;
}
</style>

<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>


<portlet:actionURL name="addEditBranch" var="addEditBranchURL" >
	<portlet:param name="redirectURL" value="${redirectURL}"/>
</portlet:actionURL>


<portlet:resourceURL id="/get/country-states" var="getStateCountryURL" />
<portlet:resourceURL id="/get/states-city" var="getCityStateURL" />

<h3>Add/Update Branch</h3>

<form action="${addEditBranchURL}" name="addEditBranchForm" id="validateBranchForm" method="POST">
	
	<input name="branchId" type="hidden" value="${selectedBranch.branchId}"/>
	
	<div class="form-group">
		<label>Branch Name</label>
		<input type="text" class="form-control" name="branchName"  value="${selectedBranch.branchName}" />
		
	</div>
	
	<!--<c:set var="isReadOnly" value="${isEdit ? 'readonly' : ''}" /> -->
	
	<div class="form-row">
		<div class="form-group col-md-4">
			<label>Country</label>
			 <select class="form-control" id="country" name="country">
				<option value="${selectedBranch.getCountryId()}"> ${selectedBranch.getCountryId()} </option>
				<c:forEach items="${countryList}" var="country">
					<option value="${country.getCountryId()}"> ${country.getName() } </option>
				</c:forEach>
			</select>
		</div>
		
		<div class="form-group col-md-4">
			<label>State</label>
			<select class="form-control" name="stateId" id="stateId">
				<option value="${selectedBranch.getStateId()}"> ${selectedBranch.getStateId()} </option>
				
			</select>
		</div>
		
		<div class="form-group col-md-4">
			<label>City</label>
			<select class="form-control" name="cityId" id="cityId">
				<option value="${selectedBranch.getCityId()}"> ${selectedBranch.getCityId()} </option>
				
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label>Enter Address1</label>
		<input type="text" class="form-control" name="address1"  value="${selectedBranch.address1}" />
	</div>
	
	<div class="form-group">
		<label>Enter Address2</label>
		<input type="text" class="form-control" name="address2" value="${selectedBranch.address2}" />
	</div>
	
	<div class="form-group">
		<label>Enter Pincode</label>
		<input type="number" class="form-control" name="pincode" value="${selectedBranch.pincode}" />
	</div>
	
	<button class="btn btn-primary col-md-2" type="submit" > Submit </button>
</form>


<script>
$(document).ready(function () {
	
	$('#country').on('change', function(){
		var countryId = $(this).val();
		$.ajax({
			  type: "POST",
			  url: '${getStateCountryURL}',
			  data: {
				 'countryId' : countryId 
			  },
			  dataType: 'json',
			  success: function(response){
				  if(response.status == 'success' && response.data){
					  var states = JSON.parse(response.data);
					  $('#stateId').empty();
					  for(var i=0; i<states.length; i++){
						  $('#stateId').append($("<option value='"+ states[i].stateId  +"'></option>")
				                    .text(states[i].stateName));
					  }
				  }
			  }
		});
	});
	
	$('#stateId').on('change', function(){
		var stateId = $(this).val();
		$.ajax({
			  type: "POST",
			  url: '${getCityStateURL}',
			  data: {
				 'stateId' : stateId 
			  },
			  dataType: 'json',
			  success: function(response){
				  if(response.status == 'success' && response.data){
					  var city = JSON.parse(response.data);
					  $('#cityId').empty();
					  for(var i=0; i<city.length; i++){
						  $('#cityId').append($("<option value='"+ city[i].cityId  +"'></option>")
				                    .text(city[i].cityName));
						  
					  }
				  }
			  }
		});
	});
	
	$('#validateBranchForm').validate({
		rules : {
			branchName : 'required',
			country : 'required',
			stateId : 'required',
			cityId : 'required',
			address1 : 'required',
			address2 : 'required',
			pincode : {
				required : true,
				maxlength : 6,
			},
		},
		messages : {
			branchName : 'Branch Name is required',
			country : 'Country is required',
			stateId : 'State is required',
			cityId : 'City is required',
			address1 : 'Address1 is required',
			address2 : 'Address2 is required',
			pincode : {
				required : 'Pincode is required',
				maxlength : 'Pincode should be of 6 digits'
			}
		}
	});
	
});
</script>