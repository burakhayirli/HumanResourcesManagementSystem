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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.burakhayirli.hrms.business.abstracts.ResumeService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.dtos.ResumeAddDto;
import com.burakhayirli.hrms.entities.dtos.ResumeGetDto;

@CrossOrigin
@RestController
@RequestMapping(value = "api/resumes")
public class ResumesController {

	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}

	@GetMapping("/getall")
	public DataResult<List<ResumeGetDto>> getAll() {
		return this.resumeService.getAll();
	}

	@GetMapping("/getByCandidateId")
	public DataResult<List<ResumeGetDto>> findAllByCandidateId(Long id) {
		return this.resumeService.findAllByCandidateId(id);
	}

	@PostMapping(value = "/add")
	public Result add(@Valid @RequestBody ResumeAddDto resumeDto) {
		return this.resumeService.add(resumeDto);
	}

	@PutMapping("/uploadImage")
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam Long resumeId) {
		return this.resumeService.saveImage(file, resumeId);

	}

}