package administration.java.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererSalleImpl;
import administration.java.models.salle;

/**
 * Servlet implementation class ServletAjoutSalle
 */
@WebServlet("/ajoutSalle")
public class ServletAjoutSalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutSalle() {
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
		
			GererSalleImpl a=new GererSalleImpl();
			String descri = request.getParameter("description");
			salle s=new salle();
			s.setDescri(descri);
			a.ajouterSalle(s);
			
			this.getServletContext().getRequestDispatcher("/ajouterSalle.jsp").forward(request,response);
		
		}

}
