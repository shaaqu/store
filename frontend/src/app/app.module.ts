import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {StorePageComponent} from './store-page/store-page.component';
import {AdminPageComponent} from './admin-page/admin-page.component';

const routes: Routes = [
  {path: '', redirectTo: 'store-page', pathMatch: 'full'},
  {path: 'store-page', component: StorePageComponent},
  {path: 'admin-page', component: AdminPageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    StorePageComponent,
    AdminPageComponent
  ],
    imports: [
        BrowserModule,
        RouterModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
