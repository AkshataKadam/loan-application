import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { ListLoansComponent } from './list-loans/list-loans.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { PaymentScheduleComponent } from './payment-schedule/payment-schedule.component';
import { RouteGuardService } from './service/route-guard.service';
import { LoanComponent } from './loan/loan.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  {path:'login' , component: LoginComponent},
  {path:'welcome/:name' , component: WelcomeComponent , canActivate: [RouteGuardService]},
  {path:'loans' , component: ListLoansComponent , canActivate: [RouteGuardService]},
  {path:'logout' , component: LogoutComponent , canActivate: [RouteGuardService]},
  {path:'loans/:id' , component: LoanComponent , canActivate: [RouteGuardService]},
  {path:'schedule/:id' , component: PaymentScheduleComponent , canActivate: [RouteGuardService]},
  {path:'**' , component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
