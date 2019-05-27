package org.alamsoft.enterprise.rs;

import java.util.Map;

//test
import org.alamsoft.enterprise.entity.Address;
import org.alamsoft.enterprise.services.implementation.PersonalInfoServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySchoolWorkflowResource {

	@Autowired
	PersonalInfoServicesImpl personalInfoServicesImpl;

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String pingServer() {
		return "I am alive";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public Address authenticate(@RequestBody Map<String, String> json) throws Error {
		Address returnAddress=null;
		Address address = personalInfoServicesImpl.getPersonalInfo(json.get("username"));
		if (address.getPassword().equals(json.get("password"))) {
			returnAddress = address;
			String token= "fake-jwt-token."+returnAddress.getRole();
			returnAddress.setToken(token);
		} else {
			
			throw new Error("user id or password doesnt match");
		}
		
		return returnAddress;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Address savePersonalInfo(@RequestBody Address personalInfo)

	{
		personalInfoServicesImpl.savePersonalInfo(personalInfo);
		return personalInfo;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Address deletePersonalInfo(@RequestBody Address personalInfo)

	{
		personalInfoServicesImpl.deletePersonalInfo(personalInfo);
		return personalInfo;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Address[] getPersonalInfo()

	{
		Address[] listAddress = personalInfoServicesImpl.getAllPersonalInfo();
		return listAddress;
	}

}
