function Footer() {
  const currentYear = new Date().getFullYear();

  return (
    <footer>
      <p>© {currentYear} Mini-Blog. All rights reserved.</p>
    </footer>
  );
}

export default Footer;