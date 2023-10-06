package com.indra.hometutor.module;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Tutor {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name = "Mobile")
	private String mobile;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Course")
	private String course;
	
	@Column(name = "Subject")
	private String subject;
	
	@Column(name = "Area")
	private String area;
	
	@Column(name = "Pincode")
	private String pincode;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public Tutor(String name, String gender, String mobile, String email, String password, String course, String subject,
		String area, String pincode) {
			super();
			this.name = name;
			this.gender = gender;
			this.mobile = mobile;
			this.email = email;
			this.password = password;
			this.course = course;
			this.subject = subject;
			this.area = area;
			this.pincode = pincode;
	}
	

	public Tutor() {
	
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
		return "Tutor [id=" + id + ", name=" + name + ", gender=" + gender + ", mobile=" + mobile + ", email=" + email
				+ ", password=" + password + ", course=" + course + ", subject=" + subject + ", area=" + area
				+ ", pincode=" + pincode + "]";
	}


	

}
