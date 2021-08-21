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
import administration.java.models.professeur;
import administration.java.models.salle;

/**
 * Servlet implementation class ServletEditSalle
 */
@WebServlet("/editSalle")
public class ServletEditSalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditSalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int id=Integer.parseInt(request.getParameter("idSalle"));
    	request.setAttribute("id_salle", id);
    	this.getServletContext().getRequestDispatcher("/modifierSalle.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GererSalleImpl e=new GererSalleImpl();
		salle sa=new salle();
		int id=0;
		id=Integer.parseInt(request.getParameter("id_salle"));
		sa.setId_salle(id);
		sa.setDescri(request.getParameter("description"));
		e.modifierSalle(sa);
		this.getServletContext().getRequestDispatcher("/listSalle").forward(request,response);
	}

}
