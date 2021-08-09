<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.java12.crmapp.util.UrlConst"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login - CRM APP</title>

<link rel="shortcut icon"
	href="<c:url value="/assets/images/favicon.ico" />" />

<!-- Perfect Scrollbar -->
<link type="text/css"
	href="<c:url value="/assets/vendor/perfect-scrollbar.css" />"
	rel="stylesheet" />

<!-- App CSS -->
<link type="text/css" href="<c:url value="/assets/css/app.css" />"
	rel="stylesheet" />
<link type="text/css" href="<c:url value="/assets/css/app.rtl.css" />"
	rel="stylesheet" />

<!-- Material Design Icons -->
<link type="text/css"
	href="<c:url value="/assets/css/vendor-material-icons.css" />"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value="/assets/css/vendor-material-icons.rtl.css" />"
	rel="stylesheet" />

<!-- Font Awesome FREE Icons -->
<link type="text/css"
	href="<c:url value="/assets/css/vendor-fontawesome-free.css" />"
	rel="stylesheet" />
<link type="text/css"
	href="<c:url value="/assets/css/vendor-fontawesome-free.rtl.css" />"
	rel="stylesheet" />
<style type="text/css">
#box_email {
	display: flex;
}

#box_email #check_email {
	color: red;
	width: 100%
}
</style>
<script type="text/javascript">
		function validateForm() {
			var email = document.getElementById("email");
			var email_regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			var check_email = document.getElementById("check_email");
// 			 			var password_regex1 = /([a-z].*[A-Z])|([A-Z].*[a-z])([0-9])+([!,%,&,@,#,$,^,*,?,_,~])/;
// 			 			var password_regex2 = /([0-9])/;
// 			 			var password_regex3 = /([!,%,&,@,#,$,^,*,?,_,~])/;

// 							else if (pass.length < 8 || password_regex1.test(pass) == false
// 			 					|| password_regex2.test(pass) == false
// 								|| password_regex3.test(pass) == false) {
// 						alert("Please Enter Strong Password");
// 							return false;

			if (!email_regex.test(email)) {
				check_email.innerHTML = "Please Enter Correct Email";
				return false;
			} else {
				check_email.innerHTML = "";
			}
		}
	</script>
</head>

<body class="layout-login">
	<div class="layout-login__overlay"></div>
	<div class="layout-login__form bg-white" data-perfect-scrollbar>
		<div class="d-flex justify-content-center mt-2 mb-5 navbar-light">
			<a href="<c:url value="<%=UrlConst.HOME%>" />" class="navbar-brand"
				style="min-width: 0"> <img class="navbar-brand-icon"
				src="assets/images/logo.png" width="250" alt="Cybersoft">
			</a>
		</div>

		<h4 class="m-0">Welcome back!</h4>
		<p class="mb-5">Login to access your account</p>
		<form action="<c:url value="<%=UrlConst.LOGIN%>" />"
			onsubmit="return validateForm()" method="post">
			<div class="form-group">
				<label class="text-label" for="email">Email Address:</label>
				<div class="input-group input-group-merge" id="box_email">
					<input id="email" name="email" type="email" value="${email}"
						required="" class="form-control form-control-prepended"
						placeholder="" />
					<div class="input-group-prepend">
						<div class="input-group-text">
							<span class="far fa-envelope"></span>
						</div>
					</div>
					<p id="check_email"></p>
				</div>
			</div>
			<div class="form-group">
				<label class="text-label" for="password">Password:</label>
				<div class="input-group input-group-merge">
					<input id="password" name="password" type="password" required=""
						class="form-control form-control-prepended"
						placeholder="Enter your password">
					<div class="input-group-prepend">
						<div class="input-group-text">
							<span class="fa fa-key"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group mb-5">
				<div class="custom-control custom-checkbox">
					<input type="checkbox" name="rememberUsername"
						class="custom-control-input" checked="" id="remember"> <label
						class="custom-control-label" for="remember">Remember me</label>
				</div>
			</div>
			<div class="form-group text-center">
				<button class="btn btn-primary mb-5" type="submit">Login</button>
				<br> <a href="<c:url value="<%=UrlConst.FORGOT_PASSWORD%>" />">Forgot
					password?</a> <br> Don't have an account? <a
					class="text-body text-underline"
					href="<c:url value="<%=UrlConst.SIGNUP%>" />">Sign up!</a>
			</div>
		</form>
	</div>


	<!-- jQuery -->
	<script src="<c:url value="assets/vendor/jquery.min.js" />"></script>

	<!-- Bootstrap -->
	<script src="<c:url value="assets/vendor/popper.min.js" />"></script>
	<script src="<c:url value="assets/vendor/bootstrap.min.js" />"></script>

	<!-- Perfect Scrollbar -->
	<script src="<c:url value="assets/vendor/perfect-scrollbar.min.js" />"></script>

	<!-- DOM Factory -->
	<script src="<c:url value="assets/vendor/dom-factory.js" />"></script>

	<!-- MDK -->
	<script src="<c:url value="assets/vendor/material-design-kit.js" />"></script>

	<!-- App -->
	<script src="<c:url value="assets/js/toggle-check-all.js" />"></script>
	<script src="<c:url value="assets/js/check-selected-row.js" />"></script>
	<script src="<c:url value="assets/js/dropdown.js" />"></script>
	<script src="<c:url value="assets/js/sidebar-mini.js" />"></script>
	<script src="<c:url value="assets/js/app.js" />"></script>
	<script src="<c:url value="assets/js/jquery.validate.min.js" />"></script>
	<!-- App Settings (safe to remove) -->
	<script src="<c:url value="assets/js/app-settings.js" />"></script>


</body>

</html>