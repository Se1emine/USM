/**
 * Компонент поиска пицц
 * @param {Object} props - Пропсы компонента
 * @param {Function} props.onSearch - Функция обработчик поиска
 * @param {boolean} props.disabled - Отключить поле поиска
 * @returns {JSX.Element} JSX элемент поля поиска
 */
function Search({ onSearch, disabled = false }) {
  /**
   * Обработчик изменения значения в поле поиска
   * @param {Event} e - Событие изменения input
   */
  const handleSearchChange = (e) => {
    onSearch(e.target.value);
  };

  return (
    <div className="mb-6">
      <div className="relative max-w-md mx-auto">
        <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
          <svg 
            className="h-5 w-5 text-gray-400" 
            fill="none" 
            stroke="currentColor" 
            viewBox="0 0 24 24"
          >
            <path 
              strokeLinecap="round" 
              strokeLinejoin="round" 
              strokeWidth={2} 
              d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" 
            />
          </svg>
        </div>
        
        <input
          type="text"
          placeholder="Поиск пиццы..."
          onChange={handleSearchChange}
          disabled={disabled}
          className={`block w-full pl-10 pr-3 py-2 border border-gray-300 rounded-md leading-5 bg-white placeholder-gray-500 focus:outline-none focus:placeholder-gray-400 focus:ring-1 focus:ring-pizza-500 focus:border-pizza-500 ${
            disabled ? 'opacity-50 cursor-not-allowed' : ''
          }`}
        />
      </div>
    </div>
  );
}

export default Search;
