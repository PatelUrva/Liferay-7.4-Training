package com.aixtor.training.employee.portlet.action;

/**
 * @author Urva Patel
 */
import com.aixtor.training.model.Designation;
import com.aixtor.training.service.DesignationLocalService;
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
	    	"javax.portlet.name=DesignationPortlet",
	        "mvc.command.name=/download/designationPDF",
	    }, 
	    service = MVCResourceCommand.class
)

public class DesignationPDFGeneration extends BaseMVCResourceCommand {
	
	private static Log log = LogFactoryUtil.getLog(DesignationPDFGeneration.class);
	
	@Reference
	DesignationLocalService designationLocalService;

	/**
	 * @return PDF saved in the given location
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		// 1. Getting the designationList from the database
		List<Designation> designationList = designationLocalService.getDesignations(-1,-1);
		
		// 2. Creating new document with the given location and creating Output stream
		Document document = new Document();
		OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Urva Patel\\Desktop\\DesignationReport.pdf"));
		PdfWriter.getInstance(document, outputStream);
		document.open();
		
		// 3. Creating table in PDF
		PdfPTable pdfPTable = new PdfPTable(2);
		
		// 4. Creating cell that represent the table header in PDF
		PdfPCell c1 = new PdfPCell(new Phrase("Designation ID"));
		pdfPTable.addCell(c1);
		c1 = new PdfPCell(new Phrase("Designation Name"));
		pdfPTable.addCell(c1);
		
		pdfPTable.setHeaderRows(1);
		
		// 5. Setting the values from the designationList to the table in the PDF
		for(int i=0;i<designationList.size();i++)
		{
			Designation designation = designationList.get(i);
			
			long designationIds = designation.getDesignationId();
			String designationId = String.valueOf(designationIds);
			
			String designationName = designation.getDesignationName();
			
			// 6. Adding cell from the designationList using loop to traverse each record
			pdfPTable.addCell(designationId);
	        pdfPTable.addCell(designationName);
	        pdfPTable.setWidths(new int[]{30, 30});
		}
        
		// 7. Adding pdfTable to document 
        document.add(pdfPTable);
        
        // 8. Closing the document and output stream
        document.close();
        outputStream.close();
		 
	    log.info("DesignationPDFGeneration >>> PDF Created");
	    
	    
	}
}
