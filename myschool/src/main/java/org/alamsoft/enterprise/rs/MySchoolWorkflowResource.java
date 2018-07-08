package org.alamsoft.enterprise.rs;

import org.alamsoft.enterprise.entity.Address;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySchoolWorkflowResource {
	
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String pingServer()
	{
		return "I am alive";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public Address savePersonalInfo(Address personalInfo)
	
	{
		//personalInfoRepository.save(personalInfo);
		return personalInfo;
	}


}
