/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 11 May 2021
 */
package com.burakhayirli.hrms.entities.concretes;


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


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "users")
@Data

@EqualsAndHashCode(callSuper=false)
//@ToString
//@EqualsAndHashCode
//@MappedSuperclass // Diğer sınıflarda extend edilebilir hale getirdik.
//@Getter @Setter
//@PrimaryKeyJoinColumn(name = "id")
//@SecondaryTables(value = { @SecondaryTable(name = "employees") })
//@DiscriminatorValue("users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User extends BaseEntity {

	@Column(name = "email", unique = true, length = 120)
	private String email;

	@Column(name = "password")
	private String password;
	
	public User() {}

	public User(Long id,String email, String password, Date createdAt, Integer createdBy, Date updatedAt, Integer updatedBy, Boolean status) {
		super(id, createdAt, createdBy, updatedAt, updatedBy, status);
		this.email=email;
		this.password=password;
	}

	



	


	
}
