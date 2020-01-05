import { Injectable } from '@angular/core';

import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../services/authentication.service';
import { Utility } from '../utility';



@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        debugger
        const currentUser = this.authenticationService.currentUserValue;
        debugger
        if (currentUser) {
        //Set set = currentUser.userRoles;
        
        
            // check if route is restricted by role
            //debugger
            //if (route.data.roles && route.data.roles.indexOf(currentUser.role[0]) === -1) {
                // role not authorised so redirect to home page
            //    this.router.navigate(['/']);
            //    return false;
           // }

            // authorised so return true
            if (route.data.roles && !Utility.isUserAllowed(currentUser, route.data.roles))  {
               this.router.navigate(['/']);
                return false;
            }
            
            return true;
        }

        // not logged in so redirect to login page with the return url
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
        return false;
    }
}