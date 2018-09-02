import { Component, OnInit } from '@angular/core';
import { ClarityModule, ClrFormsNextModule } from '@clr/angular';
/*import {MatFormFieldModule} from '@angular/material/form-field';*/
/* testing */

import { Address } from '../address';
import { SchoolServiceService } from '../school-service.service';


@Component({
  selector: 'app-personal-info-form',
  templateUrl: './personal-info-form.component.html',
  styleUrls: ['./personal-info-form.component.css']
})
export class PersonalInfoFormComponent implements OnInit {

address = new Address();

addr: Address = {
    firstname: 'Mr. Nice',
    lastname: 'Alam'
  };
  

  constructor(private schoolServiceService: SchoolServiceService) { }

  ngOnInit() {
  }
  
  savePersonalInfo(adr: Address): void {
    this.schoolServiceService.savePersonalInfo(adr).subscribe(
    
    );
  }
  
  onSubmit() {
    
    alert("Thanks for submitting! Data: " + JSON.stringify(this.address));
    this.savePersonalInfo(this.address);
    
    
    
  }

}
