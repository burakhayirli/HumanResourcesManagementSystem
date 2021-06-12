/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 16 May 2021
 */
package com.burakhayirli.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakhayirli.hrms.business.abstracts.EmployeeService;
import com.burakhayirli.hrms.business.abstracts.UserService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(UserService<Employee> userService) {
		super();
		this.employeeService =(EmployeeService)userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getall(){
		return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}
	
	@PostMapping("getByEmail")
	public DataResult<Employee> getByEmail( String email) {
		return this.employeeService.getByEmail(email);
	}
	
	@PostMapping("/existsByEmail")
	public Result existsByEmail( String email) {
		return this.employeeService.existsByEmail(email);
	}
}
