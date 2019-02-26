<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<header>
	<%@ include file="/WEB-INF/template/header.jsp"%>
	<jsp:directive.page contentType="text/html; charset=UTF-8" />
</header>

<head>
<script	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<script	src="https://cdn.rawgit.com/plentz/jquery-maskmoney/master/dist/jquery.maskMoney.min.js"></script>
<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
<spring:url value="/resources/js/bootstrap.js" var="mainJs" />
<spring:url value="/resources/js/jquery.maskMoney.min" var="maskJs" />



<script>
	$(document).ready(function($) {
		$(function() {
			$('#data').mask("99/99/9999");
			$('#preco').maskMoney();
		});
	});
</script>

<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>
<script src="${maskJs}"></script>

</head>

<body>

	<spring:url var="action" value='/evento/add' />
	<spring:url var="edit" value='/evento/edit/' />
	<spring:url var="remove" value='/evento/remove/' />


	<div class="jumbotron">
		<h2 class="display-4">Cadastre seu Evento e ganhe MUITA GRANA!</h2>
		<p class="lead">Só não vale abusar da lei Rouanet ;)</p>

		<hr class="my-4">

		<form:form action="${action}" modelAttribute="evento">
			<form:hidden path="id" />
			<div class="form-group">

				<label class="col-sm-2 control-label">Nome:</label>
				<form:input class=".form-control-lg" path="nome"
					cssClass="form-control" />
				<small class="form-text text-muted">Use o nome como uma
					forma de atrair o público.</small>

			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Data do Evento:</label>
				<form:input path="data" cssClass="form-control" id="data" maxlength="10"/>
				<small class="form-text text-muted">Utilize o padrão
					dd/mm/aaaa - Dia/Mês/Ano</small>
			</div>


			<div class="form-group">

				<label class="col-sm-2 control-label">Capacidade total:</label>
				<form:input path="capacidade" cssClass="form-control" maxlength="9"/>

				<small class="form-text text-muted">Lembrando: numero de
					pessoas será a quantidade de Ingressos.</small>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">Valor do Ingresso
					Unitário:</label>
				<form:input path="ingressoUnitario" cssClass="form-control" id="preco" maxlength="10"/>
				<small class="form-text text-muted">Sem "meter" a faca.</small>
			</div>

			<div class="form-group">

				<label class="col-sm-2 control-label">Localização:</label>
				<form:select path="casaShow" cssClass="form-control">
					<form:options items="${casaShows}" itemLabel="nome" itemValue="id"/>
				</form:select>

			</div>
			
			<div class="form-group">

				<label class="col-sm-2 control-label">Categoria:</label>
				<form:select path="categoria" cssClass="form-control">
					<form:options items="${evento.categorias}"/>
				</form:select>

			</div>
		

			<input type="submit" value="Enviar Dados"
				class="btn btn-outline-dark btn-lg" />
		</form:form>
		
		<hr class="my-4">
		
	
		<hr class="my-4">

		<br />
		<c:if test="${!empty eventos}">

			<table class="table">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nome</th>
						<th scope="col">Data</th>
						<th scope="col">Capacidade</th>
						<th scope="col">Ingresso Unitário</th>
						<th scope="col">Localização</th>
						<th scope="col">Categoria</th>
						<th scope="col">Ações</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="evento" items="${eventos}">
						<tr>
							<th scope="row">${evento.id}</th>
							<td>${evento.nome}</td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${evento.data.time}"/></td>
							<td>${evento.capacidade} pessoas</td>
							<td>$ ${evento.ingressoUnitario}</td>
							<td>${evento.casaShow}</td>
							<td>${evento.categoria}</td>
							
							<td><a href="${edit}${evento.id}">Editar</a></td>
							<td><a href="${remove}${evento.id}">Remover</a></td>
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