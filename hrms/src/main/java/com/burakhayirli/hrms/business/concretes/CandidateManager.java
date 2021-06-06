/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 13 May 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burakhayirli.hrms.business.abstracts.CandidateCheckService;
import com.burakhayirli.hrms.business.abstracts.CandidateService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.ErrorDataResult;
import com.burakhayirli.hrms.core.utilities.results.ErrorResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.CandidateDao;
import com.burakhayirli.hrms.dataAccess.abstracts.UserDao;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.dtos.CandidateDto;

@Service
public class CandidateManager extends UserManager<Candidate> implements CandidateService {

	private final CandidateDao candidateDao;
	private final ModelMapper modelMapper;
	private final CandidateCheckService candidateCheckService;

	@Autowired
	public CandidateManager(UserDao<Candidate> userDao, ModelMapper modelMapper,
			CandidateCheckService candidateCheckService) {
		super(userDao);
		this.candidateDao =(CandidateDao) userDao;
		this.modelMapper = modelMapper;
		this.candidateCheckService = candidateCheckService;
	}

//	@Override
//	public DataResult<List<Candidate>> getAll() {
//		CandidateDto[] candidatesDto = modelMapper.map(this.candidateDao.findAll(), CandidateDto[].class);
//
//		if (candidatesDto.length > 0) {
//			return new SuccessDataResult<List<CandidateDto>>(Arrays.asList(candidatesDto), "İş Arayanlar Listelendi.");
//		} else
//			return new ErrorDataResult<List<CandidateDto>>(null, "Kayıtlı İş Arayan Bulunamadı");
//	}

	
	@Override
	public Result add(Candidate candidate) {
		if (candidateCheckService.CheckIfRealPerson(candidate)) {
			candidateDao.save(candidate);
			return new SuccessResult("Kişi doğrulaması başarılı. Kişi kaydedildi.");
		} else {
			return new ErrorResult("Kişi doğrulaması başarısız. Verdiğiniz bilgilere ait bir kişi bulunamadı.");
		}
	}

	@Override
	public Result existsByIdentityNumber(String identityNumber) {
		if(candidateDao.existsByIdentityNumber(identityNumber))
			return new SuccessResult("Bu T.C. kimlik numarasına ait kullanıcı mevcut.");
		else
			return new ErrorResult("Bu T.C. kimlik numarasına ait kullanıcı mevcut değil");
					
	}
}
