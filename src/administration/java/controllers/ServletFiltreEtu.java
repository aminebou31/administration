package administration.java.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.models.etudiant;

/**
 * Servlet implementation class ServletFiltreEtu
 */
@WebServlet("/filtreEtu")
public class ServletFiltreEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFiltreEtu() {
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
		GererEtudiant e=new GererEtudiant();
		ArrayList<String> listFil =e.listFil();
		request.setAttribute("listFil", listFil);
		ArrayList<String> listSem =e.listSem(1);
		request.setAttribute("listSem", listSem);
		String nomFil=request.getParameter("nomFil");
		String nomSem=request.getParameter("nomSem");
		int id_sem=e.getIdSem(nomSem);
		ArrayList<etudiant> listEtuFilt =e.listEtuFiltrer(id_sem,e.getIdFil(nomFil));
		request.setAttribute("listEtu", listEtuFilt);
		this.getServletContext().getRequestDispatcher("/listEtu.jsp").forward(request,response);
	}

}
