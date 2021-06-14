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
import com.burakhayirli.hrms.entities.dtos.JobExperienceDto;

public interface JobExperienceService {

	Result add(JobExperienceDto jobExpeerienceDto);

	DataResult<List<JobExperienceDto>> getAll();

	DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(Long id);

}
