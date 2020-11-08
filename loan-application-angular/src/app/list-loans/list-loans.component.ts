import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Schedule } from 'src/app/model/business-models';
import { Loan } from 'src/app/model/business-models';
import { LoanDataService } from '../service/data/loan-data.service';



@Component({
  selector: 'app-list-loans',
  templateUrl: './list-loans.component.html',
  styleUrls: ['./list-loans.component.css']
})
export class ListLoansComponent implements OnInit {

  message:string
  loans: Loan[]
  schedule: Schedule
  id: number
  
  constructor(
    private loanService:LoanDataService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.refreshLoans()
  }

  refreshLoans(){
    this.loanService.retriveAllLoans().subscribe(
      response =>{
        console.log(response)
        this.loans=response
      }
    )
  }

  deleteLoan(id){
    console.log(`deleteeeee ${id}`)
    this.loanService.deleteLoan(id).subscribe(
      response=>{
        console.log(response);
        this.message='Loan Deleted!!'
        this.refreshLoans();
      }
    )
  }

  updateLoan(id){
    console.log(`update ${id}`)
    this.router.navigate(['loans',id])
  }

  viewLoan(id){
    console.log(`view ${id}`)
        this.router.navigate(['schedule',id])
        //this.router.navigate(['list',id])
  }

  addLoan(){
    this.router.navigate(['loans',-1])
  }

}
