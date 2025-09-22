import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { pizzaAPI } from '../services/api';
import ProductForm from '../components/ProductForm';

/**
 * Страница редактирования продукта
 * @returns {JSX.Element} JSX элемент страницы редактирования продукта
 */
function EditProductPage() {
  const { id } = useParams();
  const navigate = useNavigate();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  /**
   * Загрузка данных продукта для редактирования
   */
  useEffect(() => {
    const fetchProduct = async () => {
      try {
        setLoading(true);
        setError(null);
        const data = await pizzaAPI.getById(id);
        setProduct(data);
      } catch (err) {
        setError(err.message);
        console.error('Ошибка загрузки продукта:', err);
      } finally {
        setLoading(false);
      }
    };

    if (id) {
      fetchProduct();
    }
  }, [id]);

  /**
   * Обработчик успешного обновления продукта
   * @param {Object} updatedProduct - Обновленный продукт
   */
  const handleProductUpdated = (updatedProduct) => {
    console.log('Продукт обновлен:', updatedProduct);
    alert('Продукт успешно обновлен!');
    navigate('/');
  };

  /**
   * Обработчик отмены редактирования
   */
  const handleCancel = () => {
    navigate('/');
  };

  // Показываем загрузку
  if (loading) {
    return (
      <div className="container mx-auto px-4 py-8">
        <div className="text-center">
          <div className="inline-block animate-spin rounded-full h-8 w-8 border-b-2 border-pizza-600"></div>
          <p className="mt-2 text-gray-600">Загрузка данных продукта...</p>
        </div>
      </div>
    );
  }

  // Показываем ошибку
  if (error) {
    return (
      <div className="container mx-auto px-4 py-8">
        <div className="text-center">
          <div className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded mb-4">
            <p className="font-bold">Ошибка загрузки</p>
            <p>{error}</p>
          </div>
          <button
            onClick={() => navigate('/')}
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
          >
            Вернуться к списку
          </button>
        </div>
      </div>
    );
  }

  // Показываем форму редактирования
  return (
    <div className="container mx-auto px-4 py-8">
      <ProductForm
        initialData={product}
        onSubmit={handleProductUpdated}
        onCancel={handleCancel}
        isEditing={true}
      />
    </div>
  );
}

export default EditProductPage;
