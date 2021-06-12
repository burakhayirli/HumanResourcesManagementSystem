/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 8 Haz 2021
 */
package com.burakhayirli.hrms.core.utilities.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.burakhayirli.hrms.core.entities.User;
import com.burakhayirli.hrms.dataAccess.abstracts.UserDao;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{

	@Autowired
	private UserDao<User> userDao;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !userDao.existsByEmail(value);		
	}

}
