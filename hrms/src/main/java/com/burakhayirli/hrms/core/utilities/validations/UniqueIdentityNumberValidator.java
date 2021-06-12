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

import com.burakhayirli.hrms.dataAccess.abstracts.CandidateDao;

public class UniqueIdentityNumberValidator implements ConstraintValidator<UniqueIdentityNumber, String> {

	@Autowired
	private CandidateDao candidateDao;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !candidateDao.existsByIdentityNumber(value);
	}

}
