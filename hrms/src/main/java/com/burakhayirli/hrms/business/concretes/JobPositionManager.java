/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 11 May 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakhayirli.hrms.business.abstracts.JobPositionService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.ErrorResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.JobPositionDao;
import com.burakhayirli.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private final JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Meslek tanımları listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(this.jobPositionDao.save(jobPosition)!=null)	
		return new SuccessResult("Meslek tanımı kaydedildi");
		else return new ErrorResult("Meslek tanımı kaydedilemedi");
	}

}
