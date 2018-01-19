package com.example.spring.model;

import javax.validation.constraints.NotNull;

public class Product {
	
	@NotNull
	private String Id;
	
	@NotNull
	private String Name;
	
	@NotNull
	private int Amount;
	
	public Product() {}
	
	public Product(String id, String name, int amount) {
		super();
		Id = id;
		Name = name;
		Amount = amount;
	}

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
}
