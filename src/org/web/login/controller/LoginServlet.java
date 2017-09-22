package org.web.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.login.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			LoginService loginService = new LoginService();
			
			if(loginService.authenticateUser(userName, password)) {
				response.sendRedirect("home.jsp");
			}
			else {
				System.out.println("Invalid user name or password");
			}
		}
		catch(Exception ex) {
			throw new ServletException("Encountered user registration error.\n" + ex.getMessage());
		}
	}

}
