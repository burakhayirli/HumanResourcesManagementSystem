/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.entities.dtos;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementAddDto {

	@JsonIgnore
	private int id;
	private int employerId;
	private int jobPositionId;
	private int openPositionNumber;
	private int minSalary;
	private int maxSalary;
	private int cityId;
	private Date createdDate;
	private Date closedDate;
	private String description;

}