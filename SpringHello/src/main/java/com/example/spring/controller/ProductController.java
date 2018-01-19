package com.example.spring.controller;

import java.util.HashMap;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spring.model.Product;

@Controller
public class ProductController {

	public static HashMap<String, Product> map = new HashMap<>();
	
	@GetMapping("/product")
	public String ProductForm(Model model, @ModelAttribute Product product) {
		
		if(map.isEmpty()) {
			model.addAttribute("product", new Product());
			
		}
		else {
			model.addAttribute("listProduct", map.values());
			
		}
		return "list";
	}
	
	@PostMapping("/product")
	public String ProductSubmit(@ModelAttribute Product product, @Valid Product validproduct, BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("listProduct", map.values());
			return "list";
		}
//		if(map.get(product.getId()) != null) {
//			
//				Integer newAmount = product.getPAmount() + map.get(product.getId()).getPAmount();
//				map.get(product.getId()).setPAmount(newAmount);
//		}
			map.put(product.getId(), product);
		

		model.addAttribute("listProduct", map.values());
		return "list";
	}
	
	@GetMapping("/product/{id}/delete")
	public String DeleteProduct(@PathVariable String id, RedirectAttributes redirect) {
		
		map.remove(id);
		return "redirect:/product";
	}
	
	@GetMapping("/product/{id}/edit")
	public String EditProduct(@PathVariable String id, RedirectAttributes redirect, Model model) {
		
		Object editproduct = map.get(id);
		model.addAttribute("editproduct", editproduct);
		return "form";
	}
	
	@GetMapping("/product/{id}/save")
		public String SaveProduct(@ModelAttribute Product product, @PathVariable String id, RedirectAttributes redirect, Model model) {

			map.get(id).setPName(product.getPName());
			map.get(id).setPAmount(product.getPAmount());
			
			return "redirect:/product";
		}
	
	@PostMapping("product/save")
	public HashMap<String, Product> Save(@RequestBody Product product, Model model) {
		
		map.put(product.getId(), product);
		
		return map;
	}
	}


