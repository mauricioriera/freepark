<%@ include file="/WEB-INF/views/templates/layout/tags.jsp"%>
<%@ page session="false"%>
<div class="container" style="margin-top: 120px;">
	<tiles:insertDefinition name="loginTemplate">
		<tiles:putAttribute name="mensajes"
			value="/WEB-INF/views/templates/page/mensajes.jsp" />
		<tiles:putAttribute name="body">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-md-4 col-md-offset-4">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>Ingresar al Sistema</strong>
							</div>
							<div class="panel-body">
								<form:form role="form" id="form" modelAttribute="usuario" method="POST">
									<fieldset>
										<div class="row">
											<div class="col-sm-12 col-md-10  col-md-offset-1 ">
												<spring:bind path="username">
													<div class="form-group">
														<div class="input-group">
															<span class="input-group-addon"> <i class="glyphicon glyphicon-user"></i>
															</span> <form:input path="username" class="form-control" id="username" placeholder="Usuario"
																 required="required" type="text" />
														</div>
													</div>
												</spring:bind>
												
												<spring:bind path="password">
													<div class="form-group">
														<div class="input-group">
															<span class="input-group-addon"> <i class="glyphicon glyphicon-lock"></i>
															</span> <form:input path="password" class="form-control" id="password" required="required"
																 placeholder="Clave" type="password" />
														</div>
													</div>
												</spring:bind>
												
												<div class="form-group">
													<input type="submit"
														class="btn btn-lg btn-primary btn-block" value="Ingresar" />
												</div>										
											</div>
										</div>
									</fieldset>
								</form:form>
							</div>
							<div class="panel-footer">
								No tiene cuenta? <a href='<c:url value="/" />'>
									Click Aqu&iacute;! </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</div>