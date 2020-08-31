package com.comcast.FruitBasketAPP;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Comcast.FruitBasket.App;
import com.Comcast.FruitBasket.Fruit;

public class getFriutTest {

	@Test
	public void test() {
		
		Fruit fruit = new Fruit();
		fruit.setFruit("apple");
		assertTrue(fruit.getFruit() == "apple");
	}

}
