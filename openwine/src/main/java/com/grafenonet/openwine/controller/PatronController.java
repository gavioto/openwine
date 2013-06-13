package com.grafenonet.openwine.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grafenonet.openwine.cuaderno.domain.Patron;
import com.grafenonet.openwine.cuaderno.service.PatronService;

@Controller
@RequestMapping(value = "/admin/cuaderno/patron")
public class PatronController {
	private static Logger LOG = LoggerFactory.getLogger(PatronController.class);
	
	@Autowired
	private PatronService patronService;
	
	@ModelAttribute("year")
	public String populateYear() {
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		return year.toString();
	}	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		LOG.debug("Iniciando controlador listar ...");
		
		List<Patron> patrones = this.patronService.list();	
		
		model.addAttribute("moduleTitle", "Gestión de patrones"); 
		
		model.addAttribute("patrones", patrones);
		
		LOG.debug("Finalizando controlador listar.");
		return "/admin/cuaderno/patron/listarPatron";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String create(Model model) {
		LOG.debug("Iniciando controlador create.GET ...");
		
		Patron patron = new Patron();
		
		model.addAttribute("moduleTitle", "Nuevo patrón"); 
		
		model.addAttribute("patron", patron);
		
		LOG.debug("Finalizando controlador create.GET.");
		return "/admin/cuaderno/patron/crearPatron";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("patron") Patron patron, BindingResult result) {
		LOG.debug("Iniciando controlador create.POST ...");
		
		if (result.hasErrors()) {
			return "/admin/cuaderno/patron/crearPatron";
		}
		
		this.patronService.create(patron);
		if (patron == null || patron.getId() == null) {
			return "/admin/cuaderno/patron/crearPatron";
		}		
		
		LOG.debug("Finalizando controlador create.POST.");
		return "redirect:/admin/cuaderno/patron";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador view ...");		
	
		Patron patron = this.patronService.get(id);

		model.addAttribute("moduleTitle", "Ver patrón"); 
		
		model.addAttribute("patron", patron);
		
		LOG.debug("Finalizando controlador view.");
		return "/admin/cuaderno/patron/verPatron";
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador edit.GET ...");		
		
		Patron patron = this.patronService.get(id);

		model.addAttribute("moduleTitle", "Editar patrón"); 
		
		model.addAttribute("patron", patron);
		
		LOG.debug("Finalizando controlador edit.GET.");
		return "/admin/cuaderno/patron/editarPatron";		
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public String edit(@PathVariable("id") Integer id, @Valid @ModelAttribute("patron") Patron patron, BindingResult result) {
		LOG.debug("Iniciando controlador edit.POST ...");		
		
		if (result.hasErrors()) {
			return "/admin/cuaderno/patron/editarPatron";
		}
		
		this.patronService.update(patron);

		
		LOG.debug("Finalizando controlador edit.POST.");
		return "redirect:/admin/cuaderno/patron";
	}

	@RequestMapping(value = "/{id}/borrar", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador delete ...");		
		
		Patron patron = this.patronService.get(id);
		if (patron == null || patron.getId() == null) {
			throw new RuntimeException("Patrón no existe");
		}

		this.patronService.delete(patron);
		
		LOG.debug("Finalizando controlador delete.");
		return "redirect:/admin/cuaderno/patron";
	}	
}
