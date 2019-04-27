import { Component, OnInit } from '@angular/core';
import { ClarityModule, ClrFormsNextModule } from '@clr/angular';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
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
  

  constructor(private schoolServiceService: SchoolServiceService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
  this.schoolServiceService.eAdr.subscribe(data => {
  alert("oH mY: " +JSON.stringify(data));
  this.address = data;
  //do what ever needs doing when data changes
   })
  }
  
  savePersonalInfo(adr: Address): void {
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
