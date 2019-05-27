import { Component, OnInit } from '@angular/core';
import { Address } from '../address';
import {Router} from '@angular/router';
import { SchoolServiceService } from '../services/school-service.service';


@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {

selected = [];
selectedAdr: Address;

addr: Address[] = [{
    firstname: 'Mr. Nice',
    lastname: 'Alam'
  },
  {
    firstname: 'Mr. Bad',
    lastname: 'Pervez'
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
  
  onSelect(adr: Address): void {
  
    this.selectedAdr = adr;
  }
  
  onDelete(): void {
  alert('delete being tried'+JSON.stringify(this.selectedAdr));
    this.schoolServiceService.deletePersonalInfo(this.selectedAdr).subscribe(
    );
  }
  
  onEdit(): void {
  this.schoolServiceService.updatedDataSelection(this.selectedAdr);
  this.router.navigate(['/personalInfo/selectedAdr']);
    
  }
  
  

}
