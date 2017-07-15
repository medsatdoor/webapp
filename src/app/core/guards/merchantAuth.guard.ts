import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class merchantAuthGuard implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (localStorage.getItem('merchantUser')) {
            return true;
        }
        this.router.navigate(['/auth/login'], { queryParams: { returnUrl: state.url }});
        return false;
  }
}
