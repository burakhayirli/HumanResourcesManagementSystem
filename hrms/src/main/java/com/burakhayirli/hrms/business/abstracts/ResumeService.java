/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.dtos.ResumeAddDto;
import com.burakhayirli.hrms.entities.dtos.ResumeGetDto;

public interface ResumeService {
	Result add(ResumeAddDto resumeDto);

	DataResult<List<ResumeGetDto>> getAll();

	DataResult<List<ResumeGetDto>> findAllByCandidateId(Long id);

	Result saveImage(MultipartFile file, Long resumeId);
}
