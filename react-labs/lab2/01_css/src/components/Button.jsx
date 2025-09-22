import React from 'react';
import './Button.css';

export default function Button({ children, onClick, variant = 'primary' }) {
  return (
    <button onClick={onClick} className={`btn ${variant === 'secondary' ? 'btn--secondary' : 'btn--primary'}`}>
      {children}
    </button>
  );
}
