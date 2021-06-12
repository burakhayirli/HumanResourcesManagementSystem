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
import javax.validation.constraints.NotNull;

import com.burakhayirli.hrms.core.entities.User;
import com.burakhayirli.hrms.core.utilities.validations.WebSite;

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

	@NotNull
	@Column(name = "company_name")
	private String companyName;

	@NotNull
	@WebSite
	@Column(name = "website")
	private String website;

	@NotNull
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
