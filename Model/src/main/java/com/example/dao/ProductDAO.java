package com.example.dao;
import java.util.List;

import com.example.model.Product;
public interface ProductDAO {
	List<Product> getAll();
	boolean add(Product product);
	boolean delete(String Name);
	Product get(String name);
}
