import { Link } from 'react-router-dom';

/**
 * Страница 404 - отображается когда запрашиваемая страница не найдена
 * @returns {JSX.Element} JSX элемент страницы 404
 */
function NotFoundPage() {
  return (
    <div className="container mx-auto px-4 py-8">
      <div className="text-center py-16">
        <div className="text-9xl mb-4">🍕</div>
        <h1 className="text-6xl font-bold text-gray-800 mb-4">404</h1>
        <h2 className="text-2xl font-semibold text-gray-600 mb-4">
          Страница не найдена
        </h2>
        <p className="text-gray-500 mb-8 max-w-md mx-auto">
          К сожалению, запрашиваемая страница не существует. 
          Возможно, она была удалена или вы ввели неверный адрес.
        </p>
        <div className="space-x-4">
          <Link 
            to="/" 
            className="inline-block bg-orange-500 text-white px-6 py-3 rounded-lg hover:bg-orange-600 transition-colors"
          >
            На главную
          </Link>
          <button 
            onClick={() => window.history.back()}
            className="inline-block bg-gray-500 text-white px-6 py-3 rounded-lg hover:bg-gray-600 transition-colors"
          >
            Назад
          </button>
        </div>
      </div>
    </div>
  );
}

export default NotFoundPage;
