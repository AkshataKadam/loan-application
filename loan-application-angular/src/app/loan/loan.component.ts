import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Loan } from 'src/app/model/business-models';
import { LoanDataService } from '../service/data/loan-data.service';
import { LoanSchedule } from 'src/app/model/business-models';

import { Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CurrencyPipe } from '@angular/common';


@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {
id:number;
public loan: Loan = new Loan();
schedule: LoanSchedule;
message: string;

formattedAmount: string;

  constructor(
    private loanService: LoanDataService,
    private route: ActivatedRoute,
    private router: Router,
    private currencyPipe : CurrencyPipe
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    this.loan.customerId

    if(this.id!=-1){
    this.loanService.retriveLoan(this.id).subscribe(
      data=> this.loan = data
    )
  }
  }


  save(){
    console.log(this.loan);
    if(this.id == -1){
      this.loanService.createLoan(this.loan).subscribe(
        data=>{
          this.message='Loan Created!!'
          this.router.navigate(['loans'])
        }
      )
    }else{
      
    this.loanService.updateLoan(this.id,this.loan).subscribe(
      data=>{
        console.log(data)
        this.router.navigate(['loans'])
      }
    )
  }
  //this.schedule = new Schedule(this.id,new Date(),10,0,'',0)
  this.loanService.createSchedule(this.schedule).subscribe(
    data1=>{
      console.log(data1)
      this.router.navigate(['schedule'])
    }
  )
}

//loan amount formatting
transformAmount(element){
  this.formattedAmount = this.currencyPipe.transform(this.loan.loanAmount, '₹');

  element.target.value = this.formattedAmount;
}

}
