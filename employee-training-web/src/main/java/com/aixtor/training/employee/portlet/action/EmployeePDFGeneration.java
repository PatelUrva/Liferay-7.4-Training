package com.aixtor.training.employee.portlet.action;

import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.employee.helper.EmployeeHelper;

/**
 * @author Urva Patel
 */

import com.aixtor.training.model.Employee;
import com.aixtor.training.service.EmployeeLocalService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name="+EmployeeConstants.EMPLOYEE_PORTLET,
	        "mvc.command.name=/download/employeePDF",
	    }, 
	    service = MVCResourceCommand.class
)

public class EmployeePDFGeneration extends BaseMVCResourceCommand {
	
	@Reference
	EmployeeHelper employeeHelper;
	
	@Reference
	EmployeeLocalService employeeLocalService;


	/**
	 * @return PDF saved in the Downloads and Chrome
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		// 1. Getting the employeeList from the database
		List<Employee> employeeList = employeeLocalService.getEmployees(-1,-1);
				
		// 2. Creating new document with the given location and creating Output stream
		Document document = new Document();
		
		// 3. Declaring ByteArrayOutputStream object
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// 4. Set Instance of PdfWriter
	    PdfWriter.getInstance(document, baos);
	    
	    // 5. Opening document
	    document.open();
	    
	    // 6. Creating table in PDF
 		PdfPTable pdfPTable = new PdfPTable(7);
 		
 		// 7. Creating cell that represent the table header in PDF
 		PdfPCell c1 = new PdfPCell(new Phrase("Employee ID"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Employee Name"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Mobile Number"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Email"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Branch"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Department"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Designation"));
 		pdfPTable.addCell(c1);
 		pdfPTable.setHeaderRows(1);
 		
 		// 8. Setting the values from the employeeList to the table in the PDF
 		for(int i=0;i<employeeList.size();i++)
 		{
 			Employee employee = employeeList.get(i);
 			
 			long employeeIds = employee.getEmployeeId();
 			String employeeId = String.valueOf(employeeIds);
 			
 			String employeeName = employee.getEmployeeName();
 			String employeeMobile = employee.getEmployeeMobile();
 			String employeeEmail = employee.getEmployeeEmail();
 			
 			long branchIds = employee.getBranchId();
 			String branchId = String.valueOf(branchIds);
 			
 			long departmentIds = employee.getDepartmentId();
 			String departmentId = String.valueOf(departmentIds);
 			
 			long designationIds = employee.getDesignationId();
 			String designationId = String.valueOf(designationIds);
 			
 			// 6. Adding cell from the employeeList using loop to traverse each record
 			pdfPTable.addCell(employeeId);
 			pdfPTable.addCell(employeeName);
 			pdfPTable.addCell(employeeMobile);
 			pdfPTable.addCell(employeeEmail);
 			pdfPTable.addCell(branchId);
 			pdfPTable.addCell(departmentId);
 			pdfPTable.addCell(designationId);
 			
 	        pdfPTable.setWidths(new int[]{30, 30, 30, 30, 30, 30, 30});
 		}
		String fileName = "EmployeeReport.pdf";
		// 1. Adding table in pdf
		document.add(pdfPTable);
		
		// 2. Closing document
		document.close();
		
		// 3. Setting the HttpHeaders
		resourceResponse.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+fileName);
		resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL,"max-age=3600, must-revalidate");

        // 4. Setting the content type
        resourceResponse.setContentType("application/pdf");
        
        // 5. Setting the contentlength
        resourceResponse.setContentLength(baos.size());
        
        // 6. Write ByteArrayOutputStream to the ServletOutputStream
        OutputStream os = resourceResponse.getPortletOutputStream();
        baos.writeTo(os);
        os.flush();
        
        // 7. Send file using PortletResponseUtil
		PortletResponseUtil.sendFile(resourceRequest, resourceResponse,fileName, baos.toByteArray(), ContentTypes.APPLICATION_PDF);
		
	}


	


}
