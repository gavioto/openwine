<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="navbar">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
	
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				  <span class="icon-bar"></span>
				  <span class="icon-bar"></span>
				  <span class="icon-bar"></span>
				</a>
				
				<a class="brand" href="#">OpenWine</a>
				
				<div class="nav-collapse collapse">  
				  <ul class="nav">
				    <li class="active"><a href="<c:url value="/" />">Home</a></li>
				    <li><a href="<c:url value="/caderno" />">Caderno de Campo</a></li>
				    <li><a href="<c:url value="/social" />">Rede Social</a></li>
				  </ul>
				</div>
				
				
				<div class="btn-group pull-right" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone">&nbsp;admin</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="/perfil">Perfil</a></li>
						<li class="divider"></li>
						<li><a href="/logout">Sair</a></li>
					</ul>
				</div>
	
			</div>
		</div>
	</div>
</div>