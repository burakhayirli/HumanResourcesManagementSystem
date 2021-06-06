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
import com.burakhayirli.hrms.business.abstracts.EmployerService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.concretes.Employee;
import com.burakhayirli.hrms.entities.concretes.Employer;
import com.burakhayirli.hrms.entities.concretes.EmployersVerification;
import com.burakhayirli.hrms.entities.dtos.CandidateDto;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}

	@PostMapping("getByEmail")
	public DataResult<Employer> getByEmail(@RequestBody String email) {
		return this.employerService.getByEmail(email);
	}

	@PostMapping("/existsByEmail")
	public Result existsByEmail(@RequestBody String email) {
		return this.employerService.existsByEmail(email);
	}

}
