package com.shop.cart;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface ShopCartRemote {

	public abstract void addToCart(ShopItem item);

	public abstract void clearCart();

	public abstract List<ShopItem> showCart();

	public void remove();

}