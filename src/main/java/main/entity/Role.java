package main.entity;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
	@Id()
	@Column(name = "IDRole")
	private String idRole;
	@Column(name = "NameRole")
	private String nameRole;
	@Column(name = "Discription")
	private String description;
	public String getIdRole() {
		return idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
