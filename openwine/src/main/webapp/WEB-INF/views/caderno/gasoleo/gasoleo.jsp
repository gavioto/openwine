<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Gasóleo :: Caderno de Campo :: OpenWine</title>
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
					<li class=""><a href="<c:url value="/caderno/" />" class="pjax">Caderno</a></li>
					<span class="divider">&nbsp;/&nbsp;</span>
					<li class=""><a href="<c:url value="/caderno/gasoleo/" />" class="pjax">Gasóleo</a></li>
				</ul>
					


				<ul class='nav nav-tabs'>
				
		          <li title="" rel="" class="icon index_collection_link active">
		            <a class="pjax" href="<c:url value="/caderno/gasoleo" />">
		              <i class="icon-th-list"></i>
		              <span>Lista</span>
		            </a>
		          </li>
		          
		          <li title="" rel="" class="icon new_collection_link ">
		            <a class="pjax" href="<c:url value="/caderno/gasoleo/novo" />">
		              <i class="icon-plus"></i>
		              <span>Novo</span>
		            </a>
		          </li>
				
				</ul>
				
				<table class="table table-condensed table-striped">
			    	<thead>
			        	<tr>
				          	<th class="header pjax headerSortDown datetime_type">Fecha</th>
				          	<th>Importe</th>
				          	<th>Litros</th>
				          	<th></th>							          
			        	</tr>
			      	</thead>	
			      	
			      	<tbody>							
				
						
							<tr th:each="ticket : ${tickets} }">
								<td th:text="${ticket.fecha}">${ticket.fecha}</td>
								<td>${ticket.litros}</td>
								<td>${ticket.importe}</td>
								<td class="last links">								
									<ul class='inline'>
										<li title="Show" rel="tooltip" class="icon show_member_link ">
											<a class="pjax" href="<c:url value="/caderno/gasoleo/show" />">
										    	<i class="icon-info-sign"></i>
										    	<span style='display:none'>Ver</span>
											</a>
										</li>
        
							          	<li title="Editar" rel="tooltip" class="icon edit_member_link ">
							            	<a class="pjax" href="<c:url value="/caderno/gasoleo/edit" />">
							              		<i class="icon-pencil"></i>
							              		<span style='display:none'>Editar</span>
							            	</a>
							          	</li>
        
							          	<li title="Borrar" rel="tooltip" class="icon delete_member_link ">
							            	<a class="pjax" href="<c:url value="/caderno/gasoleo/delete" />">
							              		<i class="icon-remove"></i>
							              		<span style='display:none'>Borrar</span>
							            	</a>
							          	</li>
        							</ul>								
								</td>							
							</tr>
									


					
					</tbody>
				
				</table>
				
				<div class='clearfix total-count'>${numRegistros}&nbsp;rexistros</div>				
				
			</div>
		</div>			
		
	</body>
</html>
		