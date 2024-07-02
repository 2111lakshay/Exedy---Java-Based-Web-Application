<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
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
    
    .error-alert {
      position: relative;
    }

    .error-alert .close {
      position: absolute;
      top: 0;
      right: 0;
      padding: 0.5rem 1rem;
    }
  </style>
</head>
<body>
<a href="Home.jsp" class="btn btn-danger exit-button">Exit</a>
<% String errorMessagel = (String) request.getAttribute("errorMessagel"); %>

<% if (errorMessagel != null && !errorMessagel.isEmpty()) { %>
  <div class="alert alert-danger text-center error-alert">
    <%= errorMessagel %>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close" onclick="closeErrorAlert(this)">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
<% } %>
  <div class="login-container">
    <h2 class="text-center">Login</h2>
    <form action="LoginServlet" method="POST">
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" required>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" required>
      </div>
      <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block" name="login-button" id="login-button">Login</button>
      </div>
      <p class="text-center">Don't have an account? <a href="Regi.jsp">Register</a></p>
    </form>
  </div>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/js/bootstrap.min.js"></script>
    <script>
    function closeErrorAlert(button) {
      var alert = button.closest('.error-alert');
      alert.remove();
    }
  </script>
</body>
</html>
