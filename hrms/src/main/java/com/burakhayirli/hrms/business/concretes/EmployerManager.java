/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 13 May 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakhayirli.hrms.business.abstracts.CandidateService;
import com.burakhayirli.hrms.business.abstracts.EmployerService;
import com.burakhayirli.hrms.dataAccess.abstracts.CandidateDao;
import com.burakhayirli.hrms.dataAccess.abstracts.EmployerDao;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.concretes.Employer;
import com.burakhayirli.hrms.entities.dtos.CandidateDto;

@Service
public class EmployerManager implements EmployerService {

	private final EmployerDao employerDao;
	private final ModelMapper modelMapper;

	@Autowired
	public EmployerManager(EmployerDao employerDao, ModelMapper modelMapper) {
		super();
		this.employerDao = employerDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<Employer> getall() {
		Employer[] employers = 
				modelMapper.map(this.employerDao.findAll(), Employer[].class);
		return Arrays.asList(employers);
	}

}
