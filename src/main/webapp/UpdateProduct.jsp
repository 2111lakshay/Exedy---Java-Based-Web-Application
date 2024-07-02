<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.exedy.Product"%>
<%@ page import="com.exedy.ProductDAO"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Update Product</title>
<style>
.card{
background-color: #ffba49;
}
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        padding: 20px;
    }

    .container {
        max-width: 800px;
        margin: 0 auto;
        background-color: #ffba49;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
        color: #333333;
    }

    .form-group {
        margin-bottom: 20px;
        background-color: #ffba49;
    }

    .btn-primary,
    .btn-secondary,
    .btn-danger {
        margin-right: 10px;
    }
</style>
<script>
    function validateForm() {
        var functionality = document.getElementById("functionality").value;
        var performance = document.getElementById("performance").value;
        var usability = document.getElementById("usability").value;
        var cost = document.getElementById("cost").value;
        var value = document.getElementById("value").value;
        var environmentalImpact = document.getElementById("environmentalImpact").value;
        var customerFeedback = document.getElementById("customerFeedback").value;

        if (
            functionality < 0 ||
            functionality > 5 ||
            performance < 0 ||
            performance > 5 ||
            usability < 0 ||
            usability > 5 ||
            cost < 0 ||
            cost > 5 ||
            value < 0 ||
            value > 5 ||
            environmentalImpact < 0 ||
            environmentalImpact > 5 ||
            customerFeedback < 0 ||
            customerFeedback > 5
        ) {
            alert("Please enter values between 0 and 5 for the ratings.");
            return false;
        }
    }
</script>
</head>
<body>

<h1>Update Product</h1>

<%
    String userid = request.getParameter("userid");
    String productIdParam = request.getParameter("id");
    if (productIdParam != null) {
        int productId = Integer.parseInt(productIdParam);

        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);
%>

<div class="card">
    <div class="card-body">
        <form action="UpdateProductServlet" method="POST" onsubmit="return validateForm();">
            <input type="hidden" name="userid" value="<%=userid%>">
            <input type="hidden" name="productId" value="<%=product.getProductId()%>">
            <div class="form-group">
                <label for="productName">Product Name:</label>
                <input type="text" id="productName" name="productName" value="<%=product.getProductName()%>"
                       class="form-control">
            </div>
            <div class="form-group">
                <label for="functionality">Functionality:</label>
                <input type="number" id="functionality" name="functionality" min="0" max="5"
                       value="<%=product.getFunctionality()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="performance">Performance:</label>
                <input type="number" id="performance" name="performance" min="0" max="5"
                       value="<%=product.getPerformance()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="usability">Usability:</label>
                <input type="number" id="usability" name="usability" min="0" max="5"
                       value="<%=product.getUsability()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="cost">Cost:</label>
                <input type="number" id="cost" name="cost" min="0" max="5" value="<%=product.getCost()%>"
                       class="form-control">
            </div>
            <div class="form-group">
                <label for="value">Value:</label>
                <input type="number" id="value" name="value" min="0" max="5" value="<%=product.getValue()%>"
                       class="form-control">
            </div>
            <div class="form-group">
                <label for="environmentalImpact">Environmental Impact:</label>
                <input type="number" id="environmentalImpact" name="environmentalImpact" min="0" max="5"
                       value="<%=product.getEnvironmentalImpact()%>" class="form-control">
            </div>
            <div class="form-group">
                <label for="customerFeedback">Customer Feedback:</label>
                <input type="number" id="customerFeedback" name="customerFeedback" min="0" max="5"
                       value="<%=product.getCustomerFeedback()%>" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
            <a href="User.jsp" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</div>

<%
    }
%>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
