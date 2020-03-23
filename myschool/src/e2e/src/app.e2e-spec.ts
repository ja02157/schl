import { AppPage } from './app.po';
import { LoginPage } from './login/login.po';

describe('workspace-project App', () => {
  let page: AppPage;
  let loginpage: LoginPage;

  beforeEach(() => {
    page = new AppPage();
    loginpage = new LoginPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to schoolUI!');
  });
  
   it('when login is successfulhe should redirect to default', () => {
    loginpage.navigateTo();
    loginpage.fillCredentials();
    element(by.css('.btn-primary')).click();
    
    
  });
  
  
  
});
