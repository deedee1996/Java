package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ProductDAO;
import com.example.model.Product;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productDAO.getAll();
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		return productDAO.add(product);
	}

	@Override
	public boolean delete(String Name) {
		// TODO Auto-generated method stub
		return productDAO.delete(Name);
	}

	@Override
	public Product get(String name) {
		// TODO Auto-generated method stub
		return productDAO.get(name);
	}
	
}
