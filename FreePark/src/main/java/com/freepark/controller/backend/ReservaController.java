package com.freepark.controller.backend;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freepark.domain.Reserva;
import com.freepark.service.impl.ReservaServiceImpl;

@Controller
@RequestMapping("backend/reservas/")
public class ReservaController {

	private static final String URL_INDEX = "backend/reservas/index";
	private static final String URL_NUEVO = "backend/reservas/nuevo";
	private static final String URL_REDIRECT = "redirect:/backend/reservas/";
	private static final Logger logger = LoggerFactory.getLogger(ReservaController.class);
	
	@Autowired
	private ReservaServiceImpl service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("reservas", service.findAll());
		return URL_INDEX;
	}
	
	@RequestMapping(value = "/eliminar/{id_reserva}", method = RequestMethod.GET)
	public String eliminar(@Valid @PathVariable("id_reserva") long id_reserva) {
		service.removeById(id_reserva);
		return URL_REDIRECT;
	}
	
}