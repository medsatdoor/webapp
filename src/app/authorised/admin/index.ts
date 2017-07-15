import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { adminRoutes } from './admin.routes';

@NgModule({
  declarations: [
  ],
  exports: [
  ],
  imports: [
    RouterModule.forChild(adminRoutes)
  ],
  providers: [
    
  ]
})
export class AdminModule {}
