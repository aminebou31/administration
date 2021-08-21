package administration.java.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererProf_impl;
import administration.java.dao.GererSalleImpl;
import administration.java.dao.IgererProf;

/**
 * Servlet implementation class ServletDeleteSalle
 */
@WebServlet("/deleteSalle")
public class ServletDeleteSalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDeleteSalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GererSalleImpl e =new GererSalleImpl();
		int id_salle=Integer.parseInt(request.getParameter("idSalle"));
		e.deleteSalle(id_salle);
		this.getServletContext().getRequestDispatcher("/listSalle").forward(request,response);
		
	}


}
