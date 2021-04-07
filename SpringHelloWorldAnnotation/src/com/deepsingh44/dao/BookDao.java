package com.deepsingh44.dao;

import java.util.List;

import com.deepsingh44.model.Book;

public interface BookDao {
	public int insert(Book book);

	List<Book> getAllBooks();
}
