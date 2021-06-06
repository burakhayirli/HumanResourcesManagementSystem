/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 13 May 2021
 */
package com.burakhayirli.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "candidates")
@Data
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String LastName;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "year_of_birth")
	private int yearOfBirth;
	
	public Candidate() {}

	public Candidate(Long id, String firstName, String lastName, String identityNumber, int yearOfBirth,String email, String password, Date createdAt, Integer createdBy, Date updatedAt,
			Integer updatedBy, Boolean status) {
		super(id, email, password, createdAt, createdBy, updatedAt, updatedBy, status);
		this.firstName = firstName;
		this.LastName = lastName;
		this.identityNumber = identityNumber;
		this.yearOfBirth = yearOfBirth;
	}

	

}
