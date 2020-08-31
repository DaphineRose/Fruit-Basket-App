package com.comcast.FruitBasketAPP;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Comcast.FruitBasket.Fruit;

public class Char2 {

	@Test
	public void test() {
		Fruit fruit = new Fruit();
		fruit.setChar2("sweet");
		assertTrue(fruit.getChar2() == "sweet");
	}
	}


