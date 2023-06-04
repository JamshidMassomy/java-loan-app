package com.loan_app.controller;

import com.loan_app.dto.LoanOfferResponseDto;
import com.loan_app.dto.LoanRequestDto;
import com.loan_app.service.LoanOfferServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class LoanController {

    private final LoanOfferServiceImpl loanOfferServiceImpl;

    @GetMapping("loan")
    public ResponseEntity<LoanOfferResponseDto> fetchLoanOffer(@Validated LoanRequestDto loanRequestDto) {
        return new ResponseEntity<>(loanOfferServiceImpl.fetchLoanOffer(loanRequestDto), HttpStatus.OK);
    }

}
