import { Component, OnInit } from '@angular/core';
import { Address } from '../address';
import { Router } from '@angular/router';
import { Role } from '../role';
import { AuthenticationService } from '../services/authentication.service';


@Component({
  selector: 'app-schoolactivity',
  templateUrl: './schoolactivity.component.html',
  styleUrls: ['./schoolactivity.component.css']
})
export class SchoolactivityComponent implements OnInit {
currentUser: Address;

  constructor(
        
        private router: Router,
        private authenticationService: AuthenticationService
    ) { 
        
        this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
    }

  ngOnInit() {
  }
  
  onTest(): void {
        console.log('Hi There');
}

logout() {
        this.authenticationService.logout();
        this.router.navigate(['/login']);
    }

}
