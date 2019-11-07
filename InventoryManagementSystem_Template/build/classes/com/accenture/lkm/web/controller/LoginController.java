package com.accenture.lkm.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.services.LoginService;

@RestController
public class LoginController {
	
	
	@Autowired
	private LoginService service;
	

	@RequestMapping(value="loadLoginPage")
	public ModelAndView loadLoginPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginBean", new LoginBean());
		mv.setViewName("Login");
		return mv;
	}
	
	@RequestMapping(value="validateLogin", method=RequestMethod.POST)
	public ModelAndView validateLogin(@Valid @ModelAttribute("loginBean")LoginBean loginBean, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		
		LoginBean loginBeanRet = service.validateLogin(loginBean);
		
		if(result.hasErrors()) {
			mv.setViewName("Login");
			mv.addObject("error", result);
		}else {
			if(loginBean!=null) {
				mv.addObject("loginBean", loginBeanRet);
				mv.setViewName("LoginSuccess");
			}else {
				String msg="Either Username and Password is incorrect. Please enter credentials again.";
				mv.addObject("error", msg);
				mv.setViewName("Login");
			}
		}
		return mv;
	}
	
	
}
