import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { APP_BASE_HREF } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { StatusComponent } from './status/status.component';
import { HomeComponent } from './home/home.component';
import { PickupComponent } from './pickup/pickup.component';
import { ChangeComponent } from './change/change.component';


@NgModule({
  declarations: [
    AppComponent,
    StatusComponent,
    HomeComponent,
    PickupComponent,
    ChangeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{ provide: APP_BASE_HREF, useValue: '/' }],
  bootstrap: [AppComponent]
})
export class AppModule { }
