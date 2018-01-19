package com.spring.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Product {
	
	@NotNull
	private String Id;
	
	@NotNull
	@Size(min=3, max=20)
	private String PName;
	
	@NotNull
	private Integer PAmount;
	
	public Product() {}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public Integer getPAmount() {
		return PAmount;
	}

	public void setPAmount(Integer pAmount) {
		PAmount = pAmount;
	}
}
