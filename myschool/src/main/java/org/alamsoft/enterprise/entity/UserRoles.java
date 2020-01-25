package org.alamsoft.enterprise.entity;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="User_Roles", schema="school_owner")
public class UserRoles {
	private static final long serialVersionUID = 1L;
	
	public UserRoles(String userName, String roleId) {
		userRoleId = new UserRoleId(userName, roleId);
	}
	
	@EmbeddedId
    private UserRoleId userRoleId;
	
	public UserRoleId getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(UserRoleId userRoleId) {
		this.userRoleId = userRoleId;
	}

	public UserRoles() {}
	
	@OneToOne(fetch=FetchType.EAGER)
	  @JoinColumn(name="role_id", insertable = false, updatable = false)
	  private Roles role;
	
	
	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}


}

