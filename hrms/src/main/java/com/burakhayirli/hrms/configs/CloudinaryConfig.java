/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.burakhayirli.hrms.core.utilities.cloudinary.CloudinaryManager;
import com.burakhayirli.hrms.core.utilities.cloudinary.CloudinaryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

	@Value("${cld.access-key}")
	String apiKey;

	@Value("${cld.secret-key}")
	String apiSecretKey;

	@Bean
	public Cloudinary cloudinaryUser() {
		return new Cloudinary(
				ObjectUtils.asMap("cloud_name", "burakhayirlihrms", "api_key", apiKey, "api_secret", apiSecretKey));
	}

	@Bean
	public CloudinaryService cloudinaryService() {
		return new CloudinaryManager(cloudinaryUser());
	}
}
