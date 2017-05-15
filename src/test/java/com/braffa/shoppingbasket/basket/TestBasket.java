package com.braffa.shoppingbasket.basket;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.braffa.shoppingbasket.products.Product;

public class TestBasket {

	ShoppingCart shoppingCart = new ShoppingCart();

	@Before
	public void initialise() {
		Map<String, Product> products = new HashMap<String, Product>();
		Product p = new Product("Apple", 0.60, 2, 1);
		products.put(p.getName(), p);
		p = new Product("Orange", 0.25, 3, 2);
		products.put(p.getName(), p);
		p = new Product("Peach", 0.75);
		products.put(p.getName(), p);
		shoppingCart.setProducts(products);
	}

	@Test
	public void testGetBasketItems() {
		String[] items = { "Apple", "Orange", "Orange", "Apple", "Apple" };
		Map<String, Integer> basket = shoppingCart.getBasketItems(items);
		int total = basket.get("Apple");
		assertTrue("There should be 3 Apples ", 3 == total);
		total = basket.get("Orange");
		assertTrue("There should be 2 Oranges ", 2 == total);
	}

	@Test
	public void testGetTotalWithOfferApple() {
		String[] items = { "Apple", "Apple", "Apple", "Apple", "Apple" };
		Map<String, Integer> basket = shoppingCart.getBasketItems(items);
		double total = shoppingCart.getTotals(basket);
		assertTrue("The total should be 1.8 ", 1.8 == total);
	}

	@Test
	public void testGetTotalWithOfferOange() {
		String[] items = { "Orange", "Orange", "Orange", "Orange", "Orange", "Orange", "Orange" };
		Map<String, Integer> basket = shoppingCart.getBasketItems(items);
		double total = shoppingCart.getTotals(basket);
		assertTrue("The total should be 1.25 ", 1.25 == total);
	}

	@Test
	public void testGetTotalWithNoOfferPeach() {
		String[] items = { "Peach", "Peach", "Peach" };
		Map<String, Integer> basket = shoppingCart.getBasketItems(items);
		double total = shoppingCart.getTotals(basket);
		assertTrue("The total should be 2.25 ", 2.25 == total);
	}

	@Test
	public void testGetTotalWithOffer() {
		String[] items = { "Apple", "Orange", "Peach", "Apple", "Orange", "Orange" };
		Map<String, Integer> basket = shoppingCart.getBasketItems(items);
		double total = shoppingCart.getTotals(basket);
		assertTrue("The total should be 1.85 ", 1.85 == total);
	}
}
