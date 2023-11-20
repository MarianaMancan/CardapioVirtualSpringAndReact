package com.example.cardapio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Drink {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;	
	@Column(length = 100)
	private String title;
	
	@Column(length = 100000)
	private String image;
	@Column
	private Double price;
	
	
	public Drink() {
		super();
	}
	public Drink(Long id, String title, String image, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.price = price;
	}
	public Drink(String title,String image,Double price) {
		super();
		this.title = title;
		this.image = image;
		this.price = price;
		
	}

	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getImage() {
		return image;
	}
	public Double getPrice() {
		return price;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}
