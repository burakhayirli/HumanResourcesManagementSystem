/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 16 May 2021
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employer extends User {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;

//	@ManyToOne(optional = false,fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id", referencedColumnName = "id")
//	private User user;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "website")
	private String website;

	@Column(name = "phone")
	private String phone;

	public Employer() {
	}

	public Employer(Long id, String companyName, String website, String phone, String email, String password,
			Date createdAt, Integer createdBy, Date updatedAt, Integer updatedBy, Boolean status) {
		super(id, email, password, createdAt, createdBy, updatedAt, updatedBy, status);
		this.companyName = companyName;
		this.website = website;
		this.phone = phone;
	}

}
