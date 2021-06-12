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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers_verifications")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class EmployersVerification extends UserVerification{
	
	@Column(name = "is_verified_by_employee")
	private boolean isVerifiedByEmployee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "verified_by_employee_id",referencedColumnName = "id")
	private Employee verifiedByEmployee;

	@Column(name = "employee_verified_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date employeeVerifiedDate;	 
	
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="user_verification_id",referencedColumnName = "id")
	private UserVerification userVerification;
	
}
