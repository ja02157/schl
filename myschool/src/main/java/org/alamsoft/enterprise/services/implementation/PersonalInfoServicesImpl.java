package org.alamsoft.enterprise.services.implementation;


import java.util.ArrayList;
import java.util.List;

import org.alamsoft.enterprise.entity.Address;
import org.alamsoft.enterprise.repositories.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Transactional
public class PersonalInfoServicesImpl {
	
	@Autowired
	PersonalRepository personalInfoRepository;
	
	public void savePersonalInfo(Address address) {
		//address.setEmpid(24);
		personalInfoRepository.saveAndFlush(address);
		
	}
	
	public Address[] getPersonalInfo() {
		return personalInfoRepository.getAll();
//		Address address1 = new Address();
//		address1.setFirstname("first");
//		address1.setLastname("second");
//		Address address2 = new Address();
//		address2.setFirstname("first1");
//		address2.setLastname("second1");
//		List list = new ArrayList();
//		list.add(address1);
//		list.add(address2);
		//return new Address[] {address1, address2};
		
	}
	
}
