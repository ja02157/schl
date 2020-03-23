import { browser, by, element } from 'protractor';

export class LoginPage {

private credentias = {
    username: '0',
    password: 'test'
  };
  
  navigateTo() {
    return browser.get('/login');
  }
  
  fillCredentials(credentias: any = this.credentias) {
    element(by.name('username')).sendKeys(credentias.username);
    element(by.name('password')).sendKeys(credentias.password);
  }

  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }
}
