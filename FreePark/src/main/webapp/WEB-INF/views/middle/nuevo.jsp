<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@ include file="/WEB-INF/views/middle/templates/layout/tags.jsp"%>
<%@ page session="false"%>

<div class="container" style="margin-top: 50px;">
	<tiles:insertDefinition name="middleTemplate">
		<tiles:putAttribute name="mensajes"
			value="/WEB-INF/views/middle/templates/page/mensajes.jsp" />
		<tiles:putAttribute name="body">
			<h2>Nueva Reserva</h2>
			<div class="panel panel-default">
				<div class="panel-heading">Formulario</div>
				<div class="panel-body">
					<form:form method="POST" id="form" modelAttribute="reserva"
						role="form" cssClass="form-horizontal">
						
						<spring:bind path="fechaSalida">
							<div class="form-group ${status.error ? 'has-error' : '' }">
								<label class="control-label col-md-2" for="fechaSalida">Fecha Salida</label>
								<div class="col-md-5">
									<form:input type="text" id="fechaSalida" cssClass="form-control"
										path="fechaSalida" required="required" />
									<c:if test="${status.error}">
										<span class="text-danger">${status.errorMessage}</span>
									</c:if>
								</div>
							</div>
						</spring:bind>
						
						<spring:bind path="estacionamiento.id">
							<div class="form-group ${status.error ? 'has-error' : '' }">
								<form:hidden id="estacionamiento" value="${id_estacionamiento}"
									path="estacionamiento.id" />
								<c:if test="${status.error}">
									<span class="text-danger">${status.errorMessage}</span>
								</c:if>
							</div>
						</spring:bind>
						
						<div class="form-group">
							<div class="col-md-offset-2 col-md-5">
								<a class="btn btn-primary" role="button"
									href='<c:url value="/middle/" />' title="Volver">Volver</a>
							</div>
							<div class="col-md-5">
								<button type="submit" class="btn btn-success">Guardar</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
			<script>
				var playa = ${playa.id}
			</script>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</div>
