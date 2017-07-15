import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

import { merchantRoutes } from './merchant.routes';

@NgModule({
  declarations: [
  ],
  exports: [
  ],
  imports: [
    RouterModule.forChild(merchantRoutes)
  ],
  providers: [
    
  ]
})
export class MerchantModule {}
