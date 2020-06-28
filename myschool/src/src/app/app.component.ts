import { Component } from '@angular/core';

import { AuthenticationService } from './services/authentication.service';
import { UserIdentity } from 'app/domain/useridentity';
import { Router } from '@angular/router';
import { RoleConstants } from 'app/domain/roleconstants';
import { Utility } from 'app/utilities/utility';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  currentUser: UserIdentity;
  
  constructor(
        
        private router: Router,
        private authenticationService: AuthenticationService
    ) { 
        
        this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
    }
    

    
    get isAdmin() {
    debugger
        // return this.currentUser && this.currentUser.role ===
		// RoleConstants.Admin;
        // return this.currentUser && this.currentUser.role ===
		// RoleConstants.Admin;
        return this.currentUser && Utility.isRole(this.currentUser, RoleConstants.Admin);
    }
    
    logout() {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
    }
  
  
}
