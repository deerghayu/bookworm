package com.bookworm.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bookworm.dao.CartDao;
import com.bookworm.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	private Map<String, Cart> carts;

	public CartDaoImpl() {
		carts = new HashMap<String, Cart>();
	}

	public Cart create(Cart cart) {
		if (carts.keySet().contains(cart.getCartId())) {
			throw new IllegalArgumentException(String
					.format("Cannot create a cart. A cart with the given id(%s) already exits.", cart.getCartId()));
		}
		carts.put(cart.getCartId(), cart);
		return cart;
	}

	public Cart getCart(String cartId) {
		return carts.get(cartId);
	}

	public void update(String cartId, Cart cart) {
		if (!carts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(String
					.format("Cannot update a cart. The cart with the given id(%s) doesn't exits.", cart.getCartId()));
		}
		carts.put(cartId, cart);
	}

	public void delete(String cartId) {
		if (!carts.keySet().contains(cartId)) {
			throw new IllegalArgumentException(
					String.format("Cannot delete the cart. The cart with the given id(%s) doesn't exits.", cartId));
		}
		carts.remove(cartId);
	}

}
