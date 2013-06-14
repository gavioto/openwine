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

import com.grafenonet.openwine.maestros.domain.Pais;
import com.grafenonet.openwine.maestros.service.PaisService;

@Controller
@RequestMapping(value = "/admin/maestros/pais")
public class PaisController {	
	private static final Logger LOG = LoggerFactory.getLogger(PaisController.class);
	
	@Autowired
	private PaisService paisService;	
	
	@ModelAttribute("year")
	public String populateYear() {
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		return year.toString();
	}	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		LOG.debug("Iniciando controlador get ...");
		
		List<Pais> paises = this.paisService.list();	
		
		model.addAttribute("moduleTitle", "Gestión de paises"); 
		
		model.addAttribute("paises", paises);
		
		LOG.debug("Finalizando controlador list.");
		return "/admin/maestros/pais/listarPais";
	}

	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String create(Model model) {
		LOG.debug("Iniciando controlador create.GET ...");
		
		Pais pais = new Pais();
		
		model.addAttribute("moduleTitle", "Nuevo Pais"); 
		
		model.addAttribute("pais", pais);
		
		LOG.debug("Finalizando controlador create.GET.");
		return "/admin/maestros/pais/crearPais";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public ModelAndView create(@Valid @ModelAttribute("pais") Pais pais, BindingResult result, final RedirectAttributes redirectAttributes) {
		LOG.debug("Iniciando controlador create.POST ...");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("moduleTitle", "Nuevo Pais");
		
		if (result.hasErrors()) {
			LOG.debug(" - errores en la petición : " + result.toString());
			mav.setViewName("/admin/maestros/pais/crearPais");
			return mav;
		}
		
		this.paisService.create(pais);
		if (pais == null || pais.getId() == null) {
			LOG.debug(" - pais no creado.");
			mav.setViewName("/admin/maestros/pais/crearPais");
			return mav;
		}		
		
		LOG.debug("Finalizando controlador create.POST.");
		mav.setViewName("redirect:/admin/maestros/pais");
		return mav;		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador view ...");		
	
		Pais pais = this.paisService.get(id);

		model.addAttribute("moduleTitle", "Ver País"); 
		
		model.addAttribute("pais", pais);
		
		LOG.debug("Finalizando controlador view.");
		return "/admin/maestros/pais/verPais";
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador edit.GET ...");		
		
		Pais pais = this.paisService.get(id);

		model.addAttribute("moduleTitle", "Editar País"); 
		
		model.addAttribute("pais", pais);
		
		LOG.debug("Finalizando controlador edit.GET.");
		return "/admin/maestros/pais/editarPais";		
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") Integer id, @Valid @ModelAttribute("pais") Pais pais, BindingResult result, final RedirectAttributes redirectAttributes) {
		LOG.debug("Iniciando controlador edit.POST ...");		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("moduleTitle", "Editar Pais");		
		
		if (result.hasErrors()) {
			mav.setViewName("/admin/maestros/pais/editarPais");
			return mav;
		}
		
		this.paisService.update(pais);

		
		LOG.debug("Finalizando controlador edit.POST.");
		mav.setViewName("redirect:/admin/maestros/pais");
		return mav;		
	}

	@RequestMapping(value = "/{id}/borrar", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador delete ...");		
		
		Pais pais = this.paisService.get(id);
		if (pais == null || pais.getId() == null) {
			throw new RuntimeException("País no existe");
		}

		this.paisService.delete(pais);
		
		LOG.debug("Finalizando controlador delete.");
		return "redirect:/admin/maestros/pais";
	}	
	

}
