<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
      .exit-button {
        position: absolute;
        top: 10px;
        right: 10px;
    }
    .container{
box-sizing: border-box;

	background-color: #ffba49;
}
    </style>
</head>
<body>
<a href="Home.jsp" class="btn btn-danger exit-button">Exit</a>
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>

<% if (errorMessage != null && !errorMessage.isEmpty()) { %>
  <div class="alert alert-danger text-center error-alert">
    <%= errorMessage %>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close" onclick="closeErrorAlert(this)">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
<% } %>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3>Registration</h3>
                </div>
                <div class="card-body">
                    <form method="post" action="RegistrationServlet">
                        <div class="form-group">
                            <label for="fullName">Full Name</label>
                            <input type="text" class="form-control" name="fullName" placeholder="Enter your full name">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" name="email" placeholder="Enter your email">
                        </div>
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" class="form-control" name="username" placeholder="Enter your username">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" name="password" placeholder="Enter your password">
                        </div>
                        <button type="submit" class="btn btn-primary">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
 <script>
    function closeErrorAlert(button) {
      var alert = button.closest('.error-alert');
      alert.remove();
    }
  </script>

</body>
</html>
