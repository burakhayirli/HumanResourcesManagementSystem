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

import com.burakhayirli.hrms.business.abstracts.JobAdvertisementService;
import com.burakhayirli.hrms.core.utilities.converters.DtoConverterService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.burakhayirli.hrms.entities.concretes.JobAdvertisement;
import com.burakhayirli.hrms.entities.dtos.JobAdvertisementAddDto;
import com.burakhayirli.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		this.jobAdvertisementDao.save((JobAdvertisement) dtoConverterService.dtoClassConverter(jobAdvertisementAddDto,
				JobAdvertisement.class));
		return new SuccessResult("İş İlanı Eklendi");
	}

	@Override
	public Result delete(JobAdvertisement jobPosting) {
		this.jobAdvertisementDao.delete(jobPosting);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				dtoConverterService.dtoConverter(jobAdvertisementDao.findByIsActive(true), JobAdvertisementDto.class),
				"Aktif İş İlanları Listelendi");

	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findByIsActiveOrderByClosedDate(true),
						JobAdvertisementDto.class),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.dtoConverterService.dtoConverter(
				this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(true, companyName),
				JobAdvertisementDto.class), "Data Listelendi");
	}

}
