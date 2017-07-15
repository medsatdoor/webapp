import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { appRoutes } from './app.routes';

import { HomeModule } from './components/home/index';
import { LayoutModule } from './components/layout/index';
import { UserModule } from './authorised/user';
import { AdminModule } from './authorised/admin';
import { MerchantModule } from './authorised/merchant';

// adding rx operators
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/filter';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/finally';
import 'rxjs/add/observable/of';
// import { LoadingIndicatorComponent } from './shared/components/loading-indicator/loading-indicator.component';
import { NotificationComponent } from './shared/components/notification/notification.component';
import { UserComponent } from './authorised/user/user.component';
import { AdminComponent } from './authorised/admin/admin.component';
import { MerchantComponent } from './authorised/merchant/merchant.component';
import { Error404Component } from './shared/components/error404/error404.component';

@NgModule({
  declarations: [
    AppComponent,
    // LoadingIndicatorComponent,
    NotificationComponent,
    Error404Component
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    LayoutModule,
    HomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
