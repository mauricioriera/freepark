<%@ include file="/WEB-INF/views/templates/layout/tags.jsp"%>
<%@ page session="false"%>
<div class="container" style="margin-top: 50px;">
	<tiles:insertDefinition name="AppTemplate">
		<tiles:putAttribute name="mensajes"
			value="/WEB-INF/views/templates/page/mensajes.jsp" />
		<tiles:putAttribute name="body">
			<h1>Mis Reservas</h1>

			<div class="panel panel-info">
				<div class="panel-body">
					
					<table>
						<thead>
							
						</thead>
						<tbody>
						
						</tbody>
					</table>

				</div>
			</div>
		</tiles:putAttribute>
	</tiles:insertDefinition>
</div>
