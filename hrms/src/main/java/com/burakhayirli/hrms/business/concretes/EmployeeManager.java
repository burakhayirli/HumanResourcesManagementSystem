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
import com.burakhayirli.hrms.entities.concretes.Employee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {

	private final EmployeeDao employeeDao;
	private final ModelMapper modelMapper;
/*
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, ModelMapper modelMapper) {
		super();
		this.employeeDao = employeeDao;
		this.modelMapper = modelMapper;
	}
	*/

	@Override
	public List<Employee> getall() {
		Employee[] employees = modelMapper.map(this.employeeDao.findAll(), Employee[].class);
		return Arrays.asList(employees);
	}

}
