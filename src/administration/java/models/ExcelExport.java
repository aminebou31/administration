package administration.java.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExport {
	etudiant etudiant= new etudiant();
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	List<etudiant>e=new ArrayList<etudiant>();
	
	
	public ExcelExport(List<etudiant> e) {
		this.e = e;
		workbook =new XSSFWorkbook();
		sheet=workbook.createSheet("Etudiant");
	}
	public void writeEtud(etudiant e , Row r) {
		Cell cell = r.createCell(0);
		cell.setCellValue(e.getCNE());
		
		cell = r.createCell(1);
		cell.setCellValue(e.getNomFr());
		
		cell = r.createCell(2);
		cell.setCellValue(e.getPrenomFr());
	}
	

	
	public void exporter(List<etudiant> l ,HttpServletResponse response) throws IOException {
		
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		int rowCount=0;
		for(etudiant e :l) {
			Row row = sheet.createRow(++rowCount);
			writeEtud(e, row);
		}
		try (ServletOutputStream outputStream= response.getOutputStream();){
			workbook.write(outputStream);
		}
		
	}
}