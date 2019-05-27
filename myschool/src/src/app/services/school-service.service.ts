import { Injectable } from '@angular/core';
import { Address } from '../address';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { BehaviorSubject } from 'rxjs';
import { ActivatedRoute } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class SchoolServiceService {

private saveUrl = '/myschool/rs/save';
private listUrl = '/myschool/rs/list';
private deleteUrl = '/myschool/rs/delete';
editAddr: Address;

private dataSource = new BehaviorSubject(new Address());
  eAdr = this.dataSource.asObservable();


  constructor(private http: HttpClient) { 
  	
  }
  
  updatedDataSelection(eAdr: Address) {
    this.dataSource.next(eAdr);
  }
  
  savePersonalInfo(adr: Address): Observable<any> {
  
  const body = adr;
  
  const headers = new HttpHeaders().set('Content-Type','application/json');
  
  		alert("Hey Thanks : " + JSON.stringify(adr.firstname));
  	   return this.http.post<any>(this.saveUrl, body, {headers: headers});      
	}
	
	deletePersonalInfo(adr: Address): Observable<any> {
  
  const body = adr;
  
  const headers = new HttpHeaders().set('Content-Type','application/json');
  
  		alert("Hey Thanks : " + JSON.stringify(adr.firstname));
  		
  	   return this.http.post<any>(this.deleteUrl, body, {headers: headers});      
	}
	
  
  getPersonalInfo(): Observable<Address[]>  {
  
  const body = {};
  const headers = new HttpHeaders().set('Content-Type','application/json');
  
  	    return this.http.get<Address[]>(this.listUrl);
}
  	   

}
