import { browser, by, element } from 'protractor';

export class PersonlistPage {

private credentias = {
    username: '0',
    password: 'test'
  };
  
  navigateTo() {
    return browser.get('/personlist');
    expect(page.getParagraphText()).toEqual('Welcome to schoolUI!');
  }
  
  fillCredentials(credentias: any = this.credentias) {
    element(by.name('username')).sendKeys(credentias.username);
    element(by.name('password')).sendKeys(credentias.password);
  }

  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }
  getFirstNameTextSummary() {
	    return element(by.css('app-root h1')).getText();
	  }
}
