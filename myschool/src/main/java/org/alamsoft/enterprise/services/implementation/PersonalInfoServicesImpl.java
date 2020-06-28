package org.alamsoft.enterprise.services.implementation;

import java.util.HashSet;
import java.util.Optional;
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

	public UserIdentity savePersonalInfo(UserIdentityVO address) {
		UserIdentity userIdentity = toUserIdentity(address);
		return personalInfoRepository.saveAndFlush(userIdentity);
	}

	public UserIdentity toUserIdentity(UserIdentityVO address) {
		UserRolesVO[] arr = address.getUserRoles();
		Set<UserRoles> set = new HashSet<UserRoles>();
		for (UserRolesVO usrRole : arr) {
			UserRoles userRoles = new UserRoles(usrRole.getUsername(), usrRole.getRole().getRoleId());
			set.add(userRoles);
		}

		UserIdentity userIdentity = new UserIdentity();
		userIdentity.setUsername(address.getUsername());
		userIdentity.setUserInformation(address.getUserInformation());
		userIdentity.setUserRoles(set);
		userIdentity.setPassword("{noop}test");
		return userIdentity;
	}
	
	

	public void deletePersonalInfo(UserIdentityVO address) {
		UserIdentity userIdentity = new UserIdentity();
		userIdentity.setUsername(address.getUsername());
		userIdentity.setUserInformation(address.getUserInformation());
		Optional<UserIdentity> address2 = personalInfoRepository.findByUsername(address.getUsername());
		personalInfoRepository.delete(address2.get());

	}

	public void editPersonalInfo(UserIdentity address) {
		// savePersonalInfo(address);

	}

	public UserIdentity[] getAllPersonalInfo() {
		return personalInfoRepository.getAll();
	}

	public UserIdentity getPersonalInfo(String empId) {
		return personalInfoRepository.findByUsername(empId).get();
	}

}
