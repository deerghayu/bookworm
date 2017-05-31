package com.bookworm.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.bookworm.dao.BookDao;
import com.bookworm.model.Book;

@Controller
public class BookController {

	private Path path;

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

	@RequestMapping("/admin")
	public String adminPage() {
		return "admin";
	}

	@RequestMapping("/admin/bookInventory")
	public String bookInventory(Model model) {
		List<Book> books = bookDao.getAllBooks();
		model.addAttribute("books", books);

		return "bookInventory";
	}

	@RequestMapping("/admin/bookInventory/addBook")
	public String addBook(Model model) {
		Book book = new Book();
		book.setBookAuthor("Subin Kumar");
		book.setBookCategory("Novel");
		book.setBookPublisher("kantipur");
		book.setBookPrice(400);
		book.setUnitInStock(200);
		book.setBookStatus("In Stock");
		model.addAttribute("book", book);
		return "addBook";
	}

	/*
	 * when you run tomcat inside eclipse. eclipse copy your project and execute
	 * it at
	 * "C:\Users\USER_NAME\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\PROJECT_NAME\WEB-INF\resources\images\IMAGE_NAME.png"
	 * It's correct path. So, You can't see Images inside resource/images of
	 * project Directory. Don't Panic!
	 */
	@RequestMapping(value = "/admin/bookInventory/addBook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book, HttpServletRequest request) {
		bookDao.addBook(book);

		MultipartFile bookImage = book.getBookImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + book.getBookId() + ".png");

		if (bookImage != null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Book image saving failed", e);
			}
		}

		return "redirect:/admin/bookInventory";
	}

	@RequestMapping(value = "/admin/bookInventory/deleteBook/{bookId}")
	public String deleteBook(@PathVariable int bookId, Model model, HttpServletRequest request) {

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + bookId + ".png");
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		bookDao.deleteBook(bookId);

		return "redirect:/admin/bookInventory";
	}

	@RequestMapping(value = "/admin/bookInventory/editBook/{bookId}")
	public String editBook(@PathVariable int bookId, Model model) {

		Book book = bookDao.getBookById(bookId);
		model.addAttribute(book);

		return "editBook";
	}

	@RequestMapping(value = "/admin/bookInventory/editBook", method = RequestMethod.POST)
	public String editBookPost(@ModelAttribute("book") Book book, Model model, HttpServletRequest request) {

		MultipartFile bookImage = book.getBookImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + book.getBookId() + ".png");
		if (bookImage != null && !bookImage.isEmpty()) {
			try {
				bookImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				throw new RuntimeException("Book Image Saving Failed", e);
			}
		}
		bookDao.editBook(book);

		return "redirect:/admin/bookInventory";
	}

}
