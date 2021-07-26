package com.shop.cart;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import com.interceptors.HelloInterceptor;

@Stateful
@Interceptors(value = { HelloInterceptor.class })
public class ShopCartBean implements ShopCart, ShopCartRemote {
	private List<ShopItem> cart;

	@PostConstruct
	public void initialized() {
		System.out.println("PostConstruct");
		cart = new ArrayList<ShopItem>();
	}

	public void addToCart(ShopItem item) {
		System.out.println("AddTOCart");
		if (cart != null) {
			cart.add(item);
		}
	}

	public void clearCart() {
		System.out.println("ClearCart");
		cart.clear();
	}

	public List<ShopItem> showCart() {
		System.out.println("ShowCart");
		return cart;
	}

	@PrePassivate
	public void passivate() {
		System.out.println("Passivating // remove non serializable ");
	}

	@PostActivate
	public void activate() {
		System.out.println("activated // reconstruct");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroying...");
	}

	@Remove
	public void remove() {
		cart = null;
		System.out.println("Done for user ...");
	}

}
