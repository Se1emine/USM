import React from 'react';
import './Button.scss';

export default function Button({ children, onClick, variant = 'primary' }) {
  return (
    <button onClick={onClick} className={`btn ${variant === 'secondary' ? 'btn--secondary' : 'btn--primary'}`}>
      {children}
    </button>
  );
}
