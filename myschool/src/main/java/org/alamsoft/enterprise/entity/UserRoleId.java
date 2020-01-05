package org.alamsoft.enterprise.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserRoleId implements Serializable {
    private String username;
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String role_id;


	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	// default constructor
	public UserRoleId() {}
 

	public UserRoleId(String username, String role_id) {
        this.role_id = role_id;
        this.username = username;
    }
 
    // getters, equals() and hashCode() methods
}