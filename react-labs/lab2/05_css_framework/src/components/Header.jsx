import React from 'react';

export default function Header({ title, subtitle }) {
  return (
    <header className="py-4 text-left">
      <h1 className="m-0 text-2xl font-bold">{title}</h1>
      {subtitle && <p className="m-0 text-gray-500">{subtitle}</p>}
    </header>
  );
}
