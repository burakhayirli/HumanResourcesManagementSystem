/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 29 May 2021
 */
package com.burakhayirli.hrms.core.utilities.results;

public class ErrorResult extends Result {

	public ErrorResult() {
		super(false);
	}

	public ErrorResult(String message) {
		super(false, message);
	}
}
