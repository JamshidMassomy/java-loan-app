package com.loan_app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoanOfferResponseDto {

    private Integer offeredLoanAmount;
    private Integer loanPeriodInMonths;

    public LoanOfferResponseDto(Integer loanAmount, Integer loanPeriod) {
        this.loanPeriodInMonths = loanPeriod;
        this.offeredLoanAmount = loanAmount;
    }

}
