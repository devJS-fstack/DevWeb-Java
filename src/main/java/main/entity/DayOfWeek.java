package main.entity;

import javax.persistence.*;

@Entity
@Table(name = "DayOfWeek")
public class DayOfWeek {
	@Id
	@Column(name = "IDDayOfWeek")
	private int idDayOfWeek;
	@Column(name = "NameDayOfWeek")
	private String nameDayOfWeek;
	@Column(name = "MaxStylist")
	private int maxStylist;
	@Column(name = "MaxSkiner")
	private int maxSkiner;
	public int getIdDayOfWeek() {
		return idDayOfWeek;
	}
	public void setIdDayOfWeek(int idDayOfWeek) {
		this.idDayOfWeek = idDayOfWeek;
	}
	public String getNameDayOfWeek() {
		return nameDayOfWeek;
	}
	public void setNameDayOfWeek(String nameDayOfWeek) {
		this.nameDayOfWeek = nameDayOfWeek;
	}
	public int getMaxStylist() {
		return maxStylist;
	}
	public void setMaxStylist(int maxStylist) {
		this.maxStylist = maxStylist;
	}
	public int getMaxSkiner() {
		return maxSkiner;
	}
	public void setMaxSkiner(int maxSkiner) {
		this.maxSkiner = maxSkiner;
	}
}
