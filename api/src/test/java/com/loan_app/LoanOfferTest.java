package com.loan_app;

import com.loan_app.dto.LoanOfferResponseDto;
import com.loan_app.dto.LoanRequestDto;
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
        LoanRequestDto loanRequestDto = new LoanRequestDto(personalCode, initialLoanAmount, initialLoanPeriod);
        LoanOfferResponseDto expectedOffer = new LoanOfferResponseDto(0, 0);

        // Act
        LoanOfferResponseDto actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequestDto);

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


        LoanRequestDto loanRequestDto = new LoanRequestDto(personalCode, initialLoanAmount, initialLoanPeriod );
        LoanOfferResponseDto expectedOffer = new LoanOfferResponseDto(5999, 60);

        // Act
        LoanOfferResponseDto actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequestDto);

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

        LoanRequestDto loanRequestDto = new LoanRequestDto(personalCode, initialLoanAmount, initialLoanPeriod );
        LoanOfferResponseDto expectedOffer = new LoanOfferResponseDto(6000, 30); // Example expected offer

        // Act
        LoanOfferResponseDto actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequestDto);


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

        LoanRequestDto loanRequestDto = new LoanRequestDto(personalCode, initialLoanAmount, initialLoanPeriod );
        LoanOfferResponseDto expectedOffer = new LoanOfferResponseDto(3600, 12);

        // Act
        LoanOfferResponseDto actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequestDto);

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

        LoanRequestDto loanRequestDto = new LoanRequestDto(personalCode, initialLoanAmount, initialLoanPeriod );
        LoanOfferResponseDto expectedOffer = new LoanOfferResponseDto(10000, 12);

        // Act
        LoanOfferResponseDto actualOffer = loanServiceImplTest.fetchLoanOffer(loanRequestDto);

        System.out.println("offer amount > " +actualOffer.getOfferedLoanAmount());
        System.out.println("offer in months > " +actualOffer.getLoanPeriodInMonths());

        // Assert
        Assertions.assertEquals(expectedOffer.getLoanPeriodInMonths(), actualOffer.getLoanPeriodInMonths());
        Assertions.assertEquals(expectedOffer.getOfferedLoanAmount(), actualOffer.getOfferedLoanAmount());
    }

}