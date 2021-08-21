package administration.java.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.dao.GererProf_impl;
import administration.java.dao.LoginCheck;
import administration.java.models.Matieres;
import administration.java.models.Utilisateur;
import administration.java.models.etudiant;
import administration.java.models.professeur;

/**
 * Servlet implementation class ServletAjoutProf
 */
@WebServlet({"/ajoutProf","/ajouterProf"})
public class ServletAjoutProf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutProf() {
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
		String path = request.getServletPath();
		if(path.equals("/ajoutProf")) {
			GererProf_impl a=new GererProf_impl();
			Matieres ma=new Matieres();
			LoginCheck l=new LoginCheck();
			String Nom = request.getParameter("Nom");
			String Prenom = request.getParameter("Prenom");
			String matiere = request.getParameter("matiereAFF");
			int id_mat=a.getMat(matiere);
			int tel=Integer.parseInt(request.getParameter("tel"));
			String username = request.getParameter("username");
			System.out.println("nom proooof"+Nom);
			System.out.println("prenom proooof"+Prenom);
			String password = request.getParameter("password");
			professeur e=new professeur(Nom, tel,Prenom, username);
			a.ajouterProf(e,id_mat);
			Utilisateur u =new Utilisateur(username,password,"prof");
			int id_prof=a.getProfByTel(tel);
			ArrayList<Matieres> mat=ma.filterMatieres(a.listMat());
			request.setAttribute("listMat", mat);
			l.ajouterUtilProf(u,id_prof);
			
			this.getServletContext().getRequestDispatcher("/ajouterProf.jsp").forward(request,response);
		}else if(path.equals("/ajouterProf")) {
			GererProf_impl a=new GererProf_impl();
			Matieres ma=new Matieres();
			ArrayList<Matieres> mat=ma.filterMatieres(a.listMat());
			request.setAttribute("listMat", mat);
			this.getServletContext().getRequestDispatcher("/ajouterProf.jsp").forward(request,response);
		}
		}

}
