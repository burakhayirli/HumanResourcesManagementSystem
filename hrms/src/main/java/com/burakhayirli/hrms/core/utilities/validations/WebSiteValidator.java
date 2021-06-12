/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 8 Haz 2021
 */
package com.burakhayirli.hrms.core.utilities.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WebSiteValidator implements ConstraintValidator<WebSite, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String regex = "(www.)?" + "[a-zA-Z0-9@:%._\\+~#?&//=]" + "{2,256}\\.[a-z]"
				+ "{2,6}\\b([-a-zA-Z0-9@:%" + "._\\+~#?&//=]*)";

		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(value);

		return m.matches();
	}
}
