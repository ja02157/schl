import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
/*import { MatInputModule, MatButtonModule } from '@angular/material';
import { MatMenuModule, MatIconModule, MatCardModule } from '@angular/material';*/
import { HttpClientModule }    from '@angular/common/http';

import 'hammerjs';

import { AppComponent } from './app.component';
import { PersonalInfoFormComponent } from './personal-info-form/personal-info-form.component';
import { SchoolactivityComponent } from './schoolactivity/schoolactivity.component';
import { AboutComponent } from './about/about.component';
import { AppRoutingModule } from './/app-routing.module';
import { PersonlistComponent } from './personlist/personlist.component';
import { ClarityModule } from '@clr/angular';

@NgModule({
  declarations: [
    AppComponent,
    PersonalInfoFormComponent,
    SchoolactivityComponent,
    AboutComponent,
    PersonlistComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
/*    MatInputModule,
    MatButtonModule,
    MatMenuModule,
    MatIconModule,
    MatCardModule,*/
    AppRoutingModule,
    HttpClientModule,
    ClarityModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
