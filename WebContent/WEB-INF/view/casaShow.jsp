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
	<spring:url var="action" value='/casaShow/add' />
	<spring:url var="edit" value='/casaShow/edit/' />
	<spring:url var="remove" value='/casaShow/remove/' />

	<div class="jumbotron">
	<h1 class="display-4">Cadastre sua Casa de Show</h1>
		<p class="lead">Relaxe, seus dados estão totalmente protegidos!</p>
		
		 <hr class="my-4">

		<form:form action="${action}" modelAttribute="casaShow">
			<form:hidden path="id" />

			<div class="form-group">

				<label class="col-sm-2 control-label">Nome:</label>
				<form:input path="nome" cssClass="form-control" />

			</div>
			<div class="form-group">

				<label class="col-sm-2 control-label">Endereço:</label>
				<form:input path="endereco" cssClass="form-control" />

			</div>

			<input type="submit" value="Enviar Dados" class="btn btn-outline-dark btn-lg" />
		</form:form>
		
		 <hr class="my-4">
		
		<br />
		<c:if test="${!empty casaShows}">

			<table class="table">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nome</th>
						<th scope="col">Endereço</th>
						<th scope="col">Ações</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="casaShow" items="${casaShows}">
						<tr>
							<th scope="row">${casaShow.id}</th>
							<td>${casaShow.nome}</td>
							<td>${casaShow.endereco}</td>
							<td><a href="${edit}${casaShow.id}">Editar</a></td>
							<td><a href="${remove}${casaShow.id}">Remover</a></td>
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