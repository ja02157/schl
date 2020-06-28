package org.alamsoft.enterprise.services.implementation;

import org.alamsoft.enterprise.entity.Roles;
import org.alamsoft.enterprise.entity.UserIdentity;
import org.alamsoft.enterprise.entity.UserIdentityVO;
import org.alamsoft.enterprise.entity.UserInformation;
import org.alamsoft.enterprise.entity.UserRoles;
import org.alamsoft.enterprise.entity.UserRolesVO;
import org.alamsoft.enterprise.repositories.PersonalRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PersonalInfoServicesImplTest {
	
	@Mock
	PersonalRepository personalInfoRepository;
	
	@InjectMocks
	PersonalInfoServicesImpl personalInfoServicesImpl;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSavePersonalInformation() {
		UserIdentityVO ui = new UserIdentityVO();
		
		UserRolesVO ur = new UserRolesVO();
		ur.setUsername("aj");
		Roles r = new Roles();
		r.setRoleId("ROLE_USER");
		r.setRoleName("ROLE_USER");
		ur.setRole(r);
		UserRolesVO[] userRolesVOArr = new UserRolesVO[1];
		userRolesVOArr[0]=ur;
		ui.setUserRoles(userRolesVOArr);
		ui.setUsername("aj");
		UserInformation uf = new UserInformation();
		uf.setFirstname("javed");
		uf.setLastname("alam");
		ui.setUserInformation(uf);
		UserIdentity uiObject = personalInfoServicesImpl.toUserIdentity(ui);
		Mockito.when(personalInfoRepository.saveAndFlush(Mockito.any(UserIdentity.class))).thenReturn(uiObject);
		assert(personalInfoServicesImpl.savePersonalInfo(ui).equals(uiObject));
	}
	

}
