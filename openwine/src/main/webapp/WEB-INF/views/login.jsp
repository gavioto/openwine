<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="en">

	<head>
		<meta charset="utf-8">
		<title>Caderno de Campo :: OpenWine</title>
	</head>

	<body>
	
   		
		<div id="wrap">
	        <div class="modal-header">
		    	<h3>Conectar a OpenWine</h3>
	        </div>
          	<div class="modal-body">
            	<div class="well">
              		<ul class="nav nav-tabs">
                		<li class="active"><a href="#login" data-toggle="tab">Registrarse</a></li>
                		<li><a href="<c:url value="#signup" />" data-toggle="tab">Nuevo usuario</a></li>
              		</ul>
	              	<div id="tab" class="tab-content">
	                	<div class="tab-pane active in" id="login">
	                	
	                		<form action="#" th:object="${login}" th:action="@{/j_spring_security_check}" class="form-horizontal" method="POST">
	                    		<fieldset>
	                      			<div id="legend">
	                        			<legend class="">Entrar a OpenWine</legend>
	                      			</div>
	                      			<div class="control-group">
		                        		<!-- Username -->
		                        		<label class="control-label" for="j_username">Usuario</label>
		                        		<div class="controls">
		                          			<input type="text" id="j_username" name="j_username" th:field="*{j_username}" placeholder="" class="input-xlarge" required="required" autofocus="autofocus" />
		                        		</div>
	                      			</div>
	                      			<div class="control-group">
		                        		<!-- Password -->
		                        		<label class="control-label"  for="j_password">Contraseña</label>
		                        		<div class="controls">
		                          			<input type="password" id="j_password" name="j_password" th:field="j_password" placeholder="" class="input-xlarge" required="required" />
		                        		</div>
	                      			</div>
	                      			<div class="control-group">
	                        			<!-- Button -->
	                        			<div class="controls">
	                          				<button class="btn btn-success">Entrar</button>
	                        			</div>
	                      			</div>	                      			
	                			</fieldset>
	                		</form>
	                	
                
	              		</div>
	              		<div class="tab-pane" id="signup">
	                  		<form class="form-horizontal" action="<c:url value='j_spring_security_check' />" method="POST">
	                    		<fieldset>
	                      			<div id="legend">
	                        			<legend class="">Registrarse</legend>
	                      			</div>    
	                      			<div class="control-group">
		                        		<!-- Username -->
		                        		<label class="control-label"  for="j_username">Usuario</label>
		                        		<div class="controls">
		                          			<input type="text" id="j_username" name="j_username" placeholder="" class="input-xlarge">
		                        		</div>
	                      			</div> 
	                      			<div class="control-group">
	                        			<!-- Password-->
	                        			<label class="control-label" for="j_password">Contraseña</label>
	                        			<div class="controls">
	                          				<input type="password" id="j_password" name="j_password" placeholder="" class="input-xlarge">
	                        			</div>
	                      			</div>
	                      			<div class="control-group">
	                        			<!-- Button -->
	                        			<div class="controls">
	                          				<button class="btn btn-success">Registrarse</button>
	                        			</div>
	                      			</div>
	                    		</fieldset>
	                  		</form>   	              		
	              		</div>
                	
                	</div>
            	</div>
          </div>
        </div>	         

		<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	
	</body>
</html>