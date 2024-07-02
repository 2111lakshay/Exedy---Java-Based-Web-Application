<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.List"%>
<%@ page import="com.exedy.Product"%>
<%@ page import="com.exedy.ProductDAO"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>User Page</title>
<style>
.exit-button {
	position: absolute;
	top: 10px;
	right: 10px;
}

.exit-button a {
	display: inline-block;
	padding: 6px 12px;
	background-color: red;
	color: #ffffff;
	text-decoration: none;
	border-radius: 4px;
}

.add-button {
	position: absolute;
	top: 10px;
	left: 10px;
}

.add-button a {
	display: inline-block;
	padding: 6px 12px;
	background-color: green;
	color: #ffffff;
	text-decoration: none;
	border-radius: 4px;
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

.card {
	border: 1px solid #dddddd;
	border-radius: 4px;
	padding: 10px;
	margin-bottom: 20px;
	background-color: #ffba49;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.card h2 {
	margin-top: 0;
	color: #007bff;
}

.card h3 {
	margin-bottom: 10px;
	color: #333333;
}

.card p {
	margin: 0;
	color: #666666;
}

.pagination {
	display: flex;
	justify-content: center;
	margin-top: 20px;
}

.pagination a {
	display: inline-block;
	margin-right: 10px;
	padding: 6px 12px;
	background-color: #007bff;
	color: #ffffff;
	text-decoration: none;
	border-radius: 4px;
}

.pagination a:hover {
	background-color: #0056b3;
}

.pagination .active {
	background-color: #0056b3;
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

	<div class="add-button">
		<a
			href="AddProduct.jsp?userid=<%=request.getParameter("userid") != null ? Integer.parseInt(request.getParameter("userid")) : ""%>"
			style="background-color: blue;">Add</a>


	</div>
	<div class="exit-button">
		<a href="GenerateReportServlet" style="background-color: green;">Generate
			whole Report</a> <a href="Login.jsp" style="background-color: red;">Exit</a>
	</div>
	<h1>Product Viewer</h1>
	<%
	ProductDAO productDAO = new ProductDAO();
	List<Product> productList = productDAO.getAllProducts();

	int itemsPerPage = 5; // Number of products to display per page
	int currentPage = 1; // Current page number
	int totalItems = productList.size(); // Total number of products

	String pageParam = request.getParameter("page");
	if (pageParam != null) {
		currentPage = Integer.parseInt(pageParam);
	}

	int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

	int startItem = (currentPage - 1) * itemsPerPage;
	int endItem = Math.min(startItem + itemsPerPage, totalItems);

	List<Product> paginatedList = productList.subList(startItem, endItem);

	int uid = Integer.parseInt(request.getParameter("userid"));
	%>

	<%
	for (Product product : paginatedList) {
		if (product != null) {
	%>
	<a
		href="Product.jsp?productId=<%=product.getProductId()%>&userid=<%=uid%>">
		<div class="card">
			<div class="card-body">
				<h2>
					Product
					<%=product.getProductId()%></h2>
				<h3><%=product.getProductName()%></h3>
				<p>
					Functionality:
					<%=product.getFunctionality()%></p>
				<p>
					Performance:
					<%=product.getPerformance()%></p>
				<p>
					Usability:
					<%=product.getUsability()%></p>
				<p>
					Cost:
					<%=product.getCost()%></p>
				<p>
					Value:
					<%=product.getValue()%></p>
				<p>
					Environmental Impact:
					<%=product.getEnvironmentalImpact()%></p>
				<p>
					Customer Feedback:
					<%=product.getCustomerFeedback()%></p>

				<div style="margin-top: 10px;">
					<form action="DeleteProductServlet" method="POST"
						style="display: inline;">
						<input type="hidden" name="productId"
							value="<%=product.getProductId()%>"> <input type="hidden"
							name="userid" value="<%=uid%>">
						<button type="submit" class="btn btn-danger btn-sm">Delete</button>
					</form>
					<a class="btn btn-primary btn-sm" 
						href="UpdateProduct.jsp?id=<%=product.getProductId()%>&userid=<%=uid%>">Update</a>

					<a class="btn btn-secondary btn-sm"
						href="FeedbackProduct.jsp?id=<%=product.getProductId()%>&userid=<%=uid%>">Feedback</a>

					<form action="GenerateReportServlet" method="GET"
						style="display: inline;">
						<input type="hidden" name="productId"
							value="<%=product.getProductId()%>">
						<button type="submit" class="btn btn-success btn-sm">Generate
							Report</button>
					</form>
				</div>
			</div>
		</div>
	</a>
	<%
	}
	}
	%>

	<!-- Pagination links -->
	<div class="pagination">
		<%
		if (currentPage > 1) {
		%>
		<a
			href="?page=<%=currentPage - 1%>&userid=<%=request.getParameter("userid")%>">&laquo;
			Previous</a>
		<%
		}
		%>

		<%
		for (int i = 1; i <= totalPages; i++) {
		%>
		<%
		if (i == currentPage) {
		%>
		<a href="?page=<%=i%>&userid=<%=request.getParameter("userid")%>"
			class="active"><%=i%></a>
		<%
		} else {
		%>
		<a href="?page=<%=i%>&userid=<%=request.getParameter("userid")%>"><%=i%></a>
		<%
		}
		%>
		<%
		}
		%>

		<%
		if (currentPage < totalPages) {
		%>
		<a
			href="?page=<%=currentPage + 1%>&userid=<%=request.getParameter("userid")%>">Next
			&raquo;</a>
		<%
		}
		%>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
