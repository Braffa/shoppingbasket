package com.braffa.shoppingbasket.basket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import com.braffa.shoppingbasket.products.Product;

public class ShoppingCart {

	private Map<String, Product> products;

	public void setProducts(Map<String, Product> products) {
		this.products = products;
	}

	private void addToBasket(Map<String, Integer> basket, String item) {
		if (basket.containsKey(item)) {
			basket.put(item, basket.get(item).intValue() + 1);
		} else {
			basket.put(item, new Integer(1));
		}
	}

	public Map<String, Integer> getBasketItems(String[] items) {
		Map<String, Integer> basket = new HashMap<String, Integer>();
		for (String item : items) {
			Product product = products.get(item);
			if (product == null) {
				System.out.println("UnKown item " + item);
			} else {
				addToBasket(basket, item);
			}
		}
		return basket;
	}

	public double getTotals(Map<String, Integer> basket) {
		double total = 0;
		for (Map.Entry<String, Integer> item : basket.entrySet()) {
			String key = item.getKey();
			int purchased = item.getValue();
			Product product = products.get(key);
			double price = products.get(key).getCost();
			if (product.getSpecialOffer() != null) {
				int buyQty = product.getSpecialOffer().getBuyQty();
				int freeQty = product.getSpecialOffer().getFreeQty();
				double discountedNumber = (Math.floor(purchased / buyQty));
				int remaining = purchased % buyQty;
				total = total + ((discountedNumber * freeQty) * price) + (remaining * price);
			} else {
				total = total + (purchased * price);
			}
		}
		return new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
}
