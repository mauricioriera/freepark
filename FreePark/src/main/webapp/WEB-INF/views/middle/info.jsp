<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ include file="/WEB-INF/views/middle/templates/layout/tags.jsp"%>
<%@ page session="false"%>

<div class="container" style="margin-top: 50px;">
	<tiles:insertDefinition name="middleTemplate">
		<tiles:putAttribute name="mensajes"
			value="/WEB-INF/views/middle/templates/page/mensajes.jsp" />
		<tiles:putAttribute name="body">
			<h2>Info Estacionamiento</h2>

			<table class="table">
				<thead>
					<tr>
						<th>ESTACIONAMIENTO</th>
						<th>CLIENTE</th>
						<th>VEHICULO</th>
						<th>FECHA_INGRESO</th>
						<th>FECHA_SALIDA</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><c:out value="${estacionamiento.referencia}" /></th>
						<td><c:out value="${estacionamiento.reserva.usuario.username}" /></td>
						<td><c:out value="${estacionamiento.reserva.vehiculo.patente}" /></td>
						<td><c:out value="${estacionamiento.reserva.fechaIngreso}" /></td>
						<td><c:out value="${estacionamiento.reserva.fechaSalida}" /></td>
					</tr>
				</tbody>
			</table>
			
			<a class="btn btn-primary" role="button" href='<c:url value="/middle/" />' title="Volver">Volver</a>
			<script>
				var playa = ${playa.id}
			</script>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</div>