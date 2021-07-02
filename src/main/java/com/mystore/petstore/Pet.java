package com.mystore.petstore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pet {

	private Integer petid;
	private String petname;
	private String pettype;
	private float petprice;
	@Id
	public Integer getPetid() {
		return petid;
	}
	public void setPetid(Integer petid) {
		this.petid = petid;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getPettype() {
		return pettype;
	}
	public void setPettype(String pettype) {
		this.pettype = pettype;
	}
	public float getPetprice() {
		return petprice;
	}
	public void setPetprice(float petprice) {
		this.petprice = petprice;
	}
	public Pet(Integer petid, String petname, String pettype, float petprice) {
		super();
		this.petid = petid;
		this.petname = petname;
		this.pettype = pettype;
		this.petprice = petprice;
	}
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
