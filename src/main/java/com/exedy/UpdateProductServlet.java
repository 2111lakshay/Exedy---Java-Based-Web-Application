package com.exedy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve the form data
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        double functionality = Double.parseDouble(request.getParameter("functionality"));
        double performance = Double.parseDouble(request.getParameter("performance"));
        double usability = Double.parseDouble(request.getParameter("usability"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        double value = Double.parseDouble(request.getParameter("value"));
        double environmentalImpact = Double.parseDouble(request.getParameter("environmentalImpact"));
        double customerFeedback = Double.parseDouble(request.getParameter("customerFeedback"));
        int userid = Integer.parseInt(request.getParameter("userid"));

        // Create a new Product object with the updated data
        Product updatedProduct = new Product(productId, productName, functionality, performance, usability,
                cost, value, environmentalImpact, customerFeedback);

        // Update the product in the database
        ProductDAO productDAO = new ProductDAO();
        UserDAO userDAO = new UserDAO();
        boolean success = productDAO.updateProduct(updatedProduct);
        String userType = userDAO.getUserType(userid);

        // Redirect back to the product listing page with a success message
        if (success) {
        	if(userType.equals("user")) {
        		response.sendRedirect("User.jsp?userid=" + userid);
        	}
        	else if(userType.equals("analyst")) {
        		response.sendRedirect("Analyst.jsp?userid=" + userid);
        	}
            
        } else {
        	response.getWriter().println("Failed to update the product.");
        } 
	}

}
