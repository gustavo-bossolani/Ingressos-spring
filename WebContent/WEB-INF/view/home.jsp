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
	
	<title>Home</title>

	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
	<spring:url value="/resources/js/bootstrap.js" var="mainJs" />
	<spring:url value="/resources/css/home-form.css" var="style"/>
	
	<link href="${mainCss}" rel="stylesheet" />
	<link href="${style}" rel="stylesheet" type="text/css">
	<script src="${mainJs}"></script>

</head>

<body>
	<!-- Estamos criando referências a métodos e arquivos externos -->
	<spring:url var="quantidade" value='/home/quantidade' />
	<spring:url var="data" value='/home/data/' />
	<spring:url var="nome" value='/home/nome/'/>
	<spring:url var="preco" value='/home/preco/'/>
	<spring:url var="todos" value='/home/todos/'/>
	<!--<spring:url var="img" value='/resources/img/tickets.png'/>-->

	<div class="jumbotron">
		<h1 class="display-4">Bem-Vindo ${clienteLogado.nome}!</h1>
		<p class="lead">Aqui! Tome alguns destes Eventos e gaste sua GRANA</p>

		<hr class="my-4">
		<br/>
		<div class="text">Como deseja Organizar sua Lista:</div>
		<div class="row">
			<div class="w-100"></div>
			<div class="col">
				<a class="btn btn-outline-dark btn-sm btn-block" href="${nome}" style="border-radius:20px">Nome</a>
			</div>
			<div class="col">
				<a class="btn btn-outline-dark btn-sm btn-block" href="${data}" style="border-radius:20px">Data</a>
			</div>
			<div class="col">
				<a class="btn btn-outline-dark btn-sm btn-block" href="${preco}" style="border-radius:20px">Preço</a>
			</div>
			<div class="col">
				<a class="btn btn-outline-dark btn-sm btn-block" href="${quantidade}" style="border-radius:20px">Quantidade de Ingressos</a>
			</div>
			<div class="col">
				<a class="btn btn-outline-dark btn-sm btn-block" href="${todos}" style="border-radius:20px">Exibir todos os Eventos</a>
			</div>
		</div>
		<hr class="my-4">
		

		<div class="box">
    		<div class="container-fluid">
    		
   			<div class="row">
     			<c:forEach var="evento" items="${eventos}">
				    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
				    	
					    <form class="text-white bg-dark mb-3" action="comprar" method="post">
							<div class="box-part" style="padding:5%;">
		                        
		                        <i class="fa fa-github fa-3x" aria-hidden="true"></i>
		                        
		                        <input type="hidden" name="id" value="${evento.id}" />
		                        
								<div class="title"  style="text-align:center;">
									<h2/>${evento.nome}
									<h2><span class="badge badge-pill badge badge-light"> 
										Dia:
										<fmt:formatDate pattern="dd/MM/yyyy" value="${evento.data.time}"/>
									 </span></h2>
									 
									 
									 <spring:url value='${evento.categoria}' var="img"/>
									 <img src="${img}" class="rounded" class="img-fluid img-thumbnail width: 100% \9;"
										style="width:100px; height: 100px;">
								</div>
		                        
								<div class="text">
									<span>Ingressos ainda Disponíveis:
										<h4><fmt:formatNumber value="${evento.capacidade}"/></h4>
									</span>
									
									<span>Localização:
										<h4>${evento.casaShow}</h4>
									</span>
								</div>
								<span style="color:#73e27d;"><h1>$${evento.ingressoUnitario}</h1></span>
								
								<input type="submit" value="Ver Detalhes"
										class="btn btn-outline-light btn-lg"/>
							 	</div>
							 </form>
						</div>
					</c:forEach>	
				</div>	
			</div>
    </div>
</div>
</body>
<footer>
	<%@ include file="/WEB-INF/template/footer.jsp"%>
</footer>
</html>