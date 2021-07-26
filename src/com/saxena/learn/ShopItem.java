package com.shop.cart;

import java.io.Serializable;

public class ShopItem implements Serializable {

	private int itemname;
	private String itemDesc;
	private float quantity;
	private double price;

	public int getItemname() {
		return itemname;
	}

	public void setItemname(int itemname) {
		this.itemname = itemname;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
