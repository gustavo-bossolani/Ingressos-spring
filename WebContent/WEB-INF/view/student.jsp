<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<header>
	<%@ include file="/WEB-INF/template/header.jsp"%>
</header>

<head>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
<spring:url value="/resources/js/bootstrap.js" var="mainJs" />

<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>

</head>

<body>
	<spring:url var="action" value='/student/add' />
	<spring:url var="edit" value='/student/edit/' />
	<spring:url var="remove" value='/student/remove/' />


	<div class="jumbotron">
		<h1 class="display-4">Student</h1>
		<p class="lead">Hello World!</p>
		
		 <hr class="my-4">

		<form:form action="${action}" modelAttribute="student">
			<form:hidden path="id" />
			<div class="form-group">

				<label class="col-sm-2 control-label">First name:</label>
				<form:input path="firstName" cssClass="form-control"
					placeholder="First name" />

			</div>
			<div class="form-group">

				<label class="col-sm-2 control-label">Last name:</label>
				<form:input path="lastName" cssClass="form-control" />

			</div>
			<div class="form-group">

				<label class="col-sm-2 control-label">Country:</label>
				<form:select path="country" cssClass="form-control">
					<form:options items="${student.countryOptions}" />
				</form:select>

			</div>

			<input type="submit" value="Submit" class="btn btn-outline-dark btn-lg" />
		</form:form>
		
		 <hr class="my-4">
		
		<br />
		<c:if test="${!empty students}">

			<table class="table">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Country</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${students}">
						<tr>
							<th scope="row">${student.id}</th>
							<td>${student.firstName}</td>
							<td>${student.lastName}</td>
							<td>${student.country}</td>
							<td><a href="${edit}${student.id}">Edit</a></td>
							<td><a href="${remove}${student.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
</body>
<footer>
	<%@ include file="/WEB-INF/template/footer.jsp"%>
</footer>
</html>