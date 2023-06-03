import React from 'react';
import { Button, ButtonType } from './Button';
import './style.scss';

export default function ButtonX(props: Button) {
  const { text, type, onClick } = props;

  const handleButtonType = () => {
    switch (type) {
      case ButtonType.BTN_GRAY:
        return `bg-gray-200 text-gray-700 w-full rounded-md hover:bg-gray-300`;
      case ButtonType.BTN_PRIMARY:
        return ` bg-indigo-500 text-white w-full rounded-md hover:bg-indigo-600`;

      default:
        return 'primary default';
    }
  };

  return (
    <button onClick={onClick} type="button" className={handleButtonType()}>
      {text}
    </button>
  );
}
