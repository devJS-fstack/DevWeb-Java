package main.entity;
import javax.persistence.*;

@Entity
@Table (name = "Shift")
public class Shift {
	@Id
	@Column(name="IDShift")
	private String idShift;
	@Column(name="HourStart")
	private int hourStart;
	@Column(name="MinuteStart")
	private int minuteStart;
	public String getIdShift() {
		return idShift;
	}
	public void setIdShift(String idShift) {
		this.idShift = idShift;
	}
	public int getHourStart() {
		return hourStart;
	}
	public void setHourStart(int hourStart) {
		this.hourStart = hourStart;
	}
	public int getMinuteStart() {
		return minuteStart;
	}
	public void setMinuteStart(int minuteStart) {
		this.minuteStart = minuteStart;
	}
	
}
