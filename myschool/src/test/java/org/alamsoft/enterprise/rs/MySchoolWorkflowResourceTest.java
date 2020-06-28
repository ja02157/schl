package org.alamsoft.enterprise.rs;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.*;

import org.alamsoft.enterprise.entity.UserIdentity;
import org.alamsoft.enterprise.services.implementation.PersonalInfoServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class MySchoolWorkflowResourceTest {
	
	@Mock
	PersonalInfoServicesImpl personalInfoServicesMock;
	
	@InjectMocks
    private MySchoolWorkflowResource myschoolService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		//personalInfoServicesMock.deletePersonalInfo(any(UserIdentity.class));
		//Mockito.when(personalInfoServicesMock.deletePersonalInfo(any(UserIdentity.class))).thenReturn(new UserIdentity());
		//UserIdentity uid = new UserIdentity();
		//assertNotNull(myschoolService.deletePersonalInfo(uid));
		
	}

}
