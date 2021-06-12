/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 7 Haz 2021
 */
package com.burakhayirli.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burakhayirli.hrms.entities.concretes.UserVerification;

public interface UserVerificationDao<T extends UserVerification> extends JpaRepository<T, Long>  {
	
	T findByUserId(Long userId);
}
