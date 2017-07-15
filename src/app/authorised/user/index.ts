import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { userRoutes } from './user.routes';

@NgModule({
  declarations: [
  ],
  exports: [
  ],
  imports: [
    RouterModule.forChild(userRoutes)
  ],
  providers: [
    
  ]
})
export class UserModule {}
