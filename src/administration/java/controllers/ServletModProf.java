package administration.java.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.dao.GererProf_impl;
import administration.java.dao.IgererProf;
import administration.java.models.etudiant;
import administration.java.models.professeur;

/**
 * Servlet implementation class ServletModProf
 */
@WebServlet("/modifierProf")
public class ServletModProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModProf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	System.out.println("doget");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IgererProf a=new GererProf_impl();
		int id=Integer.parseInt(request.getParameter("id"));
		String Nom = request.getParameter("nom");
		String Prenom = request.getParameter("prenom");
		int nmbre_abs = Integer.parseInt(request.getParameter("nombre_abs"));
		int num_tel = Integer.parseInt(request.getParameter("num_tel"));
		professeur e = new professeur();
		e.setId_prof(id);
		e.setNom(Nom);
		e.setPrenom(Prenom);
		e.setNbreAbsence(nmbre_abs);
		e.setTel(num_tel);
		a.modifierProf(e);
		
		this.getServletContext().getRequestDispatcher("/listProf").forward(request,response);
	}

}
