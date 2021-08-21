package administration.java.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.dao.GererProf_impl;
import administration.java.models.Matieres;
import administration.java.models.etudiant;
import administration.java.models.professeur;

/**
 * Servlet implementation class ServletFilterProf
 */
@WebServlet("/filtreProf")
public class ServletFilterProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFilterProf() {
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
		GererProf_impl e=new GererProf_impl();
		ArrayList<Matieres> mat=e.listMat();
		request.setAttribute("listMat", mat);
		String nomMat=request.getParameter("nom_mat");
		System.out.println("nom de la matieere"+ nomMat);
		int id_mat=e.getMat(nomMat);
		System.out.println("id mat entreerrr"+id_mat);
		ArrayList<professeur> listProfFilt =e.listProfFilt(id_mat);
		request.setAttribute("listProfess", listProfFilt);
		this.getServletContext().getRequestDispatcher("/listeProf.jsp").forward(request,response);
	}

}
