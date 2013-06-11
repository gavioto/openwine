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
		ValidationUtils.rejectIfEmpty(errors, "tipoVariedad", "Campo 'tipo variedad' vacio.");
		ValidationUtils.rejectIfEmpty(errors, "nombre", "Campo 'nombre' vacio.");
		ValidationUtils.rejectIfEmpty(errors, "descripcion", "Campo 'descripcion' vacio.");
		ValidationUtils.rejectIfEmpty(errors, "productividad", "Campo 'productividad' vacio.");
		ValidationUtils.rejectIfEmpty(errors, "maduracion", "Campo 'maduracion' vacio.");
	}

}
