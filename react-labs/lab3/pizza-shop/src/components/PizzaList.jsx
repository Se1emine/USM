import { useState, useEffect } from "react";
import pizzaData from "../data/pizza.json";
import PizzaCard from "./PizzaCard";
import Search from "./Search";

/**
 * Компонент списка пицц с функцией поиска
 * @returns {JSX.Element} JSX элемент списка пицц
 */
function PizzaList() {
  const [pizzas, setPizzas] = useState([]);
  const [filteredPizzas, setFilteredPizzas] = useState([]);

  /**
   * Загрузка данных о пиццах при монтировании компонента
   */
  useEffect(() => {
    setPizzas(pizzaData);
    setFilteredPizzas(pizzaData);
  }, []);

  /**
   * Обработчик поиска пицц по названию
   * @param {string} query - Поисковый запрос
   */
  const handleSearch = (query) => {
    if (!query.trim()) {
      setFilteredPizzas(pizzas);
      return;
    }

    const filtered = pizzas.filter(pizza =>
      pizza.name.toLowerCase().includes(query.toLowerCase()) ||
      pizza.description.toLowerCase().includes(query.toLowerCase()) ||
      pizza.category.toLowerCase().includes(query.toLowerCase())
    );
    
    setFilteredPizzas(filtered);
  };

  return (
    <div className="container mx-auto px-4 py-8">
      <h2 className="text-3xl font-bold text-center text-gray-800 mb-8">
        Наше меню
      </h2>
      
      <Search onSearch={handleSearch} />
      
      {filteredPizzas.length === 0 ? (
        <div className="text-center py-8">
          <p className="text-gray-500 text-lg">
            Пиццы не найдены. Попробуйте изменить поисковый запрос.
          </p>
        </div>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
          {filteredPizzas.map((pizza) => (
            <PizzaCard key={pizza.id} pizza={pizza} />
          ))}
        </div>
      )}
    </div>
  );
}

export default PizzaList;
