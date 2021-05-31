/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 29 May 2021
 */
package com.burakhayirli.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}

	public ErrorDataResult(T data) {
		super(data, false);
	}

	public ErrorDataResult(String message) {
		super(null, false, message);
	}
	
	public ErrorDataResult() {
		super(null, false);
	}
}
