import axios from 'axios';

/**
 * Базовый URL для API mockapi.io
 * @constant {string}
 */
const BASE_URL = 'https://68d1388fe6c0cbeb39a3f8f9.mockapi.io';

/**
 * Экземпляр axios с базовой конфигурацией
 * @constant {Object}
 */
const api = axios.create({
  baseURL: BASE_URL,
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

/**
 * API сервис для работы с продуктами (пиццами)
 */
export const pizzaAPI = {
  /**
   * Получить все продукты с сервера
   * @returns {Promise<Array>} Массив продуктов
   * @throws {Error} Ошибка при загрузке данных
   */
  async getAll() {
    try {
      const response = await api.get('/products');
      return response.data;
    } catch (error) {
      console.error('Ошибка при загрузке продуктов:', error);
      throw new Error('Не удалось загрузить продукты');
    }
  },

  /**
   * Получить продукт по ID
   * @param {string|number} id - ID продукта
   * @returns {Promise<Object>} Объект продукта
   * @throws {Error} Ошибка при загрузке продукта
   */
  async getById(id) {
    try {
      const response = await api.get(`/products/${id}`);
      return response.data;
    } catch (error) {
      console.error('Ошибка при загрузке продукта:', error);
      throw new Error('Не удалось загрузить продукт');
    }
  },

  /**
   * Создать новый продукт
   * @param {Object} productData - Данные продукта
   * @returns {Promise<Object>} Созданный продукт
   * @throws {Error} Ошибка при создании продукта
   */
  async create(productData) {
    try {
      const response = await api.post('/products', productData);
      return response.data;
    } catch (error) {
      console.error('Ошибка при создании продукта:', error);
      throw new Error('Не удалось создать продукт');
    }
  },

  /**
   * Обновить продукт
   * @param {string|number} id - ID продукта
   * @param {Object} productData - Обновленные данные продукта
   * @returns {Promise<Object>} Обновленный продукт
   * @throws {Error} Ошибка при обновлении продукта
   */
  async update(id, productData) {
    try {
      const response = await api.put(`/products/${id}`, productData);
      return response.data;
    } catch (error) {
      console.error('Ошибка при обновлении продукта:', error);
      throw new Error('Не удалось обновить продукт');
    }
  },

  /**
   * Удалить продукт
   * @param {string|number} id - ID продукта
   * @returns {Promise<Object>} Результат удаления
   * @throws {Error} Ошибка при удалении продукта
   */
  async delete(id) {
    try {
      const response = await api.delete(`/products/${id}`);
      return response.data;
    } catch (error) {
      console.error('Ошибка при удалении продукта:', error);
      throw new Error('Не удалось удалить продукт');
    }
  },

  /**
   * Поиск продуктов по названию
   * @param {string} query - Поисковый запрос
   * @returns {Promise<Array>} Массив найденных продуктов
   * @throws {Error} Ошибка при поиске продуктов
   */
  async search(query) {
    try {
      const response = await api.get(`/products?search=${encodeURIComponent(query)}`);
      return response.data;
    } catch (error) {
      console.error('Ошибка при поиске продуктов:', error);
      throw new Error('Не удалось выполнить поиск');
    }
  }
};

export default api;
