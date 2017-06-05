package com.bookworm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookworm.dao.BookDao;
import com.bookworm.model.Book;

@Controller
public class BookController {

	@Autowired
	private BookDao bookDao;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/bookList")
	public String getBooks(Model model) {
		List<Book> books = bookDao.getAllBooks();
		model.addAttribute("books", books);
		return "bookList";
	}

	@RequestMapping("/bookList/bookDetails/{bookId}")
	public String viewBook(@PathVariable int bookId, Model model) throws IOException {

		Book book = bookDao.getBookById(bookId);
		model.addAttribute(book);

		return "bookDetails";
	}

}
