/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 12 May 2021
 */
package com.burakhayirli.hrms.business.abstracts;
import java.util.List;

import com.burakhayirli.hrms.core.entities.User;
import com.burakhayirli.hrms.core.utilities.results.DataResult;
import com.burakhayirli.hrms.core.utilities.results.Result;

public interface UserService<T extends User> {
	DataResult<T> add(T user);
	Result delete(int id);
	Result update(T user);
	DataResult<List<T>> getAll();
	DataResult<T> getByEmail(String email);
	Result existsByEmail(String email);
}
