package main.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@Column(name = "PhoneCustomer")
	private String phoneCustomer;
	@Column(name = "NameCustomer")
	private String nameCustomer;
	@Column(name = "EmailCustomer")
	private String emailCustomer;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DateCreate")
	private Date dateCreate;
	public String getPhoneCustomer() {
		return phoneCustomer;
	}
	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getEmailCustomer() {
		return emailCustomer;
	}
	public Customer(String phoneCustomer, String nameCustomer, String emailCustomer, Date dateCreate) {
		super();
		this.phoneCustomer = phoneCustomer;
		this.nameCustomer = nameCustomer;
		this.emailCustomer = emailCustomer;
		this.dateCreate = dateCreate;
	}
	public void setEmailCustomer(String emailCustomer) {
		this.emailCustomer = emailCustomer;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
}
