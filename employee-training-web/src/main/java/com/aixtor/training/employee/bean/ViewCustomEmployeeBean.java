package com.aixtor.training.employee.bean;

public class ViewCustomEmployeeBean {
	
	private String employeeName;
	private long employeeId;
	private String employeeMobile;
	private String employeeEmail;
	private long branchId;
	private long departmentId;
	private long designationId;
	private String branchName;
	private String departmentName;
	private String designationName;
	

	public ViewCustomEmployeeBean(String employeeName, long employeeId, String employeeMobile, String employeeEmail,
			long branchId, long departmentId, long designationId) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeMobile = employeeMobile;
		this.employeeEmail = employeeEmail;
		this.branchId = branchId;
		this.departmentId = departmentId;
		this.designationId = designationId;
	}

	public ViewCustomEmployeeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ViewCustomEmployeeBean [employeeName=" + employeeName + ", employeeId=" + employeeId
				+ ", employeeMobile=" + employeeMobile + ", employeeEmail=" + employeeEmail + ", branchName="
				+ branchName + ", departmentName=" + departmentName + ", designationName=" + designationName + "]";
	}

	public ViewCustomEmployeeBean(String employeeName, long employeeId, String employeeMobile, String employeeEmail,
			String branchName, String departmentName, String designationName) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeMobile = employeeMobile;
		this.employeeEmail = employeeEmail;
		this.branchName = branchName;
		this.departmentName = departmentName;
		this.designationName = designationName;
	}

	public ViewCustomEmployeeBean(String employeeName, long employeeId, String employeeMobile, String employeeEmail,
			long branchId, long departmentId, long designationId, String branchName, String departmentName,
			String designationName) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeMobile = employeeMobile;
		this.employeeEmail = employeeEmail;
		this.branchId = branchId;
		this.departmentId = departmentId;
		this.designationId = designationId;
		this.branchName = branchName;
		this.departmentName = departmentName;
		this.designationName = designationName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public long getBranchId() {
		return branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

}
