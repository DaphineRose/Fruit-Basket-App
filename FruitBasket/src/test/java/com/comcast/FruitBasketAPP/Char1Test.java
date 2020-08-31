package com.comcast.FruitBasketAPP;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Comcast.FruitBasket.Fruit;

public class Char1Test {

	@Test
	public void test() {
		Fruit fruit = new Fruit();
		fruit.setChar1("red");
		assertTrue(fruit.getChar1() == "red");
	}
	}


