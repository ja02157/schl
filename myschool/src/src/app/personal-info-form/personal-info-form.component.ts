import { Component, OnInit } from '@angular/core';
import { ClarityModule, ClrFormsNextModule } from '@clr/angular';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { UserIdentity } from '../useridentity';
import { UserRole } from '../userrole';
import { UserInformation } from '../userinformation';
/*import {MatFormFieldModule} from '@angular/material/form-field';*/
/* testing */

import { SchoolServiceService } from '../services/school-service.service';


@Component({
  selector: 'app-personal-info-form',
  templateUrl: './personal-info-form.component.html',
  styleUrls: ['./personal-info-form.component.css']
})
export class PersonalInfoFormComponent implements OnInit {


address: UserIdentity = {
    username: 'jack',
    userInformation: {
    firstname: 'maha',
    lastname: 'rushda'
    }
  }; 


addr: UserIdentity = {
    username: 'jack',
    userInformation: {
    firstname: 'maha',
    lastname: 'rushda'
    }
  }; 
  
  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};
  

  constructor(private schoolServiceService: SchoolServiceService, private router: Router, private route: ActivatedRoute) { }
  debugger
  ngOnInit() {
  debugger
  this.schoolServiceService.eAdr.subscribe(data => {
  debugger
  alert("oH mY: " +JSON.stringify(data));
  debugger
  this.address = data;
  
  debugger
  alert("oH mY:--> ");
  this.getAllRoles();
  //do what ever needs doing when data changes
   })
    
  //  this.dropdownList = [
  //    { id: 1, text: 'Barbecue' },
  //    { id: 2, text: 'Mustard' },
  //    { id: 3, text: 'Ketchup' },
  //    { id: 4, text: 'Mayonaise' }
  //  ];
  //  this.selectedItems = [
  //    { id: 1, text: 'Barbecue' },
  //    { id: 2, text: 'Mustard' }
  //  ];
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'roleId',
      textField: 'roleName',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true,
      limitSelection: 2
    };
 
  }
  getAllRoles(): void  {
    this.schoolServiceService.getRoles().subscribe(
    dropdownList => this.dropdownList = dropdownList
    );
  }
  
  savePersonalInfo(adr: UserIdentity): void {
    this.schoolServiceService.savePersonalInfo(adr).subscribe(
    
    );
  }
  
  onSubmit() {
    this.address.userInformation.username = this.address.username;
    let sel = this.selectedItems;
    alert("oH mY:--> " +sel);
    debugger
    let rand:Array<UserRole>  = new Array<UserRole>()
    for (let usrRole of this.selectedItems) {
    let userR = new UserRole(this.address.username,usrRole);
    rand.push(userR)
     }
    
    this.address.userRoles = rand;
    debugger
    this.savePersonalInfo(this.address);
    this.router.navigate(['/entry']);
    
  }
  
  onCancel() {
    this.router.navigate(['/entry']);
  }

}
