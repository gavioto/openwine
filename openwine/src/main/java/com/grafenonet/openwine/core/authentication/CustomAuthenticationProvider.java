package com.grafenonet.openwine.core.authentication;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grafenonet.openwine.maestros.dao.UsuarioDao;
import com.grafenonet.openwine.maestros.domain.Usuario;

//@Service("customAuthenticationProvider")
@Component(value = "customAuthenticationProvider")
@Transactional(rollbackFor = Throwable.class, timeout = 300, propagation = Propagation.REQUIRED)
public class CustomAuthenticationProvider implements AuthenticationProvider {
	private static Logger LOG = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
	static {
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_VITICULTOR"));
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_TECNICO"));
	}
		
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		Usuario user = null;
		
		LOG.debug("Iniciando autenticación del usuario ...");
		
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		
		if (token == null) {
			throw new RuntimeException("No se han recibido los datos de autenticacion del usuario.");
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug(" - username = " + token.getName());
			LOG.debug(" - credentials = " + token.getCredentials());
		}				
		
		// Se comprueba que el usuario existe
		String username = token.getName();
		if (username != null && !username.isEmpty()) {
			user = this.usuarioDao.loadUserByUsername(username);
		}
		if (user == null) {
			throw new UsernameNotFoundException("El usuario '" + username + "' no existe.");
		}
		
		if (user.getFechaBaja() != null) {
			throw new UsernameNotFoundException("El usuario '" + username + "' está dado de baja.");
		}
		
		// Se comprueba la credencial de la contraseña
		String password = user.getPassword();
		if (!password.equals(token.getCredentials())) {
			throw new BadCredentialsException("La contraseña del usuario '" + username + "' no es correcta.");
		}			
	
		LOG.debug("Finalizando autenticación del usuario '" + username + "'.");
		return new UsernamePasswordAuthenticationToken(username, password, AUTHORITIES);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}
}
