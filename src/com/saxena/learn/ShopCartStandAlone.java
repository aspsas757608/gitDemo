package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import javax.ejb.Handle;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.bank.beans.AuthenticationRemote;
import com.shop.cart.ShopCart;
import com.shop.cart.ShopCartRemote;
import com.shop.cart.ShopItem;

public class ShopCartStandAlone {

	public static void main(String[] args) {
		try {
			File file = new File("c:/handle.ser");
			ShopCartRemote shopCart = null;
			if (file.exists()) {
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(file));
				shopCart = (ShopCartRemote) ois.readObject();
				ois.close();
			} else if (shopCart == null) {
				Properties config = new Properties();
				config.put(Context.INITIAL_CONTEXT_FACTORY,
						"org.jboss.naming.NamingContextFactory");
				config.put(Context.PROVIDER_URL, "jnp://localhost:1099");
				InitialContext ctx = new InitialContext(config);
				shopCart = (ShopCartRemote) ctx
						.lookup("BankApp/ShopCartBean/remote");
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(shopCart);
				oos.flush();
				oos.close();
			}
			shopCart.addToCart(new ShopItem());
			shopCart.addToCart(new ShopItem());
			System.out.println(shopCart.showCart().size());
			shopCart.addToCart(new ShopItem());
			shopCart.addToCart(new ShopItem());
			System.out.println(shopCart.showCart().size());
			shopCart.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
