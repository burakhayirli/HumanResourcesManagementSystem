/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 13 May 2021
 */
package com.burakhayirli.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakhayirli.hrms.business.abstracts.CandidateService;
import com.burakhayirli.hrms.business.abstracts.UserService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.dtos.CandidateDto;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController extends UsersController<Candidate>{

	private CandidateService candidateService;
	

	@Autowired
	public CandidatesController(UserService<Candidate> userService) {
		super(userService);
		this.candidateService = (CandidateService)userService;
	}

	@PostMapping("/existsByEmail")
	public Result existsByEmail(String email) {
		return this.candidateService.existsByEmail(email);
	}

	@PostMapping("/existsByIdentityNumber")
	public Result existsByIdentityNumber( String identityNumber) {
		return this.candidateService.existsByIdentityNumber(identityNumber);
	}
}
