import { Link } from 'react-router-dom';
import { Slider, PizzaList } from '../components';

/**
 * Главная страница - отображает слайдер и список всех товаров
 * @returns {JSX.Element} JSX элемент главной страницы
 */
function HomePage() {
  return (
    <>
      <Slider />
      
      {/* Кнопка добавления продукта */}
      <div className="container mx-auto px-4 py-4">
        <div className="text-center">
          <Link
            to="/add-product"
            className="inline-block bg-green-600 text-white px-6 py-3 rounded-lg hover:bg-green-700 transition-colors font-medium"
          >
            + Добавить новый продукт
          </Link>
        </div>
      </div>
      
      <PizzaList />
    </>
  );
}

export default HomePage;
