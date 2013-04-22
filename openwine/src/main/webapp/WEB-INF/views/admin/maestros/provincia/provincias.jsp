<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>


<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Provincias :: Maestros :: OpenWine</title>
		<meta name="viewport" content="width=device-width, inital-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="GrafenoNet">
  		<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet"  type="text/css" />    		
	</head>

	<body>
	
		<div id="content" class="span10">

			<div class="row">
				<div class="span8" style="margin-left: 4px;"><h4>${moduleTitle}</h4></div>
				<div class="span3">
					<div class="btn-group">
						<a class="btn" href="<c:url value="/admin/maestros/provincias" />"><i class="icon-plus"></i></a>
						<a class="btn" href="#"><i class="icon-list-alt"></i></a>
					</div>			  
				</div>
			</div>
			
			<table class="table table-striped">
		    	<thead>
		        	<tr>
			          	<th>Código</th>
			          	<th>Nombre</th>
			          	<th>País</th>
			          	<th></th>							          
		        	</tr>
		      	</thead>	
		      	
		      	<tbody>							
			
					<c:if test="${not empty provincias}">			
						<c:forEach var="provincia" items="${provincias}">											
							<tr>
								<td>${provincia.codigo}</td>
								<td>${provincia.nombre}</td>
								<td>${provincia.pais}</td>
								<td></td>
							</tr>
						</c:forEach>
					</c:if>
				
				</tbody>
			
			</table>
		</div>						
		
	</body>
</html>
