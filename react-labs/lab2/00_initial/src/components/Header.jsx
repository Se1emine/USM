import React from 'react';

export default function Header({ title, subtitle }) {
  return (
    <header style={{ padding: '1rem 0' }}>
      <h1 style={{ margin: 0 }}>{title}</h1>
      {subtitle && <p style={{ margin: 0, color: '#666' }}>{subtitle}</p>}
    </header>
  );
}
