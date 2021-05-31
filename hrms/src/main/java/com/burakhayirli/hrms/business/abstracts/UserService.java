/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 May 2021
 */
package com.burakhayirli.hrms.business.abstracts;
import java.util.List;

import com.burakhayirli.hrms.entities.concretes.User;

public interface UserService {
//	void add(User user);
//	User getByEmail(String email);
//	boolean verifyEmail(User user,String code);
	List<User> getall();
}
