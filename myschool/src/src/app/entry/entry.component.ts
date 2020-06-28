import { Component, OnInit } from '@angular/core';
import { UserIdentity } from 'app/domain/useridentity';
import { UserInformation } from 'app/domain/userinformation';
import {Router} from '@angular/router';
import { SchoolServiceService } from 'app/services/school-service.service';


@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {

selected = [];
selectedAdr: UserIdentity;

addr: UserIdentity[] = [{
    username: 'jack',
    userInformation: {
    firstname: 'maha',
    lastname: 'rushda'
    }
  }];

  constructor(private schoolServiceService: SchoolServiceService, private router: Router) { }
  ngOnInit() {
  this.getPersonalInfo();
  }
  
  getPersonalInfo(): void  {
    this.schoolServiceService.getPersonalInfo().subscribe(
    addr => this.addr = addr
    );
  }
  
  onAdd(): void {
  this.router.navigate(['/personalInfo']);
  }
  
  onSelect(adr: UserIdentity): void {
    this.selectedAdr = adr;
  }
  
  onDelete(): void {
  // alert('delete being tried'+JSON.stringify(this.selectedAdr));
    this.schoolServiceService.deletePersonalInfo(this.selectedAdr).subscribe(
    		() => this.ngOnInit()
    );
    
  }
  
  onEdit(): void {
  this.schoolServiceService.updatedDataSelection(this.selectedAdr);
  this.router.navigate(['/personalInfo/selectedAdr']);
  }
}
