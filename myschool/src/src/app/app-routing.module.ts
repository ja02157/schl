import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AboutComponent }      from './about/about.component';
import { PersonalInfoFormComponent }      from './personal-info-form/personal-info-form.component';

const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'personalInfo', component: PersonalInfoFormComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule { }
