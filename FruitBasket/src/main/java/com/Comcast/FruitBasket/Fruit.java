package com.Comcast.FruitBasket;

public class Fruit {
	private String fruit;
	private int age;
	private String char1;
	private String char2;
	
	//default constructor
	public Fruit() {
		super();
	}
	
	//constructor with params
	public Fruit(String fruit, int age, String char1, String char2) {
		super();
		this.fruit = fruit;
		this.age = age;
		this.char1 = char1;
		this.char2 = char2;
	}
	
	
	//getters and setters
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getChar1() {
		return char1;
	}
	public void setChar1(String char1) {
		this.char1 = char1;
	}
	public String getChar2() {
		return char2;
	}
	public void setChar2(String char2) {
		this.char2 = char2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((char1 == null) ? 0 : char1.hashCode());
		result = prime * result + ((char2 == null) ? 0 : char2.hashCode());
		result = prime * result + ((fruit == null) ? 0 : fruit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		if (age != other.age)
			return false;
		if (char1 == null) {
			if (other.char1 != null)
				return false;
		} else if (!char1.equals(other.char1))
			return false;
		if (char2 == null) {
			if (other.char2 != null)
				return false;
		} else if (!char2.equals(other.char2))
			return false;
		if (fruit == null) {
			if (other.fruit != null)
				return false;
		} else if (!fruit.equals(other.fruit))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Fruit [fruit=" + fruit + ", age=" + age + ", characteristic1=" + char1 + ", characteristic2=" + char2 + "]";
	}
	
}
