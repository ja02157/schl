import { Component, OnInit } from '@angular/core';
import { UserIdentity } from '../useridentity';
import { Router } from '@angular/router';
import { RoleConstants } from '../roleconstants';
import { AuthenticationService } from '../services/authentication.service';
import { Utility } from '../utility';


@Component({
  selector: 'app-schoolactivity',
  templateUrl: './schoolactivity.component.html',
  styleUrls: ['./schoolactivity.component.css']
})
export class SchoolactivityComponent implements OnInit {
currentUser: UserIdentity;

  constructor(
        
        private router: Router,
        private authenticationService: AuthenticationService
    ) { 
        
        this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
    }

  ngOnInit() {
  }
    
  
  get isAdmin() { 
               
        //return this.currentUser && this.currentUser.role.indexOf(Role.Admin) !== -1;
        return this.currentUser && Utility.isRole(this.currentUser, RoleConstants.Admin);
    }
  
  onTest(): void {
        console.log('Hi There');
}

logout() {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
    }

}
