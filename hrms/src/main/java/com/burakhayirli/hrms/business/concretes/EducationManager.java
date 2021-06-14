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

import com.burakhayirli.hrms.business.abstracts.EducationService;
import com.burakhayirli.hrms.core.utilities.converters.DtoConverterService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.EducationDao;
import com.burakhayirli.hrms.entities.concretes.Education;
import com.burakhayirli.hrms.entities.dtos.EducationDto;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
		super();
		this.educationDao = educationDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(EducationDto educationDto) {
		educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<EducationDto>> getAll() {
		return new SuccessDataResult<List<EducationDto>>(
				dtoConverterService.dtoConverter(educationDao.findAll(), EducationDto.class));
	}

	@Override
	public DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(Long id) {
		return new SuccessDataResult<List<EducationDto>>(dtoConverterService
				.dtoConverter(educationDao.findAllByResumeIdOrderByEndedDateDesc(id), EducationDto.class));
	}

}
