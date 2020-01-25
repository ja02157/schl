package org.alamsoft.enterprise.entity;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;



public class UserIdentityVO implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	public UserIdentityVO() {}
	
	  private UserInformation userInformation;
	

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	String username;
	
	
	
	String token;
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	public String getUsername() {
		return this.username;
	}
		
	public void setUsername(String username) {
		this.username = username;
	}
	
	String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
    private UserRolesVO[] userRoles;

	public UserRolesVO[] getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRolesVO[] userRoles) {
		this.userRoles = userRoles;
	}

}

