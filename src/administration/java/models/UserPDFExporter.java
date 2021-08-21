package administration.java.models;

import java.util.List;
import java.awt.Color;
import java.io.IOException;

 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import administration.java.dao.GererEtudiant;

public class UserPDFExporter {

	private List <etudiant> listEtudiant;

	public UserPDFExporter(List<etudiant> listEtudiant) {
		super();
		this.setListEtudiant(listEtudiant);
	}

	public List <etudiant> getListEtudiant() {
		return listEtudiant;
	}

	public void setListEtudiant(List <etudiant> listEtudiant) {
		this.listEtudiant = listEtudiant;
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
	         
	        cell.setPhrase(new Phrase("Code Massar", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Filiere", font));
	        table.addCell(cell);      
	    }
	     
	    private void writeTableData(PdfPTable table) {
	    	GererEtudiant g=new GererEtudiant();
	        for (etudiant user : listEtudiant) {
	            table.addCell(user.getNomFr());
	            table.addCell(user.getPrenomFr());
	            table.addCell(user.getCNE());
	            int id_filiere=user.getId_filiere();
	            table.addCell(g.getNomFil(id_filiere));
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("Liste des etudiants ", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}