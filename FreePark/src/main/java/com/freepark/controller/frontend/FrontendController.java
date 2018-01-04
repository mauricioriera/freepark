package com.freepark.controller.frontend;

import java.util.Set;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.freepark.domain.Estacionamiento;
import com.freepark.domain.Playa;
import com.freepark.domain.Reserva;
import com.freepark.domain.Usuario;
import com.freepark.service.impl.PlayaServiceImpl;
import com.freepark.service.impl.ReservaServiceImpl;
import com.freepark.service.impl.UsuarioServiceImpl;

@Controller
@RequestMapping("frontend/")
public class FrontendController {
	private final static String URL_INDEX = "frontend/index";
	private final static String URL_INFOPLAYA = "frontend/infoPlaya";
	private final static String URL_INFORESERVA = "frontend/infoReserva";
	private Date date;
	private static final Logger logger = LoggerFactory.getLogger(FrontendController.class);

	@Autowired
	private PlayaServiceImpl playaService;

	@Autowired
	private ReservaServiceImpl reservaService;

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@InitBinder
	protected void reservaBinder(WebDataBinder binder) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		simpledateformat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaIngreso", new CustomDateEditor(simpledateformat, true));
		binder.registerCustomEditor(Date.class, "fechaSalida", new CustomDateEditor(simpledateformat, true));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) throws JsonGenerationException, JsonMappingException, IOException {
		StringWriter stringEmp = new StringWriter();
		ObjectMapper OM = new ObjectMapper();
		OM.writeValue(stringEmp, playaService.findAll());
		model.addAttribute("playas", stringEmp.toString());
		return URL_INDEX;
	}

	@RequestMapping(value = "{id}/infoplaya", method = RequestMethod.GET)
	public String infoPlaya(@PathVariable Long id, Model model) {
		date = new Date(System.currentTimeMillis());
		Playa playa = playaService.findById(id);
		Usuario usuario = usuarioService.findById((long) 27);
		model.addAttribute("playa", playa);
		model.addAttribute("usuario", usuario);
		model.addAttribute("reserva", new Reserva());
		
		int count = 0;
		int porcentaje = 0;

		for (Estacionamiento estacionamiento : playa.getEstacionamientos()) {
			try {
				if (estacionamiento.getReserva() != null
						&& (estacionamiento.getReserva().getFechaSalida().getTime() - date.getTime()) > 0)
					count++;
			} catch (NullPointerException e) {

			}

		}

		try {
			porcentaje = ((count * 100) / playa.getEstacionamientos().size());
		} catch (Exception e) {

		}

		model.addAttribute("porcentaje", porcentaje);
		return URL_INFOPLAYA;
	}

	@RequestMapping(value = "{id}/infoplaya", method = RequestMethod.POST)
	public String crearReserva(@PathVariable Long id, @Valid Reserva reserva) {
		date = new Date(System.currentTimeMillis());
		Set<Estacionamiento> estacionamientos = playaService.findById(id).getEstacionamientos();

		for (Estacionamiento e : estacionamientos) {
			try {
				logger.info(e.getReserva().toString());

				if (((date.getTime() - e.getReserva().getFechaSalida().getTime()) > 0)) {
					reserva.setEstacionamiento(e);
					break;
				}
			} catch (NullPointerException ex) {
				reserva.setEstacionamiento(e);
				break;
			}
		}

		reservaService.create(reserva);
		return "redirect:/frontend/";
	}

	@RequestMapping(value = "{id}/inforeserva", method = RequestMethod.GET)
	public String infoReserva(@PathVariable Long id, Model model) {
		model.addAttribute("reservas", reservaService.findAll());
		return URL_INFORESERVA;
	}

}
