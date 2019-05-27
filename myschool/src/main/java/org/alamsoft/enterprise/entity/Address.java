package org.alamsoft.enterprise.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Address", schema="PUBLIC")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Address() {}
	
	String firstname;
	String lastname;
	String password;
	String role;
	String token;
	

	@Id
	@Column(name="emp_id")
	String empid;
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	
	@Column(name="firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}
	
	@Column(name="lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastName) {
		this.lastname = lastName;
	}
	
	@Column(name="role")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="token")
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}

