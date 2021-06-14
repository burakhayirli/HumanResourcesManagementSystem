/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.business.abstracts;

import java.util.List;

import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.JobAdvertisement;
import com.burakhayirli.hrms.entities.dtos.JobAdvertisementAddDto;
import com.burakhayirli.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
		
		Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
		Result delete(JobAdvertisement jobPosting);
		DataResult<List<JobAdvertisementDto>> findByIsActive();
		DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByClosedDate();
		DataResult<List<JobAdvertisementDto>> findByIsActiveAndEmployer_CompanyName(String companyName);
}
