package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */

import com.aixtor.training.model.Department;
import com.aixtor.training.service.DepartmentLocalService;
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
	    	"javax.portlet.name=DepartmentPortlet",
	        "mvc.command.name=/download/departmentPDF",
	    }, 
	    service = MVCResourceCommand.class
)

public class DepartmentPDFGeneration extends BaseMVCResourceCommand {
	
	@Reference
	DepartmentLocalService departmentLocalService;


	/**
	 * @return PDF saved in the Downloads and Chrome
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		// 1. Getting the departmentList from the database
		List<Department> departmentList = departmentLocalService.getDepartments(-1,-1);
				
		// 2. Creating new document with the given location and creating Output stream
		Document document = new Document();
		
		// 3. Declaring ByteArrayOutputStream object
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// 4. Set Instance of PdfWriter
	    PdfWriter.getInstance(document, baos);
	    
	    // 5. Opening document
	    document.open();
	    
	    // 6. Creating table in PDF
 		PdfPTable pdfPTable = new PdfPTable(3);
 		
 		// 7. Creating cell that represent the table header in PDF
 		PdfPCell c1 = new PdfPCell(new Phrase("Department ID"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Department Name"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("DepartmentHead"));
 		pdfPTable.addCell(c1);
 		pdfPTable.setHeaderRows(1);
 		
 		// 8. Setting the values from the departmentList to the table in the PDF
 		for(int i=0;i<departmentList.size();i++)
 		{
 			Department department = departmentList.get(i);
 			
 			long departmentIds = department.getDepartmentId();
 			String departmentId = String.valueOf(departmentIds);
 			
 			String departmentName = department.getDepartmentName();
 			String departmentHead = department.getDepartmentHead(); 
 			
 			// 6. Adding cell from the departmentList using loop to traverse each record
 			pdfPTable.addCell(departmentId);
 	        pdfPTable.addCell(departmentName);
 	        pdfPTable.addCell(departmentHead);
 	        pdfPTable.setWidths(new int[]{30, 30, 30});
 		}
		
 		// 9. Adding table in pdf
		document.add(pdfPTable);
		
		// 10. Closing document
		document.close();
		
		// 11. Setting the HttpHeaders
		resourceResponse.setProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=DepartmentReport.pdf");
		resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL,"max-age=3600, must-revalidate");

        // 12. Setting the content type
        resourceResponse.setContentType("application/pdf");
        
        // 13. Setting the contentlength
        resourceResponse.setContentLength(baos.size());
        
        // 14. Write ByteArrayOutputStream to the ServletOutputStream
        OutputStream os = resourceResponse.getPortletOutputStream();
        baos.writeTo(os);
        os.flush();
        
        // 15. Send file using PortletResponseUtil
		PortletResponseUtil.sendFile(resourceRequest, resourceResponse,"Department.pdf", baos.toByteArray(), ContentTypes.APPLICATION_PDF);
	
	}
}
