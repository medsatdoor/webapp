import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { CheckoutRoutes } from './checkout.routes';
import { AddressComponent } from './address/address.component';
import { CartComponent } from './cart/cart.component';
import { PaymentComponent } from './payment/payment.component';

@NgModule({
  declarations: [
    AddressComponent,
    CartComponent,
    PaymentComponent
  ],
  exports: [

  ],
  imports: [
    RouterModule.forChild(CheckoutRoutes)
  ],
  providers: [
    
  ]
})
export class CheckoutModule {}
