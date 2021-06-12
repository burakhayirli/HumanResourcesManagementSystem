/*
 * Copyright (C) 2021 <https://github.com/burakhayirli>
 * @author BURAKHAYIRLI
 * Yazılım Geliştirici Yetiştirme Kampı (JAVA + REACT)
 * 7 Haz 2021
 */
package com.burakhayirli.hrms.business.abstracts;

import com.burakhayirli.hrms.core.utilities.results.Result;

public interface EmailVerificationService {
    Result verify(int userId, String code);
}