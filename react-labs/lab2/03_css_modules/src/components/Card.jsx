import React from 'react';
import styles from './Card.module.css';

export default function Card({ title, children }) {
  return (
    <section className={styles.card}>
      {title && <h2 className={styles.title}>{title}</h2>}
      <div className={styles.body}>{children}</div>
    </section>
  );
}
