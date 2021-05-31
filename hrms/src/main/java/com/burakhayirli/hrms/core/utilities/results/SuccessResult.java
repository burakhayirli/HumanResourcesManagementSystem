/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 29 May 2021
 */
package com.burakhayirli.hrms.core.utilities.results;

public class SuccessResult extends Result {

	public SuccessResult() {
		super(true);
	}

	public SuccessResult(String message) {
		super(true, message);
	}
}
