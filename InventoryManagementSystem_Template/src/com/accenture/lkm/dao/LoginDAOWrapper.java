package com.accenture.lkm.dao;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.entity.LoginEntity;
@Repository
@Transactional("txManager")
public class LoginDAOWrapper {

	@Autowired
	LoginDAO loginDAO;

	public LoginDAOWrapper() {
		super();
	}
	
	public LoginBean validateLogin(LoginBean loginBean) {
		String username = loginBean.getUsername();
		LoginEntity entity=loginDAO.findOne(username);
		LoginBean bean=new LoginBean();
		BeanUtils.copyProperties(entity, bean);
		
		return bean;
		
	}
	

}