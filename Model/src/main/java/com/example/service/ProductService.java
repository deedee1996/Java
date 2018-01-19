package com.example.service;

import java.util.List;

import com.example.model.Product;

public interface ProductService {
	List<Product> getAll();
	boolean add(Product product);
	boolean delete(String Name);
	Product get(String name);
}
