package com.grafenonet.openwine.maestros.controller;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grafenonet.openwine.domain.TicketGasoil;
import com.grafenonet.openwine.maestros.domain.Usuario;
import com.grafenonet.openwine.maestros.service.UsuarioService;
import com.grafenonet.openwine.maestros.service.impl.UsuarioServiceImpl;

@Controller
@RequestMapping(value = "/admin/maestros/usuario")
public class UsuarioController {
	private static Logger LOG = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/admin/maestros/usuario", method = RequestMethod.GET)
	public String usuarios(Model model) {
		LOG.debug("Iniciando controlador usuarios ...");
		
		List<Usuario> usuarios = usuarioService.list();
		
		model.addAttribute("moduleTitle", "Xestión de usuarios");
		
		model.addAttribute("usuarios", usuarios);
		
		LOG.debug("Finalizando controlador usuarios.");
		return "/admin/maestros/usuario/usuarios";
	}
	
	@RequestMapping(value = "/admin/maestros/usuario/novo", method = RequestMethod.GET)
	public String newUsuario(Model model) {
		LOG.debug("Iniciando controlador usuarios ...");
		
		Usuario usuario = new Usuario();
		
		model.addAttribute("moduleTitle", "Alta de usuarios");
		
		model.addAttribute("usuario", usuario);
		
		LOG.debug("Finalizando controlador nuevo usuario.");
		return "/admin/maestros/usuario/newUsuario";
	}		
}
