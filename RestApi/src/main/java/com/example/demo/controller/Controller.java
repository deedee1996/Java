package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.errortype.ErrorType;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class Controller {
	
	@Autowired
	public ProductService ps;
	
	@GetMapping("/all")
	public HashMap<String, Product> getAll(){
		
		return ps.getAll();
	}
	
	@GetMapping("/{id}")
	public Product getById(@PathVariable("id") String id){
		
		return ps.getById(id);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") String id){
		
		if(ps.getById(id) != null) {
			ps.deleteById(id);
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(new ErrorType("Not Found " + id), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		
		ps.addProduct(product);
		return new ResponseEntity<Product>(HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Product product){
		
		if(ps.getById(id) == null) {
			return new ResponseEntity<>(new ErrorType("Error, Not Found"), HttpStatus.NOT_FOUND);
		}
		
		ps.updateProduct(id, product);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("/search")
	public HashMap<String, Product> searchProduct(@RequestParam("q") String q) {
		
		return ps.searchProduct(q);
		
	}
	
	@GetMapping("/get")
	public HashMap<String, Product> getPage(@RequestParam("p") int p){
		
		return ps.getPage(p);
	}	
}
