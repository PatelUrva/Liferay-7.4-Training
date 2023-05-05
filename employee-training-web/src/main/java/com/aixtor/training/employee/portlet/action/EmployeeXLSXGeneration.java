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
import com.liferay.portal.kernel.exception.PortalException;
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
	

	/**
	 * @return XLSX saved in the given location
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		
		String searchText = ParamUtil.getString(resourceRequest, EmployeeConstants.SEARCH_TEXT);
		Date fromDate = ParamUtil.getDate(resourceRequest, EmployeeConstants.FROM_DATE, new SimpleDateFormat("yyyy-MM-dd"));
		Date toDate = ParamUtil.getDate(resourceRequest, EmployeeConstants.TO_DATE, new SimpleDateFormat("yyyy-MM-dd"));
		
		System.out.println(fromDate);
		System.out.println(toDate);
		
		// 1. Creating XSSFWorkbook 
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// 2. Creating XSSFSheet
		XSSFSheet sheet = workbook.createSheet("Employee Report");
		
		
		// 3. Calling writeHeaderLine method to write headers
		writeHeaderLine(sheet, workbook);
		
		// 4. Calling writeDataLines method to write Data
		writeDataLines(employee, fromDate, toDate, searchText, workbook, sheet);

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
	private void writeDataLines(Employee employee, Date fromDate, Date toDate, String searchText,  XSSFWorkbook workbook, XSSFSheet sheet) {

		// 1. Declaring and initalizing rowCount
		int rowCount = 1;
		
		ArrayList<ViewCustomEmployeeBean> searchEmployeeList = new ArrayList<ViewCustomEmployeeBean>();
		EmployeeHelper employeeHelper = new EmployeeHelper(employeeAPI, employeeLocalService, branchLocalService, 
				departmentLocalService, designationLocalService);
		// 2. Getting the employeeList from the database
		if (searchText != null) {
			
			searchEmployeeList = employeeHelper.searchTextEmployeeList(searchText, searchEmployeeList);
			
			for (int i = 0; i < searchEmployeeList.size(); i++) {
				
				// 4. Getting current row value
				ViewCustomEmployeeBean employees = searchEmployeeList.get(i);
				
				// 5. Storing row data in objects
				long employeeId = employees.getEmployeeId();
				String employeeName = employees.getEmployeeName();
				String employeeMobile = employees.getEmployeeMobile();
				String employeEmail = employees.getEmployeeEmail();
				String branchName = employees.getBranchName();
				String departmentName = employees.getDepartmentName();
				String designationName = employees.getDesignationName();
	
				rowCount = setRowByName(sheet, rowCount, i, employeeId, employeeName, employeeMobile, employeEmail,
						branchName, departmentName, designationName);
			}
			
		} else if(Validator.isNotNull(fromDate) && Validator.isNotNull(toDate) ) {
			
			try {
				searchEmployeeList = employeeHelper.dateSearchEmployeeList(fromDate, toDate, searchEmployeeList);
			} catch (PortalException e) {
				
			}

			for (int i = 0; i < searchEmployeeList.size(); i++) {
				
				// 4. Getting current row value
				ViewCustomEmployeeBean employees = searchEmployeeList.get(i);
				
				// 5. Storing row data in objects
				long employeeId = employees.getEmployeeId();
				String employeeName = employees.getEmployeeName();
				String employeeMobile = employees.getEmployeeMobile();
				String employeEmail = employees.getEmployeeEmail();
				String branchName = employees.getBranchName();
				String departmentName = employees.getDepartmentName();
				String designationName = employees.getDesignationName();
	
				rowCount = setRowByName(sheet, rowCount, i, employeeId, employeeName, employeeMobile, employeEmail,
						branchName, departmentName, designationName);
			}
			
		}else {
		
			List<Employee> employeeList = employeeLocalService.getEmployees(-1, -1);
			// 3. Storing list value in employee object row by row
			for (int i = 0; i < employeeList.size(); i++) {
	
				// 4. Getting current row value
				Employee employees = employeeList.get(i);
				
				// 5. Storing row data in objects
				long employeeId = employees.getEmployeeId();
				String employeeName = employees.getEmployeeName();
				String employeeMobile = employees.getEmployeeMobile();
				String employeEmail = employees.getEmployeeEmail();
				long branch = employees.getBranchId();
				long department = employees.getDepartmentId();
				long designation = employees.getDesignationId();
	
				rowCount = setRowById(sheet, rowCount, i, employeeId, employeeName, employeeMobile, employeEmail,
						branch, department, designation);
				
			}
		} 
		
	}

	private int setRowByName(XSSFSheet sheet, int rowCount, int i, long employeeId, String employeeName,
			String employeeMobile, String employeEmail, String branchName, String departmentName,
			String designationName) {
		
		Row row = sheet.createRow(rowCount++);

		// 7. Declaring and initalizing column count
		int columnCount = 0;
		
		// 8. Adding cell in sheet that represents row value of Employee ID
		Cell cell = row.createCell(columnCount++);
		cell.setCellValue(employeeId);
		sheet.autoSizeColumn(i);

		// 9. Adding cell in sheet that represents row value of Employee Name
		cell = row.createCell(columnCount++);
		cell.setCellValue(employeeName);
		sheet.autoSizeColumn(i);

		// 10. Adding cell in sheet that represents row value of Employee Mobile Number
		cell = row.createCell(columnCount++);
		cell.setCellValue(employeeMobile);
		sheet.autoSizeColumn(i);

		// 11. Adding cell in sheet that represents row value of Employee Email
		cell = row.createCell(columnCount++);
		cell.setCellValue(employeEmail);
		sheet.autoSizeColumn(i);

		// 12. Adding cell in sheet that represents row value of Employee Branch
		cell = row.createCell(columnCount++);
		cell.setCellValue(branchName);
		sheet.autoSizeColumn(i);

		// 13. Adding cell in sheet that represents row value of Employee Department
		cell = row.createCell(columnCount++);
		cell.setCellValue(departmentName);
		sheet.autoSizeColumn(i);

		// 14. Adding cell in sheet that represents row value of Employee Designation
		cell = row.createCell(columnCount);
		cell.setCellValue(designationName);
		sheet.autoSizeColumn(i);
		return rowCount;
	}

	private int setRowById(XSSFSheet sheet, int rowCount, int i, long employeeId, String employeeName,
			String employeeMobile, String employeEmail, long branch, long department, long designation) {
		
		// 6. Creating row in sheet with count incrementing based on data available
		Row row = sheet.createRow(rowCount++);

		// 7. Declaring and initalizing column count
		int columnCount = 0;
		
		// 8. Adding cell in sheet that represents row value of Employee ID
		Cell cell = row.createCell(columnCount++);
		cell.setCellValue(employeeId);
		sheet.autoSizeColumn(i);

		// 9. Adding cell in sheet that represents row value of Employee Name
		cell = row.createCell(columnCount++);
		cell.setCellValue(employeeName);
		sheet.autoSizeColumn(i);

		// 10. Adding cell in sheet that represents row value of Employee Mobile Number
		cell = row.createCell(columnCount++);
		cell.setCellValue(employeeMobile);
		sheet.autoSizeColumn(i);

		// 11. Adding cell in sheet that represents row value of Employee Email
		cell = row.createCell(columnCount++);
		cell.setCellValue(employeEmail);
		sheet.autoSizeColumn(i);

		// 12. Adding cell in sheet that represents row value of Employee Branch
		cell = row.createCell(columnCount++);
		cell.setCellValue(branch);
		sheet.autoSizeColumn(i);

		// 13. Adding cell in sheet that represents row value of Employee Department
		cell = row.createCell(columnCount++);
		cell.setCellValue(department);
		sheet.autoSizeColumn(i);

		// 14. Adding cell in sheet that represents row value of Employee Designation
		cell = row.createCell(columnCount);
		cell.setCellValue(designation);
		sheet.autoSizeColumn(i);
		return rowCount;
	}

}
