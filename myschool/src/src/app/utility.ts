import { UserIdentity } from './useridentity';

export class Utility {

static  isUserAllowed(userIdentity:UserIdentity, allowedRoles:Array<String>):boolean {
   let yes:boolean = false
   let aRoles:Array<String>  = new Array<string>()
    let ar = userIdentity.userRoles
    for (let usrRole of ar) {
    aRoles.push(usrRole.role.roleName)
     }
     
     for (let x of aRoles) {
      for (let y of allowedRoles) {
           if (x==y) {
           yes = true
           return yes
           }
      }    
     }
     return yes;
}

static isRole(userIdentity:UserIdentity, roleNm:string):boolean { 
   let yes:boolean = false
    let ar = userIdentity.userRoles;
    for (let usrRole of ar) {
    if (usrRole.role.roleName == roleNm ) {
        yes = true;
        return yes;
     }
     }
   return yes; 
} 

}