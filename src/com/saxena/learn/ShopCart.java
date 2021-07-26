package com.shop.cart;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ShopCart {

	public abstract void addToCart(ShopItem item);

	public abstract void clearCart();

	public abstract List<ShopItem> showCart();

	public void remove();
	
}