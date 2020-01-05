package org.alamsoft.enterprise.services.implementation;

import org.alamsoft.enterprise.entity.UserIdentity;
import org.alamsoft.enterprise.repositories.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PersonalInfoServicesImpl {

	@Autowired
	PersonalRepository personalInfoRepository;

	public void savePersonalInfo(UserIdentity address) {
		personalInfoRepository.saveAndFlush(address);

	}

	public void deletePersonalInfo(UserIdentity address) {
		// address.setEmpid(24);
		personalInfoRepository.delete(address);

	}

	public void editPersonalInfo(UserIdentity address) {
		savePersonalInfo(address);

	}

	public UserIdentity[] getAllPersonalInfo() {
		return personalInfoRepository.getAll();
	}
	
	public UserIdentity getPersonalInfo(String empId) {
		return personalInfoRepository.findByUsername(empId).get();
	}

}
