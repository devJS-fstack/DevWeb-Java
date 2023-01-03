package main.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name = "RegisShift")
public class RegisShift implements Serializable {
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DateRegis")
	private Date dateRegis;
	@EmbeddedId
	@ManyToOne()
	@JsonBackReference
	@JoinColumn(name="IDStaff")
	private Staff staff;
	@ManyToOne()
	@JoinColumn(name="IDDayOfWeek")
	private DayOfWeek dayOfWeek;
	@ManyToOne()
	@JoinColumn(name="IDStore")
	private Store store;
	@Column(name = "StatusRegis")
	private String statusRegis;
	public Date getDateRegis() {
		return dateRegis;
	}
	public void setDateRegis(Date dateRegis) {
		this.dateRegis = dateRegis;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public String getStatusRegis() {
		return statusRegis;
	}
	public void setStatusRegis(String statusRegis) {
		this.statusRegis = statusRegis;
	}
}
