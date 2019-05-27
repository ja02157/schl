import { Component } from '@angular/core';

import { AuthenticationService } from './services/authentication.service';
import { Address } from './address';
import { Router } from '@angular/router';
import { Role } from './role';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  currentUser: Address;
  
  constructor(
        
        private router: Router,
        private authenticationService: AuthenticationService
    ) { 
        debugger
        this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
    }
    
    get isAdmin() {
        return this.currentUser && this.currentUser.role === Role.Admin;
    }
    
    logout() {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
    }
  
  
}
