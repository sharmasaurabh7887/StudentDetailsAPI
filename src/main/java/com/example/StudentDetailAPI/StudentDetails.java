package com.example.StudentDetailAPI;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDetails {
	
	@Id
	int id;
	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", name=" + name + ", Cource_name=" + Cource_name + ", gender=" + gender
				+ ", city=" + city + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCource_name() {
		return Cource_name;
	}
	public void setCource_name(String cource_name) {
		Cource_name = cource_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public StudentDetails(int id, String name, String cource_name, String gender, String city) {
		super();
		this.id = id;
		this.name = name;
		Cource_name = cource_name;
		this.gender = gender;
		this.city = city;
	}
	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	String name;
	String Cource_name;
	String gender;
	String city;
	

}
