package com.grafenonet.openwine.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grafenonet.openwine.domain.TicketGasoil;
import com.grafenonet.openwine.service.TicketGasoilService;

@Controller
public class GasoleoController {
	private static final Logger LOG = LoggerFactory.getLogger(GasoleoController.class);
	
	private static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyy");
	
	@Autowired
	TicketGasoilService ticketGasoilService;
	
	@RequestMapping(value = "/caderno/gasoleo", method = RequestMethod.GET)
	public String gasoleo(Model model) {
		LOG.debug("Iniciando controlador gasoleo ...");

		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		year = year - 1;
		
		List<TicketGasoil> lista = ticketGasoilService.findAll(year);
		
		model.addAttribute("moduleTitle", "Tickets de Gasóleo");
		model.addAttribute("tickets", lista);
		model.addAttribute("numRegistros", lista.size());
		
		LOG.debug("Finalizando controlador gasoleo.");
		return "caderno/gasoleo/gasoleo";
	}
	
	@RequestMapping(value = "/caderno/gasoleo/novo", method = RequestMethod.GET)
	public String create(Model model) {
		
		Calendar calendar = Calendar.getInstance();
		Integer year = calendar.get(Calendar.YEAR);
		String today = DATE_FORMAT.format(calendar.getTime());
		TicketGasoil ticket = new TicketGasoil();
		
		model.addAttribute("moduleTitle", "Novo ticket de gasóleo:");
		model.addAttribute("year", year.toString());
		model.addAttribute("today", today);
		model.addAttribute("ticket", ticket);
		
		
		return "caderno/gasoleo/novo";
	}
	
	@RequestMapping(value = "/caderno/gasoleo/novo", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ticket") TicketGasoil ticket, BindingResult result) {
		LOG.debug("Iniciando controlador create ...");
		
		if (result.hasErrors()) {
			return null;
		}
		this.ticketGasoilService.save(ticket);
		
		LOG.debug("Finalizando controlador ticket gasoleo.");
		
		return "redirect:/caderno/gasoleo";
	}

}
