package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;

/**
 * Servlet implementation class AddArtikalServlet
 */
@WebServlet(description = "dodavanje artiakala u bazu", urlPatterns = { "/AddArtikalServlet" })
public class AddArtikalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String imeArtikla = request.getParameter("imeArtikla");
		String cena = 		request.getParameter("cena");
		String stanje = 	request.getParameter("stanje");
		String popust = 	request.getParameter("popust");
		
		boolean upisiArtikal = AdminDAO.ubaciArtikalUBazu(imeArtikla, cena, stanje, popust);
			
			if(upisiArtikal) {
				response.sendRedirect("view/administrator.jsp");
			}else {
				response.sendRedirect("view/addArtikal.jsp");
			}
	
	}

}
