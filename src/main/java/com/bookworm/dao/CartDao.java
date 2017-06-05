package com.bookworm.dao;

import com.bookworm.model.Cart;

public interface CartDao {

	Cart create(Cart cart);

	Cart getCart(String cartId);

	void update(String cartId, Cart cart);

	void delete(String cartId);

}
