package com.loan_app.service;


import com.loan_app.dto.LoanOfferResponse;
import com.loan_app.dto.LoanRequest;
import com.loan_app.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoanOfferServiceImpl {

    private static final int maximumLoanAmount = 10000;
    private static final int minimumLoanAmount = 2000;
    private static final int maximumLoanPeriodMonths = 60;

    private static final List<User> userList = Arrays.asList(
            new User("49002010965", -1, true),
            new User("49002010976", 100, false),
            new User("49002010987", 300, false),
            new User("49002010998", 1000, false)
    );

    public LoanOfferResponse fetchLoanOffer(LoanRequest loanRequest) {
        if (hasDebt(loanRequest)) {
            return new LoanOfferResponse(0, 0);
        }
        return findLoanOffer(loanRequest);
    }

    private LoanOfferResponse findLoanOffer(LoanRequest loanRequest) {
        int loanAmount = loanRequest.getLoanAmount();
        int loanPeriod = loanRequest.getLoanPeriod();
        String personalCode = loanRequest.getPersonalCode();
        float userCreditScore = getCreditScore(loanAmount, loanPeriod, personalCode);

        if (userCreditScore >= 1) {
            while (loanAmount < maximumLoanAmount) {
                userCreditScore = getCreditScore(loanAmount, loanPeriod, personalCode);
                if (userCreditScore == 1) {
                    return new LoanOfferResponse(loanAmount, loanPeriod);
                }
                loanAmount++;
            }

            if (loanAmount == maximumLoanAmount && userCreditScore > 1) {
                return new LoanOfferResponse(loanAmount, loanPeriod);
            }
        }
        // if no suitable offer found within loan period fetch the other one/
        return findCounterOffer(loanRequest);
    }


    private static LoanOfferResponse findCounterOffer(LoanRequest loanRequest) {
        int loanAmount = loanRequest.getLoanAmount();
        int loanPeriod = loanRequest.getLoanPeriod();
        String personalCode = loanRequest.getPersonalCode();
        float userCreditScore = getCreditScore(loanAmount, loanPeriod, personalCode);

        while (userCreditScore < 1 && loanAmount > minimumLoanAmount) {
            userCreditScore = getCreditScore(loanAmount, loanPeriod, personalCode);
            if (userCreditScore == 1) {
                return new LoanOfferResponse(loanAmount, loanPeriod);
            }
            loanAmount--;
        }

        loanPeriod = maximumLoanPeriodMonths;
        while (userCreditScore != 1) {
            loanAmount ++;
            userCreditScore = getCreditScore(loanAmount, loanPeriod, personalCode);
            if (loanAmount >= maximumLoanAmount) {
                return new LoanOfferResponse(maximumLoanAmount, loanPeriod);
            }

        }
        return new LoanOfferResponse(loanAmount, loanPeriod);
    }


    private static int getUserCreditModifier(String personalCode) {
        return userList.stream()
                .filter(x -> Objects.equals(x.getPersonalCode(), personalCode))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("User Personal code not found"))
                .getCreditModifier();
    }

    private boolean hasDebt(LoanRequest loanRequest) {
        return Objects.equals(getUserCreditModifier(loanRequest.getPersonalCode()), -1);
    }

    private static float getCreditScore(int loanAmount, int loanPeriodInMonths, String personalCode) {
        int creditModifier = getUserCreditModifier(personalCode);
        return  ((float) creditModifier / loanAmount) * loanPeriodInMonths;
    }


}