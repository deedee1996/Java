package com.example.demo.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;
import com.example.demo.model.Product;

@Service
public class ProductService {

	public static final int ITEM_PER_PAGE = 5;
	
	HashMap<String, Product> mproduct = new HashMap<String, Product>();
	HashMap<String, Product> sproduct = new HashMap<>();
	HashMap<String, Product> mgetPage = new HashMap<String, Product>();
	
	public ProductService(){
		
		mproduct.put("TE1", new Product("TE1", "AAA1", 1));
		mproduct.put("TE2", new Product("TE2", "AAA2", 2));
		mproduct.put("TE3", new Product("TE3", "AAA3", 32));
		mproduct.put("TE4", new Product("TE4", "AAA4", 72));
		mproduct.put("TE5", new Product("TE5", "AAA5", 52));
		mproduct.put("TE6", new Product("TE6", "AAA6", 32));
		mproduct.put("TE7", new Product("TE7", "AAA7", 23));
		mproduct.put("TE8", new Product("TE8", "AAA8", 123));
		mproduct.put("TE9", new Product("TE9", "AAA9", 129));
		mproduct.put("TE10", new Product("TE10", "AAA", 132));
		mproduct.put("TE11", new Product("TE11", "A1AA", 132));
		mproduct.put("TE12", new Product("TE12", "AA2A", 132));
	}
	
	public HashMap<String, Product> getAll(){
		
		return mproduct;
	}
	
	public Product getById(String id) {
		
		if(mproduct.containsKey(id)) {
			
			return mproduct.get(id);
		}
		else {
			
			return null;
		}
	}
	
	public void deleteById(String id) {
		
		mproduct.remove(id);
	}
	
	public void addProduct(Product product) {
		
		if(mproduct.get(product.getId()) == null) {
			
			mproduct.put(product.getId(), new Product(product.getId(), product.getName(), product.getQuantity()));
			
		}
		
		else {
			
			int newQuantity = product.getQuantity() + mproduct.get(product.getId()).getQuantity();
			mproduct.get(product.getId()).setQuantity(newQuantity);
		}
	}
	
	public void updateProduct(String id, Product product) {
		
		mproduct.get(id).setName(product.getName());
		mproduct.get(id).setQuantity(product.getQuantity());
	}
	
	public HashMap<String, Product> searchProduct(String q){
		
		sproduct.clear();
		
		Object[] key = mproduct.keySet().toArray();
		
		for(int i = 0; i < key.length; i++) {
			
			if(mproduct.get(key[i]).getId().contains(q) || mproduct.get(key[i]).getName().contains(q)) {
				
				sproduct.put(mproduct.get(key[i]).getId(), mproduct.get(key[i]));
			}
		}
		
		return sproduct;
	}
	
	public HashMap<String, Product> getPage(int p){
		
		mgetPage.clear();
		
		int size = mproduct.size();
		
		int totalPage = size%ITEM_PER_PAGE == 0 ? size/ITEM_PER_PAGE : size/ITEM_PER_PAGE + 1;
		
		if(p > totalPage) return null;
		
		int index = (p - 1) * ITEM_PER_PAGE;
		
		Object[] key = mproduct.keySet().toArray();
		
		if(p > 0 && p < totalPage +1) {
			
			if(p == totalPage) {
					for(int i = index; i < size; i++) {
						
						mgetPage.put(mproduct.get(key[i]).getId(), mproduct.get(key[i]));
				}
			}
			
			else {
				
				for(int i = index; i < ITEM_PER_PAGE + index; i++) {
					
					mgetPage.put(mproduct.get(key[i]).getId(), mproduct.get(key[i]));
				}
			}
		}
		
		return mgetPage;
	}
}
