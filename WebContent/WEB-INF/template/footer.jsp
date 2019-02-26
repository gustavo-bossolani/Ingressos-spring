<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script
			src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
		<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
		<spring:url value="/resources/js/bootstrap.js" var="mainJs" />
		<spring:url value="/resources/css/footer.css" var="style"/>
		<link href="${mainCss}" rel="stylesheet" />
		<link href="${style}" rel="stylesheet" type="text/css">
</head>

	
	
<footer class="footer bg-dark" style="${style}"> 
	
	<label class="text">Desenvolvido por Gustavo Bossolani</label> - 
	<a class="text" href="https://github.com/GustavoBossolani" target="_blank">GitHub</a> - 
	<a class="text" href="https://www.linkedin.com/in/gustavo-bossolani/" target="_blank">Linkedin</a>
	
</footer>	
</html>