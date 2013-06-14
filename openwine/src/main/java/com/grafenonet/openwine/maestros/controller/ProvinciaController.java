package com.grafenonet.openwine.maestros.controller;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grafenonet.openwine.maestros.controller.validator.ProvinciaValidator;
import com.grafenonet.openwine.maestros.domain.Pais;
import com.grafenonet.openwine.maestros.domain.Provincia;
import com.grafenonet.openwine.maestros.service.PaisService;
import com.grafenonet.openwine.maestros.service.ProvinciaService;

@Controller
@RequestMapping(value = "/admin/maestros/provincia")
public class ProvinciaController {
	private static Logger LOG = LoggerFactory.getLogger(ProvinciaController.class);
	
	@Autowired
	private ProvinciaService provinciaService;
	
	@Autowired 
	private PaisService paisService;
	
	@Autowired
	private ProvinciaValidator provinciaValidator;
	
	@ModelAttribute("year")
	public String populateYear() {
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		return year.toString();
	}
	
	@ModelAttribute("paises")
	public List<Pais> populatePais() {
		return paisService.list();
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(provinciaValidator);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		LOG.debug("Iniciando controlador list ...");
		
		List<Provincia> provincias = this.provinciaService.list();
		
		model.addAttribute("moduleTitle", "Gestión de provincias.");
		
		model.addAttribute("provincias", provincias);
		
		LOG.debug("Finalizando controlador list.");
		return "/admin/maestros/provincia/listarProvincia";		
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String create(Model model) {
		LOG.debug("Iniciando controlador create.GET ...");
		
		Provincia provincia = new Provincia();
		
		model.addAttribute("moduleTitle", "Nueva provincia");		
		
		model.addAttribute("provincia", provincia);
		
		LOG.debug("Finalizando controlador create.GET.");
		return "/admin/maestros/provincia/crearProvincia";		
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public ModelAndView create(@Valid @ModelAttribute("provincia") Provincia provincia, BindingResult result, final RedirectAttributes redirectAttributes) {
		LOG.debug("Iniciando controlador create.POST ...");		
			
		if (result.hasErrors()) {
			return new ModelAndView("/admin/maestros/provincia/crearProvincia");
		}
		
		ModelAndView mav = new ModelAndView();
		
		this.provinciaService.create(provincia);
		if (provincia.getId() == null) {
			return new ModelAndView("/admin/maestros/provincia/crearProvincia");
		}
		
		mav.setViewName("redirect:/admin/maestros/provincia");
		
		LOG.debug("Finalizando controlador create.POST.");		
		return mav;
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador edit.GET ...");		
		
		Provincia provincia = this.provinciaService.get(id);

		model.addAttribute("moduleTitle", "Editar Provincia"); 
		
		model.addAttribute("provincia", provincia);
		
		LOG.debug("Finalizando controlador edit.GET.");
		return "/admin/maestros/provincia/editarProvincia";		
	}	
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") Integer id, @Valid @ModelAttribute("provincia") Provincia provincia, BindingResult result, final RedirectAttributes redirectAttributes) {
		LOG.debug("Iniciando controlador edit.POST ...");		
		
		if (result.hasErrors()) {
			return new ModelAndView("/admin/maestros/provincia/editarProvincia");
		}
		
		ModelAndView mav = new ModelAndView();
		
		this.provinciaService.update(provincia);
		
		mav.setViewName("redirect:/admin/maestros/provincia");

		
		LOG.debug("Finalizando controlador edit.POST.");
		return mav;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador view ...");		
	
		Provincia provincia = this.provinciaService.get(id);

		model.addAttribute("moduleTitle", "Ver Provincia"); 
		
		model.addAttribute("provincia", provincia);
		
		LOG.debug("Finalizando controlador view.");
		return "/admin/maestros/provincia/verProvincia";
	}	
	
	@RequestMapping(value = "/{id}/borrar", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador delete ...");		
		
		Provincia provincia = this.provinciaService.get(id);
		if (provincia == null || provincia.getId() == null) {
			throw new RuntimeException("Provincia no existe");
		}

		this.provinciaService.delete(provincia);
		
		LOG.debug("Finalizando controlador delete.");
		return "redirect:/admin/maestros/provincia";
	}		
}
