<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>


<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<title>Novo :: Usuario :: Maestros :: Administracion :: OpenWine</title>
		<meta name="viewport" content="width=device-width, inital-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="GrafenoNet">
  		<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet"  type="text/css" />
  		<link href="<c:url value="/resources/css/datepicker.css" />" rel="stylesheet"  type="text/css" />
  		   		
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
				
		          <li title="" rel="" class="icon index_collection_link">
		            <a class="pjax" href="<c:url value="/caderno/gasoleo" />">
		              <i class="icon-th-list"></i>
		              <span>Lista</span>
		            </a>
		          </li>
		          
		          <li title="" rel="" class="icon new_collection_link active">
		            <a class="pjax" href="<c:url value="/caderno/gasoleo/novo" />">
		              <i class="icon-plus"></i>
		              <span>Novo</span>
		            </a>
		          </li>
				
				</ul>	
					
								
				<div class="box-content">
					<form:form class="form-horizontal" method="POST" modelAttribute="ticket" action="">
						<form:errors path="*" cssClass="errorblock" element="div" />
				
						<fieldset>
							<legend>Novo ticket de gasoil:</legend>  
						
							<div class="control-group">
								<form:label class="control-label" path="fecha">Fecha:</form:label>
								<div class="controls">
									<form:input class="input-xlarge focused datepicker" id="importe" type="text" path="fecha" value="${fecha}"/>
								</div>
							</div>	
							
							<div class="control-group">
						  		<form:label class="control-label" path="importe">Importe:</form:label>
						  		<div class="controls">
						  			<form:input class="input-xlarge" id="importe" type="text" path="importe"/>
						  		</div>
							</div>
							
							<div class="control-group">
						  		<form:label class="control-label" path="litros">Litros:</form:label>
						  		<div class="controls">
									<form:input class="input-xlarge" id="litros" type="text" path="litros"/>
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
		
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap-datepicker.js" />"></script>
	
	</body>
</html>