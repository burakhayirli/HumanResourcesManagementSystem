/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 11 May 2021
 */
package com.burakhayirli.hrms.core.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.burakhayirli.hrms.core.utilities.validations.UniqueEmail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper=false)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User extends BaseEntity {

	@Email
	@NotNull
	@UniqueEmail
	@Column(name = "email", unique = true, length = 120)
	private String email;

	@NotNull
	@Size(min=8, max=30)
	@Column(name = "password")
	private String password;
	
	@Column(name = "restricted")
	private boolean restricted;
	
	public User() {}

	public User(Long id,String email, String password, Date createdAt, Integer createdBy, Date updatedAt, Integer updatedBy, Boolean status) {
		super(id, createdAt, createdBy, updatedAt, updatedBy, status);
		this.email=email;
		this.password=password;
	}

	



	


	
}
