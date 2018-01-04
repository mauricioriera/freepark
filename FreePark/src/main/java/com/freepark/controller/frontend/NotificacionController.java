package com.freepark.controller.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.freepark.domain.Notificacion;
import com.freepark.domain.Usuario;
import com.freepark.service.impl.NotificacionServiceImpl;
import com.freepark.service.impl.UsuarioServiceImpl;

@Controller
@RequestMapping("notificaciones/")
public class NotificacionController {
	private static final Logger logger = LoggerFactory.getLogger(NotificacionController.class);

	@Autowired
	private NotificacionServiceImpl service;
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@RequestMapping(value = "/mensajes", method = RequestMethod.POST)
	@ResponseBody
	public boolean create(@RequestBody Notificacion notificacion){	
		Notificacion n = null;
		
		service.create(notificacion);
		
		int i = 0;
		while(i++ != 20){
			n = service.findByIdEmisorAndIdReceptor(notificacion.getIdEmisor(), notificacion.getIdReceptor());
	       
    		if(n.getTipo().equals("Aceptada")){
    			service.removeById(n.getId());
    			return true;
    		}else if(n.getTipo().equals("Rechazada")){
    			service.removeById(n.getId());
    			return false;
    		}
	       
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		service.removeById(n.getId());
		return false;
	}
	
	@RequestMapping(value = "/{id}/mensajes", method = RequestMethod.GET)
	public @ResponseBody Usuario respuestas(@PathVariable Long id){
			for(Notificacion n : service.findAll()){
	        	if(n.getIdReceptor() == id){
	        		if(n.getTipo().equals("peticion")){
	        			n.setTipo("Recibida");
	        			service.update(n);
	        			return usuarioService.findById(n.getIdEmisor());	
	        		}
	        	}
	        }
		
		return null;
	}
	
	@RequestMapping(value = "/responder", method = RequestMethod.POST)
	@ResponseBody
	public void responder(@RequestBody Notificacion notificacion){
		notificacion.setId(service.findByIdEmisorAndIdReceptor(notificacion.getIdEmisor(), notificacion.getIdReceptor()).getId());
		service.update(notificacion);
	}
	
	
}
