package com.deepsingh44.dao;

import javax.persistence.Query;

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
		Query query=sessionfactory.getCurrentSession().createQuery("from User where email=:email and pass=:pass");
		query.setParameter("email", email);
		query.setParameter("pass", pass);
		if(query.getResultList().size()>0) {
			return (User)query.getResultList().get(0);
		}
		return null;
	}
	@Transactional
	@Override
	public int update(User user) {
		int i=0;
		sessionfactory.getCurrentSession().update(user);
		i=1;
		return i;
	}

}
