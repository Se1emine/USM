import React from 'react';

export default function Card({ title, children }) {
  return (
    <section className="border border-gray-200 rounded-lg p-4 my-4 text-left">
      {title && <h2 className="mt-0 text-xl font-semibold">{title}</h2>}
      <div>{children}</div>
    </section>
  );
}
