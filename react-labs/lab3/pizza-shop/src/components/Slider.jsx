import { useState, useEffect } from 'react';

/**
 * Компонент слайдера для отображения промо-материалов
 * @returns {JSX.Element} JSX элемент слайдера
 */
function Slider() {
  const [currentSlide, setCurrentSlide] = useState(0);

  // Данные для слайдов
  const slides = [
    {
      id: 1,
      title: "Добро пожаловать в Mamma Mia!",
      subtitle: "Лучшая пицца в городе",
      image: "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=1200&h=400&fit=crop",
      bgColor: "bg-pizza-600"
    },
    {
      id: 2,
      title: "Свежие ингредиенты",
      subtitle: "Только натуральные продукты",
      image: "https://images.unsplash.com/photo-1571997478779-2adcbbe9ab2f?w=1200&h=400&fit=crop",
      bgColor: "bg-green-600"
    },
    {
      id: 3,
      title: "Быстрая доставка",
      subtitle: "Горячая пицца за 30 минут",
      image: "https://images.unsplash.com/photo-1565299624946-b28f40a0ca4b?w=1200&h=400&fit=crop",
      bgColor: "bg-blue-600"
    }
  ];

  /**
   * Переключение на следующий слайд
   */
  const nextSlide = () => {
    setCurrentSlide((prev) => (prev + 1) % slides.length);
  };

  /**
   * Переключение на предыдущий слайд
   */
  const prevSlide = () => {
    setCurrentSlide((prev) => (prev - 1 + slides.length) % slides.length);
  };

  /**
   * Автоматическое переключение слайдов каждые 3 секунды
   */
  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentSlide((prev) => (prev + 1) % slides.length);
    }, 3000);

    return () => clearInterval(interval);
  }, [slides.length]);

  return (
    <div className="relative h-64 md:h-80 overflow-hidden">
      {slides.map((slide, index) => (
        <div
          key={slide.id}
          className={`absolute inset-0 transition-transform duration-500 ease-in-out ${
            index === currentSlide ? 'translate-x-0' : 'translate-x-full'
          } ${index < currentSlide ? '-translate-x-full' : ''}`}
        >
          <div className={`${slide.bgColor} h-full flex items-center justify-center text-white relative`}>
            <div 
              className="absolute inset-0 bg-cover bg-center opacity-30"
              style={{ backgroundImage: `url(${slide.image})` }}
            ></div>
            
            <div className="relative z-10 text-center px-4">
              <h2 className="text-3xl md:text-4xl font-bold mb-2">
                {slide.title}
              </h2>
              <p className="text-lg md:text-xl">
                {slide.subtitle}
              </p>
            </div>
          </div>
        </div>
      ))}

      {/* Кнопка "Назад" */}
      <button
        onClick={prevSlide}
        className="absolute left-4 top-1/2 transform -translate-y-1/2 bg-black bg-opacity-50 text-white p-2 rounded-full hover:bg-opacity-75 transition-opacity"
        aria-label="Предыдущий слайд"
      >
        <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M15 19l-7-7 7-7" />
        </svg>
      </button>

      {/* Кнопка "Вперед" */}
      <button
        onClick={nextSlide}
        className="absolute right-4 top-1/2 transform -translate-y-1/2 bg-black bg-opacity-50 text-white p-2 rounded-full hover:bg-opacity-75 transition-opacity"
        aria-label="Следующий слайд"
      >
        <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M9 5l7 7-7 7" />
        </svg>
      </button>

      {/* Индикаторы слайдов */}
      <div className="absolute bottom-4 left-1/2 transform -translate-x-1/2 flex space-x-2">
        {slides.map((_, index) => (
          <button
            key={index}
            onClick={() => setCurrentSlide(index)}
            className={`w-3 h-3 rounded-full transition-colors ${
              index === currentSlide ? 'bg-white' : 'bg-white bg-opacity-50'
            }`}
            aria-label={`Перейти к слайду ${index + 1}`}
          />
        ))}
      </div>
    </div>
  );
}

export default Slider;
