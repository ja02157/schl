import { Injectable } from '@angular/core';
import { Address } from './address';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SchoolServiceService {

private heroesUrl = '/myschool/rs/save';
private listUrl = '/myschool/rs/list';

  constructor(private http: HttpClient) { 
  	
  }
  
  savePersonalInfo(adr: Address): Observable<any> {
  
  const body = adr;
  const headers = new HttpHeaders().set('Content-Type','application/json');
  
  		alert("Hey Thanks : " + JSON.stringify(adr.firstname));
  	   return this.http.post<any>(this.heroesUrl, body, {headers: headers});      
	}
	
  getPersonalInfo(): Observable<Address[]> {
  
  const body = {};
  const headers = new HttpHeaders().set('Content-Type','application/json');
  
  	    return this.http.get<Address[]>(this.listUrl);
}
  	   

}
