import { Link } from 'react-router-dom';

/**
 * Компонент Header - отображает название приложения и навигацию
 * @returns {JSX.Element} JSX элемент заголовка
 */
const Header = () => {
  return (
    <header className="bg-pizza-600 text-white shadow-lg">
      <div className="container mx-auto px-4 py-4">
        <div className="flex items-center justify-between">
          <Link to="/" className="flex items-center space-x-2 hover:opacity-80 transition-opacity">
            <span className="text-2xl">🍕</span>
            <h1 className="text-2xl font-bold">Пиццерия "Mamma Mia"</h1>
          </Link>
          
          <nav className="hidden md:flex space-x-6">
            <Link to="/" className="hover:text-pizza-200 transition-colors">
              Меню
            </Link>
            <Link to="/about" className="hover:text-pizza-200 transition-colors">
              О нас
            </Link>
            <Link to="/cart" className="hover:text-pizza-200 transition-colors flex items-center">
              <span className="mr-1">🛒</span>
              Корзина
            </Link>
          </nav>
          
          <button className="md:hidden">
            <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M4 6h16M4 12h16M4 18h16" />
            </svg>
          </button>
        </div>
      </div>
    </header>
  );
};

export default Header;
