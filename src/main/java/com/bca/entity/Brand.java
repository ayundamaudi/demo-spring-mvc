package com.bca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "tb_brand")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_brand;
	@Column(length = 20, nullable = false, unique = true)
    private String name_brand;
	
	public int getId_brand() {
		return id_brand;
	}
	public void setId_brand(int id_brand) {
		this.id_brand = id_brand;
	}
	public String getName_brand() {
		return name_brand;
	}
	public void setName_brand(String name_brand) {
		this.name_brand = name_brand;
	}
	
	
}
