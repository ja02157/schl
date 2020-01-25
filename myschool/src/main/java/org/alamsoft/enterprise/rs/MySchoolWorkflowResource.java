package org.alamsoft.enterprise.rs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.alamsoft.enterprise.entity.Roles;
//test
import org.alamsoft.enterprise.entity.UserIdentity;
import org.alamsoft.enterprise.entity.UserIdentityVO;
import org.alamsoft.enterprise.entity.UserInformation;
import org.alamsoft.enterprise.entity.UserRoles;
import org.alamsoft.enterprise.security.JwtTokenProvider;
import org.alamsoft.enterprise.services.implementation.PersonalInfoServicesImpl;
import org.alamsoft.enterprise.services.implementation.RolesServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySchoolWorkflowResource {

	@Autowired
	PersonalInfoServicesImpl personalInfoServicesImpl;
	
	@Autowired
	RolesServicesImpl rolesServicesImpl;
	
	@Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String pingServer() {
		return "I am alive";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public UserIdentity authenticate(@RequestBody Map<String, String> json) throws Error {
		UserIdentity returnAddress=null;
		UserIdentity address = personalInfoServicesImpl.getPersonalInfo(json.get("username"));
		//
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(json.get("username"), json.get("password")));
		ArrayList<String> rl=new ArrayList();
		//rl.add(address.getUserInformation().getRole());
		Iterator<UserRoles> iter = address.getUserRoles().iterator();
		while (iter.hasNext()) {
			rl.add(iter.next().getRole().getRoleName());
		}
		
		String tokenx = jwtTokenProvider.createToken(json.get("username"), rl);
		
		//
		//if (address.getPassword().equals(json.get("password"))) {
			returnAddress = address;
			//String token= "fake-jwt-token."+returnAddress.getRole();
			//String token= tokenx+"."+returnAddress.getRole();
			String token= tokenx;
			returnAddress.setToken(token);
		//} else {
		//	throw new AuthenticationFailed("user id or password doesnt match");
		//}
		
		return returnAddress;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void savePersonalInfo(@RequestBody UserIdentityVO personalInfo)

	{
		personalInfoServicesImpl.savePersonalInfo(personalInfo);
		//return personalInfo;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public UserIdentity deletePersonalInfo(@RequestBody UserIdentity personalInfo)

	{
		personalInfoServicesImpl.deletePersonalInfo(personalInfo);
		return personalInfo;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public UserIdentity[] getPersonalInfo()

	{
		UserIdentity[] listAddress = personalInfoServicesImpl.getAllPersonalInfo();
		return listAddress;
	}
	
	@RequestMapping(value = "/listRoles", method = RequestMethod.GET)
	public Roles[] getRoles()

	{
		Roles[] listRoles = rolesServicesImpl.getAllRoles();
		return listRoles;
	}

}
