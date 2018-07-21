package org.alamsoft.enterprise.services.implementation;


import org.alamsoft.enterprise.entity.Address;
import org.alamsoft.enterprise.repositories.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class PersonalInfoServicesImpl {
	
	@Autowired
	PersonalRepository personalInfoRepository;
	
	public void savePersonalInfo(Address address) {
		address.setEmpid(24);
		personalInfoRepository.saveAndFlush(address);
		
	}
	
}
