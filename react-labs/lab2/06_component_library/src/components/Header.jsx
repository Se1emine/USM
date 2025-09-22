import React from 'react';

export default function Header({ title, subtitle }) {
  return (
    <header className="py-4 text-left">
      <h1 className="text-3xl font-bold m-0">{title}</h1>
      {subtitle && <p className="m-0 text-muted-foreground">{subtitle}</p>}
    </header>
  );
}
