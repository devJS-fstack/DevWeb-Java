package main.entity;

import javax.persistence.*;

@Entity
@Table(name = "TaiKhoan")
public class TaiKhoan {
	@Id
	@Column(name = "Account")
	private String account;
	@Column(name = "Password")
	private String password;
	@Column(name = "Status")
	private String status;
	@Column(name = "IDRole")
	private String idRole;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return idRole;
	}
	public TaiKhoan(String account, String password, String status, String idRole) {
		super();
		this.account = account;
		this.password = password;
		this.status = status;
		this.idRole = idRole;
	}
	public void setRole(String role) {
		this.idRole = role;
	}
}
