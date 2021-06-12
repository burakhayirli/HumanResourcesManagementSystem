/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 7 Haz 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.burakhayirli.hrms.business.abstracts.UserVerificationService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.UserVerificationDao;
import com.burakhayirli.hrms.entities.concretes.UserVerification;

@Service
public class UserVerificationManager<T extends UserVerification> implements UserVerificationService<T> {

	
	private UserVerificationDao<T> userVerificationDao;
	
	public UserVerificationManager(UserVerificationDao<T> userVerificationDao) {
		super();
		this.userVerificationDao = userVerificationDao;
	}

	@Override
	public Result sendVerificationCode(String emailAddress) {
		UUID uuid = UUID.randomUUID();
		String code = uuid.toString();
		System.out.println(emailAddress + "Verification code sent to address . Verification code:" + code);		
		return new SuccessResult("Email doğrulama kodu gönderildi");
	}

	@Override
	public Result add(T userVerification) {
		userVerificationDao.save(userVerification);
		return new SuccessResult("Kullanıcı Kaydedildi. Kullanıcı Tipi: "+ userVerification.getClass()); 
	}

	@Override
	public Result update(T userVerification) {
		userVerificationDao.save(userVerification);
		return new SuccessResult("Kullanıcı güncellendi. Kullanıcı Tipi: "+ userVerification.getClass()); 
	}

	@Override
	public DataResult<T> getByUserId(Long candidateId) {
		return new SuccessDataResult<T>(userVerificationDao.findByUserId(candidateId));
	}

}
