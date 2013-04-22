<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Caderno de Campo :: OpenWine</title>
		<meta name="viewport" content="width=device-width, inital-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="GrafenoNet">
  		<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet"  type="text/css" />    		
  		<link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet"  type="text/css" />
  		<link href="<c:url value="/resources/css/admin.css" />" rel="stylesheet"  type="text/css" />
  		<link href="<c:url value="/resources/css/admin-responsive.css" />" rel="stylesheet"  type="text/css" />
	</head>

	<body>
	
		<div id="wrap">
	        <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		    	<h3>Conectar a OpenWine</h3>
	        </div>
          	<div class="modal-body">
            	<div class="well">
              		<ul class="nav nav-tabs">
                		<li class="active"><a href="#login" data-toggle="tab">Login</a></li>
                		<li><a href="#register" data-toggle="tab">Create Account</a></li>
              		</ul>
	              	<div id="tab" class="tab-content">
	                	<div class="tab-pane active in" id="login">
	                  		<form class="form-horizontal" action='' method="POST">
	                    		<fieldset>
	                      			<div id="legend">
	                        			<legend class="">Autenticarse</legend>
	                      			</div>    
	                      			<div class="control-group">
		                        		<!-- Username -->
		                        		<label class="control-label"  for="username">Username</label>
		                        		<div class="controls">
		                          			<input type="text" id="username" name="username" placeholder="" class="input-xlarge">
		                        		</div>
	                      			</div> 
	                      			<div class="control-group">
	                        			<!-- Password-->
	                        			<label class="control-label" for="password">Password</label>
	                        			<div class="controls">
	                          				<input type="password" id="password" name="password" placeholder="" class="input-xlarge">
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
                	
                	<div class="tab-pane fade" id="create">
                  		<form id="tab">
                    		<label>Username</label>
                    		<input type="text" value="" class="input-xlarge">
                    		<label>First Name</label>
                    		<input type="text" value="" class="input-xlarge">
                    		<label>Last Name</label>
                    		<input type="text" value="" class="input-xlarge">
                    		<label>Email</label>
                    		<input type="text" value="" class="input-xlarge">

 
                    <div>
                      <button class="btn btn-primary">Create Account</button>
                    </div>
                  </form>
                </div>
            </div>
          </div>
        </div>	         
		</div>




	
	</body>
</html>