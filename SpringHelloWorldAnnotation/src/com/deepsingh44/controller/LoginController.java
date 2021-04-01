package com.deepsingh44.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.deepsingh44.dao.UserDao;
import com.deepsingh44.model.User;

@Controller
public class LoginController {

	@Autowired
	private UserDao userDao;

	@PostMapping("/signup")
	public String register(User user) {
		int i=userDao.insert(user);
		return "index";
	}

	@PostMapping("/signin")
	public String login(String email,String pass,HttpSession session) {
		User user=userDao.login(email, pass);
		if(user!=null) {
			session.setAttribute("user",user);
		}
		return "index";
	}
	
}
