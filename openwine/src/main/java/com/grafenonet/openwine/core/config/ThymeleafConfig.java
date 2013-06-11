package com.grafenonet.openwine.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

//@Configuration
public class ThymeleafConfig {
	
//	private static final String PREFIX = "/WEB-INF/views/";
//	private static final String SUFFIX = ".html";	
//	private static final String TEMPLATE_MODE = "HTML5";
//	private static final Integer ORDER = 1;
//	private static final Boolean CACHEABLE = false;
//	
//	@Bean
//	public ServletContextTemplateResolver templateResolver() {
//		ServletContextTemplateResolver template = new ServletContextTemplateResolver(); 
//		
//		template.setPrefix(PREFIX);
//		template.setSuffix(SUFFIX);
//		template.setTemplateMode(TEMPLATE_MODE);
//		template.setOrder(ORDER);
//		template.setCacheable(CACHEABLE);
//		
//		return template;
//	}
//	
//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine engine = new SpringTemplateEngine();
//		
//		engine.setTemplateResolver(templateResolver());
//		
//		return engine;
//	}
//	
//	@Bean
//	public ThymeleafViewResolver thymeleafViewResolver() {
//		ThymeleafViewResolver view = new ThymeleafViewResolver();
//		
//		view.setTemplateEngine(templateEngine());
//		
//		return view;		
//	}

}
