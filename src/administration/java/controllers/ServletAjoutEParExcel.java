package administration.java.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import administration.java.dao.GererEtudiant;
import administration.java.dao.GererProf_impl;
import administration.java.models.ExcelExport;
import administration.java.models.doc_prof;

/**
 * Servlet implementation class ServletAjoutEParExcel
 */
@WebServlet("/ajoutEParExcel")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ServletAjoutEParExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream inputStream;
	GererEtudiant insc=new GererEtudiant();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutEParExcel() {
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
		Part filePart = request.getPart("listEtuExcel");
		System.out.println("entrer a l'excel");
		if (filePart != null) {
			inputStream = filePart.getInputStream();
		}

		insc.addEtuExcel(inputStream);
		request.getRequestDispatcher("/listetu").forward(request, response);
	}
	

}
