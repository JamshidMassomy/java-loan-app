import React, { useState } from 'react';
import { ButtonType } from '../../component/base/button/Button';
import ButtonX from '../../component/base/button/Buttons';
import Select from '../../component/base/select/Select';
import './style.scss';
import user from './users';
import RangeSlider from '../../component/base/input/range_slider/RangeSlider';
import {
  MAXIMUM_LOAN_AMOUNT,
  MAXIMUM_LOAN_PERIOD,
  MINIMUM_LOAN_AMOUNT,
  MINIMUM_LOAN_PERIOD,
} from '../../constants';

import { _fetch } from '../../api/api.config';
import { ILoanResponse } from './loan';

const LoanPage = () => {
  const [loanOffer, setLoanOffer] = useState<ILoanResponse>({
    loanPeriodInMonths: 0,
    offeredLoanAmount: 0,
  });
  const [personalCode, setPersonalCode] = useState<string>();

  const [requestedLoanAmount, setRequestedLoanAmount] = useState<number>();
  const [requestedLoanPeriod, setRequestedLoanPeriod] = useState<number>();

  const [loanValue, setLoanValue] = useState<number>();
  const [loanPeriodValue, setLoanPeriodValue] = useState<number>();

  const fetchLoanOffer = async () => {
    if (isParmsValid()) {
      await _fetch(
        `/loan?loanAmount=${requestedLoanAmount}&loanPeriod=${requestedLoanPeriod}&personalCode=${personalCode}`,
      )
        .then((data: any) => {
          setLoanOffer(data);
        })
        .catch(() => {
          setLoanOffer({ loanPeriodInMonths: 0, offeredLoanAmount: 0 });
          console.log('somethign went worong');
          // toastDispatcher('Failed to fetch API! Something went wrong');
        });
    }
  };

  const isParmsValid = () => {
    return (
      typeof requestedLoanAmount !== 'undefined' &&
      typeof requestedLoanPeriod !== 'undefined' &&
      typeof personalCode !== 'undefined'
    );
  };

  const handleSelectEvent = (e: any) => {
    const value = e.target.value;
    setPersonalCode(value);
  };

  const handleLoanAmountChange = (e: any) => {
    const value = parseInt(e.target.value);
    setLoanValue(value);
    setRequestedLoanAmount(value);
  };

  const handleLoanPeriodChange = (e: any) => {
    const value = parseInt(e.target.value);
    setLoanPeriodValue(value);
    setRequestedLoanPeriod(value);
  };

  return (
    <div className="loan">
      <div className="loan-content">
        <div className="loan-form">
          <span>Personal Code</span>
          <Select options={user} onChange={handleSelectEvent} />

          <RangeSlider
            value={loanPeriodValue}
            onChange={handleLoanPeriodChange}
            min={MINIMUM_LOAN_PERIOD}
            max={MAXIMUM_LOAN_PERIOD}
            label="Loan Period (months)"
          />
          <RangeSlider
            value={loanValue}
            onChange={handleLoanAmountChange}
            min={MINIMUM_LOAN_AMOUNT}
            max={MAXIMUM_LOAN_AMOUNT}
            label="Loan Amount (EUR)"
          />
          <ButtonX type={ButtonType.BTN_PRIMARY} text="Process" onClick={fetchLoanOffer} />
        </div>
      </div>

      <div className="loan-counter-offer" aria-label="Sidebar">
        <div className="loan-offer-title">
          <h2>Loan Offer</h2>
          <hr />
        </div>

        <div className="loan-offer-body">
          <div className="loan-amount">
            <h3>Loan Amount</h3>
            <span>{loanOffer?.offeredLoanAmount} EUR</span>
          </div>
          <div className="looan-period">
            <h2>Loan Period</h2>
            <span>{loanOffer?.loanPeriodInMonths} months</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoanPage;
