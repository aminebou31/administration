package administration.java.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererProf_impl;
import administration.java.dao.GererSalleImpl;
import administration.java.models.Matieres;
import administration.java.models.professeur;
import administration.java.models.salle;

/**
 * Servlet implementation class servletListSalle
 */
@WebServlet({"/listSalle","/listSalleFiltre"})
public class servletListSalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListSalle() {
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
		GererSalleImpl e=new GererSalleImpl();
		if(path.equals("/listSalleFiltre")) {
			salle s=new salle();
			String date = request.getParameter("date");
	        java.sql.Date date_res = Date.valueOf(date);
	        String creneau=request.getParameter("creneau");
			ArrayList<salle> list =s.filterSalles(e.listSalleFiltrer(date_res,creneau)) ;
			request.setAttribute("date", date_res);
			request.setAttribute("crenau", creneau);
			request.setAttribute("listSalle", list);
			this.getServletContext().getRequestDispatcher("/listSalle.jsp").forward(request,response);
		}else if (path.equals("/listSalle")) {
			ArrayList<salle> list =e.listSalle() ;
			request.setAttribute("listSalle", list);
			this.getServletContext().getRequestDispatcher("/listSalle.jsp").forward(request,response);
		}
		
	}

}
