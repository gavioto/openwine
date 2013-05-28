//package com.grafenonet.openwine.authentication;
//
//import java.io.IOException;
//import java.util.Set;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//public class CustomAuthenticationSuccessHandler implements
//		AuthenticationSuccessHandler {
//	private static Logger LOG = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request,
//			HttpServletResponse response, Authentication authentication)
//			throws IOException, ServletException {
//		LOG.debug("Iniciando autenticacion con exito ...");
//		
//		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//		
//		LOG.debug("Finalizando autenticacion con exito.");		
//		if (roles.contains("ROLE_ADMIN")) {
//			response.sendRedirect("/admin");
//		} 
//	}
//
//}
