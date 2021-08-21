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
 * Servlet implementation class ServletEditProf
 */
@WebServlet("/editProf")
public class ServletEditProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditProf() {
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
		IgererProf e=new GererProf_impl();
		int id=Integer.parseInt(request.getParameter("idProfesseur"));
		professeur prof=e.getProf(id);
		request.setAttribute("id_prof", id);
		request.setAttribute("infoProf", prof);
		this.getServletContext().getRequestDispatcher("/modifierProf.jsp").forward(request,response);
	}

}
