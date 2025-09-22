import React from 'react';
import './Header.scss';

export default function Header({ title, subtitle }) {
  return (
    <header className="header">
      <h1 className="header__title">{title}</h1>
      {subtitle && <p className="header__subtitle">{subtitle}</p>}
    </header>
  );
}
