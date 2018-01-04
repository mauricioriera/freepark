package com.freepark.segurity;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freepark.domain.Usuario;
import com.freepark.repository.UsuarioRepository;
import com.freepark.service.impl.UsuarioServiceImpl;

@Controller
@RequestMapping("/")
public class LoginController {

	private static final String URL_INDEX = "login/login";
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("usuario", new Usuario());
		return URL_INDEX;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String index(@Valid Usuario usuario) {
		logger.info("1: " + usuario.getUsername());
		String redirect;
		usuario = usuarioServiceImpl.findByUsername(usuario.getUsername());
		logger.info("2");
		if (usuario.getRoles().getId() == 1) {
			redirect = "redirect:/backend/default/";
		} 
		else if (usuario.getRoles().getId() == 2) {
			redirect = "redirect:/middle/";
		} 
		else {
			redirect = "redirect:/frontend/";
		}

		return redirect;
	}
	
}