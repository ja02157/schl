import { Component, OnInit } from '@angular/core';
import { ClarityModule, ClrFormsNextModule } from '@clr/angular';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { UserIdentity } from '../useridentity';
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
  //do what ever needs doing when data changes
   })
  }
  
  savePersonalInfo(adr: UserIdentity): void {
    this.schoolServiceService.savePersonalInfo(adr).subscribe(
    
    );
  }
  
  onSubmit() {
   
    this.savePersonalInfo(this.address);
    this.router.navigate(['/entry']);
    
  }
  
  onCancel() {
    this.router.navigate(['/entry']);
  }

}
