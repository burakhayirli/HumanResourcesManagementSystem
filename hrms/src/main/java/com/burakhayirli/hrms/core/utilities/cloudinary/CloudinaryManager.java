/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.core.utilities.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.ErrorDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager implements CloudinaryService {

	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
		this.cloudinary = cloudinary;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<?> save(MultipartFile file) {
		try {
			Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(cloudinaryUploader);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}

}
