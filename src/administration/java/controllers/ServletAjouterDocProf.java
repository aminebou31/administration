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
import administration.java.models.doc_etu;
import administration.java.models.doc_prof;

/**
 * Servlet implementation class ServletAjouterDocProf
 */
@WebServlet({"/ajouterDocProf","/ajouterDocP"})
@MultipartConfig()
public class ServletAjouterDocProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
    InputStream inputStream1;
    InputStream inputStream2;
    InputStream inputStream3;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouterDocProf() {
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
		
		
		
		String path = request.getServletPath();
		System.out.println("path : "+ path);
		
		
		
		if(path.equals("/ajouterDocProf")) {
		GererProf_impl a=new GererProf_impl();
	    int idEt = Integer.parseInt(request.getParameter("idP"));
		Part filePart1 = request.getPart("photo");

		if (filePart1 != null ) {

			System.out.println(filePart1.getName());

			inputStream1 = filePart1.getInputStream();
			
		}
		doc_prof doc1=new doc_prof();
		doc1.setId_prof(idEt);
		doc1.setDoc(inputStream1);
		doc1.setNom("photo");
		a.ajoutDocProf(doc1);
		
		
		this.getServletContext().getRequestDispatcher("/listProf").forward(request,response);
		}
		else if(path.equals("/ajouterDocP")) {
			int idP = Integer.parseInt(request.getParameter("idProfesseur"));
			request.setAttribute("idP", idP);
			request.getRequestDispatcher("ajouterDocProf.jsp").forward(request, response);

			
		}
	}
}
