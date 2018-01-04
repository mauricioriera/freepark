<%@ include file="/WEB-INF/views/templates/layout/tags.jsp"%>
<div class="navbar navbar-fixed-top" role="navigation"
	style="background-color: #337ab7">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#" style="color: #fff">FreePark</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">

				<li class="dropdown"><a style="color: #fff; font-size: 20px"><c:out
							value="${playa.nombre}"></c:out></a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
