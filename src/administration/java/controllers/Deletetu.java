package administration.java.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.models.etudiant;

/**
 * Servlet implementation class Deletetu
 */
@WebServlet("/deletetu")
public class Deletetu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletetu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	GererEtudiant e =new GererEtudiant();
		int id_etu=Integer.parseInt(request.getParameter("idEtudiant"));
		e.deleteEtudiant(id_etu);
		ArrayList<etudiant> list =e.listEt() ;
		request.setAttribute("listEtu", list);
		this.getServletContext().getRequestDispatcher("/listetu").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GererEtudiant e =new GererEtudiant();
		int id_etu=Integer.parseInt(request.getParameter("idEtudiant"));
		e.deleteEtudiant(id_etu);
		this.getServletContext().getRequestDispatcher("/listetu").forward(request,response);
		
	}

}
