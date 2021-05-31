/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 31 May 2021
 */
package com.burakhayirli.hrms.business.adapters;

import org.springframework.stereotype.Service;

import com.burakhayirli.hrms.business.abstracts.CandidateCheckService;
import com.burakhayirli.hrms.entities.concretes.Candidate;

@Service
public class MernisServiceAdapter implements CandidateCheckService {

	@Override
	public boolean CheckIfRealPerson(Candidate candidate) {
		return false;
	}

}
