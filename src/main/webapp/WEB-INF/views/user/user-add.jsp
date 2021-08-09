<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.java12.crmapp.util.UrlConst"%>
<head>
<meta charset="UTF-8">
<title>Add New User</title>
<style type="text/css">


#box_email #email_check {
	color: red;
	/* 	width: 100% */
}
#box_password #password_check {
	color: red;
	/* width: 100% */
}
</style>
<script type="text/javascript">
	function validateUserForm() {
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		// 		var name = document.getElementById("name").value;
		// 		var phone = document.getElementById("phone").value;

		var email_check = document.getElementById("email_check");
		var password_check = document.getElementById("password_check");
		// 		var name_check = document.getElementById("email_check");
		// 		var phone_check = document.getElementById("email_check");

// 		var email_regex = /^[a-zA-Z][a-zA-Z0-9](5,14)$/i;
 		var email_regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//  		/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/

		var password_regex1 = /([a-z].*[A-Z])|([A-Z].*[a-z])([0-9])/ ;
// 		var password_regex2 = /([0-9])/;
// 		var password_regex3 = /([!,%,&,@,#,$,^,*,?,_,~])/;

		// 		var phone_regex = /([0-9])/;

		// 		var name_regex = 

		if (email.length< 20 || !email_regex.test(email)) {
			email_check.innerHTML = "Vui lòng nhập đúng định dạng email (*)";
			return false;
		} else {
			email_check.innerHTML = "";
		}

		if (password.length < 6 || !password_regex1.test(password)){
			password_check.innerHTML = "Vui lòng nhập đúng định dạng mật khẩu (*) ";
			return false;
		} else {
			password_check.innerHTML = "";
		}

	}
</script>
</head>
<body>
	<!-- Breadcrumb -->
	<div class="container page__heading-container">
		<div class="page__heading">
			<div class="d-flex align-items-center">
				<div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb mb-0">
							<li class="breadcrumb-item"><a
								href="<c:url value="<%=UrlConst.HOME%>" />">Home</a></li>
							<li class="breadcrumb-item"><a
								href="<c:url value="<%=UrlConst.USER_DASHBOARD%>" />">User</a></li>
							<li class="breadcrumb-item active" aria-current="page">Add
								New User</li>
						</ol>
					</nav>
					<h1 class="m-0">Add New User</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- End Breadcrumb -->
	<div class="container page__container">
		<div class="card card-form">
			<div class="row no-gutters">
				<div class="col-lg-4 card-body">
					<p>
						<strong class="headings-color">Rules</strong>
					</p>
					<p class="text-muted">There is no rule!</p>
				</div>
				<div class="col-lg-8 card-form__body card-body">
					<form action="<c:url value="<%=UrlConst.USER_ADD%>" />"
						method="post" onsubmit="return validateUserForm()" id="frm">
						<div class="form-group" id="box_email">
							<label for="email">Email:</label> <input type="email"
								class="form-control" name="email" id="email">
							<p id="email_check"></p>
						</div>
						<div class="form-group" id="box_password">
							<label for="password">Password:</label> <input type="password"
								class="form-control" name="password" id="password">
							<p id="password_check"></p>
						</div>
						<div class="form-group">
							<label for="name">Name:</label> <input type="text"
								class="form-control" name="name" id="name">
							<p id="name_check"></p>
						</div>
						<div class="form-group">
							<label for="phone">Phone:</label> <input type="text"
								class="form-control" name="phone" id="phone">
							<p id="phone_check"></p>
						</div>
						<div class="form-group">
							<label for="address">Address:</label>
							<textarea type="text" class="form-control" name="address"
								id="address" aria-label="With textarea"></textarea>
						</div>
						<div class="form-group">
							<label for="role">Role</label> <select id="role" name="role"
								data-toggle="select" class="form-control">
								<option selected="" value="1">ADMIN</option>
								<option value="2">LEADER</option>
								<option value="3">STAFF</option>
							</select>
						</div>
						<button class="btn btn-primary w-25 justify-content-center"
							type="submit" class="btn btn-primary">Add</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
