package administration.java.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import administration.java.dao.GererSalleImpl;
import administration.java.models.Reservation;

/**
 * Servlet implementation class ServletListReservationProf
 */
@WebServlet("/listReservationProf")
public class ServletListReservationProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListReservationProf() {
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
		GererSalleImpl e=new GererSalleImpl();
		HttpSession session=request.getSession();
		ArrayList<Reservation> list =e.listResProf((int)session.getAttribute("user1")) ;
		request.setAttribute("listRes", list);
		this.getServletContext().getRequestDispatcher("/listReservationProf.jsp").forward(request,response);
		
	}

}
