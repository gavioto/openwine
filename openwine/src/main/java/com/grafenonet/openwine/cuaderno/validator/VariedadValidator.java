package com.grafenonet.openwine.cuaderno.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.grafenonet.openwine.cuaderno.domain.Variedad;
import com.grafenonet.openwine.cuaderno.enums.CalificacionVariedad;
import com.grafenonet.openwine.cuaderno.enums.MaduracionVariedad;
import com.grafenonet.openwine.cuaderno.enums.ProductividadVariedad;
import com.grafenonet.openwine.cuaderno.enums.TipoVariedad;

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
			errors.reject("No hay datos");
		} else {
			ValidationUtils.rejectIfEmpty(errors, "tipo", "web.validate.campo_obligatorio");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "web.validate.campo_obligatorio");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion", "web.validate.campo_obligatorio");
			ValidationUtils.rejectIfEmpty(errors, "calificacion", "web.validate.campo_obligatorio");
			ValidationUtils.rejectIfEmpty(errors, "productividad", "web.validate.campo_obligatorio");
			ValidationUtils.rejectIfEmpty(errors, "maduracion", "web.validate.campo_obligatorio");
			
			if (variedad.getNombre().length() > 100) {
				errors.rejectValue("nombre", "web.validate.tamano_campo_excede_maximo_permitido");
			}
			if (variedad.getDescripcion().length() > 2000) {
				errors.rejectValue("descripcion", "web.validate.tamano_campo_excede_maximo_permitido");
			}
			if (!TipoVariedad.asList().contains(variedad.getTipo())) {				
				errors.rejectValue("tipo", "web.validate.valor_no_valido");
			}			
			if (!CalificacionVariedad.asList().contains(variedad.getCalificacion())) {				
				errors.rejectValue("calificacion", "web.validate.valor_no_valido");
			}
			if (!ProductividadVariedad.asList().contains(variedad.getProductividad())) {				
				errors.rejectValue("productividad", "web.validate.valor_no_valido");
			}			
			if (!MaduracionVariedad.asList().contains(variedad.getMaduracion())) {				
				errors.rejectValue("descripcion", "web.validate.valor_no_valido");
			}
		}
	}

}
