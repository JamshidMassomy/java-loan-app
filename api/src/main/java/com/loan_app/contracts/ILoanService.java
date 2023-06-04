package com.loan_app.contracts;

import com.loan_app.dto.LoanOfferResponseDto;
import com.loan_app.dto.LoanRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface ILoanService {
    LoanOfferResponseDto fetchLoanOffer(LoanRequestDto loanRequestDto);
}
