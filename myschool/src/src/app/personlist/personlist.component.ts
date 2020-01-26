import { Component, OnInit } from '@angular/core';
import { UserIdentity } from 'app/domain/useridentity';
import { UserInformation } from 'app/domain/userinformation';
import {Router} from '@angular/router';
import { SchoolServiceService } from 'app/services/school-service.service';


@Component({
  selector: 'app-personlist',
  templateUrl: './personlist.component.html',
  styleUrls: ['./personlist.component.css']
})
export class PersonlistComponent implements OnInit {

selected = [];
addr: UserIdentity[] = [{
    username: 'jack',
    userInformation: {
    firstname: 'maha',
    lastname: 'rushda'
    }
  }];
  
  selectedAdr: UserIdentity = {username: 'jack',
                        userInformation: {}
                              };

  constructor(private schoolServiceService: SchoolServiceService, private router: Router) {}

  ngOnInit() {
  this.getPersonalInfo();
  }
  
  getPersonalInfo(): void  {
    this.schoolServiceService.getPersonalInfo().subscribe(
    addr => this.addr = addr
    );
  }
  
  onSelect(adr: UserIdentity): void {
    this.selectedAdr = adr;
  }
  
  onDelete(adr: UserIdentity): void {
  this.router.navigate(['/about']); 
  }
  onEdit(adr: UserIdentity): void {
    alert('how ho');
  }
}
