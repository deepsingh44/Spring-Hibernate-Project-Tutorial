package com.deepsingh44.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deepsingh44.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Transactional
	@Override
	public int insert(User user) {
		int i = 0;
		sessionfactory.getCurrentSession().save(user);
		i = 1;
		return i;
	}

	@Transactional
	@Override
	public User login(String email, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

}
