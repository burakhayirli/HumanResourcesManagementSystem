/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 May 2021
 */
package com.burakhayirli.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.burakhayirli.hrms.business.abstracts.UserService;
import com.burakhayirli.hrms.core.entities.User;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.ErrorResult;
import com.burakhayirli.hrms.core.utilities.results.Result;
import com.burakhayirli.hrms.core.utilities.results.SuccessDataResult;
import com.burakhayirli.hrms.core.utilities.results.SuccessResult;
import com.burakhayirli.hrms.dataAccess.abstracts.UserDao;
import com.google.common.collect.ImmutableList;

@Primary
@Service
public class UserManager<T extends User> implements UserService<T> {

	private final UserDao<T> userDao;

	@Autowired
	public UserManager(UserDao<T> userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<T>> getAll() {
		return new SuccessDataResult<List<T>>((List<T>) this.userDao.findAll(),"Kullanıcılar Listelendi");
	}

	@Override
	public DataResult<T> add(T user) {
		return null;
	}

	@Override
	public DataResult<T> getByEmail(String email) {
		return new  SuccessDataResult<T>(userDao.getByEmail(email),"Kullanıcı bulundu UserManager");
	}

	@Override
	public Result delete(int id) {
		userDao.deleteById(id);
		return new SuccessResult("Kullanıcı silindi");
	}

	@Override
	public Result update(T user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result existsByEmail(String email) {
		if(userDao.existsByEmail(email))
			return new SuccessResult("E-Posta mevcut");
		else return new ErrorResult("E-Posta bulunamadı");
	}


}
