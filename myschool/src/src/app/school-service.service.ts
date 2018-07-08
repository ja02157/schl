import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Address } from './address';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SchoolServiceService {

private heroesUrl = 'rs/save';

  constructor(private http: HttpClient) { 
  	
  }
  
  savePersonalInfo(adr: Address): void {
  		this.http.get<Address>(this.heroesUrl);
       console.log('test...');
       alert("Hey Thanks : " + JSON.stringify(adr));
       
}

}
