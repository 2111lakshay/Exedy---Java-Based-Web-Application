<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.exedy.Product" %>
<%@ page import="com.exedy.ProductDAO" %>
<%@ page import="com.exedy.Feedback" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Product Details</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <style>
    body {
      padding: 20px;
    }
    h1 {
      margin-bottom: 20px;
      text-align: center;
    }
    .product-card {
      max-width: 500px;
      margin: 0 auto;
      background-color: #ffffff;
      border-radius: 4px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      padding: 20px;
      margin-bottom: 20px;
    }
    .product-card h2 {
      color: #007bff;
      margin-top: 0;
      margin-bottom: 20px;
      font-size: 24px;
      text-align: center;
    }
    .product-card p {
      margin: 0;
      color: #666666;
    }
    .product-card .label {
      font-weight: bold;
      color: #333333;
      margin-bottom: 5px;
    }
    .review-card {
      max-width: 500px;
      margin: 0 auto;
      background-color: #ffffff;
      border-radius: 4px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      padding: 20px;
      margin-bottom: 20px;
    }
    .review-card .username {
      font-weight: bold;
      font-size: 18px;
    }
    .review-card .review {
      margin-top: 10px;
      color: #666666;
    }
    .container{
box-sizing: border-box;

	background-color: #ffba49;
}
  </style>
</head>
<body>
  <div class="container">
    <h1>Product Details</h1>

    <%-- Retrieve the product ID from the URL parameter --%>
    <% String productIdParam = request.getParameter("productId");
       if (productIdParam != null) {
         int productId = Integer.parseInt(productIdParam);

         // Fetch the product data from the database
         ProductDAO productDAO = new ProductDAO();
         Product product = productDAO.getProductById(productId);

         if (product != null) {
    %>
    <div class="product-card">
      <h2><%= product.getProductName() %></h2>
      <p class="label">Product ID:</p>
      <p><%= product.getProductId() %></p>
      <p class="label">Functionality:</p>
      <p><%= product.getFunctionality() %></p>
      <p class="label">Performance:</p>
      <p><%= product.getPerformance() %></p>
      <p class="label">Usability:</p>
      <p><%= product.getUsability() %></p>
      <p class="label">Cost:</p>
      <p><%= product.getCost() %></p>
      <p class="label">Value:</p>
      <p><%= product.getValue() %></p>
      <p class="label">Environmental Impact:</p>
      <p><%= product.getEnvironmentalImpact() %></p>
      <p class="label">Customer Feedback:</p>
      <p><%= product.getCustomerFeedback() %></p>
    </div>

    <%-- Retrieve and display user reviews --%>
    <h2>Customer Feedback</h2>
    <% List<Feedback> reviews = productDAO.getReviewsByProductId(productId);
       if (reviews != null && !reviews.isEmpty()) {
         for (Feedback review : reviews) {
    %>
    <div class="review-card">
      <p class="username">from <%= review.getUserName()%></p>
      <p class="review"><%= review.getFeedbackText() %></p>
    </div>
    <% }
       } else { %>
    <div class="alert alert-info" role="alert">
      No reviews available for this product.
    </div>
    <% }
       } else { %>
    <div class="alert alert-danger" role="alert">
      No product found with the specified ID.
    </div>
    <% }
       } else { %>
    <div class="alert alert-warning" role="alert">
      No product ID provided.
    </div>
    <% } %>
  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
