package com.aixtor.training.employee.portlet.action;

import com.aixtor.training.employee.api.EmployeeApi;
import com.aixtor.training.employee.bean.ViewCustomEmployeeBean;
import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.employee.helper.EmployeeHelper;
import com.aixtor.training.model.Employee;
import com.aixtor.training.service.BranchLocalService;
import com.aixtor.training.service.DepartmentLocalService;
import com.aixtor.training.service.DesignationLocalService;
import com.aixtor.training.service.EmployeeLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"javax.portlet.name="+EmployeeConstants.EMPLOYEE_PORTLET,
		"mvc.command.name=/download/employeeXLSX", 
		}, 
service = MVCResourceCommand.class)

public class EmployeeXLSXGeneration extends BaseMVCResourceCommand {

	private static Log log = LogFactoryUtil.getLog(EmployeePDFGeneration.class);
	
	private Employee employee;

	@Reference
	private EmployeeLocalService employeeLocalService;
	
	@Reference
	private EmployeeApi employeeAPI;
	
	@Reference
	private BranchLocalService branchLocalService;
	
	@Reference
	private DepartmentLocalService departmentLocalService;
	
	@Reference
	private DesignationLocalService designationLocalService;
	

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * @return XLSX saved in the given location
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		
		String searchText = ParamUtil.getString(resourceRequest, EmployeeConstants.SEARCH_TEXT, StringPool.BLANK);
		String fromDateStr = ParamUtil.getString(resourceRequest, EmployeeConstants.FROM_DATE, StringPool.BLANK);
		String toDateStr = ParamUtil.getString(resourceRequest, EmployeeConstants.TO_DATE, StringPool.BLANK);

		System.out.println(fromDateStr +"\n");
		System.out.println(toDateStr +"\n");

		JSONArray employeeArray = JSONFactoryUtil.createJSONArray();
		
		// 1. Creating XSSFWorkbook 
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// 2. Creating XSSFSheet
		XSSFSheet sheet = workbook.createSheet("Employee Report");
		
		
		// 3. Calling writeHeaderLine method to write headers
		writeHeaderLine(sheet, workbook);
		
		// 4. Calling writeDataLines method to write Data
		writeDataLines(employee, employeeArray, fromDateStr, toDateStr, searchText, workbook, sheet);

		// 5. Creating byte 
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// 6. Writing byteArray data to workbook
		workbook.write(baos);
		
		// 7. Converting data in bytes for passing in browser download
		byte[] bytes = baos.toByteArray();
		
		log.info("EmployeeCSVGeneration >>> Workbook Data :: "+workbook);

		// 8. Using PortletResponseUtil class to download file
		PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "EmployeeReport.xlsx", bytes, ContentTypes.APPLICATION_VND_MS_EXCEL);
		// "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
		
		log.info("EmployeeCSVGeneration >>> XLSX Created");
	}

	/**
	 * @return headers of the sheet
	 * @param sheet
	 */
	private void writeHeaderLine(XSSFSheet sheet, XSSFWorkbook workbook) {
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);
		
		// 1. Creating row in sheet
		Row headerRow = sheet.createRow(0);
		
		for (int i = 0; i < EmployeeConstants.EMPLOYEE_HEADER.length; i++) {
		    Cell headerCell = headerRow.createCell(i);
		    headerCell.setCellValue(EmployeeConstants.EMPLOYEE_HEADER[i]);
		    headerCell.setCellStyle(style);
		}

	}

	/**
	 * @return data from the database to sheet
	 * @param employee
	 * @param workbook
	 * @param sheet
	 */
	private void writeDataLines(Employee employee, JSONArray employeeArray, String fromDateStr, String toDateStr, String searchText,  XSSFWorkbook workbook, XSSFSheet sheet) {

		ArrayList<ViewCustomEmployeeBean> searchEmployeeList = new ArrayList<ViewCustomEmployeeBean>();
		EmployeeHelper employeeHelper = new EmployeeHelper(employeeAPI, employeeLocalService, branchLocalService, 
				departmentLocalService, designationLocalService);
		
		// 2. Getting the employeeList from the database
		if (Validator.isNotNull(searchText)) {
			
			searchEmployeeList = employeeHelper.searchTextEmployeeList(searchText, searchEmployeeList);
			
			ViewCustomEmployeeBean employees = null;
			Row dataRow = null;
			XSSFCellStyle style = workbook.createCellStyle();
			style.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
			for (int i = 0; i < searchEmployeeList.size(); i++) {
				
				// 4. Getting current row value
				employees = searchEmployeeList.get(i);
				sheet.autoSizeColumn(i);
				dataRow = sheet.createRow(i + 1);
				dataRow.setRowStyle(style);
				dataRow.createCell(0).setCellValue(employees.getEmployeeId());
			    dataRow.createCell(1).setCellValue(employees.getEmployeeName());
			    dataRow.createCell(2).setCellValue(employees.getEmployeeEmail());
			    dataRow.createCell(3).setCellValue(employees.getEmployeeMobile());
			    dataRow.createCell(4).setCellValue(employees.getBranchName());
			    dataRow.createCell(5).setCellValue(employees.getDepartmentName());
			    dataRow.createCell(6).setCellValue(employees.getDepartmentName());
			
			}
			
		} else if(Validator.isNotNull(fromDateStr) && Validator.isNotNull(toDateStr) ) {
			
			try {
				Date fromDate = simpleDateFormat.parse(fromDateStr);
				Date toDate =  simpleDateFormat.parse(toDateStr);
				searchEmployeeList = employeeHelper.dateSearchEmployeeList(fromDate, toDate, searchEmployeeList);
				System.out.println("EmployeeXLSX >>> " +searchEmployeeList);
			} catch (Exception e) {
				System.out.println("EmployeeXLSX >>> Error Occured" +e.getMessage());
			} 

			ViewCustomEmployeeBean employees = null;
			Row dataRow = null;
			XSSFCellStyle style = workbook.createCellStyle();
			style.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
			for (int i = 0; i < searchEmployeeList.size(); i++) {
				
				// 4. Getting current row value
				sheet.autoSizeColumn(i);
				employees = searchEmployeeList.get(i);
				dataRow = sheet.createRow(i + 1);
			    dataRow.createCell(0).setCellValue(employees.getEmployeeId());
			    dataRow.createCell(1).setCellValue(employees.getEmployeeName());
			    dataRow.createCell(2).setCellValue(employees.getEmployeeEmail());
			    dataRow.createCell(3).setCellValue(employees.getEmployeeMobile());
			    dataRow.createCell(4).setCellValue(employees.getBranchName());
			    dataRow.createCell(5).setCellValue(employees.getDepartmentName());
			    dataRow.createCell(6).setCellValue(employees.getDepartmentName());
			}
			
		}else {
		
			List<Employee> employeeList = employeeLocalService.getEmployees(-1, -1);
			
			// 3. Storing list value in employee object row by row
			Employee employees = null;
			Row dataRow = null;
			XSSFCellStyle style = workbook.createCellStyle();
			style.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
			for (int i = 0; i < employeeList.size(); i++) {
				
				// 4. Getting current row value
				sheet.autoSizeColumn(i);
				employees = employeeList.get(i);
				dataRow = sheet.createRow(i + 1);
			    dataRow.createCell(0).setCellValue(employees.getEmployeeId());
			    dataRow.createCell(1).setCellValue(employees.getEmployeeName());
			    dataRow.createCell(2).setCellValue(employees.getEmployeeEmail());
			    dataRow.createCell(3).setCellValue(employees.getEmployeeMobile());
			    dataRow.createCell(4).setCellValue(employees.getBranchId());
			    dataRow.createCell(5).setCellValue(employees.getDepartmentId());
			    dataRow.createCell(6).setCellValue(employees.getDesignationId());
				
			}
			
			/*
			for (int i = 0; i < employeeList.size(); i++) {
	
				// 4. Getting current row value
				Employee employees = employeeList.get(i);
				
				// 5. Storing row data in objects
				jsonObject.put(EmployeeConstants.EMPLOYEE_ID, employees.getEmployeeId());
				jsonObject.put(EmployeeConstants.EMPLOYEE_NAME, employees.getEmployeeName());
				jsonObject.put(EmployeeConstants.EMPLOYEE_EMAIL, employees.getEmployeeEmail());
				jsonObject.put(EmployeeConstants.EMPLOYEE_MOBILE, employees.getEmployeeMobile());
				jsonObject.put(EmployeeConstants.BRANCH_ID, employees.getBranchId());
				jsonObject.put(EmployeeConstants.DEPARTMENT_ID, employees.getDepartmentId());
				jsonObject.put(EmployeeConstants.DESIGNATION_ID, employees.getDesignationId());
				
				employeeArray.put(jsonObject);
				
				for (int j = 0; j < employeeArray.length(); j++) {
					
				    JSONObject employeeObj = employeeArray.getJSONObject(j);
				    Row dataRow = sheet.createRow(j + 1);
				    
				    dataRow.createCell(0).setCellValue(employeeObj.getLong(EmployeeConstants.EMPLOYEE_ID));
				    dataRow.createCell(1).setCellValue(employeeObj.getString(EmployeeConstants.EMPLOYEE_NAME));
				    dataRow.createCell(2).setCellValue(employeeObj.getString(EmployeeConstants.EMPLOYEE_MOBILE));
				    dataRow.createCell(3).setCellValue(employeeObj.getString(EmployeeConstants.EMPLOYEE_EMAIL));
				    dataRow.createCell(4).setCellValue(employeeObj.getString(EmployeeConstants.BRANCH_ID));
				    dataRow.createCell(5).setCellValue(employeeObj.getString(EmployeeConstants.DEPARTMENT_ID));
				    dataRow.createCell(6).setCellValue(employeeObj.getString(EmployeeConstants.DESIGNATION_ID));
				}
				
			}
			*/
		} 
		
	}

}
