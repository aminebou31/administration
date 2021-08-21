package administration.java.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererSalleImpl;
import administration.java.models.Reservation;

/**
 * Servlet implementation class ServletFiltrerRes
 */
@WebServlet("/filtrerRes")
public class ServletFiltrerRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFiltrerRes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GererSalleImpl e=new GererSalleImpl();
		String nom=request.getParameter("nom_prof");
		ArrayList<Reservation> list =e.listresFiltrer(nom) ;
		request.setAttribute("listRes", list);
		this.getServletContext().getRequestDispatcher("/listReservation.jsp").forward(request,response);
	}

}
