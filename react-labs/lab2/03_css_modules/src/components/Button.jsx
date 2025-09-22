import React from 'react';
import styles from './Button.module.css';

export default function Button({ children, onClick, variant = 'primary' }) {
  return (
    <button onClick={onClick} className={`${styles.btn} ${variant === 'secondary' ? styles.secondary : styles.primary}`}>
      {children}
    </button>
  );
}
