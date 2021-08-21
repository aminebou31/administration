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
import administration.java.models.etudiant;

/**
 * Servlet implementation class servletListEtu
 */
@WebServlet("/listetu")
public class servletListEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListEtu() {
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
		HttpSession session=request.getSession();
		System.out.println("ce que je veut"+session.getAttribute("user1.getId_prof()"));
		ArrayList<String> listFil =e.listFil();
		request.setAttribute("listFil", listFil);
		ArrayList<String> listSem =e.listSem(1);
		request.setAttribute("listSem", listSem);
		ArrayList<etudiant> list =e.listEt() ;
		request.setAttribute("listEtu", list);
		this.getServletContext().getRequestDispatcher("/listEtu.jsp").forward(request,response);
		
	}

}
