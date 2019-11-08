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
		LoginEntity entity=loginDAO.findOne(loginBean.getUsername());
		
		LoginBean bean=null;
		if(entity!=null) {
			if (entity.getPassword().equals(loginBean.getPassword())) {
				bean=new LoginBean();
				BeanUtils.copyProperties(entity, bean);
				return bean;
			}
		}
		return bean;
	}
	

}