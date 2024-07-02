<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Add Product</title>
<style>
.card-body {
    background-color: #ffba49;
}

form {
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
}

.btn-primary,
.btn-secondary,
.btn-danger {
    margin-right: 10px;
}
</style>
</head>
<body>
    <h1>Add Product</h1>
    <div class="card">
        <div class="card-body">
            <form action="AddProductServlet" method="POST">
                <input type="hidden" name="userid" value="<%=Integer.parseInt(request.getParameter("userid"))%>">
                <div class="form-group">
                    <label for="productName">Product Name:</label>
                    <input type="text" id="productName" name="productName" class="form-control">
                </div>
                <div class="form-group">
                    <label for="functionality">Functionality:</label>
                    <input type="number" id="functionality" name="functionality" class="form-control" min="0" max="5">
                </div>
                <div class="form-group">
                    <label for="performance">Performance:</label>
                    <input type="number" id="performance" name="performance" class="form-control" min="0" max="5">
                </div>
                <div class="form-group">
                    <label for="usability">Usability:</label>
                    <input type="number" id="usability" name="usability" class="form-control" min="0" max="5">
                </div>
                <div class="form-group">
                    <label for="cost">Cost:</label>
                    <input type="number" id="cost" name="cost" class="form-control" min="0" max="5">
                </div>
                <div class="form-group">
                    <label for="value">Value:</label>
                    <input type="number" id="value" name="value" class="form-control" min="0" max="5">
                </div>
                <div class="form-group">
                    <label for="environmentalImpact">Environmental Impact:</label>
                    <input type="number" id="environmentalImpact" name="environmentalImpact" class="form-control" min="0" max="5">
                </div>
                <div class="form-group">
                    <label for="customerFeedback">Customer Feedback:</label>
                    <input type="number" id="customerFeedback" name="customerFeedback" class="form-control" min="0" max="5">
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
                <a href="User.jsp?userid=<%=Integer.parseInt(request.getParameter("userid"))%>" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
