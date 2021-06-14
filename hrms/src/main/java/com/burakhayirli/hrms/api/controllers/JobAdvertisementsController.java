/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 14 Haz 2021
 */
package com.burakhayirli.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakhayirli.hrms.business.abstracts.JobAdvertisementService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.dtos.JobAdvertisementAddDto;
import com.burakhayirli.hrms.entities.dtos.JobAdvertisementDto;

@CrossOrigin
@RestController
@RequestMapping("api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getActive")
	DataResult<List<JobAdvertisementDto>> findByIsActive() {
		return this.jobAdvertisementService.findByIsActive();
	}

	@PostMapping("/add")
	Result add(@Valid @RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
		return this.jobAdvertisementService.add(jobAdvertisementAddDto);
	}

	@GetMapping("/getActive/OrderByEndDate")
	DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByClosedDate() {
		return this.jobAdvertisementService.findByIsActiveOrderByClosedDate();
	}

	@GetMapping("/get/CompanyName")
	DataResult<List<JobAdvertisementDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return this.jobAdvertisementService.findByIsActiveAndEmployer_CompanyName(companyName);

	}
}
