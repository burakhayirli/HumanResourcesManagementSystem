/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 13 May 2021
 */
package com.burakhayirli.hrms.entities.dtos;

import lombok.Data;

@Data
public class CandidateDto {
	private int id;
	private int userId;
	private String firstName;
	private String lastName;
	private String identityNumber;
	private int yearOfBirth;
	private UserDto user;
	
}
