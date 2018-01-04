package com.freepark.controller.middle;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.freepark.domain.Reserva;
import com.freepark.service.impl.EstacionamientoServiceImpl;
import com.freepark.service.impl.PlayaServiceImpl;
import com.freepark.service.impl.ReservaServiceImpl;


@Controller
@RequestMapping("middle/")
public class MiddleController {
	private static final String URL_INDEX = "middle/index";
	private static final String URL_NUEVO = "middle/nuevo";
	private static final String URL_INFO = "middle/info";
	private static final String URL_REDIRECT = "redirect:/middle/";
	private Date date;
	private static final Logger logger = LoggerFactory.getLogger(MiddleController.class);
	
	@Autowired
	private PlayaServiceImpl playaServiceImpl;
	
	@Autowired
	private ReservaServiceImpl reservaServiceImpl;
	
	@Autowired
	private EstacionamientoServiceImpl estacionamientoServiceImpl;
	
	@InitBinder
	protected void reservaBinder(WebDataBinder binder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		simpleDateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaIngreso", new CustomDateEditor(simpleDateFormat, true));
		binder.registerCustomEditor(Date.class, "fechaSalida", new CustomDateEditor(simpleDateFormat, true));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {	
		date = new Date(System.currentTimeMillis());
		model.addAttribute("playa", playaServiceImpl.findById((long) 30));
		model.addAttribute("fechaActual", date);
		return URL_INDEX;
	}
	
	@RequestMapping(value = "/nuevo/{id_estacionamiento}", method = RequestMethod.GET)
	public String nuevo(@Valid @PathVariable("id_estacionamiento") Long id_estacionamiento, Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("playa", playaServiceImpl.findById((long) 30));
		model.addAttribute("id_estacionamiento", id_estacionamiento);
		return URL_NUEVO;
	}
	
	@RequestMapping(value="/nuevo/{id_estacionamiento}", method= RequestMethod.POST)
	public String nuevo(Reserva reserva, BindingResult result) {
		if (!result.hasErrors()) {
			date = new Date(System.currentTimeMillis());
			reserva.setFechaIngreso(date);
			reservaServiceImpl.create(reserva);
			return URL_REDIRECT;
		} else {
			for (ObjectError error : result.getAllErrors()) {
				logger.info("Validation error: " + error.getDefaultMessage());
			}
		}
		return URL_NUEVO;
	}
	
	@RequestMapping(value = "/info/{id_estacionamiento}", method = RequestMethod.GET)
	public String info(@Valid @PathVariable("id_estacionamiento") Long id_estacionamiento, Model model) {	
		model.addAttribute("estacionamiento", estacionamientoServiceImpl.findById(id_estacionamiento));
		model.addAttribute("playa", playaServiceImpl.findById((long) 30));

		return URL_INFO;
	}
	
}
