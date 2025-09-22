import { useState, useEffect } from 'react';
import { pizzaAPI } from '../services/api';

/**
 * Компонент формы для добавления/редактирования продукта
 * @param {Object} props - Пропсы компонента
 * @param {Object} props.initialData - Начальные данные для редактирования (опционально)
 * @param {Function} props.onSubmit - Колбэк при успешной отправке формы
 * @param {Function} props.onCancel - Колбэк при отмене
 * @param {boolean} props.isEditing - Флаг редактирования
 * @returns {JSX.Element} JSX элемент формы продукта
 */
function ProductForm({ initialData = null, onSubmit, onCancel, isEditing = false }) {
  const [formData, setFormData] = useState({
    name: '',
    description: '',
    price: '',
    image: '',
    category: '',
    sizes: [30, 40, 50]
  });
  
  const [errors, setErrors] = useState({});
  const [loading, setLoading] = useState(false);
  const [customSizes, setCustomSizes] = useState('30,40,50');

  // Категории для выбора
  const categories = ['Сырная', 'Мясная', 'Вегетарианская', 'Острая', 'Сладкая'];

  /**
   * Инициализация формы данными для редактирования
   */
  useEffect(() => {
    if (initialData) {
      setFormData({
        name: initialData.name || '',
        description: initialData.description || '',
        price: initialData.price?.toString() || '',
        image: initialData.image || '',
        category: initialData.category || '',
        sizes: initialData.sizes || [30, 40, 50]
      });
      setCustomSizes(initialData.sizes?.join(',') || '30,40,50');
    }
  }, [initialData]);

  /**
   * Обработчик изменения полей формы
   * @param {Event} e - Событие изменения input
   */
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
    
    // Очищаем ошибку для измененного поля
    if (errors[name]) {
      setErrors(prev => ({
        ...prev,
        [name]: ''
      }));
    }
  };

  /**
   * Обработчик изменения размеров
   * @param {Event} e - Событие изменения input
   */
  const handleSizesChange = (e) => {
    const value = e.target.value;
    setCustomSizes(value);
    
    // Парсим размеры из строки
    try {
      const sizesArray = value
        .split(',')
        .map(size => parseInt(size.trim()))
        .filter(size => !isNaN(size) && size > 0);
      
      setFormData(prev => ({
        ...prev,
        sizes: sizesArray.length > 0 ? sizesArray : [30, 40, 50]
      }));
      
      if (errors.sizes) {
        setErrors(prev => ({
          ...prev,
          sizes: ''
        }));
      }
    } catch (error) {
      console.error('Ошибка парсинга размеров:', error);
    }
  };

  /**
   * Валидация формы
   * @returns {boolean} Результат валидации
   */
  const validateForm = () => {
    const newErrors = {};

    // Проверка названия
    if (!formData.name.trim()) {
      newErrors.name = 'Название обязательно для заполнения';
    } else if (formData.name.trim().length < 2) {
      newErrors.name = 'Название должно содержать минимум 2 символа';
    }

    // Проверка описания
    if (!formData.description.trim()) {
      newErrors.description = 'Описание обязательно для заполнения';
    } else if (formData.description.trim().length < 10) {
      newErrors.description = 'Описание должно содержать минимум 10 символов';
    }

    // Проверка цены
    if (!formData.price.trim()) {
      newErrors.price = 'Цена обязательна для заполнения';
    } else {
      const price = parseFloat(formData.price);
      if (isNaN(price) || price <= 0) {
        newErrors.price = 'Цена должна быть положительным числом';
      }
    }

    // Проверка изображения
    if (!formData.image.trim()) {
      newErrors.image = 'URL изображения обязателен для заполнения';
    } else {
      try {
        new URL(formData.image);
      } catch {
        newErrors.image = 'Введите корректный URL изображения';
      }
    }

    // Проверка категории
    if (!formData.category.trim()) {
      newErrors.category = 'Категория обязательна для заполнения';
    }

    // Проверка размеров
    if (!formData.sizes || formData.sizes.length === 0) {
      newErrors.sizes = 'Необходимо указать хотя бы один размер';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  /**
   * Обработчик отправки формы
   * @param {Event} e - Событие отправки формы
   */
  const handleSubmit = async (e) => {
    e.preventDefault();
    
    if (!validateForm()) {
      return;
    }

    setLoading(true);
    
    try {
      const productData = {
        ...formData,
        price: parseFloat(formData.price)
      };

      let result;
      if (isEditing && initialData?.id) {
        result = await pizzaAPI.update(initialData.id, productData);
      } else {
        result = await pizzaAPI.create(productData);
      }

      if (onSubmit) {
        onSubmit(result);
      }
    } catch (error) {
      console.error('Ошибка при сохранении продукта:', error);
      alert('Произошла ошибка при сохранении продукта');
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="max-w-2xl mx-auto bg-white p-6 rounded-lg shadow-md">
      <h2 className="text-2xl font-bold text-gray-800 mb-6">
        {isEditing ? 'Редактировать продукт' : 'Добавить новый продукт'}
      </h2>

      <form onSubmit={handleSubmit} className="space-y-4">
        {/* Название */}
        <div>
          <label htmlFor="name" className="block text-sm font-medium text-gray-700 mb-1">
            Название *
          </label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            className={`w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-pizza-500 ${
              errors.name ? 'border-red-500' : 'border-gray-300'
            }`}
            placeholder="Введите название пиццы"
          />
          {errors.name && (
            <p className="text-red-500 text-sm mt-1">{errors.name}</p>
          )}
        </div>

        {/* Описание */}
        <div>
          <label htmlFor="description" className="block text-sm font-medium text-gray-700 mb-1">
            Описание *
          </label>
          <textarea
            id="description"
            name="description"
            value={formData.description}
            onChange={handleChange}
            rows={3}
            className={`w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-pizza-500 ${
              errors.description ? 'border-red-500' : 'border-gray-300'
            }`}
            placeholder="Введите описание пиццы"
          />
          {errors.description && (
            <p className="text-red-500 text-sm mt-1">{errors.description}</p>
          )}
        </div>

        {/* Цена */}
        <div>
          <label htmlFor="price" className="block text-sm font-medium text-gray-700 mb-1">
            Цена (лей) *
          </label>
          <input
            type="number"
            id="price"
            name="price"
            value={formData.price}
            onChange={handleChange}
            min="0"
            step="0.01"
            className={`w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-pizza-500 ${
              errors.price ? 'border-red-500' : 'border-gray-300'
            }`}
            placeholder="Введите цену"
          />
          {errors.price && (
            <p className="text-red-500 text-sm mt-1">{errors.price}</p>
          )}
        </div>

        {/* URL изображения */}
        <div>
          <label htmlFor="image" className="block text-sm font-medium text-gray-700 mb-1">
            URL изображения *
          </label>
          <input
            type="url"
            id="image"
            name="image"
            value={formData.image}
            onChange={handleChange}
            className={`w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-pizza-500 ${
              errors.image ? 'border-red-500' : 'border-gray-300'
            }`}
            placeholder="https://example.com/pizza.jpg"
          />
          {errors.image && (
            <p className="text-red-500 text-sm mt-1">{errors.image}</p>
          )}
        </div>

        {/* Категория */}
        <div>
          <label htmlFor="category" className="block text-sm font-medium text-gray-700 mb-1">
            Категория *
          </label>
          <select
            id="category"
            name="category"
            value={formData.category}
            onChange={handleChange}
            className={`w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-pizza-500 ${
              errors.category ? 'border-red-500' : 'border-gray-300'
            }`}
          >
            <option value="">Выберите категорию</option>
            {categories.map(category => (
              <option key={category} value={category}>
                {category}
              </option>
            ))}
          </select>
          {errors.category && (
            <p className="text-red-500 text-sm mt-1">{errors.category}</p>
          )}
        </div>

        {/* Размеры */}
        <div>
          <label htmlFor="sizes" className="block text-sm font-medium text-gray-700 mb-1">
            Размеры (см, через запятую) *
          </label>
          <input
            type="text"
            id="sizes"
            value={customSizes}
            onChange={handleSizesChange}
            className={`w-full px-3 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-pizza-500 ${
              errors.sizes ? 'border-red-500' : 'border-gray-300'
            }`}
            placeholder="30,40,50"
          />
          <p className="text-gray-500 text-sm mt-1">
            Текущие размеры: {formData.sizes.join(', ')} см
          </p>
          {errors.sizes && (
            <p className="text-red-500 text-sm mt-1">{errors.sizes}</p>
          )}
        </div>

        {/* Кнопки */}
        <div className="flex gap-4 pt-4">
          <button
            type="submit"
            disabled={loading}
            className={`flex-1 py-2 px-4 rounded-md font-medium transition-colors ${
              loading
                ? 'bg-gray-400 cursor-not-allowed'
                : 'bg-pizza-600 hover:bg-pizza-700 text-white'
            }`}
          >
            {loading 
              ? 'Сохранение...' 
              : (isEditing ? 'Обновить продукт' : 'Добавить продукт')
            }
          </button>
          
          {onCancel && (
            <button
              type="button"
              onClick={onCancel}
              disabled={loading}
              className="flex-1 bg-gray-500 text-white py-2 px-4 rounded-md hover:bg-gray-600 transition-colors font-medium disabled:opacity-50"
            >
              Отмена
            </button>
          )}
        </div>
      </form>
    </div>
  );
}

export default ProductForm;
