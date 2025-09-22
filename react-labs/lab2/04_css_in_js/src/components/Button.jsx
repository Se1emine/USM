import React from 'react';
import styled, { css } from 'styled-components';

const StyledButton = styled.button`
  cursor: pointer;
  padding: 0.5rem 1rem;
  border-radius: 6px;
  border: 1px solid transparent;
  font-weight: 600;
  ${(p) =>
    p.$variant === 'secondary'
      ? css`
          background: white;
          color: #111827;
          border-color: #e5e7eb;
        `
      : css`
          background: #646cff;
          color: white;
          border-color: #646cff;
        `}
`;

export default function Button({ children, onClick, variant = 'primary' }) {
  return (
    <StyledButton onClick={onClick} $variant={variant}>
      {children}
    </StyledButton>
  );
}
