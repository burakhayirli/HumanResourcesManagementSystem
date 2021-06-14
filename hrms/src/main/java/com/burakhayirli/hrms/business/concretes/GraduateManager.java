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

import com.burakhayirli.hrms.business.abstracts.GraduateService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.ErrorResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.GraduateDao;
import com.burakhayirli.hrms.entities.concretes.Graduate;

@Service
public class GraduateManager implements GraduateService {

	private GraduateDao graduateDao;

	@Autowired
	public GraduateManager(GraduateDao graduateDao) {
		super();
		this.graduateDao = graduateDao;
	}

	@Override
	public DataResult<List<Graduate>> getAll() {
		return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(), "Data Listelendi");

	}

	@Override
	public Result add(Graduate graduate) {
		if (graduateDao.existsByDescription(graduate.getDescription())) {
			return new ErrorResult("Daha önce Eklendi");
		}

		this.graduateDao.save(graduate);
		return new SuccessResult("Eklendi");
	}

}
