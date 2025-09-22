import Skeleton from 'react-loading-skeleton';
import 'react-loading-skeleton/dist/skeleton.css';

/**
 * Компонент скелетона для карточки пиццы
 * Отображается во время загрузки данных
 * @returns {JSX.Element} JSX элемент скелетона
 */
function PizzaSkeleton() {
  return (
    <div className="bg-white rounded-lg shadow-md overflow-hidden">
      {/* Изображение */}
      <div className="h-48 bg-gray-200">
        <Skeleton height={192} />
      </div>
      
      {/* Содержимое карточки */}
      <div className="p-4">
        {/* Название */}
        <div className="mb-2">
          <Skeleton height={24} width="80%" />
        </div>
        
        {/* Описание */}
        <div className="mb-3">
          <Skeleton height={16} count={2} />
        </div>
        
        {/* Категория */}
        <div className="mb-3">
          <Skeleton height={20} width="60%" />
        </div>
        
        {/* Размеры */}
        <div className="mb-4">
          <Skeleton height={16} width="40%" className="mb-2" />
          <div className="flex gap-2">
            <Skeleton height={32} width={60} />
            <Skeleton height={32} width={60} />
            <Skeleton height={32} width={60} />
          </div>
        </div>
        
        {/* Цена и кнопка */}
        <div className="flex justify-between items-center">
          <Skeleton height={24} width={80} />
          <Skeleton height={40} width={120} />
        </div>
      </div>
    </div>
  );
}

/**
 * Компонент списка скелетонов
 * @param {Object} props - Пропсы компонента
 * @param {number} props.count - Количество скелетонов для отображения
 * @returns {JSX.Element} JSX элемент списка скелетонов
 */
export function PizzaSkeletonList({ count = 8 }) {
  return (
    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
      {Array.from({ length: count }, (_, index) => (
        <PizzaSkeleton key={index} />
      ))}
    </div>
  );
}

export default PizzaSkeleton;
