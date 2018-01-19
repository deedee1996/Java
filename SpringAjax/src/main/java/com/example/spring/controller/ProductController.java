package com.example.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.spring.model.Product;
import com.example.spring.ulti.Excel;
import com.example.spring.response.Response;

@Controller
public class ProductController {
	
	public static HashMap<String, Product> pmap = new HashMap<>();
	public HashMap<String, Product> pagination = new HashMap<>();
	public HashMap<String, Product> searchmap = new HashMap<>();
	
	@GetMapping("/product")
	public String Redirect(RedirectAttributes redirect) {
		
		return "redirect:/product/1";
	}
	
	@GetMapping("/product/{page}")
	public String Index(@PathVariable int page, @ModelAttribute Product product, Model model, RedirectAttributes redirect) {
		
		pagination.clear();
		
		pmap.put("PR1", new Product("PR1", "TEST1", 20));
		pmap.put("LS2", new Product("LS2", "PVC - 5", 20));
		pmap.put("TT3", new Product("TT3", "Iphone 10", 20));
		pmap.put("SD4", new Product("SD4", "SAMSUNG", 20));
		pmap.put("AA5", new Product("AA5", "HAHA", 20));
		pmap.put("EE6", new Product("EE6", "WOWOW", 20));
		pmap.put("PR7", new Product("PR7", "TEST7", 20));
		pmap.put("PR8", new Product("PR8", "NONO", 20));
		pmap.put("PR9", new Product("PR9", "LUCI", 20));
		pmap.put("PR10", new Product("PR10", "TEST10", 20));
		pmap.put("PR11", new Product("PR11", "OGGY", 20));
		pmap.put("PR12", new Product("PR12", "TEST12", 20));
		pmap.put("PR13", new Product("PR13", "TEST13", 20));
		pmap.put("PR14", new Product("PR14", "TEST14", 20));
		
		Object[] k = pmap.keySet().toArray();
		
		int total = pmap.size();
		int item = 5;
		
		int numpage = total%item == 0 ? total/item : total/item + 1;
		
		if(page > 0 && page <= numpage) {
			
			int numproduct = page*item;
			int index = (page - 1) * item;
			
			if(page == numpage) {
					for(int i = index; i < total; i++) {
						
						pagination.put(pmap.get(k[i]).getId(), pmap.get(k[i]));
					}
				
			}
			else {
				
				for(int i = index; i < numproduct; i++) {
					
					pagination.put(pmap.get(k[i]).getId(), pmap.get(k[i]));
				}
			}

		};
		model.addAttribute("num", page);
		model.addAttribute("counts", numpage);
		model.addAttribute("product", pagination.values());
		return "home";
		
	}
		
	@PostMapping("/product/add")
	@ResponseBody
	public Response Add(@RequestBody Product product, RedirectAttributes redirect){
		
		System.out.println(product.getName());
		if(pmap.get(product.getId()) != null) {
			
			int newAmount = pmap.get(product.getId()).getAmount() + product.getAmount();
			pmap.get(product.getId()).setAmount(newAmount);
		}
		else {
			
			pmap.put(product.getId(), product);
		}
		
		Response response = new Response("done", product);
		return response;
	}
	
	@PostMapping("/product/edit")
	@ResponseBody
	public Response Edit(@RequestBody Product product) {
		
		pmap.get(product.getId()).setName(product.getName());
		pmap.get(product.getId()).setAmount(product.getAmount());
		Object data = pmap.get(product.getId());
		
		Response res = new Response ("done", data);
		return res;
		
	}
	
	@GetMapping("/product/{id}/delete")
	public String Delete(@PathVariable String id, RedirectAttributes redirect) {
		
		pmap.remove(id);
		return "redirect:/product";
	}
	
	@GetMapping("/product/search")
	public String Search(@RequestParam("q") String q, Model model, RedirectAttributes redirect) {
		
		searchmap.clear();
		
		if(q.equals("")) {
			
			return "redirect:/product/1";
		}
		else {
			
			Object[] k = pmap.keySet().toArray();
			System.out.println(k.length);
			for(int i = 0; i < k.length; i++) {
				if(pmap.get(k[i]).getName().contains(q) || pmap.get(k[i]).getId().contains(q)) {
					
					searchmap.put(pmap.get(k[i]).getId(), pmap.get(k[i]));
					
					System.out.println("OK");
					
				}
			}
		}
		model.addAttribute("product", searchmap.values());
		return "home";
	}
	
	@GetMapping("/product/export")
	
	public ResponseEntity<Resource> downloadFile() throws IOException {
		
		new Excel(pmap);
		
		System.out.println("\n********** Download File : ************\n");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/octet-stream"));
		headers.setContentDispositionFormData("ExportData.xls","ExportData.xls");
		
		File file = FileUtils.getFile("/resources/report.xls");
		
		FileSystemResource fileSystemResource = new FileSystemResource(file);
		
		return new ResponseEntity<>(fileSystemResource, headers, HttpStatus.OK);
	}
}
