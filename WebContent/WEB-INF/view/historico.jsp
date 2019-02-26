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
	
	<title>Histórico</title>
	
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
	<spring:url value="/resources/js/bootstrap.js" var="mainJs" />
	
	<link href="${mainCss}" rel="stylesheet" />
	<script src="${mainJs}"></script>

</head>

<body>
	<div class="jumbotron">
		<h1 class="display-6">Histórico de Compras.</h1>
		<h1 class="display-2">${clienteLogado.nome}</h1>
		
		<hr class="my-4">
	
		<div class="container-fluid" style="padding:10px;">
		
		<c:choose>
			<c:when test="${!empty vendas}">
				<c:forEach var="venda" items="${vendas}">
						<div class="card text-white bg-dark mb-3" style="box-shadow: 5px 5px 5px grey;">
							<h1>
								<div class="card-header">${venda.evento.nome}</div>
							</h1>
							<div class="card-body">
								<p class="card-text">
									<div class="text">Data:</div><br />
									<h3>
										<fmt:formatDate pattern="dd/MM/yyyy"
											value="${venda.evento.data.time}" />
									</h3>
								</p>
								<p class="card-text">
										Ingressos Disponíveis:<br />
									<h3>
										<fmt:formatNumber value="${venda.evento.capacidade}" />
										unidades disponíveis
									</h3>
								</p>
								
								<p class="card-text">
									<div class="text">Localização:</div><br />
									<h3>${venda.evento.casaShow}</h3>
								</p>
								
								<p class="card-text">
									<div class="text">Unidades compradas:</div>
									<h3><p class="card-text" style="color: #73e27d;">x${venda.quantidade}</p></h3>
								</p>	
							</div>
								
							<div class="card-footer text-muted">
								<div class="text">Total</div>
								<h2>
									<p class="card-text" style="color: #73e27d;">$${venda.total}</p>
								</h2>
							</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="alert alert-danger" role="alert">Você ainda não possui nenhuma compra em seu histórico.</div>
				</c:otherwise>
			</c:choose>
		</div>	
	</div>
</body>
<footer>
	<%@ include file="/WEB-INF/template/footer.jsp"%>
</footer>
</html>