import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from 'app/app-routing.module';
import { HttpClientModule }    from '@angular/common/http';
import { ClarityModule } from '@clr/angular';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { ErrorInterceptor } from 'app/helpers/error.interceptor';
import { JwtInterceptor } from 'app/helpers/jwt.interceptor';
import { APP_BASE_HREF } from '@angular/common';


import { HomeComponent } from 'app/home/home.component';
import { AboutComponent } from 'app/about/about.component';
import { EntryComponent } from 'app/entry/entry.component';
import { LoginComponent } from 'app/login/login.component';
import { PersonalInfoFormComponent } from 'app/personal-info-form/personal-info-form.component';
import { PersonlistComponent } from 'app/personlist/personlist.component';
import { SchoolactivityComponent } from 'app/schoolactivity/schoolactivity.component';

export const imports= [
    BrowserModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    ClarityModule,
    NgMultiSelectDropDownModule.forRoot()
];
export const decl= [
    HomeComponent, AboutComponent,PersonalInfoFormComponent,PersonlistComponent,
    EntryComponent,SchoolactivityComponent,
    LoginComponent
];
export const provd= [
     { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
     { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true } ,
     { provide: APP_BASE_HREF, useValue : '/myschool/rs' }
];
