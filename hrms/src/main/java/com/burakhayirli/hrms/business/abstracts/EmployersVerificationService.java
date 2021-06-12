/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 11 Haz 2021
 */
package com.burakhayirli.hrms.business.abstracts;

import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.EmployersVerification;

public interface EmployersVerificationService extends UserVerificationService<EmployersVerification> {
	
	Result verifyEmployerByEmployee(Long employerId,Long employeeId); 
	
	
}
