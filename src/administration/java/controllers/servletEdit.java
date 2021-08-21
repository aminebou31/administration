package administration.java.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.models.etudiant;

/**
 * Servlet implementation class ServletAjout
 */
@WebServlet("/editEtu")
public class servletEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletEdit() {
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
		GererEtudiant e=new GererEtudiant();
		
		int id=Integer.parseInt(request.getParameter("idEtudiant"));
		etudiant etudiant=e.getEtu(id);
		request.setAttribute("id_etu", id);
		request.setAttribute("infoEtu", etudiant);
		ArrayList<String> listSem =e.listSem(etudiant.getId_filiere());
		request.setAttribute("listSem", listSem);
		this.getServletContext().getRequestDispatcher("/modifierEtu.jsp").forward(request,response);
	}
}
