import { Component, OnInit } from '@angular/core';
import { Address } from '../address';
import {Router} from '@angular/router';
import { SchoolServiceService } from '../school-service.service';


@Component({
  selector: 'app-personlist',
  templateUrl: './personlist.component.html',
  styleUrls: ['./personlist.component.css']
})
export class PersonlistComponent implements OnInit {

selected = [];
addr: Address[] = [{
    firstname: 'Mr. Nice',
    lastname: 'Alam'
  },
  {
    firstname: 'Mr. Bad',
    lastname: 'Pervez'
  }];
  
  selectedAdr: Address = {firstname: 'Mr. Bad',
                        lastname: 'Pervez'};

  constructor(private schoolServiceService: SchoolServiceService, private router: Router) {}

  ngOnInit() {
  this.getPersonalInfo();
  }
  
  getPersonalInfo(): void  {
    this.schoolServiceService.getPersonalInfo().subscribe(
    addr => this.addr = addr
    );
  }
  
  onSelect(adr: Address): void {
  
    this.selectedAdr = adr;
  }
  
  onDelete(adr: Address): void {
  this.router.navigate(['/about']);
   
    
  }
  onEdit(adr: Address): void {
    alert('how ho');
  }

}
