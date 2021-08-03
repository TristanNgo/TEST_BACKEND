<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cybersoft.java12.crmapp.util.UrlConst"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>

<script type="text/javascript">
    //goDownloadPermissionTemplate
     function goSubmitUpdate(id,status) {
		window.location.href = "<%=request.getContextPath() + UrlConst.PROJECT_STAFF_UPDATE%>
	?id="
				+ id + "&status=" + status;
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
							<li class="breadcrumb-item"><a href="#">User</a></li>
							<li class="breadcrumb-item active" aria-current="page">Add
								Project For Staff Dashboard</li>
						</ol>
					</nav>
					<h1 class="m-0">Add Project For Staff</h1>
				</div>
				
				<div class="ml-auto">
					<a href="<c:url value="<%=UrlConst.USER_ADD%>" />"
						class="btn btn-light"><i
						class="material-icons icon-16pt text-muted mr-1">add</i> Add New
						User </a>
				</div>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="card card-form">
			<!-- <div id="container"> -->
			<display:table name="userNoPJ" cellspacing="0" cellpadding="0"
				id="data" pagesize="10" class="table mb-0 thead-border-top-0"
				defaultsort="8" defaultorder="descending"
				requestURI="/project/staff/add">
				<display:column property="name" title="UserName" sortable="true"
					media="html excel pdf" />
				<display:column property="email" title="Email" sortable="true"
					media="html excel pdf" class="hidden" headerClass="hidden" />
				<display:column property="phone" title="Phone" sortable="true"
					media="html excel pdf" />
				<display:column property="role.name" sortable="true" title="Role"
					media="html excel pdf" />


				<display:column title="Action" media="html">
					<input type="submit" value="Add Project" class="btnSubmit"
						name="btnSave"
						onclick="return goSubmitUpdate('${data.id}','UPDATE');" />
				</display:column>

			</display:table>


		</div>
	</div>
</body>