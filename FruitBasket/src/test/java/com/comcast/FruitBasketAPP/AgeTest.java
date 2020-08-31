package com.comcast.FruitBasketAPP;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Comcast.FruitBasket.Fruit;

public class AgeTest {

	@Test
	public void test() {
		Fruit fruit = new Fruit();
		fruit.setAge(2);
		assertTrue(fruit.getAge() == 2);
	}

}
