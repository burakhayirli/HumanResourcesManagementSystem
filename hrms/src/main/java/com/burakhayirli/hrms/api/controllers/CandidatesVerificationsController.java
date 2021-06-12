/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 16 May 2021
 */
package com.burakhayirli.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakhayirli.hrms.business.abstracts.CandidatesVerificationService;
import com.burakhayirli.hrms.business.abstracts.UserVerificationService;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.CandidatesVerification;

@RestController
@RequestMapping("/api/candidatesverifications")
public class CandidatesVerificationsController {

	private CandidatesVerificationService candidatesVerificationService;

	@Autowired
	public CandidatesVerificationsController(UserVerificationService<CandidatesVerification> userVerificationService) {
		super();
		this.candidatesVerificationService = (CandidatesVerificationService)userVerificationService;
	}

	@PostMapping("/verify")
	public Result verify(Long candidateId,Long employeeId) {
		CandidatesVerification candidatesVerification= candidatesVerificationService.getByUserId(candidateId).getData();
		
		return candidatesVerificationService.update(candidatesVerification);
	}
}
