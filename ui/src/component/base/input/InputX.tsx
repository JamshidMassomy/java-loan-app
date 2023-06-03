/* eslint-disable jsx-a11y/label-has-associated-control */
import React from 'react';
import IInput from './Input';

export default function InputX(props: IInput) {
  const { type, label, placeholder, id, name, onChange, required, defaultValue: value } = props;

  return (
    <div>
      <label htmlFor={id} className="block text-sm font-medium text-gray-700">
        {label}
      </label>
      <div className="relative mt-1 rounded-md shadow-sm">
        <div className="pointer-events-none absolute inset-y-0 left-0 flex items-center pl-3"></div>
        <input
          defaultValue={value}
          required={required}
          onChange={onChange}
          type={type}
          name={name}
          id={id}
          className="block w-full rounded-md border-gray-300 pr-12 focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"
          placeholder={placeholder}
        />
      </div>
    </div>
  );
}
