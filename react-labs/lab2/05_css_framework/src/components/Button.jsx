import React from 'react';

export default function Button({ children, onClick, variant = 'primary' }) {
  return (
    <button
      onClick={onClick}
      className={
        `cursor-pointer px-4 py-2 rounded-md border font-semibold ` +
        (variant === 'secondary'
          ? 'bg-white text-gray-900 border-gray-200'
          : 'bg-indigo-500 text-white border-indigo-500 hover:bg-indigo-600')
      }
    >
      {children}
    </button>
  );
}
