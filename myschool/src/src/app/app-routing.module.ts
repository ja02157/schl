import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AboutComponent }      from './about/about.component';
import { HomeComponent }      from './home/home.component';
import { EntryComponent }      from './entry/entry.component';
import { PersonalInfoFormComponent }      from './personal-info-form/personal-info-form.component';
import { PersonlistComponent }      from './personlist/personlist.component';
import { LoginComponent }      from './login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { Roles } from './roles';
import { RoleConstants } from './roleconstants';

const routes: Routes = [
   { path: '', component: HomeComponent, canActivate: [AuthGuard]},
  { path: 'about', component: AboutComponent, canActivate: [AuthGuard]},
  { path: 'entry', component: EntryComponent , canActivate: [AuthGuard],
        data: { roles: [RoleConstants.Admin] }},
  
  { path: 'personalInfo/:addr', component: PersonalInfoFormComponent, canActivate: [AuthGuard] },
  { path: 'personalInfo', component: PersonalInfoFormComponent, canActivate: [AuthGuard] },
  { path: 'personlist', component: PersonlistComponent , canActivate: [AuthGuard]},
  { path: 'login', component: LoginComponent},
  { path: '**', redirectTo: '' }
  
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule { }
