import { useParams, Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import pizzaData from '../data/pizza.json';
import NotFoundPage from './NotFoundPage';

/**
 * Страница товара - отображает детальную информацию о конкретной пицце
 * @returns {JSX.Element} JSX элемент страницы товара
 */
function ProductPage() {
  const { id } = useParams();
  const [pizza, setPizza] = useState(null);
  const [selectedSize, setSelectedSize] = useState(0);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Валидация параметра id
    const pizzaId = parseInt(id);
    
    // Проверяем, является ли параметр числом
    if (isNaN(pizzaId) || pizzaId <= 0) {
      setLoading(false);
      return;
    }

    // Ищем пиццу по id
    const foundPizza = pizzaData.find(p => p.id === pizzaId);
    
    if (foundPizza) {
      setPizza(foundPizza);
      setSelectedSize(0); // Выбираем первый размер по умолчанию
    }
    
    setLoading(false);
  }, [id]);

  // Показываем загрузку
  if (loading) {
    return (
      <div className="container mx-auto px-4 py-8">
        <div className="text-center">
          <div className="text-4xl mb-4">🍕</div>
          <p className="text-gray-600">Загрузка...</p>
        </div>
      </div>
    );
  }

  // Если пицца не найдена или id некорректный, показываем 404
  if (!pizza) {
    return <NotFoundPage />;
  }

  /**
   * Обработчик изменения размера пиццы
   * @param {number} sizeIndex - Индекс выбранного размера
   */
  const handleSizeChange = (sizeIndex) => {
    setSelectedSize(sizeIndex);
  };

  /**
   * Вычисляет цену в зависимости от размера
   * @param {number} basePrice - Базовая цена
   * @param {number} sizeIndex - Индекс размера (0, 1, 2)
   * @returns {number} Цена с учетом размера
   */
  const calculatePrice = (basePrice, sizeIndex) => {
    const multipliers = [1, 1.3, 1.6]; // 30см = базовая цена, 40см = +30%, 50см = +60%
    return Math.round(basePrice * multipliers[sizeIndex]);
  };

  return (
    <div className="container mx-auto px-4 py-8">
      <div className="bg-white rounded-lg shadow-md overflow-hidden">
        <div className="md:flex">
          {/* Изображение пиццы */}
          <div className="md:w-1/2">
            <img 
              src={pizza.image} 
              alt={pizza.name}
              className="w-full h-64 md:h-full object-cover"
            />
          </div>
          
          {/* Информация о пицце */}
          <div className="md:w-1/2 p-6">
            <h1 className="text-3xl font-bold text-gray-800 mb-2">
              {pizza.name}
            </h1>
            
            <p className="text-gray-600 mb-4">
              {pizza.description}
            </p>
            
            <div className="mb-4">
              <span className="inline-block bg-orange-100 text-orange-800 px-3 py-1 rounded-full text-sm">
                {pizza.category}
              </span>
            </div>
            
            {/* Выбор размера */}
            <div className="mb-6">
              <h3 className="text-lg font-semibold text-gray-800 mb-3">
                Выберите размер:
              </h3>
              <div className="space-y-2">
                {pizza.sizes.map((size, index) => (
                  <label 
                    key={index}
                    className="flex items-center cursor-pointer p-3 border rounded-lg hover:bg-gray-50"
                  >
                    <input
                      type="radio"
                      name="size"
                      value={index}
                      checked={selectedSize === index}
                      onChange={() => handleSizeChange(index)}
                      className="mr-3"
                    />
                    <span className="flex-1">
                      {size} см
                    </span>
                    <span className="font-semibold text-orange-600">
                      {calculatePrice(pizza.price, index)} ₽
                    </span>
                  </label>
                ))}
              </div>
            </div>
            
            {/* Цена и кнопка заказа */}
            <div className="flex items-center justify-between">
              <div className="text-2xl font-bold text-orange-600">
                {calculatePrice(pizza.price, selectedSize)} ₽
              </div>
              <button className="bg-orange-500 text-white px-6 py-3 rounded-lg hover:bg-orange-600 transition-colors">
                Добавить в корзину
              </button>
            </div>
          </div>
        </div>
      </div>
      
      {/* Кнопка "Назад к меню" */}
      <div className="mt-6">
        <Link 
          to="/" 
          className="inline-flex items-center text-orange-600 hover:text-orange-700 transition-colors"
        >
          <span className="mr-2">←</span>
          Назад к меню
        </Link>
      </div>
    </div>
  );
}

export default ProductPage;
