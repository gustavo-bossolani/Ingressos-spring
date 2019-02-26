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

	<spring:url var="action" value='/cliente/add' />
	<spring:url var="edit" value='/cliente/edit/' />
	<spring:url var="remove" value='/cliente/remove/' />


	<div class="jumbotron">
		<h1 class="display-4">Faça seu Cadastro como Cliente</h1>
		<p class="lead">Relaxe, seus dados estão totalmente protegidos!</p>
		
		 <hr class="my-4">
		
		<form:form action="${action}" modelAttribute="cliente">
			<form:hidden path="id" />
			<div class="form-group">

				<label class="col-sm-2 control-label">Email:</label>
				<form:input class=".form-control-lg" path="email" cssClass="form-control" aria-describedby="emailHelp" placeholder="Digite seu Email" />
				<small class="form-text text-muted">Verifique mais de uma vez antes de avançar.</small>
				
			</div>
			<div class="form-group">

				<label class="col-sm-2 control-label">Nome:</label>
				<form:input path="nome" cssClass="form-control" />

			</div>
			<div class="form-group">

				<label class="col-sm-2 control-label">Senha:</label>
				<form:input type="password" path="senha" cssClass="form-control" />
				<small class="form-text text-muted">Evite criar senhas contendo seu nome!</small>
				
			</div>

			<input type="submit" value="Enviar Dados" class="btn btn-outline-dark btn-lg" />
		</form:form>
		
		 <hr class="my-4">
		
		<br />
		<c:if test="${!empty clientes}">

			<table class="table">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nome</th>
						<th scope="col">Email</th>
						<th scope="col">Senha</th>
						<th scope="col">Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cliente" items="${clientes}">
						<tr>
							<th scope="row">${cliente.id}</th>
							<td>${cliente.nome}</td>
							<td>${cliente.email}</td>
							<td>${cliente.senha}</td>
							<td><a href="${edit}${cliente.id}">Editar</a></td>
							<td><a href="${remove}${cliente.id}">Remover</a></td>
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