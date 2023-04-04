package com.aixtor.training.employee.EmployeeHelper;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.bean.ViewCustomEmployeeBean;

public class EmployeeHelper {
	
	/**
	 * @author Urva Patel
	 * @param employeeId
	 * @param employeeName
	 * @param employeeMobile
	 * @param employeeEmail
	 * @param branchId
	 * @param departmentId
	 * @param designationId
	 * @return viewCustomEmployeeBean
	 */
	public ViewCustomEmployeeBean setCustomBean(long employeeId, String employeeName, String employeeMobile, 
				String employeeEmail, long branchId, long departmentId, long designationId){
		
		// 1. Initalizing customBean
		ViewCustomEmployeeBean viewCustomEmployeeBean = new ViewCustomEmployeeBean();
		
		// 2. Setting SQL values to custommBean
		viewCustomEmployeeBean.setEmployeeId(employeeId);
		viewCustomEmployeeBean.setEmployeeName(employeeName);
		viewCustomEmployeeBean.setEmployeeMobile(employeeMobile);
		viewCustomEmployeeBean.setEmployeeEmail(employeeEmail);
		viewCustomEmployeeBean.setBranchId(branchId);
		viewCustomEmployeeBean.setDepartmentId(departmentId);
		viewCustomEmployeeBean.setDesignationId(designationId);
		
		// 3. Return viewCustomEmployeeBean object
		return viewCustomEmployeeBean;
	}

}
