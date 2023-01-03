package main.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "BookItem")
public class BookItem implements Serializable {
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
	@Id
	@Column(name = "IDService")
	private int idService;
	@Column(name = "Price")
	private int price;
	public Date getDateBook() {
		return dateBook;
	}
	public void setDateBook(Date dateBook) {
		this.dateBook = dateBook;
	}
	public String getIdShiftBook() {
		return idShiftBook;
	}
	public BookItem() {
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
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	@Override
	public String toString() {
		return "BookItem [dateBook=" + dateBook + ", idShiftBook=" + idShiftBook + ", idStaff=" + idStaff
				+ ", idService=" + idService + ", price=" + price + "]";
	}
	public BookItem(Date dateBook, String idShiftBook, String idStaff, int idService, int price) {
		super();
		this.dateBook = dateBook;
		this.idShiftBook = idShiftBook;
		this.idStaff = idStaff;
		this.idService = idService;
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
