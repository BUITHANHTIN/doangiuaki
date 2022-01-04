<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/tablig.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Sign in/up Form</h2>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form action='<c:url value="/j_security_check"/>' method="post">
				<h1>Create Account</h1>
				<div class="social-container"></div>
				<span>or use your email for registration</span>
				<c:if test="${not empty messageRe}">
					<div class="alert alert-${danger}"
						style="color: red; background-color: #FFCCCC; text-align: center;">
						<strong>${messageRe}</strong>
					</div>
				</c:if>
				<input type="text" placeholder="Name" name="name" /> <input
					type="email" placeholder="Email" name="j_username" /> <input
					type="password" placeholder="Password" name="j_password" />
				<button>Sign Up</button>
				<input type="hidden" value="registration" name="action" />

			</form>
		</div>
		<div class="form-container sign-in-container">
			<form action='<c:url value="/j_security_check"/>' method="post">
				<h1>Sign in</h1>
				<div class="social-container"></div>
				<span>or use your account</span>
				<c:if test="${not empty message}">
					<div class="alert alert-${danger}"
						style="color: red; background-color: #FFCCCC; text-align: center;">
						<strong>${message}</strong>
					</div>
				</c:if>
				<input type="email" placeholder="Email" name="j_username"
					value="${username}" /> <input type="password"
					placeholder="Password" name="j_password" value="${password}" /> <a
					href="#">Forgot your password?</a>
				<button>Sign In</button>
				<input type="hidden" value="login" name="action" />
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>To keep connected with us please login with your personal
						info</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Hello, Friend!</h1>
					<p>Enter your personal details and start journey with us</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>
	<script>
        const signUpButton = document.getElementById('signUp');
        const signInButton = document.getElementById('signIn');
        const container = document.getElementById('container');

        signUpButton.addEventListener('click',() => {
            container.classList.add('right-panel-active');
        });

        signInButton.addEventListener('click',() => {
            container.classList.remove('right-panel-active');
        });
    </script>
</body>
</html>