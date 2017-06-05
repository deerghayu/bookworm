package com.bookworm.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private String cartId;
	private Map<Integer, CartItem> cartItems;
	private double grandTotal;

	private Cart() {

		cartItems = new HashMap<Integer, CartItem>();
		grandTotal = 0;
	}

	public Cart(String cartId) {
		this();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<Integer, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<Integer, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public void addCartItem(CartItem item) {
		int bookId = item.getBook().getBookId();
		if (cartItems.containsKey(bookId)) {
			CartItem existingCartItem = cartItems.get(bookId);
			existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
			cartItems.put(bookId, existingCartItem);
		} else {
			cartItems.put(bookId, item);
		}
		updateGrandTotal();
	}

	public void removeCartItem(CartItem item) {
		int bookId = item.getBook().getBookId();
		cartItems.remove(bookId);
		updateGrandTotal();
	}

	private void updateGrandTotal() {
		grandTotal = 0;
		for (CartItem item : cartItems.values()) {
			grandTotal += item.getTotalPrice();
		}
	}

}
