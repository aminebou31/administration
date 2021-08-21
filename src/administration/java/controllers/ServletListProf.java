package administration.java.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.dao.GererProf_impl;
import administration.java.dao.IgererProf;
import administration.java.models.Matieres;
import administration.java.models.etudiant;
import administration.java.models.professeur;

/**
 * Servlet implementation class ServletListProf
 */
@WebServlet("/listProf")
public class ServletListProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListProf() {
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
		Matieres m=new Matieres();
		GererProf_impl e=new GererProf_impl();
		ArrayList<professeur> list =e.listProf() ;
		request.setAttribute("listProfess", list);
		ArrayList<Matieres> mat=m.filterMatieres(e.listMat());
		request.setAttribute("listMat", mat);
		this.getServletContext().getRequestDispatcher("/listeProf.jsp").forward(request,response);
		
	}

}
