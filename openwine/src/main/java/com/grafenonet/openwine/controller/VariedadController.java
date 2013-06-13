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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grafenonet.openwine.cuaderno.domain.Variedad;
import com.grafenonet.openwine.cuaderno.enums.CalificacionVariedad;
import com.grafenonet.openwine.cuaderno.enums.MaduracionVariedad;
import com.grafenonet.openwine.cuaderno.enums.ProductividadVariedad;
import com.grafenonet.openwine.cuaderno.enums.TipoVariedad;
import com.grafenonet.openwine.cuaderno.service.VariedadService;
import com.grafenonet.openwine.cuaderno.validator.VariedadValidator;

@Controller
@RequestMapping(value = "/admin/cuaderno/variedad")
public class VariedadController {
	private static Logger LOG = LoggerFactory.getLogger(VariedadController.class);	
	
	@Autowired
	private VariedadService variedadService;
	
	@Autowired
	private VariedadValidator variedadValidator;	
	
	@ModelAttribute("year")
	public String populateYear() {
		Integer year = Calendar.getInstance().get(Calendar.YEAR);
		return year.toString();
	}
	
	@ModelAttribute("tipos")
	public List<TipoVariedad> populateTipoVariedad() {
		return TipoVariedad.asList();
	}
	
	@ModelAttribute("productividades")
	public List<ProductividadVariedad> populateProductividad() {
		return ProductividadVariedad.asList();
	}
	
	@ModelAttribute("maduraciones")
	public List<MaduracionVariedad> populateMaduracion() {
		return MaduracionVariedad.asList();
	}
	
	@ModelAttribute("calificaciones")
	public List<CalificacionVariedad> populateCalificacion() {
		return CalificacionVariedad.asList();
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		LOG.debug("Iniciando controlador variedades ...");
		
		List<Variedad> variedades = variedadService.list();
		
		model.addAttribute("moduleTitle", "Gestión de variedades.");
		
		model.addAttribute("variedades", variedades);
		
		LOG.debug("Finalizando controlador variedades.");
		return "/admin/cuaderno/variedad/listarVariedad";		
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String create(Model model) {
		LOG.debug("Iniciando controlador create.GET ...");
		
		Variedad variedad = new Variedad();
		
		model.addAttribute("moduleTitle", "Gestión de variedades de vid");		
		
		model.addAttribute("variedad", variedad);
		
		LOG.debug("Finalizando controlador create.GET.");
		return "/admin/cuaderno/variedad/crearVariedad";		
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public ModelAndView create(@Valid @ModelAttribute("variedad") Variedad variedad, BindingResult result) {
		LOG.debug("Iniciando controlador create.POST ...");		
			
		if (result.hasErrors()) {
			return new ModelAndView("/admin/cuaderno/variedad/crearVariedad");
		}
		
		ModelAndView mav = new ModelAndView();
		
		this.variedadService.create(variedad);
		if (variedad.getId() == null) {
			return new ModelAndView("/admin/cuaderno/variedad/crearVariedad");
		}
		
		mav.setViewName("redirect:/admin/cuaderno/variedad");
		
		LOG.debug("Finalizando controlador create.POST.");		
		return mav;
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador edit.GET ...");		
		
		Variedad variedad = this.variedadService.get(id);

		model.addAttribute("moduleTitle", "Editar variedad"); 
		
		model.addAttribute("variedad", variedad);
		
		LOG.debug("Finalizando controlador edit.GET.");
		return "/admin/cuaderno/variedad/editarVariedad";		
	}	
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView edit(@PathVariable("id") Integer id, @Valid @ModelAttribute("variedad") Variedad variedad, BindingResult result, final RedirectAttributes redirectAttributes) {
		LOG.debug("Iniciando controlador edit.POST ...");		
		
		if (result.hasErrors()) {
			return new ModelAndView("/admin/cuaderno/variedad/editarVariedad");
		}
		
		ModelAndView mav = new ModelAndView();
		
		this.variedadService.update(variedad);
		
		mav.setViewName("redirect:/admin/cuaderno/variedad");

		
		LOG.debug("Finalizando controlador edit.POST.");
		return mav;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String view(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador view ...");		
	
		Variedad variedad = this.variedadService.get(id);

		model.addAttribute("moduleTitle", "Ver Variedad"); 
		
		model.addAttribute("variedad", variedad);
		
		LOG.debug("Finalizando controlador view.");
		return "/admin/cuaderno/variedad/verVariedad";
	}	
	
	@RequestMapping(value = "/{id}/borrar", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Integer id, Model model) {
		LOG.debug("Iniciando controlador delete ...");		
		
		Variedad variedad = this.variedadService.get(id);
		if (variedad == null || variedad.getId() == null) {
			throw new RuntimeException("Variedad no existe");
		}

		this.variedadService.delete(variedad);
		
		LOG.debug("Finalizando controlador delete.");
		return "redirect:/admin/cuaderno/variedad";
	}	
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(variedadValidator);
	}
}
