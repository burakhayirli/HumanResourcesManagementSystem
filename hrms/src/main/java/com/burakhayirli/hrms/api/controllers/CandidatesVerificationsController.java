/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 16 May 2021
 */
package com.burakhayirli.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakhayirli.hrms.business.abstracts.CandidatesVerificationService;
import com.burakhayirli.hrms.entities.concretes.CandidatesVerification;

@RestController
@RequestMapping("/api/candidatesverifications")
public class CandidatesVerificationsController {

	private CandidatesVerificationService candidatesVerificationService;

	@Autowired
	public CandidatesVerificationsController(CandidatesVerificationService candidatesVerificationService) {
		super();
		this.candidatesVerificationService = candidatesVerificationService;
	}

	@GetMapping("/getall")
	public List<CandidatesVerification> getAll() {

		return candidatesVerificationService.getAll();
	}
}
