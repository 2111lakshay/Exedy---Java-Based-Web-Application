package com.exedy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminDeleteProductServlet
 */
@WebServlet("/AdminDeleteProductServlet")
public class AdminDeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		ProductDAO productDAO = new ProductDAO();
        

        // Delete the product from the database
        productDAO.deleteProductFromDatabase(productId);
        

        
            // Display an error message or handle the error case accordingly
        	
            response.sendRedirect("ProductDetails.jsp");
        
    
	}

}
