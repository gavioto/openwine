package com.grafenonet.openwine.maestros.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.grafenonet.openwine.maestros.domain.Municipio;

@Component(value = "municipioValidator")
public class MunicipioValidator implements Validator {
	private static final Logger LOG = LoggerFactory.getLogger(MunicipioValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Municipio.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Municipio municipio = (Municipio) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigo", "web.validate.campo_obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "web.validate.campo_obligatorio");
		
		if (municipio.getCodigo().length() > 3) {
			LOG.debug(" - codigo excede maximo");
			errors.rejectValue("codigo", "web.validate.tamano_campo_excede_maximo_permitido");
		}
		if (municipio.getNombre().length() > 250) {
			LOG.debug(" - municipio excede maximo");
			errors.rejectValue("nombre", "web.validate.tamano_campo_excede_maximo_permitido");
		}		
		
		
		if (municipio.getProvincia() == null || municipio.getProvincia().getId() == null) {
			LOG.debug(" - provincia null");
			errors.rejectValue("provincia", "web.validate.valor_no_valido");
		}
		
	}

}
