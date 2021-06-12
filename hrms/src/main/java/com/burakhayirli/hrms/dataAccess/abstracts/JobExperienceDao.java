/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burakhayirli.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao  extends JpaRepository<JobExperience, Long> {

	List<JobExperience> findAllByResumeIdOrderByEndedDateDesc(Long id);
}