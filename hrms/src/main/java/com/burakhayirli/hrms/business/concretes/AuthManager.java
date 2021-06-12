/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 7 Haz 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakhayirli.hrms.business.abstracts.AuthService;
import com.burakhayirli.hrms.business.abstracts.CandidateService;
import com.burakhayirli.hrms.business.abstracts.CandidatesVerificationService;
import com.burakhayirli.hrms.business.abstracts.EmployerService;
import com.burakhayirli.hrms.business.abstracts.UserService;
import com.burakhayirli.hrms.business.abstracts.UserVerificationService;
import com.burakhayirli.hrms.core.utilities.results.ErrorResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.concretes.CandidatesVerification;
import com.burakhayirli.hrms.entities.concretes.Employer;
import com.burakhayirli.hrms.entities.concretes.EmployersVerification;
import com.burakhayirli.hrms.entities.concretes.UserVerification;

@Service
public class AuthManager implements AuthService {

	private EmployerService employerService;
	private CandidateService candidateService;
	private UserVerificationService<UserVerification> userVerificationService;
	//private CandidatesVerificationService candidateVerificationService;
	
	
	@Autowired
	public AuthManager(EmployerService employerService, CandidateService candidateService,
			UserVerificationService<UserVerification> verificationService,
			UserVerificationService<CandidatesVerification> candidateVerificationService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.userVerificationService = verificationService;
		//this.candidateVerificationService = (CandidatesVerificationService) candidateVerificationService;
		
	}

	@Override
	public Result confirmPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword))
			return new SuccessResult();
		else
			return new ErrorResult();
	}

	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		if (!this.confirmPassword(employer.getPassword(), confirmPassword).isSuccess()) {
			return new ErrorResult("Parolalar uyuşmuyor. Lütfen kontrol ediniz.");
		}
		var result = this.employerService.add(employer);

		System.out.println("EMPLOYER " + employer);
		if (result.isSuccess()) {
			
			UserVerification employerVerification = new EmployersVerification();
			
			employerVerification.setVerificationCode("ISVEREN"+new Random().hashCode());
			employerVerification.setVerifiedEmail(false);
			employerVerification.setUserId(result.getData().getId().intValue());
			employerVerification.setStatus(true);
			employerVerification.setVerifiedEmail(false);
			this.userVerificationService.add(employerVerification);
			
			if (this.userVerificationService.sendVerificationCode(employer.getEmail()).isSuccess()) {
				return new SuccessResult("İş veren kaydedildi.");
			}			
		}

		return new ErrorResult();
	}

	@Override
	public Result registerCandidate(Candidate candidate, String confirmPassword) {

		if (!this.confirmPassword(candidate.getPassword(), confirmPassword).isSuccess()) {
			return new ErrorResult("Parolalar uyuşmuyor. Lütfen kontrol ediniz.");
		}
		var result = this.candidateService.add(candidate);
		System.out.println("CANDIDATE " + result.getData().getId());
		if (result.isSuccess()) {

			UserVerification candidateVerification = new CandidatesVerification();
			candidateVerification.setVerificationCode("ADAY"+new Random().hashCode());
			candidateVerification.setVerifiedEmail(false);
			candidateVerification.setUserId(result.getData().getId().intValue());
			candidateVerification.setStatus(true);
			this.userVerificationService.add(candidateVerification);

			if (this.userVerificationService.sendVerificationCode(candidate.getEmail()).isSuccess()) {
				return new SuccessResult("Aday kaydedildi.");
			}

			// if(this.candidateVerificationService.add(candidatesVerification).isSuccess())
			// return new SuccessResult("Aday ve Aktivasyonu kodu kaydedildi. Lütfen
			// e-postanızı kontrol ediniz.");
			// else return new ErrorResult("Aday kaydedilemedi.");

			//
//			if(this.verificationService.sendVerificationCode(candidate.getEmail())) {
//				return new SuccessResult("Aday kaydedildi.");
//			}
		}
		return new ErrorResult("Aday kaydedilemedi");
	}

}
