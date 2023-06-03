import React from 'react';
import './RangeSlider.scss';

interface IRangeSlider {
  min: number;
  max: number;
  value: any;
  onChange: (e: any) => void;
  label: string;
}

const RangeSlider = (props: IRangeSlider) => {
  const { onChange, min, max, value, label } = props;

  return (
    <div className="loan-slider mt-4">
      <div className="max-slider">
        <span>{label}</span>
        <input type="range" min={min} max={max} value={value} onChange={onChange} />
      </div>

      <div>
        <span className="mr-2">{value}</span>
      </div>
    </div>
  );
};

export default RangeSlider;
