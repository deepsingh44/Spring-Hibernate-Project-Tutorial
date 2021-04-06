package com.deepsingh44.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.deepsingh44.dao.UserDao;
import com.deepsingh44.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@PostMapping("/signup")
	public String register(User user) {
		int i=userDao.insert(user);
		return "index";
	}

	@PostMapping("/update")
	public String update(User currentUser,HttpSession session) {
		User sessionUser=(User)session.getAttribute("user");
		sessionUser.setName(currentUser.getName());
		sessionUser.setEmail(currentUser.getEmail());
		sessionUser.setPass(currentUser.getPass());
		int i=userDao.update(sessionUser);
		return "profile";
	}
	
	@PostMapping("/signin")
	public String login(String email,String pass,HttpSession session) {
		User user=userDao.login(email, pass);
		if(user!=null) {
			session.setAttribute("user",user);
		}
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
}
