package com.accenture.lkm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.dao.LoginDAOWrapper;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAOWrapper daoWrapper;

	public LoginServiceImpl() {
		super();
	}

	@Override
	public LoginBean validateLogin(LoginBean loginBean) {
		return daoWrapper.validateLogin(loginBean);
	}

}