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
	
		<div id="content" class="span10">
	
			<div class="row">
				<div class="span10" style="margin-left: 4px;">
					<h4>
					<ul class="breadcrumb">
						<li>
							<span>Dashboard</span>&nbsp;<span class="divider">|</span>&nbsp;
						</li>
						<li>
							<span>${moduleTitle}</span>&nbsp;<span class="divider">|</span>&nbsp;
						</li>		
					</ul>				
					</h4>
				</div>
			</div>
			
			<div class="row">
				<div class="span12" style="margin-left: 4px;">
				
					<!-- selector de campaña begin -->
					<div class="btn-group pull-left theme-container" >
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
							<i class="icon-calendar"></i><span class="hidden-phone">Campaña:&nbsp;${year}</span>
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" id="themes">
							<li><a data-value="classic" href="#"><i class="icon-blank"></i></a></li>
							<li><a data-value="cerulean" href="#"><i class="icon-blank"></i>&nbsp;${year}</a></li>
							<li><a data-value="cyborg" href="#"><i class="icon-blank"></i>&nbsp;2012</a></li>
							<li><a data-value="redy" href="#"><i class="icon-blank"></i>&nbsp;2011</a></li>
							<li><a data-value="journal" href="#"><i class="icon-blank"></i>&nbsp;2010</a></li>
						</ul>
					</div>
					<!-- selector de campaña end -->
				</div>
			</div>
			
		</div>	
		
		
		


			
		<div class="sortable row-fluid">

			<div data-rel="tooltip" title="Tickets de Gasoil" class="well span3 top-block">
				<span class="icon32 icon-color icon-list-alt"></span>&nbsp;<h4>Gasóleo:</h4>
				<div><strong>Importe:</strong>&nbsp;${importeTotal}&nbsp;€</div>
				<div><strong>Litros:</strong>&nbsp;${litrosTotal}&nbsp;</div>
			</div>

			<a data-rel="tooltip" title="$34 new sales." class="well span3 top-block" href="#">
				<span class="icon32 icon-color icon-cart"></span>
				<div>Sales</div>
				<div>$13320</div>
				<span class="notification yellow">$34</span>
			</a>
			
			<a data-rel="tooltip" title="12 new messages." class="well span3 top-block" href="#">
				<span class="icon32 icon-color icon-envelope-closed"></span>
				<div>Messages</div>
				<div>25</div>
				<span class="notification red">12</span>
			</a>
		</div>
		
			
		<script type="text/javascript" src="<c:url value="/resources/js/charts/area.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/charts/donut.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/application.js" />"></script>

	</body>
</html>
