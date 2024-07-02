<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Home</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="CSS/style.css">
<style>
.main {
  background: #ffff;
  padding: 50px 0; }

.container{
box-sizing: border-box;

	background-color: #ffba49;
}
a {
    text-decoration: none;
    
  }

a:hover {
    text-decoration: none;
  }
  
</style>
</head>
<body>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Welcome to the Home</h2> 
						<button type="button" class="btn btn-outline-light btn-sm"><a href="Login.jsp">Login</a></button>
						<button type="button" class="btn btn-outline-light btn-sm"><a href="AdminLogin.jsp">Admin</a></button>
						<button type="button" class="btn btn-outline-light btn-sm"><a href="Viewer.jsp">Viewer</a></button>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/exedy.png" alt="sign up image" style="max-width: 62%; height: fit-content;">
						</figure>
					</div>
				</div>
			</div>
		</section>
	</div>

	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
