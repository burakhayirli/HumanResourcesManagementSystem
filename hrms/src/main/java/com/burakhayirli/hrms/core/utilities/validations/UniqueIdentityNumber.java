/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 8 Haz 2021
 */
package com.burakhayirli.hrms.core.utilities.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueIdentityNumberValidator.class)
public @interface UniqueIdentityNumber {
	String message() default "{com.burakhayirli.constraints.UniqueIdentityNumber.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
