package org.alamsoft.enterprise.services.implementation;

import java.util.HashSet;
import java.util.Set;

import org.alamsoft.enterprise.entity.UserIdentity;
import org.alamsoft.enterprise.entity.UserIdentityVO;
import org.alamsoft.enterprise.entity.UserRoles;
import org.alamsoft.enterprise.entity.UserRolesVO;
import org.alamsoft.enterprise.repositories.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PersonalInfoServicesImpl {

	@Autowired
	PersonalRepository personalInfoRepository;

	public void savePersonalInfo(UserIdentityVO address) {
		//UserRoles usrRole = 
		UserRolesVO[] arr = address.getUserRoles();
		Set<UserRoles> set = new HashSet<UserRoles>();
		for (UserRolesVO usrRole : arr) {
			System.out.println(usrRole);
			UserRoles userRoles = new UserRoles(usrRole.getUsername(), usrRole.getRole().getRoleId());
			set.add(userRoles);
		}
		
		UserIdentity address1 = new UserIdentity();
		address1.setUsername(address.getUsername());
		address1.setUserInformation(address.getUserInformation());
		//address1.setUserRoles(set);
		//UserRoles usrRole = new UserRoles(address.getUsername(), "ROLE_ADMIN");
		//UserRoles usrRoleA = new UserRoles(address.getUsername(), "ROLE_USER");
		//Set set = new HashSet();
		//set.add(usrRole);
		//set.add(usrRoleA);
		address1.setUserRoles(set);
		address1.setPassword("{noop}test");
		personalInfoRepository.saveAndFlush(address1);
	}
	
	

	public void deletePersonalInfo(UserIdentity address) {
		// address.setEmpid(24);
		personalInfoRepository.delete(address);

	}

	public void editPersonalInfo(UserIdentity address) {
		//savePersonalInfo(address);

	}

	public UserIdentity[] getAllPersonalInfo() {
		return personalInfoRepository.getAll();
	}
	
	public UserIdentity getPersonalInfo(String empId) {
		return personalInfoRepository.findByUsername(empId).get();
	}

}
