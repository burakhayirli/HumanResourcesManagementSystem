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
import com.burakhayirli.hrms.dataAccess.abstracts.CandidateVerificationDao;
import com.burakhayirli.hrms.entities.concretes.CandidatesVerification;

@Service
public class CandidatesVerificationManager implements CandidatesVerificationService {

	private CandidateVerificationDao candidatesVerificationDao;

	@Autowired
	public CandidatesVerificationManager(CandidateVerificationDao candidatesVerificationDao) {
		super();
		this.candidatesVerificationDao = candidatesVerificationDao;
	}

	@Override
	public List<CandidatesVerification> getAll() {
		return candidatesVerificationDao.findAll();
	}

}
