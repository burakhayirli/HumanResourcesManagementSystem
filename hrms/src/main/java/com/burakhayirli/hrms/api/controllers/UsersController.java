/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 May 2021
 */
package com.burakhayirli.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burakhayirli.hrms.business.abstracts.UserService;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.entities.concretes.Candidate;
import com.burakhayirli.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController<T extends User> {
	
	private UserService<T> userService;
	
	@Autowired
	public UsersController(UserService<T> userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<T>> getAll(){		
		return this.userService.getAll();
	}
	
	@PostMapping("getByEmail")
	public DataResult<T> getByEmail(@RequestBody String email) {
		return this.userService.getByEmail(email);
	}
	
	@PostMapping("/existsByEmail")
	public Result existsByEmail(@RequestBody String email) {
		return this.userService.existsByEmail(email);
	}

}
