export interface ILoanResponse {
  offeredLoanAmount: number;
  loanPeriodInMonths: number;
}

export interface ILoanRequest {
  personalCode: string;
  loanAmount: number;
  loanPeriod: number;
}
