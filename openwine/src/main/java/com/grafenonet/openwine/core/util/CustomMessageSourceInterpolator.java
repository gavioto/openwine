package com.grafenonet.openwine.core.util;

import java.util.Locale;

import javax.validation.MessageInterpolator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

@Component(value = "customMessageSourceInterpolator")
public class CustomMessageSourceInterpolator extends ResourceBundleMessageInterpolator implements MessageInterpolator, MessageSourceAware, InitializingBean {

	@Autowired
	private MessageSource messageSource;
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@Override
	public String interpolate(String message, Context context) {
		try {
			return messageSource.getMessage(message, new Object[]{}, Locale.getDefault());
		} catch (NoSuchMessageException e) {
			return super.interpolate(message, context);
		}
	}
	
	@Override
	public String interpolate(String message, Context context, Locale locale) {
		try {
			return messageSource.getMessage(message, new Object[]{}, locale);
		} catch (NoSuchMessageException e) {
			return super.interpolate(message, context, locale);
		}
	}
	
	public void afterPropertiesSet() throws Exception {
		if (messageSource == null) {
			throw new IllegalStateException("MessageSource no inicializado");
		}
	}
	
}
