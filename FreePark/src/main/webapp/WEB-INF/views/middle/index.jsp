<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ include file="/WEB-INF/views/middle/templates/layout/tags.jsp"%>
<%@ page session="false"%>

<div class="container" style="margin-top: 50px;">
	<tiles:insertDefinition name="middleTemplate">
		<tiles:putAttribute name="mensajes"
			value="/WEB-INF/views/middle/templates/page/mensajes.jsp" />
		<tiles:putAttribute name="body">
			<center>
				<h1>Opciones de Playa</h1>
			</center>

			<table class="table">
				<thead>
					<tr>
						<th>ESTACIONAMIENTO</th>
						<th>TECHO</th>
						<th>DISPONIBLE</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="estacionamiento" items="${playa.estacionamientos}">
						<c:if test="${estacionamiento.reserva.fechaSalida > fechaActual}">
							<tr class="danger">
								<th><c:out value="${estacionamiento.referencia}" /></th>
								<c:if test="${estacionamiento.techo == true}">
									<td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
								</c:if>
								<c:if test="${estacionamiento.techo == false}">
									<td></td>
								</c:if>
								<td><c:out value="NO" /></td>
								<td>
									<button type="button" class="btn btn-default" disabled="disabled">Reservar</button>
									<a href="<c:url value="/middle/info/${estacionamiento.id}" />" class="btn btn-link">
										<span class="glyphicon glyphicon-info-sign"></span>
									</a>
								</td>
							</tr>
						</c:if>
						<c:if test="${(estacionamiento.reserva == null) || (estacionamiento.reserva.fechaSalida < fechaActual)}">
							<tr>
								<th><c:out value="${estacionamiento.referencia}" /></th>
								<c:if test="${estacionamiento.techo == true}">
									<td><span class="glyphicon glyphicon-ok" aria-hidden="true"></span></td>
								</c:if>
								<c:if test="${estacionamiento.techo == false}">
									<td></td>
								</c:if>
								<td><c:out value="SI" /></td>
								<td><a href="<c:url value="/middle/nuevo/${estacionamiento.id}" />" class="btn btn-primary">Reservar</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			<script>
				var playa = ${playa.id}
			</script>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</div>