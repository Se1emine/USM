import { useNavigate } from 'react-router-dom';
import ProductForm from '../components/ProductForm';

/**
 * Страница добавления нового продукта
 * @returns {JSX.Element} JSX элемент страницы добавления продукта
 */
function AddProductPage() {
  const navigate = useNavigate();

  /**
   * Обработчик успешного добавления продукта
   * @param {Object} newProduct - Созданный продукт
   */
  const handleProductAdded = (newProduct) => {
    console.log('Продукт добавлен:', newProduct);
    alert('Продукт успешно добавлен!');
    navigate('/');
  };

  /**
   * Обработчик отмены добавления
   */
  const handleCancel = () => {
    navigate('/');
  };

  return (
    <div className="container mx-auto px-4 py-8">
      <ProductForm
        onSubmit={handleProductAdded}
        onCancel={handleCancel}
        isEditing={false}
      />
    </div>
  );
}

export default AddProductPage;
