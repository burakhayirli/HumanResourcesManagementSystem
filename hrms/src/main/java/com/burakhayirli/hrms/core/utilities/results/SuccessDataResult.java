/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 29 May 2021
 */
package com.burakhayirli.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, String message) {
		super(data, true, message);
	}

	public SuccessDataResult(T data) {
		super(data, true);
	}

	public SuccessDataResult(String message) {
		super(null, true, message);
	}
	
	public SuccessDataResult() {
		super(null, true);
	}
}
