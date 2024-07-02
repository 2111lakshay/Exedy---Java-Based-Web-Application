<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Feedback</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            padding: 20px;
        }

        .container {
            max-width: 600px;
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

        .btn-submit {
            display: block;
            width: 100%;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Product Feedback</h1>
    <form action="SubmitFeedbackServlet" method="POST">
        <div class="form-group">
            <label for="productId">Product ID:</label>
            <input type="text" id="productId" name="productId" class="form-control" readonly
                   value="<%= request.getParameter("id") %>">
            <input type="hidden" name="userid" value=<%=request.getParameter("userid") %>>
        </div>
        <div class="form-group">
            <label for="feedback">Feedback:</label>
            <textarea id="feedback" name="feedback" rows="5" class="form-control" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary btn-submit">Submit Feedback</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
