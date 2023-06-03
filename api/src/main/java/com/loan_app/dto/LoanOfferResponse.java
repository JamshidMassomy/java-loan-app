package com.loan_app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoanOfferResponse {

    private Integer offeredLoanAmount;
    private Integer loanPeriodInMonths;

    public LoanOfferResponse(Integer loanAmount, Integer loanPeriod) {
        this.loanPeriodInMonths = loanPeriod;
        this.offeredLoanAmount = loanAmount;
    }

}
