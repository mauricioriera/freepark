<%@ include file="/WEB-INF/views/templates/layout/tags.jsp"%>
<%@ page session="false"%>
<div class="container" style="margin-top: 50px;">
	<tiles:insertDefinition name="AppTemplate">
		<tiles:putAttribute name="mensajes"
			value="/WEB-INF/views/templates/page/mensajes.jsp" />
		<tiles:putAttribute name="body">
			<h1>${playa.nombre}</h1>

			<div class="panel panel-info">
				<div class="panel-heading">
					<h4>INFORMACION</h4>
				</div>

				<div class="panel-body">
					<h4 align="center">Ocupacion</h4>
					<div class="progress">
						<div class="progress-bar progress-bar-success" role="progressbar"
							aria-valuenow="40" aria-valuemin="0" aria-valuemax="80"
							style="width: ${porcentaje}%">${porcentaje}%</div>
					</div>
				</div>

				<ul class="list-group">
					<li class="list-group-item list-group-item-success"><h4
							align="center">Realizar reserva</h4></li>
				</ul>

				<div class="panel-body">
					<form:form method="POST" id="form" modelAttribute="reserva"
						role="form" cssClass="form-horizontal">
						<spring:bind path="usuario.id">
							<div class="form-group ${status.error ? 'has-error' : '' }">

								<form:hidden path="usuario.id" value="${usuario.id}" />
								<c:if test="${status.error}">
									<span class="text-danger">${status.errorMessage}</span>
								</c:if>

							</div>
						</spring:bind>
						<spring:bind path="vehiculo.id">
							<div class="form-group ${status.error ? 'has-error' : '' }">
								<label class="control-label col-md-2" for="vehiculo">Vehiculo:</label>
								<div class="col-md-8">
									<form:select path="vehiculo.id" cssClass="form-control">
										<form:options items="${usuario.vehiculos}" itemValue="id"
											itemLabel="patente" />
									</form:select>
									<c:if test="${status.error}">
										<span class="text-danger">${status.errorMessage}</span>
									</c:if>
								</div>
							</div>
						</spring:bind>
						<spring:bind path="fechaIngreso">
							<div class="form-group ${status.error ? 'has-error' : '' }">
								<label class="control-label col-md-2" for="fechaIngreso">Fecha
									de Ingreso:</label>
								<div class="col-md-8">
									<form:input cssClass="form-control" path="fechaIngreso" required="required"/>
									<c:if test="${status.error}">
										<span class="text-danger">${status.errorMessage}</span>
									</c:if>
								</div>
							</div>
						</spring:bind>

						<spring:bind path="fechaSalida">
							<div class="form-group ${status.error ? 'has-error' : '' }">
								<label class="control-label col-md-2" for="fechaSalida">Fecha
									de Salida:</label>
								<div class="col-md-8">
									<form:input cssClass="form-control" path="fechaSalida" required="required" />
									<c:if test="${status.error}">
										<span class="text-danger">${status.errorMessage}</span>
									</c:if>
								</div>
							</div>
						</spring:bind>

						<spring:bind path="estacionamiento.techo">
							<div class="form-group ${status.error ? 'has-error' : '' }">
								<label class="control-label col-md-2"
									for="estacionamiento.techo">Techo:</label>
								<div class="col-md-8">
									<form:select path="estacionamiento.techo"
										cssClass="form-control">
										<form:option value="false">Sin Techo</form:option>
										<form:option value="true">Con Techo</form:option>
									</form:select>
									<c:if test="${status.error}">
										<span class="text-danger">${status.errorMessage}</span>
									</c:if>
								</div>
							</div>
						</spring:bind>
						<div class="col-md-offset-2 col-md-6">
							<a type="button" class="btn btn-info"
								href="/ingenieria/frontend/">Volver</a>
						</div>
						<div class="col-md-4">
							<button type="submit" class="btn btn-success"
								data-loading-text="Loading..." id="reservar">Reservar</button>
						</div>
					</form:form>

					<script>
						var playa = ${playa.id}
					</script>
				</div>
			</div>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</div>
