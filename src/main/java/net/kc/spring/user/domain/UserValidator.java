package net.kc.spring.user.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
	private static Logger logger = LoggerFactory.getLogger(UserValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		logger.debug("vaildate");
	}

}
