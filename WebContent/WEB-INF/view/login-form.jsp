<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	
	<title>Login</title>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<spring:url value="/resources/css/bootstrap.css" var="mainCss" />
	<spring:url value="/resources/js/bootstrap.js" var="mainJs" />
	<spring:url value="/resources/css/login-form.css" var="style"/>
	
	<link href="${mainCss}" rel="stylesheet" />
	<script src="${mainJs}"></script>
	<link href="${style}" rel="stylesheet" type="text/css">

</head>

<body style="${style}">

	<spring:url var="img" value='/resources/img/tickets.png' />
		
		
              <div class="container login-container">
            	<div class="row">
                <div class="col-md-6 login-form-1">
                
                		
                    <h3 style="color:#1f2934;">Insira seus Dados</h3>
                    
                    <form action="logar" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Email" name="email"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Senha" name="senha"/>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-outline-dark" value="Entrar"/>
                        </div>
                    </form>
                    
                    <c:choose>
						<c:when test="${falha == true}">
							<h2><span class="badge badge-pill badge-danger" style="text-align: center;"> Senha ou Email Incorreto! </span></h2>
						</c:when>
						 <c:otherwise>
					        <h2><span class="badge badge-pill badge-danger"></span></h2>
					    </c:otherwise>
            		</c:choose>
                    
                </div>
                
                
                <!-- FORM DE REGISTRO -->
                <div class="col-md-6 login-form-2" style="background-color:#1f2934;">
                    <h3>Registre-se</h3>
                    
                    <form action="registrar" method="post">
                    	<input type="hidden" name="id" value= 1 />
                    	
                    	<div class="form-group">
                            <input type="text" class="form-control" placeholder="Nome"  name="nome"/>
                        </div>
                        
                        <div class="form-group">
                            <input type="email" class="form-control" placeholder="Email"  name="email"/>
                        </div>
                        
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Senha"  name="senha"/>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-outline-light" value="Registrar"/>
                    	</div>
                    </form>
                    
                    <c:choose>
						<c:when test="${registrado == true}">
							<h2><span class="badge badge-pill badge-success" style="text-align: center;"> Registrado com Sucesso! </span></h2>
						</c:when>
						 <c:otherwise>
					        <h2><span class="badge badge-pill badge-danger"></span></h2>
					    </c:otherwise>
            		</c:choose>
                    
                </div>
            </div>
        </div>
</body>
<footer>
	<%@ include file="/WEB-INF/template/footer.jsp"%>
</footer>
</html>