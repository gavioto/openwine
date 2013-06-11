package com.grafenonet.openwine.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grafenonet.openwine.maestros.domain.Pais;
import com.grafenonet.openwine.maestros.service.PaisService;

@Controller
public class PaisController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PaisController.class);
	
	@Autowired
	PaisService paisService;
	
	@RequestMapping(value = "/admin/maestros/pais", method = RequestMethod.GET)
	public String paises(Model model) {
		LOG.debug("Iniciando controlador paises ...");
		
		List<Pais> paises = paisService.list();
		
		model.addAttribute("moduleTitle", "Maestro de paises");
		model.addAttribute("paises", paises);
		model.addAttribute("numRegistros", paises.size());		
		
		LOG.debug("Finalizando controlador paises.");
		return "admin/maestros/pais/paises";
	}

}
