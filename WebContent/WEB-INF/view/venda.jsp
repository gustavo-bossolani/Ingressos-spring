<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
	<div class="jumbotron">
		<h1 class="display-4">Confirme os Dados de seu Evento.</h1>
		
		<hr class="my-4">
	
		<div class="container-fluid" style="padding:10px;">
	
			<div class="card text-white bg-dark mb-3" style="box-shadow: 5px 5px 5px grey;">
				<h1><div class="card-header">${evento_vendido.nome}</div></h1>
				
				<div class="card-body">
					<p class="card-text">
						Data:<br/>
						<h3><fmt:formatDate pattern="dd/MM/yyyy" value="${evento_vendido.data.time}"/></h3>
					</p>
					
					<p class="card-text">
						Ingressos Disponíveis:<br/>
						<h3><fmt:formatNumber value="${evento_vendido.capacidade}"/> unidades</h3>
					</p>
					
					<p class="card-text">
						Localização:<br/>
						<h3> ${evento_vendido.casaShow} </h3>
					</p>
				</div>
				
				 <div class="card-footer text-muted">
					<h2>
						<p class="card-text" style="color: #73e27d;">$${evento_vendido.ingressoUnitario}</p>
					</h2>
				</div>
			</div>
			<form:form action="processar" modelAttribute="evento">
				<input type="hidden" name="eventoId" value="${evento_vendido.id}"/>
				<input type="hidden" name="clienteId" value="${clienteLogado.id}"/>
				<div class="text">Quantidade de Ingressos</div>
				<input type="number" min="1" name="quantidade" max="${evento_vendido.capacidade}" value="1"/>
				<input type="submit" value="Comprar" class="btn btn-outline-dark btn-lg"/>
			</form:form>
		</div>	
	</div>
</body>
<footer>
	<%@ include file="/WEB-INF/template/footer.jsp"%>
</footer>
</html>