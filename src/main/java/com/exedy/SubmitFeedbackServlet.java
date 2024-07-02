package com.exedy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmitFeedbackServlet
 */
@WebServlet("/SubmitFeedbackServlet")
public class SubmitFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the feedback data from the request parameters
        int productId = Integer.parseInt(request.getParameter("productId"));
        int userid = Integer.parseInt(request.getParameter("userid"));
        String feedbackText = request.getParameter("feedback");
        
        ProductDAO productDAO = new ProductDAO();
        boolean flag = productDAO.addFeedback(productId, userid, feedbackText);

        if(flag) {
        	response.sendRedirect("User.jsp?userid=" + userid);
        }
        else {
        	response.getWriter().println("Failed to give product feedback.");
        }
        

	}

}
