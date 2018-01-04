$(document).ready(function(){
		setInterval(function() {
			c()
		}, 2000);
			});

function c(){
	
	$.ajax({
		url: "http://localhost:8080/ingenieria/notificaciones/" + playa + "/mensajes",
		type: "GET",
		contentType : "application/json",
		success: function(e){
			if(e){
				var alerta = '<div style="position: fixed; top: 70px; right: 10px;" ><div class="alert alert-danger alert-dismissible fade in" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true" class="glyphicon glyphicon-remove"></span></button><h4>Atencion! Solicitud entrante!</h4><p>El usuario ' + e.username + ' solicita una reserva de estacionamiento</p><p><button type="button" data-dismiss="alert" onclick="responder(' + e.id + ', \'Aceptada\')" class="btn btn-danger">Aceptar</button><button type="button" data-dismiss="alert" onclick="responder(' + e.id + ', \'Rechazada\')" class="btn btn-default">Rechazar</button></p></div></div>'
				$(".container").append(alerta)
			}
		}
	})
}

function responder(id, mje){
	var notificacion = {"idEmisor" : id, "idReceptor" : playa, "tipo": mje};
	
	$.ajax({
		url: "http://localhost:8080/ingenieria/notificaciones/responder",
		type: "POST",
		contentType : 'application/json; charset=utf-8',
		dataType : 'json',
		data : JSON.stringify(notificacion)
	})
}