package com.deepsingh44.dao;

import com.deepsingh44.model.User;

public interface UserDao {

	int insert(User user);
	int update(User user);
	User login(String email,String pass);
	
}
