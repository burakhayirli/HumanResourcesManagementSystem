/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yaz�l�m Geli�tirici Yeti�tirme Kamp� (JAVA + REACT)
 * 7 May 2021
 */
package com.burakhayirli.hrms.business.abstracts;

import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.concretes.Employer;

public interface AuthService {
	
	Result registerEmployer(Employer employer,String confirmPassword);
	Result registerCandidate(Candidate candidate ,String confirmPassword);
	//Result register(User user,String confirmPassword);
	Result confirmPassword(String password,String confirmPassword);
}
