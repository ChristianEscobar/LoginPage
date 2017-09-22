package org.web.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.web.login.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("userName");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");
			
			RegisterService registerService = new RegisterService();
			
			if(!registerService.userAlreadyExists(lastName, firstName) && !registerService.userNameAlreadyExists(userName)) {
			
				registerService.registerNewUser(lastName, firstName, userName, password); 
		
				response.sendRedirect("login.jsp");
			}
			else {
				//TODO Change this so a message is sent back to registration page instead of redirecting to a new page
				response.sendRedirect("userExists.jsp");
			}
			
			return;
		}
		catch(Exception ex) {
			throw new ServletException("Encountered user registration error.\n" + ex.getMessage());
		}
	}

}
