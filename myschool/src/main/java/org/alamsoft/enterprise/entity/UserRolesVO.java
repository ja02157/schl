package org.alamsoft.enterprise.entity;
import java.io.Serializable;


public class UserRolesVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private Roles roles;


	

	
	public UserRolesVO(String userName, Roles role) {
		this.roles = role;
        this.username = username;
	}
	
	public UserRolesVO() {
		
	}
	
	private Roles role;
	
	
	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}


}

