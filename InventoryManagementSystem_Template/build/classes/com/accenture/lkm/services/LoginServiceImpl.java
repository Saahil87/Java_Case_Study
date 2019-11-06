package com.accenture.lkm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.dao.LoginDAOWrapper;
import com.accenture.lkm.dao.PurchaseDAOWrapper;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAOWrapper daoWrapper;

	public LoginServiceImpl() {
		super();
	}

	@Override
	public LoginBean validateLogin(LoginBean loginBean) {
		// TODO Auto-generated method stub

		LoginBean daoBean =daoWrapper.validateLogin(loginBean);
		if (loginBean.getUsername().equals(daoBean.getUsername())
				&& loginBean.getPassword().equals(daoBean.getPassword()))
			return daoBean;
		else
			return null;
	}

}
