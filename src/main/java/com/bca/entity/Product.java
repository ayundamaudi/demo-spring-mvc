package com.bca.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name = "tb_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_product;
	@Column(length = 45, nullable = false)
    private String 	type;
	@Column(length = 45, nullable = false)
    private String photo;
	@Column(length = 1000, nullable = false)
    private String descrip;
	@Column(length = 20, nullable = false)
    private String 	color;
	@Column(length = 45)
    private double price;
	@Column(length = 10, nullable = false)
    private int stock;
	@Column(length = 10, nullable = false)
    private int sold;
	@Column(length = 20, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date created_product;
	@ManyToOne
    private Brand brand;
	@ManyToOne
    private Admin admin;
	
	
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Admin getAdmin() {
		return admin;
	}
	public Date getCreated_product() {
		return created_product;
	}
	public void setCreated_product(Date created_product) {
		this.created_product = created_product;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@PrePersist
	public void setCreated_product() {
		this.created_product = new Date();
	}
	
}
