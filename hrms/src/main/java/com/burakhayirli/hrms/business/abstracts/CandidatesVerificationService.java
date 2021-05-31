/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 16 May 2021
 */
package com.burakhayirli.hrms.business.abstracts;

import java.util.List;

import com.burakhayirli.hrms.entities.concretes.CandidatesVerification;

public interface CandidatesVerificationService {
	List<CandidatesVerification> getAll();
}
