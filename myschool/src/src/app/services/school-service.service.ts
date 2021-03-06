import { Injectable } from '@angular/core';
import { UserIdentity } from 'app/domain/useridentity';
import { Roles } from 'app/domain/roles';
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
private listRolesUrl = '/myschool/rs/listRoles';
private deleteUrl = '/myschool/rs/delete';
editAddr: UserIdentity;

tobj: UserIdentity = {
		username: '',
    userInformation: {
    firstname: '',
    lastname: ''
    }
  }; 

private dataSource = new BehaviorSubject(this.tobj);
  eAdr = this.dataSource.asObservable();


  constructor(private http: HttpClient) { 
  	
  }
  
  updatedDataSelection(eAdr: UserIdentity) {
    this.dataSource.next(eAdr);
  }
  
  savePersonalInfo(adr: UserIdentity): Observable<any> {
  
  const body = adr;
  const headers = new HttpHeaders().set('Content-Type','application/json');
  	   return this.http.post<any>(this.saveUrl, body, {headers: headers});      
	}
	deletePersonalInfo(adr: UserIdentity) {
    const body = adr;
    const headers = new HttpHeaders().set('Content-Type','application/json');
       // alert("delete "+this.deleteUrl);
  	   return this.http.post<any>(this.deleteUrl, body, {headers: headers});      
	}
	 
  getPersonalInfo(): Observable<UserIdentity[]>  { 
  const body = {};
  const headers = new HttpHeaders().set('Content-Type','application/json');
        //  alert("list  "+this.listUrl); 
  	    return this.http.get<UserIdentity[]>(this.listUrl);
}

getRoles(): Observable<Roles[]>  {
  
  const body = {};
  const headers = new HttpHeaders().set('Content-Type','application/json');
       // alert("list Role "+this.listRolesUrl);
  	    return this.http.get<Roles[]>(this.listRolesUrl);
}
  	   

}
