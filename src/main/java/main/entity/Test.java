package main.entity;

import javax.persistence.*;

@Entity
@Table(name="Test")
public class Test {
	@Id
	private String id;
	@Column
	private String name;
	@Column
	private int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
