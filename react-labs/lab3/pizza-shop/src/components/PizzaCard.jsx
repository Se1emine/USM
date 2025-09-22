import { useState } from 'react';

/**
 * Компонент карточки пиццы
 * @param {Object} props - Пропсы компонента
 * @param {Object} props.pizza - Объект пиццы с данными
 * @param {number} props.pizza.id - ID пиццы
 * @param {string} props.pizza.name - Название пиццы
 * @param {string} props.pizza.description - Описание пиццы
 * @param {number} props.pizza.price - Цена пиццы
 * @param {string} props.pizza.image - URL изображения пиццы
 * @param {string} props.pizza.category - Категория пиццы
 * @param {number[]} props.pizza.sizes - Массив доступных размеров
 * @returns {JSX.Element} JSX элемент карточки пиццы
 */
function PizzaCard({ pizza }) {
  const [selectedSize, setSelectedSize] = useState(pizza.sizes[0]);

  /**
   * Обработчик изменения размера пиццы
   * @param {number} size - Выбранный размер
   */
  const handleSizeChange = (size) => {
    setSelectedSize(size);
  };

  return (
    <div className="bg-white rounded-lg shadow-md overflow-hidden hover:shadow-lg transition-shadow">
      <img 
        src={pizza.image} 
        alt={pizza.name}
        className="w-full h-48 object-cover"
      />
      
      <div className="p-4">
        <h2 className="text-xl font-semibold text-gray-800 mb-2">
          {pizza.name}
        </h2>
        
        <p className="text-gray-600 text-sm mb-3">
          {pizza.description}
        </p>
        
        <div className="mb-4">
          <span className="text-lg font-bold text-pizza-600">
            {pizza.price} лей.
          </span>
          <span className="text-sm text-gray-500 ml-2">
            ({pizza.category})
          </span>
        </div>
        
        <div className="mb-4">
          <p className="text-sm text-gray-700 mb-2">Размеры:</p>
          <div className="flex space-x-2">
            {pizza.sizes.map((size) => (
              <button
                key={size}
                onClick={() => handleSizeChange(size)}
                className={`px-3 py-1 rounded-md text-sm font-medium transition-colors ${
                  selectedSize === size
                    ? 'bg-pizza-600 text-white'
                    : 'bg-gray-200 text-gray-700 hover:bg-gray-300'
                }`}
              >
                {size} см.
              </button>
            ))}
          </div>
        </div>
        
        <button className="w-full bg-pizza-600 text-white py-2 px-4 rounded-md hover:bg-pizza-700 transition-colors font-medium">
          Добавить в корзину
        </button>
      </div>
    </div>
  );
}

export default PizzaCard;
