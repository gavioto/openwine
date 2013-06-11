<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Paises :: Maestros :: OpenWine</title>   		
	</head>

	<body>
	
		<div id="content">

			<div class="row">
				<div class="span8" style="margin-left: 4px;"><h4>${moduleTitle}</h4></div>
				<div class="span3">
					<div class="btn-group">
						<a class="btn" href="<c:url value="/admin/maestros/paises" />"><i class="icon-plus"></i></a>
						<a class="btn" href="#"><i class="icon-list-alt"></i></a>
					</div>			  
				</div>
			</div>
			
			<table class="table table-striped">
		    	<thead>
		        	<tr>
			          	<th>Código</th>
			          	<th>Nombre</th>
			          	<th></th>							          
		        	</tr>
		      	</thead>	
		      	
		      	<tbody>							
			
					<c:if test="${not empty paises}">			
						<c:forEach var="pais" items="${tickets}">											
							<tr>
								<td>${pais.codigo}</td>
								<td>${pais.nombre}</td>
								<td></td>
							</tr>
						</c:forEach>
					</c:if>
				
				</tbody>
			
			</table>
		</div>						
		
	</body>
</html>
