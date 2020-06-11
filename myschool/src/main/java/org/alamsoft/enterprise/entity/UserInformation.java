package org.alamsoft.enterprise.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="User_Detail", schema="school_owner")
public class UserInformation  {
	private static final long serialVersionUID = 1L;
	
	public UserInformation() {}
	
	String firstname;
	String lastname;
	String middlename;
	
	@Column(name="middlename")
	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	@Id
	@Column(name="username")
	String username;
	
	
	
	
	public void setUsername(String username) {
		this.username = username;
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

