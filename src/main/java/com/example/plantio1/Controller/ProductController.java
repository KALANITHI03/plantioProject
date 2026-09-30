package com.example.plantio1.Controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.plantio1.Entity.Product;
import com.example.plantio1.Services.ProductServices;

import jakarta.websocket.server.PathParam;

@RestController
public class ProductController {

	@Autowired
	ProductServices productServices;
	@GetMapping("/getAllProduct")
	public List<Product> getAll(){
		return productServices.getAll();
	}
	
	@GetMapping("/getByIdProduct/{id}")
	public Product getById(@PathVariable long id) {
		return productServices.getById(id);
	}
	
	@GetMapping("/getByNameProduct")
	public Product getByName(@RequestParam String name) {
		return productServices.getByName(name);
	}
	
	
	@GetMapping("/searchByNameProduct")
	public List<Product> searchByName(@RequestParam String name) {
		return productServices.searchByName(name);
	}
	
	
	@PostMapping("/add")
	public void addPoduct(@RequestBody Product product) {
		productServices.addProduct(product);
	}
	
	@PostMapping("/addAll")
	public List<Product> addAll(@RequestBody List<Product> products) {
		return productServices.addAll(products);
	}
	
	@PutMapping("/update/{id}")
	public Product updateDate(@PathVariable long id , @RequestBody Product product) {
	return	productServices.updateProduct(id, product);
	}
	
	@DeleteMapping("/deleteData/{id}")
	public void deleteData(@PathVariable long id) {
		productServices.deleteData(id);
	}
}
