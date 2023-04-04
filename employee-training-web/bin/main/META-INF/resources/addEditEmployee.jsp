<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="init.jsp"%>

<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<style>
#employeeValidateForm label.error {
	margin-left: 10px;
	width: auto;
	color: red;
}
</style>

<portlet:actionURL name="addEditEmployee" var="addEditEmployeeURL" >
	<portlet:param name="redirectURL" value="${redirectURL}"/>
</portlet:actionURL>

<h3>Add/Update Employee</h3>

<form action="${addEditEmployeeURL}" id="employeeValidateForm" name="addEditEmployeeForm" method="POST">
	
	<input name="employeeId" type="hidden" value="${selectedEmployee.employeeId}"/>
	
	<div class="form-group">
		<label>Employee Name</label>
		<input type="text" class="form-control" name="employeeName"  value="${selectedEmployee.employeeName}" />
	</div>
	
	
	<div class="form-row">
		<div class="form-group col-md-6">
			 <label>Mobile Number</label>
			 <input type="number" class="form-control" name="employeeMobile"  value="${selectedEmployee.employeeMobile}" />
		</div>
		
		<div class="form-group col-md-6">
			 <label>Email</label>
			 <input type="email" class="form-control" name="employeeEmail"  value="${selectedEmployee.employeeEmail}" />
		</div>
	</div>
	
	<div class="form-row">
		<div class="form-group col-md-4">
			 <label>Branch</label>
			 <select class="form-control" name="branchId">
				<c:forEach items="${branchList}" var="branch">
					<option value="${branch.getBranchId()}" ${ branch.getBranchId() == selectedEmployee.getBranchId() ? 'selected' : '' }> ${branch.getBranchName() } </option>
				</c:forEach>
			</select>
		</div>
		
		<div class="form-group col-md-4">
			<label>Department</label>
			<select class="form-control" name="departmentId">
				<c:forEach items="${departmentList}" var="department">
					<option value="${department.getDepartmentId()}" ${department.getDepartmentId() == selectedEmployee.getDepartmentId() ? 'selected' : '' }> ${department.getDepartmentName()} </option>
				</c:forEach>
			</select>
		</div>
		
		<div class="form-group col-md-4">
			<label>Designation</label>
			<select class="form-control" name="designationId">
				<c:forEach items="${designationList}" var="designation">
					<option value="${designation.getDesignationId()}" ${designation.getDesignationId() == selectedEmployee.getDesignationId() ? 'selected' : '' }> ${designation.getDesignationName()} </option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<button class="btn btn-primary col-md-2" type="submit" > <i class="fa-solid fa-floppy-disk"></i> Submit </button>
	<button class="btn btn-primary col-md-2" id="backBtn" type="button" > <i class="fa-solid fa-square-left"></i> Back </button>
	
</form>


<script>
$(document).ready(function () {
	document.getElementById("backBtn").onclick = function(){
		location.href = "http://localhost:8080/web/manali/employee";
	};
	
	$('#employeeValidateForm').validate({
		rules : {
			employeeName : 'required',
			employeeMobile : {
				required : true,
				digits : true,
				maxlength : 10,
				minlength : 10
			},
			employeeEmail : {
				required : true,
				email : true
			},
			branchId : 'required',
			departmentId : 'required',
			designationId : 'required',
		},
		messages : {
			employeeName : 'Employee Name is required',
			employeeMobile : {
				required : 'Mobile Number is required',
				digits : 'Mobile Number should have only digits',
				maxlength : 'Mobile Number should be 10 digits',
				minlength : 'Mobile Number should be 10 digits'
			},
			employeeEmail : {
				required : 'Email is required',
				email : 'Invalid Email'
			},
			branchId : 'Branch is required',
			departmentId : 'Department is required',
			designationId : 'Designation is required',
		}
	});
	
});
</script>