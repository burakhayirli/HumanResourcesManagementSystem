/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 13 May 2021
 */
package com.burakhayirli.hrms.dataAccess.abstracts;

import com.burakhayirli.hrms.entities.concretes.Candidate;

public interface CandidateDao extends UserDao<Candidate>{

	boolean existsByIdentityNumber(String identityNumber);
}
