package com.aixtor.training.employee.portlet.action;

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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.ByteArrayOutputStream;
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
	    	"javax.portlet.name=BranchPortlet",
	        "mvc.command.name=/download/branchPDF",
	    }, 
	    service = MVCResourceCommand.class
)

public class BranchPDFGeneration extends BaseMVCResourceCommand {
	
	private static Log log = LogFactoryUtil.getLog(BranchPDFGeneration.class);
	
	@Reference
	BranchLocalService branchLocalService;

	/**
	 * @return PDF saved in the given location
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		// 1. Getting the branchList from the database
		List<Branch> branchList = branchLocalService.getBranches(-1,-1);
		//log.info(branchList);
		
		// 2. Creating new document with the given location and creating Output stream
		Document document = new Document();
		OutputStream outputStream = new FileOutputStream(new File("C:\\Users\\Urva Patel\\Desktop\\BranchReport.pdf"));
		PdfWriter.getInstance(document, outputStream);
		document.open();
		
		// 3. Creating table in PDF
		PdfPTable pdfPTable = new PdfPTable(8);
		
		// 4. Creating cell that represent the table header in PDF
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
		
		// 5. Setting the values from the branchList to the table in the PDF
		for(int i=0;i<branchList.size();i++)
		{
			Branch branch = branchList.get(i);
			
			long branchIds = branch.getBranchId();
			String branchId = String.valueOf(branchIds);
			
			String branchName = branch.getBranchName();
			
			long countrys = branch.getCountryId();
			String country = String.valueOf(countrys);
			
			long states = branch.getStateId();
			String state = String.valueOf(states);
			
			long citys = branch.getCityId();
			String city = String.valueOf(citys);
			
			String address1 = branch.getAddress1();
			String address2 = branch.getAddress2();
			
			int pincodes = branch.getPincode();
			String pincode = String.valueOf(pincodes);
			
			// 6. Adding cell from the branchList using loop to traverse each record
			pdfPTable.addCell(branchId);
	        pdfPTable.addCell(branchName);
	        pdfPTable.addCell(country);
	        pdfPTable.addCell(state);
	        pdfPTable.addCell(city);
	        pdfPTable.addCell(address1);
	        pdfPTable.addCell(address2);
	        pdfPTable.addCell(pincode);
	        pdfPTable.setWidths(new int[]{30, 30, 30, 30, 30, 30, 30, 30});
		}
        
		// 7. Adding pdfTable to document 
        document.add(pdfPTable);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        baos.writeTo(outputStream); 
        baos.toByteArray();
        // 8. Closing the document and output stream
        document.close();
        outputStream.close();
        
        
	    log.info("BranchPDFGeneration >>> PDF Created");
	    
	    
	}
}
