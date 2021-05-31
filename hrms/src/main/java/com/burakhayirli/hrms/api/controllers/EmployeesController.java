/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 16 May 2021
 */
package com.burakhayirli.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakhayirli.hrms.business.abstracts.EmployeeService;
import com.burakhayirli.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public List<Employee> getall(){
		return this.employeeService.getall();
	}
}
