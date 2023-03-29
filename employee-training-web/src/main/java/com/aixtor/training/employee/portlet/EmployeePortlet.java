package com.aixtor.training.employee.portlet;

import com.aixtor.training.employee.bean.ViewCustomEmployeeBean;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.model.Branch;
import com.aixtor.training.model.Department;
import com.aixtor.training.model.Designation;
import com.aixtor.training.model.Employee;
import com.aixtor.training.service.BranchLocalService;
import com.aixtor.training.service.DepartmentLocalService;
import com.aixtor.training.service.DesignationLocalService;
import com.aixtor.training.service.EmployeeLocalService;
import com.aixtor.training.service.EmployeeLocalServiceUtil;
import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.JournalConverter;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.requires-namespaced-parameters=false", 
		"javax.portlet.display-name=Employee Form",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/employeeView.jsp",
		"javax.portlet.name=EmployeePortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		
}, service = Portlet.class)

public class EmployeePortlet extends MVCPortlet {

	private static Log log = LogFactoryUtil.getLog(EmployeePortlet.class);

	@Reference
	private DepartmentLocalService departmentLocalService;

	@Reference
	private DesignationLocalService designationLocalService;

	@Reference
	private BranchLocalService branchLocalService;

	@Reference
	private CounterLocalService count;

	@Reference
	private EmployeeLocalService employeeLocalService;
	
	@Reference
	private DDMStructureLocalService ddmStructureLocalService;
	
	@Reference
	private JournalArticleLocalService journalArticleLocalService;
	
	@Reference
	private JournalConverter journalConverter;
	

	/**
	 * @return Department List, EmployeeList, BranchList, DesignationList on page load
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException, java.io.IOException {

		// 1. Using departmentLocalService get Department List
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
		
		// 2. Using designationLocalService get Designation List
		List<Designation> designationList = designationLocalService.getDesignations(-1, -1);
		
		// 3. Using branchLocalService get Branch List
		List<Branch> branchList = branchLocalService.getBranches(-1, -1);
		
		renderRequest.setAttribute(EmployeeConstants.DEPARTMENT_LIST, departmentList);
		renderRequest.setAttribute(EmployeeConstants.DESIGNATION_LIST, designationList);
		renderRequest.setAttribute(EmployeeConstants.BRANCH_LIST, branchList);
		List<Employee> employeeList = null;
		
		/**
		 * @return EmployeeList based on searching functionality changing the updated employeelist
		 */
		String fromSearch = (String) renderRequest.getAttribute("fromSearch");
		if (Validator.isNotNull(fromSearch)) {
			employeeList = (List<Employee>) renderRequest.getAttribute(EmployeeConstants.EMPLOYEE_LIST);
		}else {
			// 4. Using employeeLocalService get Employee List
			employeeList = employeeLocalService.getEmployees(-1, -1);

		}
		renderRequest.setAttribute("fromSearch", fromSearch);
		renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_LIST, employeeList);
		
	
		super.render(renderRequest, renderResponse);
	}

	/**
	 * @return employee deleted based on employeeId
	 * @param requesting employeeId for deleting employee on the record user selected
	 * @param response deleting employee based on employeeId user selected
	 */
	@ProcessAction(name = "deleteEmployee")
	public void deleteEmployee(ActionRequest request, ActionResponse response) {
		
		// 1. Using GetterUtil to get the employeeId selected by the user
		long employeeId = ParamUtil.getLong(request, EmployeeConstants.EMPLOYEE_ID, GetterUtil.DEFAULT_LONG);
		try {
			// 2. Deleting employee record based on employeeId selected and deleteEmployee method of employeeLocalService
			employeeLocalService.deleteEmployee(employeeId);
			
		} catch (Exception e) {
			log.error("EmployeePortlet >>> Delete Employee Method :: " +e);
		}
	}

	/**
	 * 
	 * @param requesting fromDate and toDate entered by user for searching employee details
	 * @return employeeList based on the searching data provided by the user
	 */
	@ProcessAction(name = "searchEmployee")
	public void searchEmployee(ActionRequest request, ActionResponse response) {
		
		// 1. Getting fromDate selected by the user
		String fromDates = ParamUtil.getString(request, EmployeeConstants.FROM_DATE);
		
		// 2. Getting toDate selected by the user
		String toDates = ParamUtil.getString(request, EmployeeConstants.TO_DATE);
		
		// 3. Getting searchText data selected by the user
		String searchText = ParamUtil.getString(request, EmployeeConstants.SEARCH_TEXT);
		
		/*
		log.info(searchText);
		log.info(fromDates);
		log.info(toDates);
		*/
		
		// 4. Validating if the search is done based on dates :: if yes parsing the dates and performing DynamicQuery
		if(Validator.isNull(searchText)) {
			
			Date fromDate = null;
			try {
				// 5. Parsing the fromDate value
				fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDates);
				
			} catch (ParseException e) {
				log.error("EmployeePortlet >>> Search Employee Method >>> From Date :: " +e);
			}
			Date toDate = null;
			try {
				
				// 6. Parsing the toDate value using Calendar
				toDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDates);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(toDate);
				calendar.set(Calendar.HOUR, 23);
				calendar.set(Calendar.MINUTE, 59);
				calendar.set(Calendar.SECOND, 59);
				toDate = calendar.getTime();
				
			} catch (ParseException e) {
				log.error("EmployeePortlet >>> Search Employee Method >>> To Date :: " +e);
			}
			
			// 7. If toDate is null then set the toDate value to todays date 
			if(toDate == null) {
				Calendar today = Calendar.getInstance();
				today.set(Calendar.HOUR_OF_DAY, 0);
				today.set(Calendar.MINUTE, 0);
				today.set(Calendar.SECOND, 0);
				toDate = today.getTime();
			}
			if(fromDate == null) {
				
			}
			
			// 8. Using DynamicQuery searching the employees data entered that falls between the fromDate and toDate provided by user
			DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("createDate").between(fromDate , toDate));
			
			
			// 9. Returning employeeList based on the query
			List<Employee> employeeList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			// 10. Setting the employeeList in the request 
			request.setAttribute("employeeList", employeeList);
			
			// 11. Setting the fromSearch flag to true 
			request.setAttribute("fromSearch", "Yes");
			
			log.info("Employee Portlet >>> employeeList :: " + employeeList);
		}
		else {
			
			// 1. If searching is done using textbox provided then passing the searchbox data
			// 2. Returning employeeObjectList using getEmployeeByAllEntity made in EmployeeFinderImpl that matches the search
			List<Object[]> searchList = employeeLocalService.getEmployeeByAllEntity(searchText);
			
			// 3. Validating if searchList is empty or not :: If not null then return employeeList
			if(Validator.isNotNull(searchList)) {
				
				// 4. Creating ArrayList of Employee to stored the searchList and retrieve the data element by element
				ArrayList<Employee> searchEmployeeList = new ArrayList<Employee>();
				
				// 5. Traversing to all the records available in the Employee entity
				for (Object[] obj : searchList) {
					
					/*
					 *
					log.info(" Employee Id:-  " + ((BigInteger) obj[0]).longValue());
					log.info(" Employee Name:-  " + String.valueOf(obj[1]));
					log.info(" Employee Mobile:-  " + String.valueOf(obj[2]));
					log.info(" Employee Email:-  " + String.valueOf(obj[3]));
					log.info(" Branch Id:-  " + ((BigInteger) obj[4]).longValue());
					log.info(" Department Id:-  " + ((BigInteger) obj[5]).longValue());
					log.info(" Designation Id:-  " + ((BigInteger) obj[6]).longValue());
					
					*/
					
					// 6. Casting the sql values in java 
					long employeeId = GetterUtil.getLong(obj[0]);
					
					/*
					String employeeName = String.valueOf(obj[1]);
					String employeeMobile = String.valueOf(obj[2]);
					String employeeEmail = String.valueOf(obj[3]);
					
					long branchId = GetterUtil.getLong(obj[4]);
					long departmentId = GetterUtil.getLong(obj[5]);
					long designationId = GetterUtil.getLong(obj[6]);
					*/
					
					try {
						
						//7. Setting the values of the list that matches the search
						Employee employee = employeeLocalService.getEmployee(employeeId);
			
						//ViewCustomEmployeeBean viewCustomEmployeeBean = new ViewCustomEmployeeBean();
						
						//8. Adding the employee object in the ArrayList
						searchEmployeeList.add(employee);
						
						log.info("Employee Portlet >>> searchByNameList :: " + searchEmployeeList);
					
					} catch (PortalException e) {
						log.error("Employee Portlet >>> Error in searchByNameList :: " + e);
					}	
				}
				// 9. Setting the employeeList in the request 
				request.setAttribute("employeeList", searchEmployeeList);
				
				// 10. Setting the fromSearch flag to true 
				request.setAttribute("fromSearch", "yes");
			}
		}
	
		
		// 11. Copying the request parameters for sending the current request in the renderRequest
		PortalUtil.copyRequestParameters(request, response);
	}

	
	
}
