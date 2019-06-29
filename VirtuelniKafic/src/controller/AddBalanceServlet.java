package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dao.LoginDAO;
import model.User;

/**
 * Servlet implementation class AddBalanceServlet
 */
@WebServlet(description = "dodavanje novca u novcanik", urlPatterns = { "/AddBalanceServlet" })
public class AddBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String balance = request.getParameter("balance");
		
		LoginDAO ld = new LoginDAO();
		
		boolean proveriUsername = ld.daLiPostojiUserUbazi(userName);
		
		if(proveriUsername) {
			//idemo dalje
			User user = ld.vratiUsera(userName);
			boolean dodajNovac = AdminDAO.dodajUnovcanik(user, balance);
				if(dodajNovac) {
					response.sendRedirect("view/administrator.jsp");
				}else {
					response.sendRedirect("view/addBalanceError.jsp");
				}	
		}else {
			response.sendRedirect("view/addBalanceError.jsp");
		}
		
		
		
	}

}
