package administration.java.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import administration.java.dao.GererEtudiant;
import administration.java.models.doc_etu;

/**
 * Servlet implementation class ServletAjout
 */
@WebServlet({"/ajouterDocEtu","/ajouterDoc"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ServletAjouterDocEtu extends HttpServlet {
	private static final long serialVersionUID = 1L;
    InputStream inputStream1;
    InputStream inputStream2;
    InputStream inputStream3;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjouterDocEtu() {
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
		System.out.println("path : "+ path);
		
		
		
		if(path.equals("/ajouterDocEtu")) {
		GererEtudiant a=new GererEtudiant();
		System.out.println("test : " + request.getParameter("idEt"));
	    int idEt = Integer.parseInt(request.getParameter("idEt"));
		System.out.println("idEt : " + idEt);
		Part filePart1 = request.getPart("photo");
		Part filePart2 = request.getPart("baccalaureat");
		Part filePart3 = request.getPart("relevee de note");

		if (filePart1 != null && filePart2 != null && filePart3 != null) {

			System.out.println(filePart1.getName());

			inputStream1 = filePart1.getInputStream();
			inputStream2 = filePart2.getInputStream();
			inputStream3 = filePart3.getInputStream();
			
		}
		doc_etu doc1=new doc_etu();
		doc1.setId_etu(idEt);
		doc1.setDoc(inputStream1);
		doc1.setNom("photo");
		a.ajoutDocEtu(doc1);
		
		doc_etu doc2=new doc_etu();
		doc2.setId_etu(idEt);
		doc2.setDoc(inputStream2);
		doc2.setNom("baccalaureat");
		a.ajoutDocEtu(doc2);
		
		doc_etu doc3=new doc_etu();
		doc3.setId_etu(idEt);
		doc3.setDoc(inputStream3);
		doc3.setNom("relevee de note");
		a.ajoutDocEtu(doc3);
		
		this.getServletContext().getRequestDispatcher("/listetu").forward(request,response);
		}
		else if(path.equals("/ajouterDoc")) {
			int idEt = Integer.parseInt(request.getParameter("idEtudiant"));
			System.out.println("idEt : " + idEt);
			request.setAttribute("idEt", idEt);
			request.getRequestDispatcher("ajouterDocEtu.jsp").forward(request, response);

			
		}
	}
}
