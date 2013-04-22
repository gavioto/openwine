<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Usuarios :: Maestros :: Administración :: OpenWine</title>
		<meta name="viewport" content="width=device-width, inital-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="GrafenoNet">
  		<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet"  type="text/css" />    		
	</head>

	<body>
	
			<div id="content">
			<div class="row-fluid sortable">
				<div class="box">	
	
					<div id="content" class="span10">
						<h4>${moduleTitle}</h4>		
					</div>
				</div>		
				<ul class="breadcrumb">
					<li class=""><a href="<c:url value="/admin" />" class="pjax">Administración</a></li>
					<span class="divider">&nbsp;/&nbsp;</span>
					<li class=""><a href="<c:url value="/admin/maestros" />" class="pjax">Maestros</a></li>
					<span class="divider">&nbsp;/&nbsp;</span>
					<li class=""><a href="<c:url value="/admin/maestros/usuario" />" class="pjax">Usuario</a></li>
				</ul>
					


				<ul class='nav nav-tabs'>
				
		          <li title="" rel="" class="icon index_collection_link">
		            <a class="pjax" href="<c:url value="/admin/maestros/usuario" />">
		              <i class="icon-th-list"></i>
		              <span>Lista</span>
		            </a>
		          </li>
		          
		          <li title="" rel="" class="icon new_collection_link active">
		            <a class="pjax" href="<c:url value="/admin/maestros/usuario/novo" />">
		              <i class="icon-plus"></i>
		              <span>Novo</span>
		            </a>
		          </li>
				
				</ul>	
					
				<div class="box-content">
					<form:form class="form-horizontal" method="POST" modelAttribute="usuario" action="">
						<form:errors path="*" cssClass="errorblock" element="div" />
				
						<fieldset>
							<legend>Novo usuario:</legend>  
						
							<div class="control-group">
								<form:label class="control-label" path="username">Login:</form:label>
								<div class="controls">
									<form:input class="input-xlarge focused" id="username" type="text" path="username" value="${usuario.username}"/>
								</div>
							</div>	
							
							<div class="control-group">
						  		<form:label class="control-label" path="password">Contrasena:</form:label>
						  		<div class="controls">
						  			<form:input class="input-xlarge" id="password" type="text" path="password"/>
						  		</div>
							</div>
							
							<div class="control-group">
						  		<form:label class="control-label" path="password">Contrasena:</form:label>
						  		<div class="controls">
						  			<form:input class="input-xlarge" id="password" type="text" path="password"/>
						  		</div>
							</div>							
							
							<div class="control-group">
						  		<form:label class="control-label" path="nombre">Nombre:</form:label>
						  		<div class="controls">
									<form:input class="input-xlarge" id="nombre" type="text" path="nombre"/>
						  		</div>
							</div>
							
							<div class="control-group">
						  		<form:label class="control-label" path="apellidos">Apellidos:</form:label>
						  		<div class="controls">
									<form:input class="input-xlarge" id="apellidos" type="text" path="apellidos"/>
						  		</div>
							</div>							
							
							<div class="control-group">
						  		<form:label class="control-label" path="fechaNacimiento">Fecha de nacimiento:</form:label>
						  		<div class="controls">
									<form:input class="input-xlarge" id="fechaNacimiento" type="text" path="fechaNacimiento" value="${usuario.fechaNacimiento}"/>
						  		</div>
							</div>

							<div class="control-group">
						  		<form:label class="control-label" path="numeroTelefono">Número teléfono:</form:label>
						  		<div class="controls">
									<form:input class="input-xlarge" id="numeroTelefono" type="text" path="numeroTelefono"/>
						  		</div>
							</div>							

							<div class="control-group">
						  		<form:label class="control-label" path="numeroMovil">Número móbil:</form:label>
						  		<div class="controls">
									<form:input class="input-xlarge" id="numeroMovil" type="text" path="numeroMovil"/>
						  		</div>
							</div>							
							
							<div class="form-actions">
						  		<button type="submit" class="btn btn-primary">Gardar</button>
						  		<button type="reset" class="btn">Limpar</button>
							</div>
						
						</fieldset>
					</form:form>
				</div>
										

			</div>
		</div>			
		
	</body>
</html>
