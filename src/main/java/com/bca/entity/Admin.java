package com.bca.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "tb_admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_admin;
	@Column(length = 20, nullable = false)
    private String username_admin;
	@Column(length = 45, nullable = false)
    private String name_admin;
	@Column(length = 20, nullable = false)
    private String password_admin;
	
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
	public String getUsername_admin() {
		return username_admin;
	}
	public void setUsername_admin(String username_admin) {
		this.username_admin = username_admin;
	}
	public String getName_admin() {
		return name_admin;
	}
	public void setName_admin(String name_admin) {
		this.name_admin = name_admin;
	}
	public String getPassword_admin() {
		return password_admin;
	}
	public void setPassword_admin(String password_admin) {
		this.password_admin = password_admin;
	}
    
	
}
