<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/tablig.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<link rel="stylesheet"
	href="<c:url value='/templates/login/style.css'/>" />
<body>
	<form action='<c:url value="/login"/>' method="post">
		<div class="imgcontainer">
			<img
				src='<c:url value="/template/web/images/ab.jpg"/>'
				alt="Avatar" class="avatar">
		</div>

		<div class="container">
			<c:if test="${not empty message}">
				<div class="alert alert-${danger}"
					style="color: red; background-color: #FFCCCC; text-align: center;">
					<strong>${message}</strong>
				</div>
			</c:if>

			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>
			<button type="submit">Login</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Remember me
			</label>
		</div>
		<div class="container" style="background-color: #ffffff">
			<button type="button" class="cancelbtn">Cancel</button>
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
		<input type="hidden" value="login" name="action" />
	</form>

</body>
</html>