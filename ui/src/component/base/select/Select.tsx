import React from 'react';
import './styles.scss';

export interface ISelectOptions {
  id?: number | 0;
  label: string;
}

export interface ISelect {
  hasDefaultOption?: boolean;
  label?: string;
  hasPlusBtn?: boolean;
  onChange?: (value: any) => void;
  options: ISelectOptions[];
}

export default function Select(props: ISelect) {
  const { options, onChange, label } = props;
  return (
    <div className="select-wrapper">
      <div className="select-wrapper-content">
        <label>{label || null}</label>
        <select
          onChange={onChange}
          className="select cursor-default
       focus:border-indigo-500 focus:outline-none focus:ring-1
        focus:ring-indigo-500 small-text">
          <option>--------</option>
          {options?.map((option: any, index: number) => {
            return (
              <option key={option?.id} value={option?.id || index}>
                {option.label || ''}
              </option>
            );
          })}
        </select>
      </div>
    </div>
  );
}
