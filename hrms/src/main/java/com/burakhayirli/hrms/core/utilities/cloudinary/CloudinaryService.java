/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.core.utilities.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import com.burakhayirli.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<?> save(MultipartFile file);

}
