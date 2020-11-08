package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product {
    private Integer id;
    private String name;
    private float price;
    //private float ratings;
    private String rate;
    private float rate1;
 
    public Product() {
    }
 
    public Product(Integer id, String name, float price, String rate,float rate1) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rate = rate;
        this.rate1 = rate1;
        //this.ratings = ratings;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getRate1() {
		return rate1;
	}
	public void setRate1(float rate1) {
		this.rate1 = rate1;
	}
	
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	/*public float getRate() {
		return ratings;
	}
	public void setRate(float ratings) {
		this.ratings = ratings;
	}*/
}
