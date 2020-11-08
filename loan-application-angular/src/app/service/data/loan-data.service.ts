import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Loan } from 'src/app/model/business-models';
import { LoanSchedule } from 'src/app/model/business-models';

import { Schedule } from 'src/app/model/business-models';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class LoanDataService {

  constructor(
    private http:HttpClient
  ) { }

  retriveAllLoans(){
    return this.http.get<Loan[]>(`http://localhost:8080/loans`)
  }

  

  deleteLoan(id){
    return this.http.delete(`http://localhost:8080/loans/${id}`)
  }

  retriveLoan(id){
    return this.http.get<Loan>(`http://localhost:8080/loans/${id}`)
  }

  retriveSchedule(id){
    return this.http.get<LoanSchedule>(`http://localhost:8080/schedule/${id}`)
  }

  updateLoan(id, loan){
    return this.http.put(`http://localhost:8080/loans/${id}`,loan)
  }

  createSchedule(schedule){
    return this.http.post(`http://localhost:8080/schedule`,schedule)
  }

  createLoan(loan){
    console.log("Loan Created " , loan);
    return this.http.post(`http://localhost:8080/loans`,loan)
  }

}
