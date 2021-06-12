/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 13 May 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.burakhayirli.hrms.business.abstracts.EmployeeService;
import com.burakhayirli.hrms.dataAccess.abstracts.EmployeeDao;
import com.burakhayirli.hrms.dataAccess.abstracts.UserDao;
import com.burakhayirli.hrms.entities.concretes.Employee;

import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class EmployeeManager extends UserManager<Employee> implements EmployeeService {

	private final EmployeeDao employeeDao;
	private final ModelMapper modelMapper;

	@Autowired
	public EmployeeManager(UserDao<Employee> userDao, ModelMapper modelMapper) {
		super(userDao);
		this.employeeDao = (EmployeeDao)userDao;
		this.modelMapper = modelMapper;
	}

}
