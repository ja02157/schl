package org.alamsoft.enterprise.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Roles", schema="school_owner")
public class Roles {
	private static final long serialVersionUID = 1L;
	
	public Roles() {}
	

	@Id
	@Column(name="role_id")
	String roleId;
	
	


	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	@Column(name="role_name")
	String roleName;
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	@Column(name="role_description")
	String roleDescription;
	

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
}

