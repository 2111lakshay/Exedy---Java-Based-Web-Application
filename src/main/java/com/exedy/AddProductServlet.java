 package com.exedy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		// Retrieve form data
		int userid = Integer.parseInt(request.getParameter("userid"));
	    String productName = request.getParameter("productName");
	    double functionality = 0.0;
	    double performance = 0.0;
	    double usability = 0.0;
	    double cost = 0.0;
	    double value = 0.0;
	    double environmentalImpact = 0.0;
	    double customerFeedback = 0.0;

	    // Check if optional fields are provided and parse their values if available
	    String functionalityParam = request.getParameter("functionality");
	    if (functionalityParam != null && !functionalityParam.isEmpty()) {
	        functionality = Double.parseDouble(functionalityParam);
	    }

	    String performanceParam = request.getParameter("performance");
	    if (performanceParam != null && !performanceParam.isEmpty()) {
	        performance = Double.parseDouble(performanceParam);
	    }

	    String usabilityParam = request.getParameter("usability");
	    if (usabilityParam != null && !usabilityParam.isEmpty()) {
	        usability = Double.parseDouble(usabilityParam);
	    }

	    String costParam = request.getParameter("cost");
	    if (costParam != null && !costParam.isEmpty()) {
	        cost = Double.parseDouble(costParam);
	    }

	    String valueParam = request.getParameter("value");
	    if (valueParam != null && !valueParam.isEmpty()) {
	        value = Double.parseDouble(valueParam);
	    }

	    String environmentalImpactParam = request.getParameter("environmentalImpact");
	    if (environmentalImpactParam != null && !environmentalImpactParam.isEmpty()) {
	        environmentalImpact = Double.parseDouble(environmentalImpactParam);
	    }

	    String customerFeedbackParam = request.getParameter("customerFeedback");
	    if (customerFeedbackParam != null && !customerFeedbackParam.isEmpty()) {
	        customerFeedback = Double.parseDouble(customerFeedbackParam);
	    }

	    // Create a new Product object without setting the productId
	    Product product = new Product(productName, functionality, performance, usability, cost, value,
	            environmentalImpact, customerFeedback, userid);

	    // Add the product to the database
	    ProductDAO productDAO = new ProductDAO();
	    UserDAO userDAO = new UserDAO();
	    productDAO.addProduct(product);	    
	    String userType = userDAO.getUserType(userid);
	    
	    if (userType.equals("user")) {
	    	response.sendRedirect("User.jsp?userid="+userid);

	    } else if (userType.equals("analyst")) {
	    	response.sendRedirect("Analyst.jsp?userid="+userid);
	    
	    } else {
	    	response.getWriter().println("Failed to add the product.");
	    }
	    
	    
    }
}
