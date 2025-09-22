import React from 'react';
import { Card as ShadCard, CardHeader, CardTitle, CardContent } from './ui/card';

export default function Card({ title, children }) {
  return (
    <ShadCard className="my-4 text-left">
      {title && (
        <CardHeader>
          <CardTitle className="text-xl">{title}</CardTitle>
        </CardHeader>
      )}
      <CardContent>{children}</CardContent>
    </ShadCard>
  );
}
