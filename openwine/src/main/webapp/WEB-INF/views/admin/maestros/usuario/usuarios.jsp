<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

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
				
		          <li title="" rel="" class="icon index_collection_link active">
		            <a class="pjax" href="<c:url value="/admin/maestros/usuario" />">
		              <i class="icon-th-list"></i>
		              <span>Lista</span>
		            </a>
		          </li>
		          
		          <li title="" rel="" class="icon new_collection_link">
		            <a class="pjax" href="<c:url value="/admin/maestros/usuario/novo" />">
		              <i class="icon-plus"></i>
		              <span>Novo</span>
		            </a>
		          </li>
				
				</ul>	
					
				<table class="table table-condensed table-striped">
			    	<thead>
			        	<tr>
				          	<th class="header pjax headerSortDown">Login</th>
				          	<th>Nombre y Apellidos</th>
				          	<th>Email</th>
				          	<th></th>							          
			        	</tr>
			      	</thead>	
			      	
			      	<tbody>							
				
						<c:if test="${not empty tickets}">			
							<c:forEach var="ticket" items="${tickets}">											
								<tr>
									<td>${usuario.username}</td>
									<td>${usuario.nombreApellidos}</td>
									<td>${usuario.email}</td>
									<td class="last links">								
										<ul class='inline'>
											<li title="Show" rel="tooltip" class="icon show_member_link ">
												<a class="pjax" href="<c:url value="/admin/maestros/usuario/${usuario.idUsuario}/show" />">
											    	<i class="icon-info-sign"></i>
											    	<span style='display:none'>Ver</span>
												</a>
											</li>
	        
								          	<li title="Editar" rel="tooltip" class="icon edit_member_link ">
								            	<a class="pjax" href="<c:url value="/admin/maestros/usuario/${usuario.idUsuario}/edit" />">
								              		<i class="icon-pencil"></i>
								              		<span style='display:none'>Editar</span>
								            	</a>
								          	</li>
	        
								          	<li title="Borrar" rel="tooltip" class="icon delete_member_link ">
								            	<a class="pjax" href="<c:url value="/admin/maestros/usuario/${usuario.idUsuario}/delete" />">
								              		<i class="icon-remove"></i>
								              		<span style='display:none'>Borrar</span>
								            	</a>
								          	</li>
	        							</ul>								
									</td>
								</tr>
							</c:forEach>
						</c:if>
					
					</tbody>
				
				</table>
				
				<div class='clearfix total-count'>${numRegistros}&nbsp;rexistros</div>									

			</div>
		</div>			
		
	</body>
</html>
