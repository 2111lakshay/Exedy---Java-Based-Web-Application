package com.exedy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the product ID from the request parameter
        String productId = request.getParameter("productId");
        int userIdParam = Integer.parseInt(request.getParameter("userid"));

        ProductDAO productDAO = new ProductDAO();
        UserDAO userDAO = new UserDAO();

        // Delete the product from the database
        boolean deleteSuccessful = productDAO.deleteProductFromDatabase(productId);
        String userType = userDAO.getUserType(userIdParam);

        if (deleteSuccessful) {
        	if(userType.equals("user")){
        		response.sendRedirect("User.jsp?userid=" + userIdParam);
        	}
        	else if(userType.equals("analyst")) {
        		response.sendRedirect("Analyst.jsp?userid=" + userIdParam);
        	}
        	
        } else {
            // Display an error message or handle the error case accordingly
        	
            response.getWriter().println("Failed to delete the product.");
        }
    }


}
