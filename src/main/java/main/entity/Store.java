package main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Store")
public class Store {
	@Id
	@Column(name = "IDStore")
	private String idStore;
	@Column(name = "Phone")
	private String phone;
	@Column(name = "Email")
	private String email;
	@Column(name = "Street")
	private String street;
	@Column(name = "City")
	private String city;
	@Column(name = "PathImg")
	private String pathImg;
	public String getIdStore() {
		return idStore;
	}
	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPathImg() {
		return pathImg;
	}
	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}
}
