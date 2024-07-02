<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Panel</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <style>
    .exit-button {
        position: absolute;
        top: 10px;
        right: 10px;
    }
    .login-container {
      max-width: 400px;
      margin: 0 auto;
      margin-top: 100px;
      padding: 20px;
      border: 1px solid #ddd;
      border-radius: 4px;
      background-color: #ffba49;
    }
    
.button-group{
margin-bottom: 10px;
}
  </style>
</head>
<body>
<a href="AdminLogin.jsp" class="btn btn-danger exit-button">Exit</a>
  <div class="login-container">
    <h2 class="text-center">Admin Panel</h2>
    <div class="button-group">
      <a href="UserDetails.jsp" class="btn btn-primary btn-block">User Details</a>
    </div>
    <div class="button-group">
      <a href="ProductDetails.jsp" class="btn btn-primary btn-block">Product Details</a>
    </div>
    <div class="button-group">
      <a href="AnalystDetails.jsp" class="btn btn-primary btn-block">Analyst Details</a>
    </div>
  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/js/bootstrap.min.js"></script>
</body>

</html>
