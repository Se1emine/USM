import { Slider, PizzaList } from '../components';

/**
 * Главная страница - отображает слайдер и список всех товаров
 * @returns {JSX.Element} JSX элемент главной страницы
 */
function HomePage() {
  return (
    <>
      <Slider />
      <PizzaList />
    </>
  );
}

export default HomePage;
