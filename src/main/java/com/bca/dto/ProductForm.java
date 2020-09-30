package com.bca.dto;

import javax.validation.constraints.NotEmpty;
/*import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;*/

public class ProductForm {

	@NotEmpty(message="Type is required")
	/* @Size(min = 3, max = 5, message="Code length must be 3 to 5 characters") */
	/* @Pattern(regexp = "BT[0-9]+", message = "Code must be start with BT") */
    private String type;
	
	@NotEmpty(message="Photo is required")
    private String photo;
	
	@NotEmpty(message="Deskripsi is required")
    private String descrip;
	
	@NotEmpty(message="Color is required")
	private String color;
	
    private double price;
	
    private int stock;
	
    private int sold;

    private int brandId;
//    private int adminId;
	
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
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
//	public int getAdminId() {
//		return adminId;
//	}
//	public void setAdminId(int adminId) {
//		this.adminId = adminId;
//	}
//
    
}
