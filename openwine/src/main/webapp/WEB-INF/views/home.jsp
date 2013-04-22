<?xml version="1.0" encoding="UTF-8" standalone="no" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>


<h4>OpenWine:</h4>
<c:if test="${not empty tickets}">

	<c:forEach var="ticket" items="${tickets}">
		<div class="row">
			<div class="span4">${ticket.fecha}</div>
			<div class="span4">${ticket.litros}</div>
			<div class="span4">${ticket.importe}</div>
		</div>
	</c:forEach>
	
</c:if>
<h6>${serverTime}</h6>
