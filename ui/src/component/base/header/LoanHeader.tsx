import React, { useState } from 'react';
import './styles.scss';

export interface IMenu {
  text: string;
  path: string;
  icon: any;
}

export default function LoanHeader() {
  const [state, setState] = useState(false);

  return (
    <nav className="loan-header bg-white w-full border-b md:border-0 md:static shadow-sm">
      <div className="items-center w-full px-4  md:flex md:px-8">
        <div
          className={`flex-1 justify-self-center pb-3 mt-8 md:block md:pb-0 md:mt-0 ${
            state ? 'block' : 'hidden'
          }`}>
          <ul className="justify-center items-center space-y-8 md:flex md:space-x-6 md:space-y-0">
            <span>Loan Offer App</span>
          </ul>
        </div>
      </div>
    </nav>
  );
}
