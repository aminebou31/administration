package administration.java.models;

import java.util.List;
import java.awt.Color;
import java.io.IOException;

 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


public class ProfPDFExportter {

	private List <professeur> listProf;

	public ProfPDFExportter(List<professeur> listProf) {
		super();
		this.setListProf(listProf);
	}

	public List <professeur> getListEtudiant() {
		return listProf;
	}

	public void setListProf(List <professeur> listProf) {
		this.listProf = listProf;
	}
	
	 private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(5);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Nom", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Prenom", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Telephone", font));
	        table.addCell(cell);
	    }
	     
	    private void writeTableData(PdfPTable table) {
	        for (professeur user : listProf) {
	            table.addCell(user.getNom());
	            table.addCell(user.getPrenom());
	            String t= String.valueOf(user.getTel());
	            table.addCell(t);
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("Liste des professeurs ", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(3);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}