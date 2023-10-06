package com.indra.hometutor.module;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "Name")
	@NotBlank(message = "Name can't be empty")
	private String name;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name = "Mobile")
	private String mobile;
	
	@Column(name = "Email")
	@NotBlank
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Area")
	private String area;
	
	@Column(name = "Pin_Code")
	private int pincode;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Student(String name, String mobile, String email, String password) {
		super();
		
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + ", area=" + area + ", pincode=" + pincode + "]";
	}
	
	
	
	

}
