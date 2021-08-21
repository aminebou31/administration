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
 * Servlet implementation class ServletReserverSalleProf
 */
@WebServlet("/reserverSalleProf")
public class ServletReserverSalleProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReserverSalleProf() {
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
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		GererSalleImpl g=new GererSalleImpl();
		GererProf_impl p=new GererProf_impl();
		int id_salle=Integer.parseInt(request.getParameter("idSalle"));
		//String nom_prof=request.getParameter("nom_prof");
		int id_prof=(int) session.getAttribute("user1");
		System.out.println(id_prof);
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
		
		this.getServletContext().getRequestDispatcher("/listSalleProf").forward(request,response);
	}

}
