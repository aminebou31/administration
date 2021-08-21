package administration.java.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.dao.GererSalleImpl;
import administration.java.models.salle;

/**
 * Servlet implementation class ServletAffecterMat
 */
@WebServlet("/affecterMat")
public class ServletAffecterMat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAffecterMat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	int id_etu=Integer.parseInt(request.getParameter("id_etu"));
    	request.setAttribute("id_etu", id_etu);
    	this.getServletContext().getRequestDispatcher("/affecterMatiere.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_etu=Integer.parseInt(request.getParameter("id_etu"));
		GererEtudiant a=new GererEtudiant();
		String descri = request.getParameter("nom_mat");
		a.affecterMat(id_etu,a.getIdMat(descri));
			
		this.getServletContext().getRequestDispatcher("/listetu").forward(request,response);
		
		}

}
