import { Routes } from '@angular/router';
import { userAuthGuard, adminAuthGuard, merchantAuthGuard } from './core/guards';
import { Error404Component } from './shared/components/error404/error404.component';

export const appRoutes: Routes = [
  { path: '', loadChildren: './components/home/index#HomeModule' },
  // { path: 'checkout', loadChildren: './checkout/checkout.module#CheckoutModule' },
  // {
  //   path: 'user',
  //   loadChildren: './authorised/user/index#UserModule',
  //   canActivate: [ userAuthGuard ]
  // },
  // {
  // 	path: 'admin',
  // 	loadChildren: './authorised/admin/index#AdminModule',
  // 	canActivate: [ adminAuthGuard ]
  // },
  // {
  // 	path: 'merchant',
  // 	loadChildren: './authorised/merchant/index#MerchantModule',
  // 	canActivate: [ merchantAuthGuard ]
  // },
  // { path: 'product', loadChildren: './components/product/index#ProductModule' },
  { path: 'auth', loadChildren: './auth/auth.module#AuthModule' },
  { path: '**', component: Error404Component}
];