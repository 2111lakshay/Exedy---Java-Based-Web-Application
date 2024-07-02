<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Error Page</title>
<!-- Include Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
	integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I"
	crossorigin="anonymous">
<!-- Include custom CSS -->
<style>
body {
	background-image:url("https://img.freepik.com/premium-vector/aper-cut-luxury-gold-background-with-dark-metal-texture-3d-abstract-style_206725-43.jpg");
	background-color: #f8f9fa;
	background-size: cover;
	background-repeat: no-repeat;
	background-position: center;
}

.error-container {
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	text-align: center;
	background-color: #ffba49;
}

.error-message {
	font-size: 4rem;
	font-weight: bold;
	color: #dc3545;
}
</style>
</head>
<body>
	<div class="error-container">
		<div class="error-message text-primary">
			<span>404</span> Page Not Found
		</div>
	</div>

	<!-- Include Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
