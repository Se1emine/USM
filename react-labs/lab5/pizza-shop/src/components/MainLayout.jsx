import Header from './Header';
import Footer from './Footer';
import { Outlet } from 'react-router-dom';

/**
 * Основной Layout компонент, который включает шапку, подвал и область для контента
 * @returns {JSX.Element} JSX элемент с общим макетом страницы
 */
function MainLayout() {
  return (
    <div className="min-h-screen bg-gray-50 flex flex-col">
      <Header />
      
      <main className="flex-1">
        <Outlet />
      </main>
      
      <Footer />
    </div>
  );
}

export default MainLayout;
