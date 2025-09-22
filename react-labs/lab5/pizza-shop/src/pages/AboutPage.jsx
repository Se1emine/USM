/**
 * Страница "О нас" - краткая информация о магазине
 * @returns {JSX.Element} JSX элемент страницы "О нас"
 */
function AboutPage() {
  return (
    <div className="container mx-auto px-4 py-8">
      <h1 className="text-3xl font-bold text-gray-800 mb-8">О нас</h1>
      
      <div className="grid md:grid-cols-2 gap-8">
        <div className="bg-white rounded-lg shadow-md p-6">
          <h2 className="text-2xl font-semibold text-gray-800 mb-4">
            Наша история
          </h2>
          <p className="text-gray-600 mb-4">
            Добро пожаловать в нашу пиццерию! Мы готовим самую вкусную пиццу в городе 
            уже более 10 лет. Наша команда профессиональных поваров использует только 
            свежие ингредиенты и традиционные рецепты.
          </p>
          <p className="text-gray-600">
            Каждая пицца готовится с любовью и вниманием к деталям, чтобы подарить 
            вам незабываемый вкус настоящей итальянской пиццы.
          </p>
        </div>
        
        <div className="bg-white rounded-lg shadow-md p-6">
          <h2 className="text-2xl font-semibold text-gray-800 mb-4">
            Наши преимущества
          </h2>
          <ul className="space-y-3">
            <li className="flex items-center text-gray-600">
              <span className="text-green-500 mr-2">✓</span>
              Свежие ингредиенты каждый день
            </li>
            <li className="flex items-center text-gray-600">
              <span className="text-green-500 mr-2">✓</span>
              Быстрая доставка по городу
            </li>
            <li className="flex items-center text-gray-600">
              <span className="text-green-500 mr-2">✓</span>
              Большой выбор пицц на любой вкус
            </li>
            <li className="flex items-center text-gray-600">
              <span className="text-green-500 mr-2">✓</span>
              Доступные цены
            </li>
            <li className="flex items-center text-gray-600">
              <span className="text-green-500 mr-2">✓</span>
              Дружелюбный персонал
            </li>
          </ul>
        </div>
      </div>
      
      <div className="bg-white rounded-lg shadow-md p-6 mt-8">
        <h2 className="text-2xl font-semibold text-gray-800 mb-4">
          Контактная информация
        </h2>
        <div className="grid md:grid-cols-3 gap-6">
          <div className="text-center">
            <div className="text-3xl mb-2">📍</div>
            <h3 className="font-semibold text-gray-800 mb-1">Адрес</h3>
            <p className="text-gray-600">ул. Пиццы, 123<br />г. Москва</p>
          </div>
          <div className="text-center">
            <div className="text-3xl mb-2">📞</div>
            <h3 className="font-semibold text-gray-800 mb-1">Телефон</h3>
            <p className="text-gray-600">+7 (999) 123-45-67</p>
          </div>
          <div className="text-center">
            <div className="text-3xl mb-2">⏰</div>
            <h3 className="font-semibold text-gray-800 mb-1">Режим работы</h3>
            <p className="text-gray-600">Ежедневно<br />10:00 - 23:00</p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AboutPage;
