/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burakhayirli.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Long>{

	List<JobAdvertisementDao> findByIsActive(boolean status);
	List<JobAdvertisementDao> findByIsActiveOrderByClosedDate(boolean status);
	List<JobAdvertisementDao> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);
}