package main.entity;

import javax.persistence.*;

@Entity
@Table (name = "Service")
public class Service {
	@Id
	@Column(name = "IDService")
	private int idService;
	@Column(name = "TypeService")
	private int typeService;
	@Column(name = "NameService")
	private String nameService;
	@Column(name = "Description")
	private String description;
	@Column(name = "ListPrice")
	private int price;
	@Column(name = "Status")
	private String status;
	@Column(name = "PathImg")
	private String pathImg;
	public String getPathImg() {
		return pathImg;
	}
	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}
	public int getIdService() {
		return idService;
	}
	public void setIdService(int idService) {
		this.idService = idService;
	}
	public int getTypeService() {
		return typeService;
	}
	public void setTypeService(int typeService) {
		this.typeService = typeService;
	}
	public String getNameService() {
		return nameService;
	}
	public void setNameService(String nameService) {
		this.nameService = nameService;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
