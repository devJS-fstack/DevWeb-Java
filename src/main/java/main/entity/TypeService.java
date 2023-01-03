package main.entity;

import javax.persistence.*;

@Entity
@Table (name = "TypeService")
public class TypeService {
	@Id
	@Column(name = "IDTypeS")
	private int idTypeService;
	@Column(name = "NameTypeService")
	private String nameType;
	@Column(name = "Description")
	private String description;
	@Column(name = "AmountService")
	private int amount;
	public int getIdTypeService() {
		return idTypeService;
	}
	public void setIdTypeService(int idTypeService) {
		this.idTypeService = idTypeService;
	}
	public String getNameType() {
		return nameType;
	}
	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
