package com.loan_app.service;


import com.loan_app.contracts.ILoanService;
import com.loan_app.dto.LoanOfferResponseDto;
import com.loan_app.dto.LoanRequestDto;
import com.loan_app.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class LoanOfferServiceImpl implements ILoanService {

    private static final int MAXIMUM_LOAN_AMOUNT = 10000;
    private static final int MINIMUM_LOAN_AMOUNT = 2000;
    private static final int MAXIMUM_LOAN_PERIOD_MONTHS = 60;

    private static final List<UserDto> USER_DTO_LIST = Arrays.asList(
            new UserDto("49002010965", -1, true),
            new UserDto("49002010976", 100, false),
            new UserDto("49002010987", 300, false),
            new UserDto("49002010998", 1000, false)
    );


    @Override
    public LoanOfferResponseDto fetchLoanOffer(LoanRequestDto loanRequestDto) {
        if (hasDebt(loanRequestDto)) {
            return new LoanOfferResponseDto(0, 0);
        }
        return findLoanOffer(loanRequestDto);
    }


    private LoanOfferResponseDto findLoanOffer(LoanRequestDto loanRequestDto) {
        int userCreditSegment = getUserCreditModifier(loanRequestDto.getPersonalCode());
        int loanPeriod = loanRequestDto.getLoanPeriod();
        int maxSum = userCreditSegment * loanPeriod;

        if (maxSum <= MINIMUM_LOAN_AMOUNT) {
            // max offer
            maxSum = userCreditSegment * MAXIMUM_LOAN_PERIOD_MONTHS;
            return new LoanOfferResponseDto(maxSum, MAXIMUM_LOAN_PERIOD_MONTHS);
        }

        if (maxSum >= MAXIMUM_LOAN_AMOUNT) {
            return new LoanOfferResponseDto(MAXIMUM_LOAN_AMOUNT, loanPeriod);
        }

        return new LoanOfferResponseDto(maxSum, loanPeriod);
    }

    private static int getUserCreditModifier(String personalCode) {
        return USER_DTO_LIST.stream()
                .filter(x -> Objects.equals(x.getPersonalCode(), personalCode))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("User Personal code not found"))
                .getCreditModifier();
    }

    private boolean hasDebt(LoanRequestDto loanRequestDto) {
        return Objects.equals(getUserCreditModifier(loanRequestDto.getPersonalCode()), -1);
    }

}