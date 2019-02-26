<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
	<spring:url value="/resources/js/bootstrap.js" var="mainJs" />
	<spring:url var="logout" value='logout' />

<link href="${mainCss}" rel="stylesheet" />
<script src="${mainJs}"></script>

</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="http://localhost:8080/student-crud/home">Ingressos Pesadão</a> 
		
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="navbar-item"><a class="nav-link" href="http://localhost:8080/student-crud/cliente">Cliente</a></li>
				<li class="navbar-item"><a class="nav-link" href="http://localhost:8080/student-crud/casaShow">Casa de Show</a></li>
				<li class="navbar-item"><a class="nav-link" href="http://localhost:8080/student-crud/evento">Eventos</a></li>
				<li class="navbar-item"><a class="nav-link" href="http://localhost:8080/student-crud/historico">Histórico de Compras</a></li>
				<li class="navbar-item"><a class="nav-link" href="http://localhost:8080/student-crud/logout">Sair</a></li>
			</ul>
		</div>
	</nav>

</body>
</html>