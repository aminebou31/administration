package administration.java.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import administration.java.dao.GererEtudiant;
import administration.java.dao.GererProf_impl;
import administration.java.models.Matieres;
import administration.java.models.etudiant;

/**
 * Servlet implementation class ServletListEtuProf
 */
@WebServlet({"/listEtuProf","/listEtuProfFil"})
public class ServletListEtuProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListEtuProf() {
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
		String path =request.getServletPath();
		if(path.equals("/listEtuProf")) {
			HttpSession session=request.getSession();
			System.out.println("ce que je veut"+session.getAttribute("user1"));
			Matieres ma=new Matieres();
			GererEtudiant e=new GererEtudiant();
			GererProf_impl m=new GererProf_impl();
			ArrayList<Matieres> mat=ma.filterMatieres(m.listMat());
			request.setAttribute("listMat", mat);
			ArrayList<etudiant> list =e.listEt() ;
			request.setAttribute("listEtu", list);
			this.getServletContext().getRequestDispatcher("/listEtuProf.jsp").forward(request,response);
		}else if(path.equals("/listEtuProfFil")) {
			Matieres ma=new Matieres();
			GererEtudiant e=new GererEtudiant();
			GererProf_impl m=new GererProf_impl();
			String nom_mat=request.getParameter("nom_mat");
			int id_mat=e.getIdMat(nom_mat);
			ArrayList<Matieres> mat=ma.filterMatieres(m.listMat());
			request.setAttribute("listMat", mat);
			//String nom=request.getParameter("nom_etu");
			ArrayList<etudiant> list =e.listEtuFiltrerProf(id_mat) ;
			request.setAttribute("listEtu", list);
			this.getServletContext().getRequestDispatcher("/listEtuProf.jsp").forward(request,response);
		}
		
		
	}

}
