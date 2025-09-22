import React from 'react';

export default function Card({ title, children }) {
  return (
    <section style={{ border: '1px solid #e5e7eb', borderRadius: 8, padding: '1rem', margin: '1rem 0', textAlign: 'left' }}>
      {title && <h2 style={{ marginTop: 0 }}>{title}</h2>}
      <div>{children}</div>
    </section>
  );
}
