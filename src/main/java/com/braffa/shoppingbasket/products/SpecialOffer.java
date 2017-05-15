package com.braffa.shoppingbasket.products;

public class SpecialOffer {

	int buyQty;
	int freeQty;

	public SpecialOffer(int buyQty, int freeQty) {
		this.buyQty = buyQty;
		this.freeQty = freeQty;
	}

	public int getBuyQty() {
		return buyQty;
	}

	public void setBuyQty(int buyQty) {
		this.buyQty = buyQty;
	}

	public int getFreeQty() {
		return freeQty;
	}

	public void setFreeQty(int freeQty) {
		this.freeQty = freeQty;
	}

}