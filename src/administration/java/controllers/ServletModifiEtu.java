package administration.java.controllers;

import java.io.IOException;

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
@WebServlet("/modifierEtu")
public class ServletModifiEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifiEtu() {
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
		
		GererEtudiant a=new GererEtudiant();
		int id=Integer.parseInt(request.getParameter("id"));
		String NomFr = request.getParameter("nomFr");
		String NomAr = request.getParameter("nomAr");
		String PrenomFr = request.getParameter("prenomFr");
		String PrenomAr = request.getParameter("prenomAr");
		String nomsem=request.getParameter("nomSem");
		int id_sem=a.getIdSem(nomsem);
		System.out.println("haaaaaak"+id_sem);
		etudiant e = new etudiant();
		e.setId_etu(id);
		e.setNomFr(NomFr);
		e.setNomAr(NomAr);
		e.setPrenomAr(PrenomAr);
		e.setPrenomFr(PrenomFr);
		e.setId_sem(id_sem);
		a.modifierEtu(e);
		
		this.getServletContext().getRequestDispatcher("/listetu").forward(request,response);
	}
}
