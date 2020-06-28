import { AppPage } from './app.po';
import { LoginPage } from './login/login.po';
import { PersonlistPage } from './personlist/personlist.po';

describe('workspace-project App', () => {
  let page: AppPage;
  let loginpage: LoginPage;
  let personlistpage: PersonlistPage;

  beforeEach(() => {
    page = new AppPage();
    loginpage = new LoginPage();
    personlistpage = new PersonlistPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    page.getParagraphText();
    
  });
  
   it('when login is successfulhe should redirect to default', () => {
    loginpage.navigateTo();
    loginpage.fillCredentials();
    element(by.css('.btn-primary')).click(); 
  });
   it('should redirect to personlist', () => {
	   personlistpage.navigateTo();
	   personlistpage.getParagraphText();
	  });
  
  
  
});
