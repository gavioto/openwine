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
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grafenonet.openwine.cuaderno.validator.UsuarioValidator;
import com.grafenonet.openwine.maestros.domain.Rol;
import com.grafenonet.openwine.maestros.domain.Usuario;
import com.grafenonet.openwine.maestros.service.RolService;
import com.grafenonet.openwine.maestros.service.UsuarioService;

@Controller
@RequestMapping(value = "/admin/maestros/usuario")
public class UsuarioController {
	private static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
	
	private final Integer YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RolService rolService;
	
	@Autowired
	private UsuarioValidator usuarioValidator;
	
	@ModelAttribute("roles")
	public List<Rol> populateRol() {
		return this.rolService.list();
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		LOG.debug("Iniciando controlador usuarios ...");
		
		List<Usuario> usuarios = usuarioService.list();	
		
		model.addAttribute("moduleTitle", "Gestión de usuarios"); 
		model.addAttribute("year", this.YEAR);
		
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("numRegistros", usuarios != null ? usuarios.size() : 0);
		
		LOG.debug("Finalizando controlador usuarios.");
		return "/admin/maestros/usuario/usuarios";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String create(Model model) {
		LOG.debug("Iniciando controlador nuevo ...");
		
		Usuario usuario = new Usuario();
		
		model.addAttribute("moduleTitle", "Nuevo usuario");
		model.addAttribute("year", this.YEAR);
		
		model.addAttribute("usuario", usuario );
		
		LOG.debug("Finalizando controlador nuevo.");
		return "/admin/maestros/usuario/nuevoUsuario";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		LOG.debug("Iniciando controlador nuevo POST ...");
		
		ValidationUtils.invokeValidator(usuarioValidator, usuario, result);	
		if (result.hasErrors()) {
			return "/admin/maestros/usuario/nuevoUsuario";
		}
		
		this.usuarioService.create(usuario);
		if (usuario == null || usuario.getId() == null) {
			return "/admin/maestros/usuario/nuevoUsuario";
		}
		
		LOG.debug("Finalizando controlador nuevo POST.");
		return "redirect:/admin/maestros/usuario";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(usuarioValidator);
	}
}
