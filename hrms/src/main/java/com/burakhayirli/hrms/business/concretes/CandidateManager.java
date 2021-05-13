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
import com.burakhayirli.hrms.dataAccess.abstracts.CandidateDao;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.dtos.CandidateDto;

@Service
public class CandidateManager implements CandidateService {

	private final CandidateDao candidateDao;
	private final ModelMapper modelMapper;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, ModelMapper modelMapper) {
		super();
		this.candidateDao = candidateDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<CandidateDto> getall() {
		CandidateDto[] candidatesDto = modelMapper.map(this.candidateDao.findAll(), CandidateDto[].class);
		return Arrays.asList(candidatesDto);
	}

}
