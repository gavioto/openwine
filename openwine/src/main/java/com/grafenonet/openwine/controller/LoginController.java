package com.grafenonet.openwine.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.grafenonet.openwine.maestros.domain.LoginUser;

@Controller
public class LoginController {
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@Resource
	AuthenticationProvider customAuthenticationProvider;
		
	public LoginController() {
		super();
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(ModelMap model) {
		LOG.debug("Iniciando controlador login GET ...");
		
		LoginUser login = new LoginUser();
		model.addAttribute("loginUser", login);
		
		LOG.debug("Finalizando controlador login GET.");
		return "login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String loginForm(@Valid @ModelAttribute("login") LoginUser login, final BindingResult errors, ModelMap model) {
		LOG.debug("Controller 'loginForm'.");
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - login: " + login.toString());
		}
		
		if (errors.hasErrors()) {
			LOG.debug("Error al validar el login: " + errors.toString());
			return null;
		}
		
		final String username = login.getJ_username();
		final String password = login.getJ_password();
		
		final UsernamePasswordAuthenticationToken authRequest = new 
				  UsernamePasswordAuthenticationToken(username, password);

		final Authentication authentication = customAuthenticationProvider.authenticate(authRequest);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String home = "";
				
		LOG.debug("Usuario autenticado: " + login.toString());		
		return "redirect:home";
	}	

//	@RequestMapping(value = "/signup", method=RequestMethod.POST)
//	public String signup(ModelMap model) {
//		LOG.debug("Controller 'signup'.");
//		return "signup";
//	}
//	
//	@RequestMapping(value = "/logout", method=RequestMethod.GET)
//	public String logoff(ModelMap model) {
//		LOG.debug("Controller 'logoff'.");
//		return "logoff";
//	}	
	
}
