package administration.java.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import administration.java.dao.GererSalleImpl;
import administration.java.models.salle;

/**
 * Servlet implementation class ServletDeleteRes
 */
@WebServlet({"/deletRes","/deletResProf"})
public class ServletDeleteRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDeleteRes() {
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
		String path=request.getServletPath();
		HttpSession session=request.getSession();
		GererSalleImpl a=new GererSalleImpl();
		if(path.equals("/deletRes")) {
			int id_prof = Integer.parseInt(request.getParameter("idProf"));
			int id_salle = Integer.parseInt(request.getParameter("idSalle"));
			String date = request.getParameter("date_res");
	        java.sql.Date date_res = Date.valueOf(date);
	        String crenau=request.getParameter("crenau");
			a.deleteRes(id_prof,id_salle,crenau,date_res);
			this.getServletContext().getRequestDispatcher("/listReservation").forward(request,response);
		}else if(path.equals("/deletResProf")) {
			int id_salle = Integer.parseInt(request.getParameter("idSalle"));
			String date = request.getParameter("date_res");
	        java.sql.Date date_res = Date.valueOf(date);
	        String crenau=request.getParameter("crenau");
			a.deleteRes((int)session.getAttribute("user1"),id_salle,crenau,date_res);
			this.getServletContext().getRequestDispatcher("/listReservationProf").forward(request,response);
		}
		}

}
