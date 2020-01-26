import { Injectable } from '@angular/core';
import { UserIdentity } from 'app/domain/useridentity';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
    private authenticationUrl = '/myschool/rs/authenticate';
    private currentUserSubject: BehaviorSubject<UserIdentity>;
    public currentUser: Observable<UserIdentity>;

  constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<UserIdentity>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
  }
  
  public get currentUserValue(): UserIdentity {
        return this.currentUserSubject.value;
    }

    login(username: string, password: string) {
        return this.http.post<any>(this.authenticationUrl, { username, password })
        .pipe(map(user => {
                // login successful if there's a jwt token in the response
                if (user && user.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                    this.currentUserSubject.next(user);
                }
                return user;
            }))    
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}
