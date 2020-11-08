import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Loan } from 'src/app/model/business-models';
import { LoanDataService } from '../service/data/loan-data.service';
import { LoanSchedule } from '../model/business-models';



@Component({
  selector: 'app-payment-schedule',
  templateUrl: './payment-schedule.component.html',
  styleUrls: ['./payment-schedule.component.css']
})
export class PaymentScheduleComponent implements OnInit {
loanSchedule: LoanSchedule
loans: Loan[]
loan: Loan
id:number

  constructor(private loanService:LoanDataService,
    private route: ActivatedRoute,
    private router: Router ) { }

    ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
  
      this.loanService.retriveSchedule(this.id).subscribe(
        data=> this.loanSchedule = data
      )
    
    }
  
    refreshTodos(){
      this.loanService.retriveLoan(this.id).subscribe(
        response =>
          this.loan=response
          //this.schedule=response
        
      )
    }


}
