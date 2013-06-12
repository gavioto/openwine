package com.grafenonet.openwine.cuaderno.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.grafenonet.openwine.cuaderno.domain.Variedad;

@Component("variedadValidator")
public class VariedadValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Variedad.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Variedad variedad = (Variedad) target;
		if (variedad == null) {
			errors.reject("Datos nulos");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo", "Campo 'tipo' vacio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "Campo 'nombre' vacio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "Campo 'descripcion' vacio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "calificacion", "Campo 'calificacion' vacio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productividad", "Campo 'productividad' vacio.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "maduracion", "Campo 'maduracion' vacio.");
	}

}
