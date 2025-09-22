import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { pizzaAPI } from "../services/api";
import PizzaCard from "./PizzaCard";
import Search from "./Search";
import { PizzaSkeletonList } from "./PizzaSkeleton";
import { debounce } from "lodash";

/**
 * Компонент списка пицц с функцией поиска
 * @param {Object} props - Пропсы компонента
 * @param {Function} props.onPizzasChange - Колбэк для обновления списка пицц
 * @returns {JSX.Element} JSX элемент списка пицц
 */
function PizzaList({ onPizzasChange }) {
  const navigate = useNavigate();
  const [pizzas, setPizzas] = useState([]);
  const [filteredPizzas, setFilteredPizzas] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [searchQuery, setSearchQuery] = useState("");

  /**
   * Загрузка данных при монтировании компонента
   */
  useEffect(() => {
    /**
     * Загрузка данных о пиццах с сервера
     */
    const fetchPizzas = async () => {
      try {
        setLoading(true);
        setError(null);
        const data = await pizzaAPI.getAll();
        setPizzas(data);
        setFilteredPizzas(data);
        // Передаем данные в родительский компонент, если нужно
        if (onPizzasChange) {
          onPizzasChange(data);
        }
      } catch (err) {
        setError(err.message);
        console.error('Ошибка загрузки пицц:', err);
      } finally {
        setLoading(false);
      }
    };

    fetchPizzas();
  }, [onPizzasChange]);

  /**
   * Повторная загрузка данных (для кнопки "Попробовать снова")
   */
  const refetchPizzas = async () => {
    try {
      setLoading(true);
      setError(null);
      const data = await pizzaAPI.getAll();
      setPizzas(data);
      setFilteredPizzas(data);
      if (onPizzasChange) {
        onPizzasChange(data);
      }
    } catch (err) {
      setError(err.message);
      console.error('Ошибка загрузки пицц:', err);
    } finally {
      setLoading(false);
    }
  };

  /**
   * Дебаунсированная функция поиска
   */
  const debouncedSearch = debounce((query) => {
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
  }, 300);

  /**
   * Обработчик поиска пицц по названию
   * @param {string} query - Поисковый запрос
   */
  const handleSearch = (query) => {
    setSearchQuery(query);
    debouncedSearch(query);
  };

  /**
   * Обработчик удаления пиццы
   * @param {string|number} id - ID пиццы для удаления
   */
  const handleDelete = async (id) => {
    try {
      await pizzaAPI.delete(id);
      // Обновляем локальное состояние
      const updatedPizzas = pizzas.filter(pizza => pizza.id !== id);
      setPizzas(updatedPizzas);
      setFilteredPizzas(updatedPizzas.filter(pizza =>
        !searchQuery.trim() || 
        pizza.name.toLowerCase().includes(searchQuery.toLowerCase()) ||
        pizza.description.toLowerCase().includes(searchQuery.toLowerCase()) ||
        pizza.category.toLowerCase().includes(searchQuery.toLowerCase())
      ));
      if (onPizzasChange) {
        onPizzasChange(updatedPizzas);
      }
    } catch (err) {
      console.error('Ошибка удаления пиццы:', err);
      alert('Не удалось удалить пиццу');
    }
  };

  /**
   * Обработчик редактирования пиццы
   * @param {Object} pizza - Объект пиццы для редактирования
   */
  const handleEdit = (pizza) => {
    navigate(`/edit-product/${pizza.id}`);
  };

  // Показываем скелетон во время загрузки
  if (loading) {
    return (
      <div className="container mx-auto px-4 py-8">
        <h2 className="text-3xl font-bold text-center text-gray-800 mb-8">
          Наше меню
        </h2>
        <div className="mb-8">
          <Search onSearch={() => {}} disabled />
        </div>
        <PizzaSkeletonList count={8} />
      </div>
    );
  }

  // Показываем ошибку, если она есть
  if (error) {
    return (
      <div className="container mx-auto px-4 py-8">
        <h2 className="text-3xl font-bold text-center text-gray-800 mb-8">
          Наше меню
        </h2>
        <div className="text-center py-8">
          <div className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4">
            <p className="font-bold">Ошибка загрузки</p>
            <p>{error}</p>
          </div>
          <button
            onClick={refetchPizzas}
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          >
            Попробовать снова
          </button>
        </div>
      </div>
    );
  }

  return (
    <div className="container mx-auto px-4 py-8">
      <h2 className="text-3xl font-bold text-center text-gray-800 mb-8">
        Наше меню
      </h2>
      
      <Search onSearch={handleSearch} />
      
      {filteredPizzas.length === 0 ? (
        <div className="text-center py-8">
          <p className="text-gray-500 text-lg">
            {searchQuery.trim() 
              ? "Пиццы не найдены. Попробуйте изменить поисковый запрос."
              : "Пиццы не найдены."
            }
          </p>
        </div>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
          {filteredPizzas.map((pizza) => (
            <PizzaCard 
              key={pizza.id} 
              pizza={pizza} 
              onDelete={handleDelete}
              onEdit={handleEdit}
            />
          ))}
        </div>
      )}
    </div>
  );
}

export default PizzaList;
