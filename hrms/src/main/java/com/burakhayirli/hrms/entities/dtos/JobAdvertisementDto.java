/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.entities.dtos;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private String employerCompanyName;
	private String jobPositionPosition;
	private int openPositionNumber;
	private Date createdDate;
	private Date closedDate;
	private String description;
	private int minSalary;
	private int maxSalary;
}