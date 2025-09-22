import React from 'react';
import styled from 'styled-components';

const HeaderWrap = styled.header`
  padding: 1rem 0;
  text-align: left;
`;

const Title = styled.h1`
  margin: 0;
  font-size: 2rem;
`;

const Subtitle = styled.p`
  margin: 0;
  color: #666;
`;

export default function Header({ title, subtitle }) {
  return (
    <HeaderWrap>
      <Title>{title}</Title>
      {subtitle && <Subtitle>{subtitle}</Subtitle>}
    </HeaderWrap>
  );
}
