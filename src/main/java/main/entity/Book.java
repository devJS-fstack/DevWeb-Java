package main.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "Book")
public class Book implements Serializable {
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DateBook")
	private Date dateBook;
	@Id
	@Column(name = "IDShiftBook")
	private String idShiftBook;
	@Id
	@Column(name = "IDStaff")
	private String idStaff;
	public Book(Date dateBook, String idShiftBook, String idStaff, int payment, String phoneCustomer, int idStore,
			String stautsBook) {
		this.dateBook = dateBook;
		this.idShiftBook = idShiftBook;
		this.idStaff = idStaff;
		this.payment = payment;
		this.phoneCustomer = phoneCustomer;
		this.idStore = idStore;
		this.stautsBook = stautsBook;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [dateBook=" + dateBook + ", idShiftBook=" + idShiftBook + ", idStaff=" + idStaff + ", payment="
				+ payment + ", phoneCustomer=" + phoneCustomer + ", idStore=" + idStore + ", stautsBook=" + stautsBook
				+ "]";
	}
	@Column(name = "Payment")
	private int payment;
	@Column(name = "PhoneCustomer")
	private String phoneCustomer;
	@Column(name = "IDStore")
	private int idStore;
	@Column(name = "StatusBook")
	private String stautsBook;
	public Date getDateBook() {
		return dateBook;
	}
	public void setDateBook(Date dateBook) {
		this.dateBook = dateBook;
	}
	public String getIdShiftBook() {
		return idShiftBook;
	}
	public void setIdShiftBook(String idShiftBook) {
		this.idShiftBook = idShiftBook;
	}
	public String getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(String idStaff) {
		this.idStaff = idStaff;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getPhoneCustomer() {
		return phoneCustomer;
	}
	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}
	public int getIdStore() {
		return idStore;
	}
	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}
	public String getStautsBook() {
		return stautsBook;
	}
	public void setStautsBook(String stautsBook) {
		this.stautsBook = stautsBook;
	}
}
