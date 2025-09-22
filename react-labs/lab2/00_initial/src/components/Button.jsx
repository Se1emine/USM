import React from 'react';

export default function Button({ children, onClick, variant = 'primary' }) {
  const styles = {
    base: {
      cursor: 'pointer',
      padding: '0.5rem 1rem',
      borderRadius: 6,
      border: '1px solid transparent',
      fontWeight: 600,
    },
    primary: {
      background: '#646cff',
      color: 'white',
      borderColor: '#646cff',
    },
    secondary: {
      background: 'white',
      color: '#111827',
      borderColor: '#e5e7eb',
    },
  };

  const style = { ...styles.base, ...(variant === 'secondary' ? styles.secondary : styles.primary) };

  return (
    <button onClick={onClick} style={style}>
      {children}
    </button>
  );
}
