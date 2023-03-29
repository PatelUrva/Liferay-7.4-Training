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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.File;
import java.io.FileOutputStream;
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
	        "mvc.command.name=/download/DepartmentPDF",
	    }, 
	    service = MVCResourceCommand.class
)

public class DepartmentPDFGeneration extends BaseMVCResourceCommand {
	
	private static Log log = LogFactoryUtil.getLog(DepartmentPDFGeneration.class);
	
	@Reference
	DepartmentLocalService departmentLocalService;

	/**
	 * @return PDF saved in the given location
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		// 1. Getting the departmentList from the database
		List<Department> departmentList = departmentLocalService.getDepartments(-1,-1);
		//log.info(departmentList);
		
		// 2. Creating new document with the given location and creating Output stream
		Document document = new Document();
		OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Urva Patel\\Desktop\\DepartmentReport.pdf"));
		PdfWriter.getInstance(document, outputStream);
		document.open();
		
		// 3. Creating table in PDF
		PdfPTable pdfPTable = new PdfPTable(3);
		
		// 4. Creating cell that represent the table header in PDF
		PdfPCell c1 = new PdfPCell(new Phrase("Department ID"));
		pdfPTable.addCell(c1);
		c1 = new PdfPCell(new Phrase("Department Name"));
		pdfPTable.addCell(c1);
		c1 = new PdfPCell(new Phrase("Department Head"));
		pdfPTable.addCell(c1);
		
		pdfPTable.setHeaderRows(1);
		
		// 5. Setting the values from the departmentList to the table in the PDF
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
        
		// 7. Adding pdfTable to document 
        document.add(pdfPTable);
        
        // 8. Closing the document and output stream
        document.close();
        outputStream.close();
		 
	    log.info("DepartmentPDFGeneration >>> PDF Created");
	    
	    
	}
}
