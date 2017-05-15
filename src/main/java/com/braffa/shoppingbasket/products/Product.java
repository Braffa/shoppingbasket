package com.braffa.shoppingbasket.products;

public class Product {
	private String name;

	private double cost;

	private SpecialOffer specialOffer;

	public Product(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}

	public Product(String name, double cost, int buyQty, int freeQty) {
		this.name = name;
		this.cost = cost;
		this.specialOffer = new SpecialOffer(buyQty, freeQty);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public SpecialOffer getSpecialOffer() {
		return specialOffer;
	}

	public void setSpecialOffer(SpecialOffer specialOffer) {
		this.specialOffer = specialOffer;
	}
}
