import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AboutComponent }      from './about/about.component';
import { EntryComponent }      from './entry/entry.component';
import { PersonalInfoFormComponent }      from './personal-info-form/personal-info-form.component';
import { PersonlistComponent }      from './personlist/personlist.component';

const routes: Routes = [
  { path: 'about', component: AboutComponent },
  { path: 'entry', component: EntryComponent },
  { path: 'personalInfo/:addr', component: PersonalInfoFormComponent },
  { path: 'personalInfo', component: PersonalInfoFormComponent },
  { path: 'personlist', component: PersonlistComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule { }
