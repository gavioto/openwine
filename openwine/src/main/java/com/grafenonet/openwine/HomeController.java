package com.grafenonet.openwine;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grafenonet.openwine.cuaderno.domain.Gasoleo;
import com.grafenonet.openwine.cuaderno.service.GasoleoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	GasoleoService ticketGasoilService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOG.debug("Iniciando controlador home ...");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date);
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		
		List<Gasoleo> tickets = new ArrayList<Gasoleo>(); 
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("tickets", tickets);
		//model.addAttribute("tickets", ticketGasoilService.findAll(year));
		
		LOG.debug("Finalizando controlador home ...");
		return "home";
	}
	
}
