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
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grafenonet.openwine.cuaderno.domain.Variedad;
import com.grafenonet.openwine.cuaderno.enums.MaduracionVariedad;
import com.grafenonet.openwine.cuaderno.enums.ProductividadVariedad;
import com.grafenonet.openwine.cuaderno.enums.TipoVariedad;
import com.grafenonet.openwine.cuaderno.service.VariedadService;
import com.grafenonet.openwine.cuaderno.validator.VariedadValidator;

@Controller
@RequestMapping(value = "/admin/cuaderno/variedad")
public class VariedadController {
	private static Logger LOG = LoggerFactory.getLogger(VariedadController.class);
	
	private final Integer YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	@Autowired
	private VariedadService variedadService;
	
	@Autowired 
	private VariedadValidator variedadValidator;	
	
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
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		LOG.debug("Iniciando controlador variedades ...");
		
		List<Variedad> variedades = variedadService.list();
		
		model.addAttribute("moduleTitle", "Gestión de variedades de vid");
		model.addAttribute("year", this.YEAR);
		
		model.addAttribute("variedades", variedades);
		model.addAttribute("numRegistros", variedades != null ? variedades.size() : 0);
		
		LOG.debug("Finalizando controlador variedades.");
		return "/admin/cuaderno/variedad/variedades";		
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String create(Model model) {
		LOG.debug("Iniciando controlador variedades nueva GET ...");
		
		Variedad variedad = new Variedad();
		
		model.addAttribute("moduleTitle", "Gestión de variedades de vid");		
		model.addAttribute("year", this.YEAR);
		
		model.addAttribute("variedad", variedad);
		
		LOG.debug("Finalizando controlador variedades nueva GET.");
		return "/admin/cuaderno/variedad/nuevoVariedad";		
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("variedad") Variedad variedad, BindingResult result) {
		LOG.debug("Iniciando controlador variedades nueva POST ...");		
		
		ValidationUtils.invokeValidator(variedadValidator, variedad, result);		
		if (result.hasErrors()) {
			return "/admin/cuaderno/variedad/nuevoVariedad";
		}
		
		this.variedadService.create(variedad);
		
		LOG.debug("Finalizando controlador variedades nueva POST.");
		
		return "redirect:/admin/cuaderno/variedad";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(variedadValidator);
	}
}
