<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="span3 main-menu-span">
	<div class="well nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
			<li class="nav-header hidden-tablet">Maestros</li>
			<li><a class="ajax-link" href="<c:url value="/admin/maestros/usuario" />"><i class="icon-home"></i><span class="hidden-tablet">&nbsp;Usuarios</span></a></li>
			<li><a class="ajax-link" href="<c:url value="/admin/maestros/pais" />"><i class="icon-eye-open"></i><span class="hidden-tablet">&nbsp;Paises</span></a></li>
			<li><a class="ajax-link" href="<c:url value="/admin/maestros/provincia" />"><i class="icon-edit"></i><span class="hidden-tablet">&nbsp;Provincias</span></a></li>			
			<li><a class="ajax-link" href="<c:url value="/admin/maestros/concello" />"><i class="icon-list-alt"></i><span class="hidden-tablet">&nbsp;Concellos</span></a></li>			
		</ul>
	</div>
</div>
