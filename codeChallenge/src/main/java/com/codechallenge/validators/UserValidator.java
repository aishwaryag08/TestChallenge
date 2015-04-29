package com.codechallenge.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.codechallenge.domain.User;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> c) {
		return User.class.isAssignableFrom(c);
	}

	@Override
	public void validate(Object paramObject, Errors errors) {
		//User user = (User) paramObject;
		ValidationUtils.rejectIfEmpty(errors,"userName", "required","Username is required");
		ValidationUtils.rejectIfEmpty(errors,"dob", "required","DOB is required");

	}

}
