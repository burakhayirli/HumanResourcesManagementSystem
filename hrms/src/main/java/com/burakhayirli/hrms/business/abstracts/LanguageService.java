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
import com.burakhayirli.hrms.entities.dtos.LanguageDto;

public interface LanguageService {

	Result add(LanguageDto languageDto);

	DataResult<List<LanguageDto>> getAll();

}
