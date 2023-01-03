package poly.controller;

public class PayloadAuthen {
	private String account;
	private String password;
	private String phone;
	private String referenceDuplicate;
	private String email;
	private String verifyNumber;
	private String nameCustomer;
	private String accessToken;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	@Override
	public String toString() {
		return "PayloadAuthen [account=" + account + ", password=" + password + ", phone=" + phone
				+ ", referenceDuplicate=" + referenceDuplicate + ", email=" + email + ", verifyNumber=" + verifyNumber
				+ ", nameCustomer=" + nameCustomer + ", accessToken=" + accessToken + "]";
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReferenceDuplicate() {
		return referenceDuplicate;
	}
	public void setReferenceDuplicate(String referenceDuplicate) {
		this.referenceDuplicate = referenceDuplicate;
	}
	public String getAccount() {
		return account;
	}
	public String getPhone() {
		return phone;
	}
	public String getVerifyNumber() {
		return verifyNumber;
	}
	public void setVerifyNumber(String verifyNumber) {
		this.verifyNumber = verifyNumber;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
