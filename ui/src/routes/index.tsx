import React from 'react';
import { Route, Routes } from 'react-router';
import App from '../App';
import NotFound from '../pages/error/NotFound';
import LoanPage from '../pages/loan';
import LoanHeader from '../component/base/header/LoanHeader';

export default function RouteX() {
  return (
    <Routes>
      <Route path="/" element={<App />}>
        <Route path="header" element={<LoanHeader />} />
        <Route path="loan" element={<LoanPage />} />
        <Route path="*" element={<NotFound />} />
      </Route>
    </Routes>
  );
}
