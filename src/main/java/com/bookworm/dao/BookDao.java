package com.bookworm.dao;

import java.util.List;

import com.bookworm.model.Book;

public interface BookDao {

	void addBook(Book book);

	Book getBookById(int id);

	List<Book> getAllBooks();

	void deleteBook(int id);
}
