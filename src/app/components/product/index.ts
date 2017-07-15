import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { prodRoutes } from './products.routes';

@NgModule({
  declarations: [
    
  ],
  exports: [

  ],
  imports: [
    RouterModule.forChild(prodRoutes)
  ],
  providers: [
    
  ]
})
export class ProductModule {}
