<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>OpenWine :: GrafenoNet</title>
		<meta name="viewport" content="width=device-width, inital-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="GrafenoNet">
  		<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />    
  		<link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet"  type="text/css" />
  		
  		<link rel="shortcut icon" href="/resources/favicon.ico">
	</head>
	
	<body>
		
		<div id="wrap">
	
			<!-- navbar begin -->
			<div class="navbar navbar-inverse navbar-fixed-top">
				<div class="navbar-inner">
					<div class="container-fluid">
						<c:import url="/WEB-INF/decorator/default/navbar.jsp"/> 
					</div>
				</div>
			</div>
			<!-- navbar nd -->
			
			<!-- content begin -->
			<div class="container-fluid">
				<div class="row-fluid">
					
					<!-- menu left begin -->
					<c:import url="/WEB-INF/decorator/default/menu.jsp"/> 
					<!-- menu left end -->
					
					<!-- body begin -->
					<div class="span10">
						<div class="row-fluid">
							<div class="span8">
								<div class="container">
									<decorator:body />
								</div>
							</div>
						</div>
					</div>
					<!-- body end -->
					
				</div>
			</div>		
			
			<hr>	
			
		</div>
		
		<!-- footer begin -->
		<footer>
			<div class="container">
				<c:import url="/WEB-INF/decorator/default/footer.jsp"/>
			</div> 
		</footer>	
		<!-- footer end -->	
	
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/demo.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/json2.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/date.format.js" />"></script>	
	</body>
	
</html>	