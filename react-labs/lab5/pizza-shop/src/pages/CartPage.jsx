import { Link } from 'react-router-dom';

/**
 * Страница корзины - отображает список выбранных товаров
 * @returns {JSX.Element} JSX элемент страницы корзины
 */
function CartPage() {
  return (
    <div className="container mx-auto px-4 py-8">
      <h1 className="text-3xl font-bold text-gray-800 mb-8">Корзина</h1>
      
      <div className="bg-white rounded-lg shadow-md p-6">
        <div className="text-center py-12">
          <div className="text-6xl mb-4">🛒</div>
          <h2 className="text-xl font-semibold text-gray-600 mb-2">
            Ваша корзина пуста
          </h2>
          <p className="text-gray-500 mb-6">
            Добавьте пиццы из нашего меню, чтобы оформить заказ
          </p>
          <Link 
            to="/" 
            className="inline-block bg-orange-500 text-white px-6 py-3 rounded-lg hover:bg-orange-600 transition-colors"
          >
            Перейти к меню
          </Link>
        </div>
      </div>
    </div>
  );
}

export default CartPage;
