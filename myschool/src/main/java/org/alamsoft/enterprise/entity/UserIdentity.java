package org.alamsoft.enterprise.entity;
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



@Entity
@Table(name="User_Identity", schema="school_owner")
public class UserIdentity implements  UserDetails {
	private static final long serialVersionUID = 1L;
	
	public UserIdentity() {}
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	  @JoinColumn(name="username")
	  private UserInformation userInformation;
	

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	@Id
	@Column(name="username")
	String username;
	
	
	@Column(name="token")
	String token;
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
		
	public void setUsername(String username) {
		this.username = username;
	}
	
	String password;
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuths =
                AuthorityUtils.commaSeparatedStringToAuthorityList(commaSeperatedRoles(getUserRoles()));
		return grantedAuths;
		}
	
	private String commaSeperatedRoles(Set<UserRoles> roles) {
		StringBuffer commaSeperatedRoles= new StringBuffer();
		for (UserRoles role : roles) {
			commaSeperatedRoles.append(role.getRole().getRoleName());
		}
		
		return commaSeperatedRoles.toString();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	@OneToMany(mappedBy="userRoleId.username", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<UserRoles> userRoles;

	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}
}

