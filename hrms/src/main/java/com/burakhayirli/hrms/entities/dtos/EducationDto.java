/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 Haz 2021
 */
package com.burakhayirli.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

	@JsonIgnore
	private int id;
	private int resumeId;
	private String schoolName;
	@JsonProperty(access = Access.WRITE_ONLY)
	private int graduateId;
	private String graduateDescription;
	private String schoolDepartment;
	private Date startedDate;
	private Date endedDate;
	private Date createdDate;

}