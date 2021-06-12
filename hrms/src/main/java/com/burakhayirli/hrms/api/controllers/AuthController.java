/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 7 Haz 2021
 */
package com.burakhayirli.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.burakhayirli.hrms.business.abstracts.AuthService;
import com.burakhayirli.hrms.business.abstracts.CandidatesVerificationService;
import com.burakhayirli.hrms.core.utilities.results.ErrorDataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.concretes.CandidatesVerification;
import com.burakhayirli.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/Employer/register")
	public Result registerEmployer(@Valid @RequestBody Employer employer,String confirmPassword) {
		return this.authService.registerEmployer(employer, confirmPassword);
	}
	

	@PostMapping("/Candidate/register")
	public Result registerCandidate(@Valid @RequestBody Candidate candidate ,String confirmPassword) {
		return this.authService.registerCandidate (candidate, confirmPassword);
	}
	
	
	
	
}
