package com.exedy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserActionServlet")
public class UserActionServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int userId = Integer.parseInt(request.getParameter("id"));

        AdminDAO adminDAO = new AdminDAO();
        boolean success = false;

        if (action.equals("convertToAnalyst")) {
            try {
				success = adminDAO.convertToAnalyst(userId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (action.equals("convertToUser")) {
            try {
				success = adminDAO.convertToUser(userId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else if (action.equals("deleteUser")) {
            try {
				success = adminDAO.deleteUser(userId);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        if (success) {
            response.sendRedirect("UserDetails.jsp");
        } else {
            response.getWriter().println("Action failed!");
        }
    }
}
