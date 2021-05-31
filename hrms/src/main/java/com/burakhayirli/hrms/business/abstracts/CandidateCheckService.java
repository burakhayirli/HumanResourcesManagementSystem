/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 31 May 2021
 */
package com.burakhayirli.hrms.business.abstracts;

import com.burakhayirli.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	boolean CheckIfRealPerson(Candidate candidate);
}
