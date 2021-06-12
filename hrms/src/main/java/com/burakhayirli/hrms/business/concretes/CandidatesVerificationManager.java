/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 16 May 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakhayirli.hrms.business.abstracts.CandidatesVerificationService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.CandidateVerificationDao;
import com.burakhayirli.hrms.dataAccess.abstracts.UserVerificationDao;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.concretes.CandidatesVerification;
import com.burakhayirli.hrms.entities.concretes.UserVerification;
import com.google.common.base.Optional;

@Service
public class CandidatesVerificationManager extends UserVerificationManager<CandidatesVerification> 
											implements CandidatesVerificationService {

	private CandidateVerificationDao candidatesVerificationDao;
	//EmailVerificationService
	@Autowired
	public CandidatesVerificationManager(UserVerificationDao<CandidatesVerification> userVerificationDao) {
		super(userVerificationDao);
		this.candidatesVerificationDao = (CandidateVerificationDao)userVerificationDao;
	}
}
