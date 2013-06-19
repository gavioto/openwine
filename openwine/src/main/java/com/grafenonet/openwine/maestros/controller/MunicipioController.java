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

import com.grafenonet.openwine.maestros.controller.validator.MunicipioValidator;
import com.grafenonet.openwine.maestros.domain.Municipio;
import com.grafenonet.openwine.maestros.domain.Pais;
import com.grafenonet.openwine.maestros.domain.Provincia;
import com.grafenonet.openwine.maestros.service.MunicipioService;
import com.grafenonet.openwine.maestros.service.PaisService;
import com.grafenonet.openwine.maestros.service.ProvinciaService;

@Controller
@RequestMapping(value = "/admin/maestros/municipio")
public class MunicipioController {
	private static final Logger LOG = LoggerFactory.getLogger(MunicipioController.class);
	
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired 
	private ProvinciaService provinciaService;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired MunicipioValidator municipioValidator;
	
	@ModelAttribute("year")
	public String populateYear() {
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		return year.toString();
	}	
	
	@ModelAttribute("paises")
	public List<Pais> populatePais() {
		return this.paisService.list();
	}
	
	@ModelAttribute("provincias")
	public List<Provincia> populateProvincia() {
		return this.provinciaService.list();
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(municipioValidator);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)	
	public String list(Model model) {
		LOG.debug("Iniciando controlador list ...");
		
		List<Municipio> municipios = this.municipioService.list();
		
		model.addAttribute("moduleTitle", "Gestión de Municipios.");
		
		model.addAttribute("municipios", municipios);
		
		LOG.debug("Finalizando controlador list.");
		return "/admin/maestros/municipio/listarMunicipio";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)	
	public String create(Model model) {
		LOG.debug("Iniciando controlador create.GET ...");
		
		Municipio municipio = new Municipio();
		
		model.addAttribute("moduleTitle", "Nuevo Municipio");		
		
		model.addAttribute("municipio", municipio);
		
		LOG.debug("Finalizando controlador create.GET.");
	
		return "/admin/maestros/municipio/crearMunicipio";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public ModelAndView create(@Valid @ModelAttribute("municipio") Municipio munucipio, BindingResult result, final RedirectAttributes redirectAttributes) {
		LOG.debug("Iniciando controlador create.POST ...");		
			
		if (result.hasErrors()) {
			return new ModelAndView("/admin/maestros/municipio/crearMunicipio");
		}				
		
		this.municipioService.create(munucipio);
		if (munucipio.getId() == null) {
			return new ModelAndView("/admin/maestros/municipio/crearMunicipio");
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/admin/maestros/municipio");
		
		LOG.debug("Finalizando controlador create.POST.");		
		return mav;
	}	
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)	
	public String edit(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador edit.GET ...");		
		
		Municipio municipio = this.municipioService.get(id);

		model.addAttribute("moduleTitle", "Editar Municipio"); 
		
		model.addAttribute("municipio", municipio);
		
		LOG.debug("Finalizando controlador edit.GET.");
	
		return "/admin/maestros/municipio/edtarMunicipio";
	}	
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") Integer id, @Valid @ModelAttribute("municipio") Municipio municipio, BindingResult result, final RedirectAttributes redirectAttributes) {
		LOG.debug("Iniciando controlador edit.POST ...");		
		
		if (result.hasErrors()) {
			return new ModelAndView("/admin/maestros/municipio/editarMunicipio");
		}
		
		ModelAndView mav = new ModelAndView();
		
		this.municipioService.update(municipio);
		
		mav.setViewName("redirect:/admin/maestros/municipio");

		
		LOG.debug("Finalizando controlador edit.POST.");
		return mav;
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	public String view(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador view ...");		
		
		Municipio municipio = this.municipioService.get(id);

		model.addAttribute("moduleTitle", "Ver Municipio"); 
		
		model.addAttribute("municipio", municipio);
		
		LOG.debug("Finalizando controlador view.");		
		return "/admin/maestros/municipio/verMunicipio";
	}
	
	@RequestMapping(value = "/{id}/borrar", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador delete ...");		
		
		Municipio municipio = this.municipioService.get(id);
		if (municipio == null || municipio.getId() == null) {
			throw new RuntimeException("Municipio no existe");
		}

		this.municipioService.delete(municipio);
		
		LOG.debug("Finalizando controlador delete.");
		return "redirect:/admin/maestros/municipio";
	}	
	
}
