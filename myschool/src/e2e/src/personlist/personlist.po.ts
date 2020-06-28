import { browser, by, all, element, repeater } from 'protractor';

export class PersonlistPage {

private credentias = {
    username: '0',
    password: 'test'
  };
  
  navigateTo() {
    return browser.get('/personlist');
  }
  
  fillCredentials(credentias: any = this.credentias) {
    element(by.name('username')).sendKeys(credentias.username);
    element(by.name('password')).sendKeys(credentias.password);
  }

  getParagraphText1() {
      var organizations = element.all(by.id('organizations')).all(by.css('app-personlist.datagrid-cell'));
      var firstOrg = organizations.get(0);
      console.log(firstOrg.getText());
      debugger;
  }
  getParagraphText() {
	    return element(by.css('app-root h3')).getText().then(function (text) {
	        console.log(text);
	        debugger;
	    });
	    
	  }
}
