package com.example.plantio1.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private String name;
    
    @OneToMany(mappedBy = "category")
    private List<Product > product;
    

	public Category(Long cid, String name, List<Product> product) {
		super();
		this.cid = cid;
		this.name = name;
		this.product = product;
	}


	


	public Long getCid() {
		return cid;
	}





	public void setCid(Long cid) {
		this.cid = cid;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	public Category() {
		super();
	}
    
}
