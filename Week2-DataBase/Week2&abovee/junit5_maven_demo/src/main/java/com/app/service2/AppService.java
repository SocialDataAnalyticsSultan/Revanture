package com.app.service2;

import com.app.exception.BusinessException;

public interface AppService {

	public boolean isValidPrimeNumber(int n);
	public boolean isValidMobileNumber(String mobile)throws BusinessException;
}
