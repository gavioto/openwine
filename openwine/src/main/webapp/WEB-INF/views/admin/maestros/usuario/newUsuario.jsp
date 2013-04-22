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
					
										

			</div>
		</div>			
		
	</body>
</html>
