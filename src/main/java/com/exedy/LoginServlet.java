package com.exedy;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userdao = new UserDAO();
        try {
            if (userdao.isValidUser(username, password)) {
                User user = userdao.getUserByUsername(username);
                String userType = user.getUserType();
                int userid = user.getId();

                if (userType.equals("user")) {
                	response.sendRedirect("User.jsp?userid=" + userid);
                } else if (userType.equals("analyst")) {
                	response.sendRedirect("Analyst.jsp?userid=" + userid);
                } else {
                    response.sendRedirect("home.jsp");
                }
            } else {
            	String errorMessagel = "Invalid username or password. Please try again.";
                request.setAttribute("errorMessagel", errorMessagel);
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
