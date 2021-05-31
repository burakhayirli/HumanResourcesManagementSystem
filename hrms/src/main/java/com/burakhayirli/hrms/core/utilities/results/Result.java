/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 29 May 2021
 */
package com.burakhayirli.hrms.core.utilities.results;

public class Result {
	private boolean success;
	private String message;

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public String getMessage() {
		return this.message;
	}
}
