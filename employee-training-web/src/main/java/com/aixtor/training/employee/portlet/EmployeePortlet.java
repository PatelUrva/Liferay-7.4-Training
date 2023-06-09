package com.aixtor.training.employee.portlet;

/**
 * @author Urva Patel
 */

import com.aixtor.training.employee.api.EmployeeApi;
import com.aixtor.training.employee.bean.ViewCustomEmployeeBean;
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.employee.helper.EmployeeHelper;
import com.aixtor.training.model.Branch;
import com.aixtor.training.model.Department;
import com.aixtor.training.model.Designation;
import com.aixtor.training.model.Employee;
import com.aixtor.training.service.BranchLocalService;
import com.aixtor.training.service.DepartmentLocalService;
import com.aixtor.training.service.DesignationLocalService;
import com.aixtor.training.service.EmployeeLocalService;
import com.aixtor.training.service.EmployeeLocalServiceUtil;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
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
	private BranchLocalService branchLocalService;
	
	@Reference
	private DepartmentLocalService departmentLocalService;
	
	@Reference
	private DesignationLocalService designationLocalService;

	@Reference
	private EmployeeLocalService employeeLocalService;
	
	@Reference
	private EmployeeApi employeeAPI;

	/**
	 * @return EmployeeList based on searching functionality changing the updated employeelist
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException, java.io.IOException {

		List<Object[]> employeeLists = null;
		
		// 1. Requsting fromSearch value from searchAction
		String fromSearch = (String) renderRequest.getAttribute(EmployeeConstants.FROM_SEARCH);
		String searchText = (String) renderRequest.getAttribute(EmployeeConstants.SEARCH_TEXT);
		Date fromDate = (Date) renderRequest.getAttribute(EmployeeConstants.FROM_DATE);
		Date toDate = (Date) renderRequest.getAttribute(EmployeeConstants.TO_DATE);
		
		PortletURL portletSearchURL = null;
		List<ViewCustomEmployeeBean> employeeSearchList = null;
		int totalSize = 0;
		int delta = 0;
		PortletURL portletURL = renderResponse.createRenderURL();
		
		// 2. Setting searchContainer values 
		SearchContainer<ViewCustomEmployeeBean> employeeContainer = new SearchContainer<>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 4, portletURL, null, null);
		
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
			ArrayList<ViewCustomEmployeeBean> employeeList = new ArrayList<>();
			
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
				long branchId = 0;
				long departmentId = 0;
				long designationId = 0;
				
				// 5. Calling setCustomBean method for setting values in ViewEmployeeCustomBean
				ViewCustomEmployeeBean viewCustomEmployeeBean = employeeAPI.setNewCustomBean(employeeId, employeeName, employeeMobile, employeeEmail, branchName,
						departmentName, designationName, branchId, departmentId, designationId);
						
				// 6. Adding the customBean object in the ArrayList
				employeeList.add(viewCustomEmployeeBean);
				
				renderRequest.setAttribute(EmployeeConstants.EMPLOYEE_LIST, employeeList);
			}
			
			// 8. Setting value of searchContainer attributes
			delta = employeeContainer.getDelta();
			totalSize = employeeList.size();
		}
		
		// 1. Setting searchContainer attribute values in render request
		renderRequest.setAttribute(EmployeeConstants.DELTA, delta);
		renderRequest.setAttribute(EmployeeConstants.PORTLET_SEARCH_URL, portletSearchURL);
		renderRequest.setAttribute(EmployeeConstants.TOTAL_SIZE, totalSize);
		renderRequest.setAttribute(EmployeeConstants.SEARCH_TEXT, searchText);
		renderRequest.setAttribute(EmployeeConstants.FROM_DATE, fromDate);
		renderRequest.setAttribute(EmployeeConstants.TO_DATE, toDate);
		
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
		
		String formatPattern = ParamUtil.getString(request, EmployeeConstants.DATE_FORMAT);
		
		// 1. Getting fromDate selected by the user
		Date fromDate = ParamUtil.getDate(request, EmployeeConstants.FROM_DATE, new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat(formatPattern).parse("1990-01-01"));
		
		// 2. Getting toDate selected by the user
		Date toDate = ParamUtil.getDate(request, EmployeeConstants.TO_DATE, new SimpleDateFormat("yyyy-MM-dd"), new Date());
		
		// 3. Getting searchText data selected by the user
		String searchText = ParamUtil.getString(request, EmployeeConstants.SEARCH_TEXT);
		
		// 4. Creating ArrayList of customEmployeeBean to stored the searchList and  retrieve the data element by element
		ArrayList<ViewCustomEmployeeBean> searchEmployeeList = new ArrayList<ViewCustomEmployeeBean>();
		
		EmployeeHelper employeeHelper = new EmployeeHelper(employeeAPI, employeeLocalService, branchLocalService, 
				departmentLocalService, designationLocalService);
		
		if (Validator.isNull(searchText)) {

			/*
			 * 5. Using DynamicQuery searching the employees data entered that falls betweent he fromDate and toDate
			 *	  provided by user	
			 */
			searchEmployeeList = employeeHelper.dateSearchEmployeeList(fromDate, toDate, searchEmployeeList);

		} else {

			// 1. If searching is done using textbox provided then passing the searchbox data
			// 2. Returning employeeObjectList using getEmployeeByAllEntity made in EmployeeFinderImpl that matches the search
			
			searchEmployeeList = employeeHelper.searchTextEmployeeList(searchText, searchEmployeeList);
			
		}
		
		request.setAttribute(EmployeeConstants.EMPLOYEE_LIST, searchEmployeeList);
		request.setAttribute(EmployeeConstants.FROM_SEARCH, "Yes");
		request.setAttribute(EmployeeConstants.SEARCH_TEXT, searchText);
		request.setAttribute(EmployeeConstants.FROM_DATE, fromDate);
		request.setAttribute(EmployeeConstants.TO_DATE, toDate);
		
		// 8. Copying the request parameters for sending the current request in the renderRequest
		PortalUtil.copyRequestParameters(request, response);
	}


}