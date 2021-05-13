/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 May 2021
 */
package com.burakhayirli.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burakhayirli.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
