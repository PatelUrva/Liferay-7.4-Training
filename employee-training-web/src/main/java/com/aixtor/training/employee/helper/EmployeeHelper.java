package com.aixtor.training.employee.helper;


/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.api.EmployeeApi;
import com.aixtor.training.employee.bean.ViewCustomEmployeeBean;
import com.aixtor.training.model.Branch;
import com.aixtor.training.model.Department;
import com.aixtor.training.model.Designation;
import com.aixtor.training.model.Employee;
import com.aixtor.training.service.BranchLocalService;
import com.aixtor.training.service.DepartmentLocalService;
import com.aixtor.training.service.DesignationLocalService;
import com.aixtor.training.service.EmployeeLocalService;
import com.aixtor.training.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeHelper {
	
	private static EmployeeApi _employeeAPI;
	private static BranchLocalService _branchLocalService;
	private static EmployeeLocalService _employeeLocalService;
	private static DepartmentLocalService _departmentLocalService;
	private static DesignationLocalService _designationLocalService;
	
	public EmployeeHelper(EmployeeApi employeeAPI, EmployeeLocalService employeeLocalService, 
				BranchLocalService branchBranchLocalService, DepartmentLocalService departmentLocalService,
				DesignationLocalService designationLocalService) {
		_employeeAPI = employeeAPI;
		_employeeLocalService = employeeLocalService;
		_branchLocalService = branchBranchLocalService;
		_departmentLocalService = departmentLocalService;
		_designationLocalService = designationLocalService;
	}
	
	public ArrayList<ViewCustomEmployeeBean> searchTextEmployeeList(String searchText, ArrayList<ViewCustomEmployeeBean> searchEmployeeList) {
		
		List<Object[]> searchList = _employeeLocalService.getEmployeesByAllEntity(searchText);
		System.out.println("EmployeeHelper >>> " + searchList);
		
		// 3. Validating if searchList is empty or not :: If not null then return employeeList
		if (Validator.isNotNull(searchList)) {

			// 4. Traversing to all the records available in the Employee entity
			for (Object[] obj : searchList) {
				
				// 5. Getting values from database and casting them
				long employeeId = GetterUtil.getLong(obj[0]);
				String employeeName = String.valueOf(obj[1]);
				String employeeMobile = String.valueOf(obj[2]);
				String employeeEmail = String.valueOf(obj[3]);
				String branchName = String.valueOf(obj[4]);
				String departmentName = String.valueOf(obj[5]);
				String designationName = String.valueOf(obj[6]);
				long branchId = 0;
				long departmentId = 0;
				long designationId = 0;
				
				
				// 6. Calling setCustomBean function for setting values in ViewEmployeeCustomBean
				ViewCustomEmployeeBean viewCustomEmployeeBean = _employeeAPI.setNewCustomBean(employeeId, employeeName, employeeMobile, employeeEmail, branchName,
						departmentName, designationName, branchId, departmentId, designationId);
						
				// 7. Adding the customBean object in the ArrayList
				searchEmployeeList.add(viewCustomEmployeeBean);
			}
		}
		return searchEmployeeList;
	}


	public ArrayList<ViewCustomEmployeeBean> dateSearchEmployeeList(Date fromDate, Date toDate,
			ArrayList<ViewCustomEmployeeBean> searchEmployeeList) throws PortalException {
		
		DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("createDate").between(fromDate, toDate));

		// 6. Returning employeeList based on the query
		List<Employee> employeeList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);

		// 7. Traversing to all the records available in the Employee entity
		for (Employee employee : employeeList) {

			// 8. Getting values from database
			long employeeId = employee.getEmployeeId();

			if (employeeId > 0) {
				Employee getEmployee = _employeeLocalService.getEmployee(employeeId);
				
				String employeeName = getEmployee.getEmployeeName();
				String employeeMobile = getEmployee.getEmployeeMobile();
				String employeeEmail = getEmployee.getEmployeeEmail();
				long branchId = getEmployee.getBranchId();
				long departmentId = getEmployee.getDepartmentId();
				long designationId = getEmployee.getDesignationId();
				Branch branch = _branchLocalService.fetchBranch(branchId);
				Department department = _departmentLocalService.fetchDepartment(departmentId);
				Designation designation = _designationLocalService.fetchDesignation(designationId);
				String branchName = branch.getBranchName();
				String departmentName = department.getDepartmentName() ;
				String designationName = designation.getDesignationName();
				
				// 9. Calling setCustomBean function for setting values in ViewEmployeeCustomBean
				ViewCustomEmployeeBean viewCustomEmployeeBean = _employeeAPI.setNewCustomBean(employeeId, employeeName, employeeMobile, employeeEmail, branchName,
						departmentName, designationName, branchId, departmentId, designationId);
				
				searchEmployeeList.add(viewCustomEmployeeBean);
			}
		}
		return searchEmployeeList;
	}
}
