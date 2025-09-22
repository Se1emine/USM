import React from 'react';
import styled from 'styled-components';

const CardWrap = styled.section`
  border: 1px solid #e5e7eb;
  border-radius: 8px;
  padding: 1rem;
  margin: 1rem 0;
  text-align: left;
`;

const CardTitle = styled.h2`
  margin-top: 0;
  font-size: 1.25rem;
`;

const CardBody = styled.div`
  display: block;
`;

export default function Card({ title, children }) {
  return (
    <CardWrap>
      {title && <CardTitle>{title}</CardTitle>}
      <CardBody>{children}</CardBody>
    </CardWrap>
  );
}
