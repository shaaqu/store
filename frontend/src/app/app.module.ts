import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RouterModule, ROUTES, Routes} from '@angular/router';
import {StorePageComponent} from './store-page/store-page.component';
import {AdminPageComponent} from './admin-page/admin-page.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AccountService} from './service/account.service';
import {OrderService} from './service/order.service';
import {ProductService} from './service/product.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';

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
        RouterModule,
        FormsModule,
        HttpClientModule,
        RouterModule.forRoot(routes),
        ReactiveFormsModule
    ],
  providers: [AccountService, OrderService, ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
