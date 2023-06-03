package com.loan_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
public class LoanRequest {

    @NotBlank(message = "Personal Code can not be blank")
    private String personalCode;

    @Min(value = 2000, message = "Minimum loan amount must be greater 2000 EUR")
    @Max(value = 10000, message = "Maximum loan amount must be greater 1000 EUR")
    private Integer loanAmount;

    @Min(value = 12, message = "Minimum loan period should be greater then 12 months")
    @Max(value = 60, message = "Maximum loan period should not be greater then 60 months")
    private Integer loanPeriod;

}
