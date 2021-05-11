/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 11 May 2021
 */
package com.burakhayirli.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="candidates")
@Data
public class Users {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int Id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	public Users() {}

	public Users(int id, String email, String password, LocalDate createdDate) {
		super();
		Id = id;
		this.email = email;
		this.password = password;
		this.createdDate = createdDate;
	}
}
