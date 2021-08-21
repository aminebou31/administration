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
import administration.java.dao.LoginCheck;
import administration.java.models.Utilisateur;
import administration.java.models.etudiant;

/**
 * Servlet implementation class controller
 */
@WebServlet({ "/login","/home", "/logout" })
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/logout")) {
			request.getSession().invalidate();
			this.getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
		} else if (path.equals("/login")) {
			this.getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
		}else if(path.equals("/home")) {
			HttpSession session = request.getSession();
			Utilisateur u = (Utilisateur)session.getAttribute("user");
			if (u.getRole().equals("admin")) {
				this.getServletContext().getRequestDispatcher("/AdminPage.jsp").forward(request, response);
			} else if (u.getRole().equals("prof")) {
				this.getServletContext().getRequestDispatcher("/listEtuProf").forward(request, response);
			} else if (u.getRole().equals("etudiant")) {
				this.getServletContext().getRequestDispatcher("/EtudiantPage.jsp").forward(request, response);
			}
		}else {
			response.sendError(0);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/login")) {
			String email = request.getParameter("username");
			String mdp = request.getParameter("mdp");
			Utilisateur u = new Utilisateur();
			u.setEmail(email);
			u.setMdp(mdp);
			LoginCheck check = new LoginCheck();
			u.setRole(check.getRole(u));
			boolean login = check.checkUtil(u);
			String erreur = "Username or password was incorrect, please try again";
			if (login) {
				request.setAttribute("user", u.getEmail());
				HttpSession session = request.getSession();
				session.setAttribute("user", u);
				if (u.getRole().equals("admin")) {
					this.getServletContext().getRequestDispatcher("/AdminPage.jsp").forward(request, response);
				} else if (u.getRole().equals("prof")) {
					session.setAttribute("user1", check.getidProf(u));
					this.getServletContext().getRequestDispatcher("/listEtuProf").forward(request, response);
				} else if (u.getRole().equals("etudiant")) {
					this.getServletContext().getRequestDispatcher("/EtudiantPage.jsp").forward(request, response);
				}
				
			} else {
				request.setAttribute("erreur", erreur);
				this.getServletContext().getRequestDispatcher("/view.jsp").forward(request, response);
			}
		} else {
			response.sendError(0);
		}
	}

}
