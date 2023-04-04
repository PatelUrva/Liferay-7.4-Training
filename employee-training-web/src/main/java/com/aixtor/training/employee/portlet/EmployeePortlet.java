package com.aixtor.training.employee.portlet;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.bean.ViewCustomEmployeeBean;
import com.aixtor.training.employee.common.CommonEmployeeMethods;
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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
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
import javax.portlet.PortletURL;
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
	private CounterLocalService count;
	
	@Reference
	BranchLocalService branchLocalService;
	
	@Reference
	DepartmentLocalService departmentLocalService;
	
	@Reference
	DesignationLocalService designationLocalService;

	@Reference
	private EmployeeLocalService employeeLocalService;
	

	/**
	 * @return EmployeeList based on searching functionality changing the updated employeelist
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException, java.io.IOException {

		List<Object[]> employeeLists = null;
		
		// 1. Requsting fromSearch value from searchAction
		String fromSearch = (String) renderRequest.getAttribute(EmployeeConstants.FROM_SEARCH);
		
		String cur = null;
		PortletURL portletSearchURL = null;
		List<ViewCustomEmployeeBean> employeeSearchList = null;
		int totalSize = 0, delta = 2;
		PortletURL portletURL = renderResponse.createRenderURL();
		
		// 2. Setting searchContainer values 
		SearchContainer<ViewCustomEmployeeBean> employeeContainer = new SearchContainer<ViewCustomEmployeeBean>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 4, portletURL, null, null);
		
		// 3. Validating if search list to be passed 
		if (Validator.isNotNull(fromSearch)) {
			
			// 4. Setting portletURL value to fromSearch
			portletURL.setParameter(EmployeeConstants.PORTLET_SEARCH_URL, fromSearch);
			
			// 5. Rendering new searchEmployeeList
			employeeSearchList = (List<ViewCustomEmployeeBean>) renderRequest.getAttribute(EmployeeConstants.EMPLOYEE_LIST);
			
			// 6. Setting value of employeeSearchList
			employeeSearchList = ListUtil.subList(employeeSearchList, employeeContainer.getStart(), employeeContainer.getEnd());
			
			// 7. Setting value of searchContainer attributes
			delta = employeeContainer.getDelta();
			totalSize = employeeSearchList.size();
			
			renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_LIST, employeeSearchList);
			
		}else {
			
			// 1. If validation is null then using employeeLocalService get Employee List
			employeeLists = employeeLocalService.getAllEmployees();
					
			// 2. Creating ArrayList of customEmployeeBean to stored the searchList and retrieve the data element by element
			ArrayList<ViewCustomEmployeeBean> employeeList = new ArrayList<ViewCustomEmployeeBean>();
			
			// 3. Traversing to all the records available in the Employee entity
			for (Object[] obj : employeeLists) {
				
				// 4. Getting values from object
				long employeeId = GetterUtil.getLong(obj[0]);
				String employeeName = String.valueOf(obj[1]);
				String employeeMobile = String.valueOf(obj[2]);
				String employeeEmail = String.valueOf(obj[3]);
				String branchName = String.valueOf(obj[4]);
				String departmentName = String.valueOf(obj[5]);
				String designationName = String.valueOf(obj[6]);
				
				// 5. Calling setCustomBean method for setting values in ViewEmployeeCustomBean
				ViewCustomEmployeeBean viewCustomEmployeeBean = CommonEmployeeMethods.setNewCustomBean(employeeId, 
						employeeName, employeeMobile, employeeEmail, branchName, departmentName, designationName);
						
				// 6. Adding the customBean object in the ArrayList
				employeeList.add(viewCustomEmployeeBean);
				
				renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_LIST, employeeList);
			}
			
			// 8. Setting value of searchContainer attributes
			delta = employeeContainer.getDelta();
			totalSize = employeeList.size();
		}
		
		// 1. Setting searchContainer attribute values in render request
		renderRequest.setAttribute(EmployeeConstants.FROM_SEARCH, fromSearch);
		renderRequest.setAttribute(EmployeeConstants.DELTA, delta);
		renderRequest.setAttribute(EmployeeConstants.PORTLET_SEARCH_URL, portletSearchURL);
		renderRequest.setAttribute(EmployeeConstants.TOTAL_SIZE, totalSize);
		
		// 2. Setting searchContainer in render request
		renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_CONTAINER, employeeContainer);
		
		
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
			log.error("EmployeePortlet >>> deleteEmployee() :: " +e);
		}
	}

	
	/**
	 * 
	 * @param requesting fromDate and toDate entered by user for searching employee details
	 * @return employeeList based on the searching data provided by the user
	 * @throws ParseException 
	 */
	@ProcessAction(name = "searchEmployee")
	public void searchEmployee(ActionRequest request, ActionResponse response) throws PortalException, ParseException {
		
		// 1. Getting fromDate selected by the user
		String fromDates = ParamUtil.getString(request, EmployeeConstants.FROM_DATE);
		
		// 2. Getting toDate selected by the user
		String toDates = ParamUtil.getString(request, EmployeeConstants.TO_DATE);
		
		// 3. Getting searchText data selected by the user
		String searchText = ParamUtil.getString(request, EmployeeConstants.SEARCH_TEXT);
		
		// 4. Validating if the search is done based on dates :: if yes parsing the dates and performing DynamicQuery
		if(Validator.isNull(searchText)) {
			
			Date fromDate = null;
			try {
				// 5. Parsing the fromDate value
				fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDates);
				
			} catch (ParseException e) {
				log.error("EmployeePortlet >>> searchEmployee() >>> From Date :: " +e);
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
				log.error("EmployeePortlet >>>searchEmployee() >>> To Date :: " +e);
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
				 String newDate = "1990-01-01";
				 fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(newDate);
			}
			log.info("From Date :: " +fromDate);
			log.info("To Date :: " +toDate);
			
			// 8. Using DynamicQuery searching the employees data entered that falls between the fromDate and toDate provided by user
			DynamicQuery dynamicQuery = EmployeeLocalServiceUtil.dynamicQuery();
			dynamicQuery.add(PropertyFactoryUtil.forName("createDate").between(fromDate , toDate));
			
			// 9. Returning employeeList based on the query
			List<Employee> employeeList = EmployeeLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			// 10. Creating ArrayList of customEmployeeBean to stored the searchList and retrieve the data element by element
			ArrayList<ViewCustomEmployeeBean> searchEmployeeList = new ArrayList<ViewCustomEmployeeBean>();
			
			// 11. Traversing to all the records available in the Employee entity
			for (Employee employee : employeeList) {
				
				// 12. Getting values from database 
				long employeeId = employee.getEmployeeId();
				
				if(employeeId > 0) {
					Employee getEmployee = employeeLocalService.getEmployee(employeeId);

					String employeeName = getEmployee.getEmployeeName();
					String employeeMobile = getEmployee.getEmployeeMobile();
					String employeeEmail = getEmployee.getEmployeeEmail();
					long branchId = getEmployee.getBranchId();
					long departmentId = getEmployee.getDepartmentId();
					long designationId = getEmployee.getDesignationId();
					
					Branch branch = branchLocalService.fetchBranch(branchId);
					Department department = departmentLocalService.fetchDepartment(departmentId);
					Designation designation = designationLocalService.fetchDesignation(designationId);
					
					String branchName = branch.getBranchName();
					String departmentName = department.getDepartmentName() ;
					String designationName = designation.getDesignationName();
					
					// 13. Calling setCustomBean function for setting values in ViewEmployeeCustomBean
					ViewCustomEmployeeBean viewCustomEmployeeBean = CommonEmployeeMethods.setNewCustomBean(employeeId, 
							employeeName, employeeMobile, employeeEmail, branchName, departmentName, designationName);
					
					searchEmployeeList.add(viewCustomEmployeeBean);
				}
			}	
			
			request.setAttribute(EmployeeConstants.EMPLOYEE_LIST, searchEmployeeList);
			request.setAttribute(EmployeeConstants.FROM_SEARCH, "Yes");
			
		}
		else {
			
			// 1. If searching is done using textbox provided then passing the searchbox data
			// 2. Returning employeeObjectList using getEmployeeByAllEntity made in EmployeeFinderImpl that matches the search
			List<Object[]> searchList = employeeLocalService.getEmployeesByAllEntity(searchText);
					
			// 3. Validating if searchList is empty or not :: If not null then return employeeList
			if(Validator.isNotNull(searchList)) {
				
				// 4. Creating ArrayList of customEmployeeBean to stored the searchList and retrieve the data element by element
				ArrayList<ViewCustomEmployeeBean> searchEmployeeList = new ArrayList<ViewCustomEmployeeBean>();
				
				// 5. Traversing to all the records available in the Employee entity
				for (Object[] obj : searchList) {
					
					// 6. Getting values from database and casting them
					long employeeId = GetterUtil.getLong(obj[0]);
					String employeeName = String.valueOf(obj[1]);
					String employeeMobile = String.valueOf(obj[2]);
					String employeeEmail = String.valueOf(obj[3]);
					
					String branchName = String.valueOf(obj[4]);
					String departmentName = String.valueOf(obj[5]);
					String designationName = String.valueOf(obj[6]);
					
					
					// 7. Calling setCustomBean function for setting values in ViewEmployeeCustomBean
					ViewCustomEmployeeBean viewCustomEmployeeBean = CommonEmployeeMethods.setNewCustomBean(employeeId, 
							employeeName, employeeMobile, employeeEmail, branchName, departmentName, designationName);
							
					// 9. Adding the customBean object in the ArrayList
					searchEmployeeList.add(viewCustomEmployeeBean);
					
				}
				// 10. Setting the employeeList in the request 
				request.setAttribute(EmployeeConstants.EMPLOYEE_LIST, searchEmployeeList);
				
				// 11. Setting the fromSearch flag to true 
				request.setAttribute(EmployeeConstants.FROM_SEARCH, "yes");
			}
		}
	
		// 12. Copying the request parameters for sending the current request in the renderRequest
		PortalUtil.copyRequestParameters(request, response);
	}

	
}
