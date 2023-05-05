package com.aixtor.training.employee.portlet.action;

import com.aixtor.training.employee.constants.EmployeeConstants;
import com.aixtor.training.employee.helper.EmployeeHelper;

/**
 * @author Urva Patel
 */

import com.aixtor.training.model.Branch;
import com.aixtor.training.service.BranchLocalService;
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
	    	"javax.portlet.name="+EmployeeConstants.BRANCH_PORTLET,
	        "mvc.command.name=/download/branchPDF",
	    }, 
	    service = MVCResourceCommand.class
)

public class BranchPDFGeneration extends BaseMVCResourceCommand {
	
	@Reference
	EmployeeHelper employeeHelper;
	
	@Reference
	BranchLocalService branchLocalService;
	
	/**
	 * @return PDF saved in the Downloads and Chrome
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		// 1. Getting the employeeList from the database
		List<Branch> branchList = branchLocalService.getBranches(-1,-1);
				
		// 2. Creating new document with the given location and creating Output stream
		Document document = new Document();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		// 4. Set Instance of PdfWriter
	    PdfWriter.getInstance(document, baos);
	    
	    // 5. Opening document
	    document.open();
	    
	    // 6. Creating table in PDF
 		PdfPTable pdfPTable = new PdfPTable(8);
 		
 		// 7. Creating cell that represent the table header in PDF
 		PdfPCell c1 = new PdfPCell(new Phrase("Branch ID"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Branch Name"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Country"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("State"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("City"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Address1"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Address2"));
 		pdfPTable.addCell(c1);
 		c1 = new PdfPCell(new Phrase("Pincode"));
 		pdfPTable.addCell(c1);
 		pdfPTable.setHeaderRows(1);
 		
 		// 8. Setting the values from the employeeList to the table in the PDF
 		for(int i=0;i<branchList.size();i++)
 		{
 			Branch branch = branchList.get(i);
 			
 			long branchIds = branch.getBranchId();
 			String branchId = String.valueOf(branchIds);
 			
 			String branchName = branch.getBranchName();
 			
 			long countryIds = branch.getCountryId();
 			String countryId = String.valueOf(countryIds);
 			
 			long stateIds = branch.getStateId();
 			String stateId = String.valueOf(stateIds);
 			
 			long cityIds = branch.getCityId();
 			String cityId = String.valueOf(cityIds);
 			
 			String address1 = branch.getAddress1();
 			String address2 = branch.getAddress2();
 			
 			int pincodes = branch.getPincode();
 			String pincode = String.valueOf(pincodes); 
 			
 			// 6. Adding cell from the employeeList using loop to traverse each record
 			pdfPTable.addCell(branchId);
 			pdfPTable.addCell(branchName);
 			pdfPTable.addCell(countryId);
 			pdfPTable.addCell(stateId);
 			pdfPTable.addCell(cityId);
 			pdfPTable.addCell(address1);
 			pdfPTable.addCell(address2);
 			pdfPTable.addCell(pincode);
 			
 	        pdfPTable.setWidths(new int[]{30, 30, 30, 30, 30, 30, 30, 30});
 		}
 		String fileName = "BranchReport.pdf";
 		
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
