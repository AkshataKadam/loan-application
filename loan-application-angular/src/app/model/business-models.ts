export class BusinessModels {
}

export class LoanSchedule{
  
    public loanId: number;
    /*public customerId: number;*/
    public loanStartDate: Date;
    public principal: number;
    public interest: number;
    public schedule:Schedule[];
    public loann:Loan[];
    
  }

  export class Schedule{

    public paymentDate: Date;
    public principal: number;
    public projectedInterest: number;
    public paymentStatus: string;
    public paymentAmount: number;
    
  }

  export class Loan{
      public id: number;
      public customerId: number;
      public loanAmount: number;
      public paymentFrequency: string;
      public paymentTerm: string;
      public interestRate: number;
      public tradeDate: Date;
      public loanStartDate: Date;
      public maturityDate: Date
    }

  