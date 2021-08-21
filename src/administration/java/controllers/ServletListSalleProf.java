package administration.java.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererSalleImpl;
import administration.java.models.salle;

/**
 * Servlet implementation class ServletListSalleProf
 */
@WebServlet({"/listSalleProf","/listSalleProfFiltre"})
public class ServletListSalleProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListSalleProf() {
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
		if(path.equals("/listSalleProfFiltre")) {
			salle s=new salle();
			String date = request.getParameter("date");
	        java.sql.Date date_res = Date.valueOf(date);
	        String creneau=request.getParameter("creneau");
			ArrayList<salle> list =s.filterSalles(e.listSalleFiltrer(date_res,creneau)) ;
			request.setAttribute("date", date_res);
			request.setAttribute("crenau", creneau);
			request.setAttribute("listSalle", list);
			this.getServletContext().getRequestDispatcher("/listSalleProf.jsp").forward(request,response);
		}else if (path.equals("/listSalleProf")) {
			ArrayList<salle> list =e.listSalle() ;
			request.setAttribute("listSalle", list);
			this.getServletContext().getRequestDispatcher("/listSalleProf.jsp").forward(request,response);
		}
		
	}

}
