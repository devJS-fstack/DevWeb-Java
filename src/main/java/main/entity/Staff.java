package main.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name = "Staff")
public class Staff implements Serializable {
	@Id
	@Column(name="IDStaff")
	private String idStaff;
	@Column(name="SurName")
	private String surName;
	@Column(name="NameStaff")
	private String nameStaff;
	@Column(name="Gender")
	private String gender;
	@Column(name="Phone")
	private String phone;
	@Column(name="Email")
	private String email;
	@Column(name="CCCD")
	private String cccd;
	@ManyToOne()
	@JoinColumn(name="IDStore")
	private Store store;
	@Column(name="Status")
	private String status;
	@Column(name="PathImgStaff")
	private String pathImgStaff;
	@Column(name="IDManager")
	private String idManager;
	@Column(name="TypeStaff")
	private int typeStaff;
	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
	private List<RegisShift> listRegis;
	
	public List<RegisShift> getListRegis() {
		return listRegis;
	}
	public void setListRegis(List<RegisShift> listRegis) {
		this.listRegis = listRegis;
	}
	public String getIdStaff() {
		return idStaff;
	}
	public Staff(String idStaff, String surName, String nameStaff, String gender, String phone, String email,
			String cccd, Store store, String status, String pathImgStaff, String idManager, int typeStaff) {
		super();
		this.idStaff = idStaff;
		this.surName = surName;
		this.nameStaff = nameStaff;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.cccd = cccd;
		this.store = store;
		this.status = status;
		this.pathImgStaff = pathImgStaff;
		this.idManager = idManager;
		this.typeStaff = typeStaff;
	}
	public Staff() {
		super();
	}
	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getNameStaff() {
		return nameStaff;
	}
	public void setNameStaff(String nameStaff) {
		this.nameStaff = nameStaff;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPathImgStaff() {
		return pathImgStaff;
	}
	public void setPathImgStaff(String pathImgStaff) {
		this.pathImgStaff = pathImgStaff;
	}
	public String getIdManager() {
		return idManager;
	}
	public void setIdManager(String idManager) {
		this.idManager = idManager;
	}
	public int getTypeStaff() {
		return typeStaff;
	}
	public void setTypeStaff(int typeStaff) {
		this.typeStaff = typeStaff;
	}
}
