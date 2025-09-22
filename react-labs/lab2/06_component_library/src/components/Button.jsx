import React from 'react';
import { Button as ShadButton } from './ui/button';

export default function Button({ children, onClick, variant = 'primary' }) {
  return (
    <ShadButton onClick={onClick} variant={variant === 'secondary' ? 'secondary' : 'default'}>
      {children}
    </ShadButton>
  );
}
