package administration.java.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import administration.java.dao.GererProf_impl;
import administration.java.dao.GererSalleImpl;
import administration.java.models.Reservation;

/**
 * Servlet implementation class ServletReserverSalle
 */
@WebServlet("/reserverSalle")
public class ServletReserverSalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReserverSalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id_salle=Integer.parseInt(request.getParameter("idSalle"));
		String date = request.getParameter("date");
        java.sql.Date date_res = Date.valueOf(date);
        String crenau=request.getParameter("crenau");
        request.setAttribute("date", date_res);
		request.setAttribute("crenau", crenau);
		request.setAttribute("id_salle", id_salle);
		this.getServletContext().getRequestDispatcher("/ReserverSalle.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GererSalleImpl g=new GererSalleImpl();
		GererProf_impl p=new GererProf_impl();
		int id_salle=Integer.parseInt(request.getParameter("id_salle"));
		String nom_prof=request.getParameter("nom_prof");
		int id_prof=p.getProfByName(nom_prof);
		String date = request.getParameter("date");
        java.sql.Date date_res = Date.valueOf(date);
        String crenau=request.getParameter("crenau");
		Reservation r=new Reservation();
		r.setId_prof(id_prof);
		r.setId_salle(id_salle);
		r.setDate_res(date_res);
		r.setCrenau(crenau);
		try {
			g.ajouterReser(r);
		}catch (SQLException e) {
			this.getServletContext().getRequestDispatcher("/500.jsp").forward(request,response);
		}
		
		this.getServletContext().getRequestDispatcher("/listSalle").forward(request,response);
	}

}
