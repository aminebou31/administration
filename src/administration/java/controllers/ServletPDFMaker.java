package administration.java.controllers;

import java.awt.List;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.dao.GererProf_impl;
import administration.java.models.Matieres;
import administration.java.models.ProfPDFExportter;
import administration.java.models.UserPDFExporter;
import administration.java.models.etudiant;
import administration.java.models.professeur;

/**
 * Servlet implementation class ServletPDFMaker
 */
@WebServlet({"/PDFMaker","/PDFMakerP"})
public class ServletPDFMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPDFMaker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if	(path.equals("/PDFMaker"))	{	
			try {
							GererEtudiant etudiantD=new GererEtudiant();
		                    response.setContentType("application/pdf");
		                    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		                    String currentDateTime = dateFormatter.format(new java.util.Date());

		                    String headerKey = "Content-Disposition";
		                    String headerValue = "attachment; filename=liste" + currentDateTime + ".pdf";
		                    response.setHeader(headerKey, headerValue);

		                    ArrayList<etudiant> listUsers = etudiantD.listEt();

		                    UserPDFExporter exporter = new UserPDFExporter(listUsers);
		                    exporter.export(response);


		                }catch(Exception e) {
		                    e.printStackTrace();
		                }
		}else if(path.equals("/PDFMakerP")) {
			try {
				GererProf_impl pr=new GererProf_impl();
                response.setContentType("application/pdf");
                DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
                String currentDateTime = dateFormatter.format(new java.util.Date());

                String headerKey = "Content-Disposition";
                String headerValue = "attachment; filename=liste" + currentDateTime + ".pdf";
                response.setHeader(headerKey, headerValue);

                ArrayList<professeur> listUsers = pr.listProf();

                ProfPDFExportter exporter = new ProfPDFExportter(listUsers);
                exporter.export(response);


            }catch(Exception e) {
                e.printStackTrace();
            }
		}
	}

}
