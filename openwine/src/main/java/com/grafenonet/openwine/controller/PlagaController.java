package com.grafenonet.openwine.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/cuaderno/plaga")
public class PlagaController {
	private static Logger LOG = LoggerFactory.getLogger(PlagaController.class);
	
	private static final String TAB_ACTIVE = "active";
	private static final String TAB_INACTIVE = "";
	private static final String URL_LISTA = "/admin/cuaderno/plaga";
	private static final String URL_NUEVO = "/admin/cuaderno/plaga/nuevo";	

}
