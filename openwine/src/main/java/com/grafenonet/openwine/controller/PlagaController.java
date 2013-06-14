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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grafenonet.openwine.cuaderno.domain.Plaga;
import com.grafenonet.openwine.cuaderno.service.PlagaService;

@Controller
@RequestMapping(value = "/admin/cuaderno/plaga")
public class PlagaController {
	private static Logger LOG = LoggerFactory.getLogger(PlagaController.class);
	
	@Autowired
	private PlagaService plagaService;
	
	@ModelAttribute("year")
	public String populateYear() {
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		return year.toString();
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		LOG.debug("Iniciando controlador list ...");
		
		List<Plaga> plagas = this.plagaService.list();	
		
		model.addAttribute("moduleTitle", "Gestión de plagas"); 
		
		model.addAttribute("plagas", plagas);
		
		LOG.debug("Finalizando controlador list.");
		return "/admin/cuaderno/plaga/listarPlaga";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String create(Model model) {
		LOG.debug("Iniciando controlador create.GET ...");
		
		Plaga plaga = new Plaga();
		
		model.addAttribute("moduleTitle", "Nueva Plaga"); 
		
		model.addAttribute("plaga", plaga);
		
		LOG.debug("Finalizando controlador create.GET.");
		return "/admin/cuaderno/plaga/crearPlaga";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public ModelAndView create(@Valid @ModelAttribute("plaga") Plaga plaga, BindingResult result, final RedirectAttributes redirectAttributes) {
		LOG.debug("Iniciando controlador create.POST ...");
		
		if (result.hasErrors()) {
			return new ModelAndView("/admin/cuaderno/plaga/crearPlaga");
		}
		
		this.plagaService.create(plaga);
		if (plaga == null || plaga.getId() == null) {
			return new ModelAndView("/admin/cuaderno/plaga/crearPlaga");
		}		
		
		LOG.debug("Finalizando controlador create.POST.");
		return new ModelAndView("redirect:/admin/cuaderno/plaga");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador view ...");		
	
		Plaga plaga = this.plagaService.get(id);

		model.addAttribute("moduleTitle", "Ver plaga"); 
		
		model.addAttribute("plaga", plaga);
		
		LOG.debug("Finalizando controlador view.");
		return "/admin/cuaderno/plaga/verPlaga";
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador edit.GET ...");		
		
		Plaga plaga = this.plagaService.get(id);

		model.addAttribute("moduleTitle", "Editar plaga"); 
		
		model.addAttribute("plaga", plaga);
		
		LOG.debug("Finalizando controlador edit.GET.");
		return "/admin/cuaderno/plaga/editarPlaga";		
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") Integer id, @Valid @ModelAttribute("plaga") Plaga plaga, BindingResult result, final RedirectAttributes redirectAttributes) {
		LOG.debug("Iniciando controlador edit.POST ...");		
		
		if (result.hasErrors()) {
			return new ModelAndView("/admin/cuaderno/plaga/editarPlaga");
		}
		
		this.plagaService.update(plaga);

		
		LOG.debug("Finalizando controlador edit.POST.");
		return new ModelAndView("redirect:/admin/cuaderno/plaga");
	}

	@RequestMapping(value = "/{id}/borrar", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador delete ...");		
		
		Plaga plaga = this.plagaService.get(id);
		if (plaga == null || plaga.getId() == null) {
			throw new RuntimeException("Plaga no existe");
		}

		this.plagaService.delete(plaga);
		
		LOG.debug("Finalizando controlador delete.");
		return "redirect:/admin/cuaderno/plaga";
	}	
	
}
