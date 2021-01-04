package com.app.service2.impl;

import com.app.exception.BusinessException;
import com.app.service2.AppService;

public class AppServiceImp implements AppService{

	@Override
	public boolean isValidPrimeNumber(int n) {
		boolean isValid = true;
		
		if(n<=0) {
			isValid = false;
			return isValid;
		}
		for(int num = 2; num<n; num++) {
			if(n%num == 0) {
				isValid = false;
				break;
			}
		}
		return isValid;
	}

	@Override
	public boolean isValidMobileNumber(String mobile) throws BusinessException {
		boolean isValid = false;
		if(mobile != null && mobile.matches("\\+1-[0-9]{10}")) {
			isValid = true;
		}else {
			throw new BusinessException ("Entered mobile number " + mobile + " is not valid");
		}
		return isValid;
	}

}
