//import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
//import { FormsModule } from '@angular/forms';
//import { HttpClientModule }    from '@angular/common/http';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { ErrorInterceptor } from './helpers/error.interceptor';
import { JwtInterceptor } from './helpers/jwt.interceptor';
import 'hammerjs';

import { AppComponent } from './app.component';
//import { PersonalInfoFormComponent } from './personal-info-form/personal-info-form.component';
//import { SchoolactivityComponent } from './schoolactivity/schoolactivity.component';
//import { AboutComponent } from './about/about.component';
//import { AppRoutingModule } from './/app-routing.module';
//import { PersonlistComponent } from './personlist/personlist.component';
//import { ClarityModule } from '@clr/angular';
//import { EntryComponent } from './entry/entry.component';
//import { LoginComponent } from './login/login.component';
//import { ReactiveFormsModule } from '@angular/forms';
//import { HomeComponent } from './home/home.component';
//import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { imports } from 'app/shared/app.imports';
import { decl } from 'app/shared/app.imports';

@NgModule({
  declarations: [
    AppComponent,
    decl
  ],
  imports: [
    imports
  ],
  providers: [
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true } 
             ],
  bootstrap: [AppComponent]
})
export class AppModule { }
