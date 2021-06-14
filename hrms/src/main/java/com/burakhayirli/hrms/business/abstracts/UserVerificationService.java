/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 7 Haz 2021
 */
package com.burakhayirli.hrms.business.abstracts;

import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.UserVerification;
import com.google.common.base.Optional;

public interface UserVerificationService<T extends UserVerification> {
	Result add(T userVerification);

	Result update(T userVerification);

	DataResult<T> getByUserId(Long candidateId);
	
	Result sendVerificationCode(String emailAddress);
	
//	
//	String createVerifyCode(User user);
//	void sendMail(String mail);
//	Result verifyUser(String code); 
}
