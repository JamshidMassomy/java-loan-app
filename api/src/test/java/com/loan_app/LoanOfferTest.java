package com.loan_app;

import com.loan_app.dto.LoanOfferResponse;
import com.loan_app.dto.LoanRequest;
import com.loan_app.service.LoanOfferServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanOfferTest {

    @Autowired
    private  LoanOfferServiceImpl loanServiceImplTest;

    @Test
    public void testUserHasDebt() {
        // Arrange
        int initialLoanAmount = 2500;
        int initialLoanPeriod = 12;
        String personalCode = "49002010965";
        LoanRequest loanRequest = new LoanRequest(personalCode, initialLoanAmount, initialLoanPeriod);
        LoanOfferResponse expectedOffer = new LoanOfferResponse(0, 0);

        // Act
        LoanOfferResponse actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequest);

        // Assert
       Assertions.assertEquals(expectedOffer.getLoanPeriodInMonths(), actualOffer.getLoanPeriodInMonths());
       Assertions.assertEquals(expectedOffer.getOfferedLoanAmount(), actualOffer.getOfferedLoanAmount());

    }

    @Test
    public void test100SegmentWithLongerLoanPeriod() {
        // Arrange
        int initialLoanAmount = 3200;
        int initialLoanPeriod = 60;
        String personalCode = "49002010976";


        LoanRequest loanRequest = new LoanRequest(personalCode, initialLoanAmount, initialLoanPeriod );
        LoanOfferResponse expectedOffer = new LoanOfferResponse(5999, 60);

        // Act
        LoanOfferResponse actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequest);

        System.out.println("offer amount > " +actualOffer.getOfferedLoanAmount());
        System.out.println("offer in months > " +actualOffer.getLoanPeriodInMonths());

        // Assert
        Assertions.assertTrue(actualOffer.getOfferedLoanAmount() > expectedOffer.getOfferedLoanAmount());
        Assertions.assertEquals(expectedOffer.getLoanPeriodInMonths(), actualOffer.getLoanPeriodInMonths());
    }


    @Test
    public void testUserModifierOf100() {
        // Arrange
        int initialLoanAmount = 4000;
        int initialLoanPeriod = 30;
        String personalCode = "49002010976";

        LoanRequest loanRequest = new LoanRequest(personalCode, initialLoanAmount, initialLoanPeriod );
        LoanOfferResponse expectedOffer = new LoanOfferResponse(6000, 30); // Example expected offer

        // Act
        LoanOfferResponse actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequest);


        System.out.println("initial loan request > " +initialLoanAmount);
        System.out.println("initial loan offer in months > " + initialLoanPeriod);
        System.out.println("offer amount > " +actualOffer.getOfferedLoanAmount());
        System.out.println("offer in months > " +actualOffer.getLoanPeriodInMonths());

        // Assert
        Assertions.assertTrue(actualOffer.getOfferedLoanAmount() < expectedOffer.getOfferedLoanAmount());
        Assertions.assertEquals(expectedOffer.getLoanPeriodInMonths(), actualOffer.getLoanPeriodInMonths());
    }

    @Test
    public void testUserModifierOf300() {
        // Arrange
        int initialLoanAmount = 9500;
        int initialLoanPeriod = 12;
        String personalCode = "49002010987";

        LoanRequest loanRequest = new LoanRequest(personalCode, initialLoanAmount, initialLoanPeriod );
        LoanOfferResponse expectedOffer = new LoanOfferResponse(3600, 12);

        // Act
        LoanOfferResponse actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequest);

        System.out.println("initial loan request > " +initialLoanAmount);
        System.out.println("initial loan offer in months > " + initialLoanPeriod);
        System.out.println("offer amount > " +actualOffer.getOfferedLoanAmount());
        System.out.println("offer in months > " +actualOffer.getLoanPeriodInMonths());

        // Assert
        Assertions.assertEquals(expectedOffer.getLoanPeriodInMonths(), actualOffer.getLoanPeriodInMonths());
        Assertions.assertEquals(expectedOffer.getOfferedLoanAmount(), actualOffer.getOfferedLoanAmount());
    }

    @Test
    public void testUserModifierOf1000() {

        // Arrange
        int initialLoanAmount = 2000;
        int initialLoanPeriod = 12;
        String personalCode = "49002010998";

        LoanRequest loanRequest = new LoanRequest(personalCode, initialLoanAmount, initialLoanPeriod );
        LoanOfferResponse expectedOffer = new LoanOfferResponse(10000, 12);

        // Act
        LoanOfferResponse actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequest);

        System.out.println("offer amount > " +actualOffer.getOfferedLoanAmount());
        System.out.println("offer in months > " +actualOffer.getLoanPeriodInMonths());

        // Assert
        Assertions.assertEquals(expectedOffer.getLoanPeriodInMonths(), actualOffer.getLoanPeriodInMonths());
        Assertions.assertEquals(expectedOffer.getOfferedLoanAmount(), actualOffer.getOfferedLoanAmount());
    }

}
