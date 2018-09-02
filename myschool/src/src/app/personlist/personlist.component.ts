import { Component, OnInit } from '@angular/core';
import { Address } from '../address';
import { SchoolServiceService } from '../school-service.service';

@Component({
  selector: 'app-personlist',
  templateUrl: './personlist.component.html',
  styleUrls: ['./personlist.component.css']
})
export class PersonlistComponent implements OnInit {

addr: Address[] = [{
    firstname: 'Mr. Nice',
    lastname: 'Alam'
  },
  {
    firstname: 'Mr. Bad',
    lastname: 'Pervez'
  }];
  
  selectedAdr: Address;

  constructor(private schoolServiceService: SchoolServiceService ) {}

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

}
