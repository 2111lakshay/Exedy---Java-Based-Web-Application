<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.exedy.AdminDAO"%>
<%@ page import="com.exedy.User"%>
<!DOCTYPE html>
<html>
<head>
<title>User Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
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
	<div class="container mt-5">
		<h2 class="text-center">Analyst Details</h2>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Password</th>
					<th>Email</th>
					<th>Full Name</th>
					<th>User Type</th>
				</tr>
			</thead>
			<tbody>
				<%
				try {
					AdminDAO helper = new AdminDAO();
					List<User> userList = helper.getAnalystDetails();

					for (User user : userList) {
						int id = user.getId();
						String username = user.getUsername();
						String password = user.getPassword();
						String email = user.getEmail();
						String fullname = user.getFullName();
						String usertype = user.getUserType();
				%>
				<tr>
    <td><%= id %></td>
    <td><%= username %></td>
    <td><%= password %></td>
    <td><%= email %></td>
    <td><%= fullname %></td>
    <td><%= usertype %></td>

</tr>
				<%
				}
				} catch (Exception e) {
				e.printStackTrace();
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
