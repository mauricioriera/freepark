
$(document).ready(
				function() {
					
					$("#reservar").click(
									function(event){
										event.preventDefault();
										$("#reservar").addClass("disabled");
										
										var notificacion = {
											"idEmisor" : 27,
											"idReceptor" : playa,
											"tipo" : "peticion"
										};

										$.ajax({
													url : "http://localhost:8080/ingenieria/notificaciones/mensajes",
													type : "POST",
													contentType : 'application/json; charset=utf-8',
													dataType : 'json',
													data : JSON
															.stringify(notificacion),
													success : function(e) {
														if (e) {
															$(".container").append('<div style="position:fixed; top: 70px; right:10px;"><div class="alert alert-danger alert-dismissible fade in" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true" class="glyphicon glyphicon-remove"></span></button><h4>Felicidades! Ya tienes tu lugar!</h4><p>La reserva se completo exitosamente.</p></div></div>')
															$("#form").submit();
														} else {
															$(".container").append('<div style="position: fixed; top: 70px; right: 10px;"><div class="alert alert-danger alert-dismissible fade in"role="alert"><button type="button" class="close" data-dismiss="alert"aria-label="Close"><span aria-hidden="true" class="glyphicon glyphicon-remove"></span></button><h4>Uups! Tu solicitud fue rechazada!</h4><p>Vuelve a intentarlo en un momento.</p></div></div>')
														}
														
					
														$("#reservar").removeClass("disabled");
													}
												
												})

									})

					

				});
