package com.deepsingh44.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deepsingh44.model.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public int insert(Book book) {
		int i = (Integer) sessionFactory.getCurrentSession().save(book);
		return i;
	}

	@Transactional
	@Override
	public List<Book> getAllBooks() {
		Query q = sessionFactory.getCurrentSession().createQuery("from Book");
		return q.getResultList();
	}

}
