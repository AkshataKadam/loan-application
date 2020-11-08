import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { HardCodedAuthService } from './hard-coded-auth.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private HardCodedAuthService: HardCodedAuthService,
    private router: Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
    ) {
      if(this.HardCodedAuthService.isLogedIn())
      return true
      this.router.navigate(['/login'])
    return false
    }

}
