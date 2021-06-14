/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakhayirli.hrms.business.abstracts.JobExperienceService;
import com.burakhayirli.hrms.core.utilities.converters.DtoConverterService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.JobExperienceDao;
import com.burakhayirli.hrms.entities.concretes.JobExperience;
import com.burakhayirli.hrms.entities.dtos.JobExperienceDto;
@Service
public class JobExperienceManager implements JobExperienceService {

	private JobExperienceDao jobExperienceDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		jobExperienceDao
				.save((JobExperience) dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public SuccessDataResult<List<JobExperienceDto>> getAll() {
		return new SuccessDataResult<List<JobExperienceDto>>(
				this.dtoConverterService.dtoConverter(this.jobExperienceDao.findAll(), JobExperienceDto.class),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(Long id) {
		return new SuccessDataResult<List<JobExperienceDto>>(this.dtoConverterService
				.dtoConverter(this.jobExperienceDao.findAllByResumeIdOrderByEndedDateDesc(id), JobExperienceDto.class),
				"Data Listelendi");
	}

}
