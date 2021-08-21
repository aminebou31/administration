package administration.java.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import administration.java.dao.GererEtudiant;
import administration.java.dao.LoginCheck;
import administration.java.models.Utilisateur;
import administration.java.models.etudiant;

/**
 * Servlet implementation class ServletAjout
 */
@WebServlet("/ServletAjout")
public class ServletAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date ok;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/view.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GererEtudiant a=new GererEtudiant();
		LoginCheck l=new LoginCheck();
		String NomFr = request.getParameter("NomFr");
		String NomAr = request.getParameter("NomAr");
		String PrenomFr = request.getParameter("PrenomFr");
		String PrenomAr = request.getParameter("PrenomAr");
		String Sexe = request.getParameter("sexe");
		String date = request.getParameter("dateN");
        java.sql.Date date_sql = Date.valueOf(date);
		String LieuNaissanceFR = request.getParameter("lieuN_fr");
		String LieuNaissanceAR = request.getParameter("lieuN_ar");
		String villeN = request.getParameter("villeN");
		String nationalite = request.getParameter("nationalite");
		String cin = request.getParameter("cin");
		String cne = request.getParameter("massarEtud");
		String filiere = request.getParameter("filiere");
		String sBac = request.getParameter("sBac");
		String mention = request.getParameter("mt");
		String lycee = request.getParameter("lycee");
		String villeBac = request.getParameter("villeBac");
		String academie = request.getParameter("acad");
		int anBac=Integer.parseInt(request.getParameter("anBac"));
		int id_sem=a.getIdSem(request.getParameter("nomSem"));
		etudiant e=new etudiant(NomAr,  PrenomAr,  NomFr,  PrenomFr,  nationalite,
				 LieuNaissanceAR,  LieuNaissanceFR,  villeN,  anBac,  mention,  lycee,
				 sBac,  villeBac,  academie,  cne,
				 cin,  date_sql,  Sexe);
		e.setId_filiere(a.getIdFil(filiere));
		e.setId_sem(id_sem);
		a.ajoutEtudiant(e);int id_etu=a.getEtuByCNE(cne);
		if(filiere.equals("BGI")) {
			a.affecterMatBgi(id_etu);
		}else if(filiere.equals("BGB")) {
			a.affecterMatBgb(id_etu);
		}else if(filiere.equals("BCA")) {
			a.affecterMatBca(id_etu);
		}
		
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		Utilisateur u =new Utilisateur(login,password,"etudiant");
		l.ajouterUtilEtu(u,id_etu);
		
		this.getServletContext().getRequestDispatcher("/ajouterEtu.jsp").forward(request,response);
	}
}
