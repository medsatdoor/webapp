import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { homeRoutes } from './home.routes';

@NgModule({
  declarations: [
    HomeComponent
  ],
  exports: [

  ],
  imports: [
    RouterModule.forChild(homeRoutes)
  ],
  providers: [
    
  ]
})
export class HomeModule {}
