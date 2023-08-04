package com.tekheroes.shop;

public class ShoppingCart {
	private Product[] products;
	private double cartTotal;
	private int index;
	
	public ShoppingCart() {
		products = new Product[5];
	}
	
	public void addToCart(Product p) {
		if(index < products.length) {
			products[index ++] = p;
			cartTotal += p.getPrice();
		} else
			System.out.println("Your cart is full");
	}
	
	public void checkout() {
		for (int i = 0; i < index; i++) 
			System.out.println(products[i].getName() + "\t" + products[i].getPrice());
		
		System.out.println("Cart Total: " + cartTotal);
	}
}
