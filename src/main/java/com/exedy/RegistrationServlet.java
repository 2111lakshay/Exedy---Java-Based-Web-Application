package com.exedy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = "user";
		
		UserDAO add = new UserDAO();
		boolean flag = add.registerUser(username, password, email, fullName, usertype);
		if(flag) {
			response.sendRedirect("Login.jsp");
		}
		else {
			String errorMessage = "something went wrong";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("Regi.jsp").forward(request, response);

		}

	}

}
