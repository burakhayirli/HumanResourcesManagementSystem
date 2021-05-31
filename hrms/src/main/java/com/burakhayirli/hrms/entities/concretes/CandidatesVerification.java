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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidates_verifications")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
//@PrimaryKeyJoinColumn(name="id")
public class CandidatesVerification extends BaseEntity{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private int id;

	//@ManyToOne(optional = false,fetch = FetchType.EAGER)
	//@JoinColumn(name = "user_verification_id", referencedColumnName = "id")
	//@OneToMany(targetEntity = UserVerification.class)

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name="user_verification_id",referencedColumnName = "id")
	private UserVerification userVerification;
	
	//@JoinColumn(name="user_verification_id",table = "user_verifications",referencedColumnName = "id")
	//private int userVerificationId;
	
	//@OneToMany(fetch = FetchType.EAGER,mappedBy = "UserVerification")
	//@JoinColumn(name = "user_verification_id", referencedColumnName = "id")
	//private UserVerification userVerification;
	
	//@Column(name = "user_verification_id")
	//private int userVerificationId;
}
