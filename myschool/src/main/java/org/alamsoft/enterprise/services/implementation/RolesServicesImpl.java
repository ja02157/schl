package org.alamsoft.enterprise.services.implementation;

import org.alamsoft.enterprise.entity.Roles;
import org.alamsoft.enterprise.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class RolesServicesImpl {

	@Autowired
	RoleRepository roleRepository;

	public Roles[] getAllRoles() {
		return roleRepository.getAll();
	}
	

}
