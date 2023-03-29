package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */

import com.aixtor.training.model.Employee;
import com.aixtor.training.service.EmployeeLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"javax.portlet.name=EmployeePortlet",
		"mvc.command.name=/download/employeeXLSX", 
		}, 
service = MVCResourceCommand.class)

public class EmployeeXLSXGeneration extends BaseMVCResourceCommand {

	private static Log log = LogFactoryUtil.getLog(EmployeePDFGeneration.class);
	
	private Employee employee;

	@Reference
	EmployeeLocalService employeeLocalService;

	/**
	 * @return CSV saved in the given location
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		// 1. Creating XSSFWorkbook 
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		// 2. Creating XSSFSheet
		XSSFSheet sheet = workbook.createSheet("Employee Report");

		// 3. Calling writeHeaderLine method to write headers
		writeHeaderLine(sheet);
		
		// 4. Calling writeDataLines method to write Data
		writeDataLines(employee, workbook, sheet);

		// 5. Creating byte 
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// 6. Writing byteArray data to workbook
		workbook.write(baos);
		
		// 7. Converting data in bytes for passing in browser download
		byte[] bytes = baos.toByteArray();
		
		log.info("EmployeeCSVGeneration >>> Workbook Data :: "+workbook);

		// 8. Using PortletResponseUtil class to download file
		PortletResponseUtil.sendFile(resourceRequest, resourceResponse, "EmployeeReport.xlsx", bytes, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		log.info("EmployeeCSVGeneration >>> XLSX Created");
	}

	/**
	 * @return headers of the sheet
	 * @param sheet
	 */
	private void writeHeaderLine(XSSFSheet sheet) {

		// 1. Creating row in sheet
		Row headerRow = sheet.createRow(0);

		// 2. Adding cell in sheet that represents header named Employee ID
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Employee ID");

		// 3. Adding cell in sheet that represents header named Employee Name
		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("Employee Name");

		// 4. Adding cell in sheet that represents header named Employee Mobile Number
		headerCell = headerRow.createCell(2);
		headerCell.setCellValue("Mobile Number");

		// 5. Adding cell in sheet that represents header named Employee Mail
		headerCell = headerRow.createCell(3);
		headerCell.setCellValue("Email");

		// 6. Adding cell in sheet that represents header named Employee Branch
		headerCell = headerRow.createCell(4);
		headerCell.setCellValue("Branch");

		// 7. Adding cell in sheet that represents header named Employee Department
		headerCell = headerRow.createCell(5);
		headerCell.setCellValue("Department");

		// 8. Adding cell in sheet that represents header named Employee Designation
		headerCell = headerRow.createCell(6);
		headerCell.setCellValue("Designation");

	}

	/**
	 * @return data from the database to sheet
	 * @param employee
	 * @param workbook
	 * @param sheet
	 */
	private void writeDataLines(Employee employee, XSSFWorkbook workbook, XSSFSheet sheet) {

		// 1. Declaring and initalizing rowCount
		int rowCount = 1;

		// 2. Getting the employeeList from the database
		List<Employee> employeeList = employeeLocalService.getEmployees(-1, -1);

		// 3. Storing list value in employee object row by row
		for (int i = 0; i < employeeList.size(); i++) {

			// 4. Getting current row value
			employee = employeeList.get(i);
			
			// 5. Storing row data in objects
			long employeeId = employee.getEmployeeId();
			String employeeName = employee.getEmployeeName();
			String employeeMobile = employee.getEmployeeMobile();
			String employeEmail = employee.getEmployeeEmail();
			long branch = employee.getBranchId();
			long department = employee.getDepartmentId();
			long designation = employee.getDesignationId();

			// 6. Creating row in sheet with count incrementing based on data available
			Row row = sheet.createRow(rowCount++);

			// 7. Declaring and initalizing column count
			int columnCount = 0;
			
			// 8. Adding cell in sheet that represents row value of Employee ID
			Cell cell = row.createCell(columnCount++);
			cell.setCellValue(employeeId);

			// 9. Adding cell in sheet that represents row value of Employee Name
			cell = row.createCell(columnCount++);
			cell.setCellValue(employeeName);

			// 10. Adding cell in sheet that represents row value of Employee Mobile Number
			cell = row.createCell(columnCount++);
			cell.setCellValue(employeeMobile);

			// 11. Adding cell in sheet that represents row value of Employee Email
			cell = row.createCell(columnCount++);
			cell.setCellValue(employeEmail);

			// 12. Adding cell in sheet that represents row value of Employee Branch
			cell = row.createCell(columnCount++);
			cell.setCellValue(branch);

			// 13. Adding cell in sheet that represents row value of Employee Department
			cell = row.createCell(columnCount++);
			cell.setCellValue(department);

			// 14. Adding cell in sheet that represents row value of Employee Designation
			cell = row.createCell(columnCount++);
			cell.setCellValue(designation);
		}

	}

}
