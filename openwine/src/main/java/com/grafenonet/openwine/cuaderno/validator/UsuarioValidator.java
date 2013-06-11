package com.grafenonet.openwine.cuaderno.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.grafenonet.openwine.maestros.domain.Usuario;

@Component("usuarioValidator")
public class UsuarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		if (usuario == null) {
			errors.reject("Datos nulos.");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "username", "Campo 'usuario' vacio.");
	}

}
