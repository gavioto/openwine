package com.grafenonet.openwine.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grafenonet.openwine.caderno.domain.Gasoleo;
import com.grafenonet.openwine.caderno.service.CadernoService;
import com.grafenonet.openwine.caderno.service.GasoleoService;

@Controller
@RequestMapping(value = "caderno")
public class CadernoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CadernoController.class);
	
	@Autowired
	CadernoService cadernoService;
	
	@Autowired 
	GasoleoService ticketGasoilService;	
	
	@RequestMapping(value = "/caderno", method = RequestMethod.GET)
	public String gasoleo(Model model) {
		LOG.debug("Iniciando controlador caderno ...");
		
		
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		
		Gasoleo ticket = cadernoService.getResumenTickets(year);
		
		model.addAttribute("moduleTitle", "Cadro de mando do Caderno de Campo");
		model.addAttribute("year", year.toString());
		
		model.addAttribute("importeTotal", ticket.getImporte());
		model.addAttribute("litrosTotal", ticket.getLitros());
		
		LOG.debug("Finalizando controlador caderno.");
		return "caderno/dashboard";
	}	

}
