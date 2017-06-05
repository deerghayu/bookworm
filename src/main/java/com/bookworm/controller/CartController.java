package com.bookworm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bookworm.dao.BookDao;
import com.bookworm.dao.CartDao;
import com.bookworm.model.Book;
import com.bookworm.model.Cart;
import com.bookworm.model.CartItem;

@Controller
@RequestMapping("/rest/cart")
public class CartController {
	@Autowired
	private CartDao cartDao;

	@Autowired
	private BookDao bookDao;

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
	public @ResponseBody Cart getCart(@PathVariable(value = "cartId") String cartId) {
		return cartDao.getCart(cartId);

	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
		cartDao.update(cartId, cart);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "cartId") String cartId) {
		cartDao.delete(cartId);
	}

	@RequestMapping(value = "/add/{bookId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "bookId") int bookId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.getCart(sessionId);
		if (cart == null) {
			cart = cartDao.create(new Cart(sessionId));
		}
		Book book = bookDao.getBookById(bookId);
		if (book == null) {
			throw new IllegalArgumentException(new Exception());
		}
		cart.addCartItem(new CartItem(book));
		cartDao.update(sessionId, cart);
	}

	@RequestMapping(value = "/remove/{bookId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable int bookId, HttpServletRequest request) {
		String sessionId = request.getSession(true).getId();
		Cart cart = cartDao.getCart(sessionId);
		if (cart == null) {
			cart = cartDao.create(new Cart(sessionId));
		}
		Book book = bookDao.getBookById(bookId);
		if (book == null) {
			throw new IllegalArgumentException(new Exception());
		}
		cart.removeCartItem(new CartItem(book));
		cartDao.update(sessionId, cart);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, Please verify your payload")
	public void handleClientError(Exception ex) {

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
	public void handleServerError(Exception ex) {

	}
}
