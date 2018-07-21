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

	@Id
	@Column(name="emp_id")
	long empid;
	
	String firstname;
	String lastname;
	
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
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
}

