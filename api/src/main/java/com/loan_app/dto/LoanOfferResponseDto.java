package com.loan_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LoanOfferResponseDto {

    private Integer offeredLoanAmount;
    private Integer loanPeriodInMonths;

}
