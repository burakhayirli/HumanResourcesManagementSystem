/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 11 Haz 2021
 */
package com.burakhayirli.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import com.burakhayirli.hrms.business.abstracts.EmployersVerificationService;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.EmployerVerificationDao;
import com.burakhayirli.hrms.dataAccess.abstracts.UserVerificationDao;
import com.burakhayirli.hrms.entities.concretes.EmployersVerification;

public class EmployersVerificationManager extends UserVerificationManager<EmployersVerification>
		implements EmployersVerificationService {

	private EmployerVerificationDao employersVerificationDao;

	//EmailVerificationService
	@Autowired
	public EmployersVerificationManager(UserVerificationDao<EmployersVerification> userVerificationDao) {
		super(userVerificationDao);
		this.employersVerificationDao = (EmployerVerificationDao)userVerificationDao;
	}

	@Override
	public Result verifyEmployerByEmployee(Long employerId, Long employeeId) {		
		return new SuccessResult("İş veren onaylandı");
	}
}
