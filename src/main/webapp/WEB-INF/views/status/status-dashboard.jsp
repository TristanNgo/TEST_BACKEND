<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.java12.crmapp.util.UrlConst"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STATUS-Dashboard</title>
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
							<li class="breadcrumb-item"><a href="#">Status</a></li>
							<li class="breadcrumb-item active" aria-current="page">
								STATUS Dashboard</li>
						</ol>
					</nav>
					<h1 class="m-0">STATUS Dashboard</h1>
				</div>
				<div class="ml-auto">
					<a href="<c:url value="<%=UrlConst.STATUS_ADD%>" />"
						class="btn btn-light"><i
						class="material-icons icon-16pt text-muted mr-1">add</i> Add New
						Status </a>
				</div>


			</div>
		</div>
	</div>
	<!-- End Breadcrumb -->

	<!-- START BODY -->
	<div class="container">
		<div class="card card-form">
			<table class="table mb-0 thead-border-top-0">
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>UpDate/Delete</th>
					</tr>
				</thead>
				<tbody class="list" id="">
					<c:choose>
						<c:when test="${statuss == null}">
							<tr class="row">
								<td class="col-12 text-center">There is no data.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="status" items="${statuss}">
								<tr>
									<td>${status.name }</td>
									<td>${status.description }</td>

									<!--  	<a href="" class="text-muted"><i class="material-icons">settings</i></a> -->

									<td><a
										href="<c:url value="<%=UrlConst.STATUS_UPDATE%>" />?id=${status.id}"
										class="text-muted"><i class="material-icons">update</i></a> <a
										href="<c:url value="<%=UrlConst.STATUS_DELETE%>" />?id=${status.id}"
										class="text-muted"><i class="material-icons">delete</i></a></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
	<!-- END BODY -->
</body>