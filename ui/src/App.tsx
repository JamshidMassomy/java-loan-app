import React from 'react';
import LoanHeader from './component/base/header/LoanHeader';
import LoanPage from './pages/loan';

function App() {
  return (
    <body className="min-h-fit bg-gray-50">
      <LoanHeader />
      <LoanPage></LoanPage>
    </body>
  );
}

export default App;
