<%@ include file="/WEB-INF/views/templates/layout/tags.jsp"%>
<%@ page session="false"%>
<div class="container" style="margin-top: 50px;">
	<tiles:insertDefinition name="formularioGMaps">
		<tiles:putAttribute name="mensajes"
			value="/WEB-INF/views/templates/page/mensajes.jsp" />
		<tiles:putAttribute name="body">
			<h1>Freepark</h1>

			<div id="map" style="width: auto; height: 450px; margin: 5px 5px 5px 5px;"></div>
			
				 	<script>
				 	
				 		var a = ${playas};
				 	
					</script>	

		</tiles:putAttribute>
	</tiles:insertDefinition>
</div>
