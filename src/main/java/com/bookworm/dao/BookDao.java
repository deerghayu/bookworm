package com.bookworm.dao;

import java.util.List;

import com.bookworm.model.Book;

public interface BookDao {

	void addBook(Book book);

	Book getBookById(String id);

	List<Book> getAllBooks();

	void deleteBook(String id);
}
