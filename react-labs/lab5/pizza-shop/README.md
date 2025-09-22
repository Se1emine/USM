# 🍕 Пиццерия "Mamma Mia" - Интернет-магазин

Современный интернет-магазин пиццерии, разработанный на React с использованием React Router v7, Vite и Tailwind CSS.

## 📋 Содержание

- [Инструкции по запуску](#-инструкции-по-запуску)
- [Описание лабораторной работы](#-описание-лабораторной-работы)
- [Документация проекта](#-документация-проекта)
- [Примеры использования](#-примеры-использования)
- [Контрольные вопросы](#-контрольные-вопросы)
- [Источники](#-источники)
- [Дополнительная информация](#-дополнительная-информация)

## 🚀 Инструкции по запуску

### Предварительные требования

- Node.js версии 16.0 или выше
- npm или yarn

### Установка и запуск

1. **Клонирование репозитория**
   ```bash
   git clone <repository-url>
   cd pizza-shop
   ```

2. **Установка зависимостей**
   ```bash
   npm install
   ```

3. **Запуск в режиме разработки**
   ```bash
   npm run dev
   ```
   Приложение будет доступно по адресу: `http://localhost:5173`

4. **Сборка для продакшена**
   ```bash
   npm run build
   ```

5. **Предварительный просмотр продакшен-сборки**
   ```bash
   npm run preview
   ```

## 📚 Описание лабораторной работы

### Цель работы
Разработать интернет-магазин пиццерии с использованием React, демонстрирующий:
- Работу с компонентами и их композицией
- Управление состоянием с помощью хуков
- Обработку пользовательских событий
- Рендеринг списков и условный рендеринг
- **Маршрутизацию с React Router v7**
- **Динамические маршруты и валидацию параметров**
- **Layout-компоненты для общего макета**

### Задачи
1. **Подготовка среды разработки** - создание React-приложения с Vite
2. **Создание мок-данных** - файл с данными о пиццах
3. **Разработка базовых компонентов** - Header, Footer
4. **Создание функциональных компонентов** - PizzaCard, PizzaList
5. **Реализация интерактивности** - слайдер, поиск
6. **Настройка маршрутизации** - React Router v7, динамические маршруты
7. **Создание страниц** - главная, корзина, о нас, товар, 404
8. **Валидация параметров** - проверка корректности ID товара
9. **Документирование кода** - JSDoc комментарии

### Технологический стек
- **React 19** - библиотека для создания пользовательских интерфейсов
- **React Router v7** - библиотека для маршрутизации
- **Vite** - инструмент сборки и dev-сервер
- **Tailwind CSS** - CSS-фреймворк для стилизации
- **JavaScript ES6+** - современный синтаксис JavaScript

## 📖 Документация проекта

### Структура проекта

```
pizza-shop/
├── public/                 # Статические файлы
├── src/
│   ├── components/         # React компоненты
│   │   ├── Header.jsx     # Заголовок с навигацией (обновлен с Router Link)
│   │   ├── Footer.jsx     # Подвал сайта
│   │   ├── MainLayout.jsx # Layout компонент с Header/Footer
│   │   ├── PizzaCard.jsx  # Карточка пиццы (добавлены ссылки)
│   │   ├── PizzaList.jsx  # Список пицц
│   │   ├── Slider.jsx     # Слайдер промо-материалов
│   │   ├── Search.jsx     # Компонент поиска
│   │   └── index.js       # Экспорт компонентов
│   ├── pages/             # Страницы приложения (новая папка)
│   │   ├── HomePage.jsx   # Главная страница
│   │   ├── CartPage.jsx   # Страница корзины
│   │   ├── AboutPage.jsx  # Страница "О нас"
│   │   ├── ProductPage.jsx # Страница товара с валидацией
│   │   └── NotFoundPage.jsx # Страница 404
│   ├── data/
│   │   └── pizza.json     # Данные о пиццах
│   ├── App.jsx            # Главный компонент с маршрутизацией
│   ├── index.css          # Глобальные стили
│   └── main.jsx           # Точка входа
├── tailwind.config.js     # Конфигурация Tailwind
├── postcss.config.js      # Конфигурация PostCSS
└── package.json           # Зависимости проекта
```

### Основные компоненты

#### MainLayout
Основной Layout компонент для всех страниц.
- Включает Header и Footer
- Использует `<Outlet />` для вложенного контента
- Общий макет для всех страниц

#### Header
Отображает логотип, название и навигационное меню.
- Адаптивный дизайн
- Мобильное меню (hamburger)
- **React Router Link** для навигации
- Ссылки на главную, корзину и страницу "О нас"

#### PizzaCard
Карточка отдельной пиццы с возможностью выбора размера.
- Управление состоянием выбранного размера
- Интерактивные кнопки размеров
- Кнопка добавления в корзину
- **Ссылка на страницу товара** через Router Link

#### Страницы (Pages)

**HomePage** - Главная страница
- Отображает слайдер и список пицц
- Маршрут: `/`

**ProductPage** - Страница товара
- Детальная информация о пицце
- Выбор размера с динамическим ценообразованием
- Валидация параметра ID
- Маршрут: `/product/:id`

**CartPage** - Страница корзины
- Отображение товаров в корзине
- Маршрут: `/cart`

**AboutPage** - Страница "О нас"
- Информация о магазине
- Контактные данные
- Маршрут: `/about`

**NotFoundPage** - Страница 404
- Отображается при неверных маршрутах
- Кнопки навигации "На главную" и "Назад"
- Маршрут: `*`

#### Slider
Автоматический слайдер промо-материалов.
- Автопереключение каждые 3 секунды
- Ручное управление кнопками
- Индикаторы текущего слайда

#### Search
Компонент поиска с живой фильтрацией.
- Поиск по названию, описанию и категории
- Иконка поиска
- Мгновенная фильтрация результатов

### Маршрутизация

Приложение использует **React Router v7** с следующими маршрутами:

```jsx
<Routes>
  <Route path="/" element={<MainLayout />}>
    <Route index element={<HomePage />} />
    <Route path="cart" element={<CartPage />} />
    <Route path="about" element={<AboutPage />} />
    <Route path="product/:id" element={<ProductPage />} />
    <Route path="*" element={<NotFoundPage />} />
  </Route>
</Routes>
```

## 💡 Примеры использования

### 1. Настройка маршрутизации в App.jsx

```jsx
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { MainLayout } from './components';
import HomePage from './pages/HomePage';
import CartPage from './pages/CartPage';
import AboutPage from './pages/AboutPage';
import ProductPage from './pages/ProductPage';
import NotFoundPage from './pages/NotFoundPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<MainLayout />}>
          <Route index element={<HomePage />} />
          <Route path="cart" element={<CartPage />} />
          <Route path="about" element={<AboutPage />} />
          <Route path="product/:id" element={<ProductPage />} />
          <Route path="*" element={<NotFoundPage />} />
        </Route>
      </Routes>
    </Router>
  );
}
```

### 2. Layout компонент с Outlet

```jsx
import Header from './Header';
import Footer from './Footer';
import { Outlet } from 'react-router-dom';

function MainLayout() {
  return (
    <div className="min-h-screen bg-gray-50 flex flex-col">
      <Header />
      <main className="flex-1">
        <Outlet /> {/* Здесь отображается содержимое страниц */}
      </main>
      <Footer />
    </div>
  );
}
```

### 3. Динамический маршрут с валидацией

```jsx
import { useParams, Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import pizzaData from '../data/pizza.json';
import NotFoundPage from './NotFoundPage';

function ProductPage() {
  const { id } = useParams(); // Получаем параметр из URL
  const [pizza, setPizza] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Валидация параметра id
    const pizzaId = parseInt(id);
    
    // Проверяем, является ли параметр числом
    if (isNaN(pizzaId) || pizzaId <= 0) {
      setLoading(false);
      return;
    }

    // Ищем пиццу по id
    const foundPizza = pizzaData.find(p => p.id === pizzaId);
    
    if (foundPizza) {
      setPizza(foundPizza);
    }
    
    setLoading(false);
  }, [id]);

  // Если пицца не найдена, показываем 404
  if (!loading && !pizza) {
    return <NotFoundPage />;
  }

  return (
    <div>
      {pizza && (
        <>
          <h1>{pizza.name}</h1>
          <p>{pizza.description}</p>
          <Link to="/">← Назад к меню</Link>
        </>
      )}
    </div>
  );
}
```

### 4. Навигация с Link компонентами

```jsx
import { Link } from 'react-router-dom';

function Header() {
  return (
    <header>
      <Link to="/">
        <h1>Пиццерия "Mamma Mia"</h1>
      </Link>
      
      <nav>
        <Link to="/">Меню</Link>
        <Link to="/about">О нас</Link>
        <Link to="/cart">🛒 Корзина</Link>
      </nav>
    </header>
  );
}
```

### 5. Использование хука useState в PizzaCard

```jsx
import { useState } from 'react';

function PizzaCard({ pizza }) {
  // Инициализация состояния с первым размером из массива
  const [selectedSize, setSelectedSize] = useState(pizza.sizes[0]);

  // Обработчик изменения размера
  const handleSizeChange = (size) => {
    setSelectedSize(size);
  };

  return (
    <div>
      {/* Отображение кнопок размеров */}
      {pizza.sizes.map((size) => (
        <button
          key={size}
          onClick={() => handleSizeChange(size)}
          className={selectedSize === size ? 'active' : ''}
        >
          {size} см.
        </button>
      ))}
    </div>
  );
}
```

### 2. Использование useEffect в PizzaList

```jsx
import { useState, useEffect } from "react";
import pizzaData from "../data/pizza.json";

function PizzaList() {
  const [pizzas, setPizzas] = useState([]);
  const [filteredPizzas, setFilteredPizzas] = useState([]);

  // Загрузка данных при монтировании компонента
  useEffect(() => {
    setPizzas(pizzaData);
    setFilteredPizzas(pizzaData);
  }, []); // Пустой массив зависимостей = выполнится один раз

  return (
    <div>
      {filteredPizzas.map((pizza) => (
        <PizzaCard key={pizza.id} pizza={pizza} />
      ))}
    </div>
  );
}
```

### 3. Рендеринг списков с методом map()

```jsx
// Рендеринг списка пицц
{pizzas.map((pizza) => (
  <PizzaCard key={pizza.id} pizza={pizza} />
))}

// Рендеринг кнопок размеров
{pizza.sizes.map((size) => (
  <button key={size} onClick={() => handleSizeChange(size)}>
    {size} см.
  </button>
))}

// Рендеринг слайдов
{slides.map((slide, index) => (
  <div key={slide.id} className={index === currentSlide ? 'active' : 'hidden'}>
    {slide.content}
  </div>
))}
```

### 4. Структура данных pizza.json

```json
[
  {
    "id": 1,
    "name": "Маргарита",
    "description": "Соус, сыр, помидоры",
    "price": 200,
    "image": "https://example.com/pizza.jpg",
    "category": "Сырная",
    "sizes": [30, 40, 50]
  }
]
```

## ❓ Контрольные вопросы

### 1. Что такое динамические маршруты в React Router и как их использовать?

**Динамические маршруты** - это маршруты, которые содержат переменные параметры, обозначаемые двоеточием `:`.

**Синтаксис:**
```jsx
<Route path="/product/:id" element={<ProductPage />} />
<Route path="/user/:userId/posts/:postId" element={<PostPage />} />
```

**Получение параметров с помощью useParams:**
```jsx
import { useParams } from 'react-router-dom';

function ProductPage() {
  const { id } = useParams(); // Получаем параметр id из URL
  
  // Используем параметр для загрузки данных
  const product = products.find(p => p.id === parseInt(id));
  
  return <div>{product?.name}</div>;
}
```

**Примеры URL:**
- `/product/1` → `{ id: "1" }`
- `/product/123` → `{ id: "123" }`
- `/user/5/posts/42` → `{ userId: "5", postId: "42" }`

### 2. Как реализовать Layout-компоненты в приложении с маршрутизацией?

**Layout-компоненты** позволяют создать общий макет для нескольких страниц.

**Создание Layout компонента:**
```jsx
import { Outlet } from 'react-router-dom';
import Header from './Header';
import Footer from './Footer';

function MainLayout() {
  return (
    <div className="app-layout">
      <Header />
      <main>
        <Outlet /> {/* Здесь отображается содержимое дочерних маршрутов */}
      </main>
      <Footer />
    </div>
  );
}
```

**Настройка вложенных маршрутов:**
```jsx
<Routes>
  <Route path="/" element={<MainLayout />}>
    <Route index element={<HomePage />} />
    <Route path="about" element={<AboutPage />} />
    <Route path="contact" element={<ContactPage />} />
  </Route>
</Routes>
```

**Преимущества:**
- Общий Header/Footer для всех страниц
- Переиспользование макета
- Лучшая организация кода

### 3. Какие методы проверки параметров маршрута можно использовать?

**Методы валидации параметров:**

**1. Проверка типа данных:**
```jsx
function ProductPage() {
  const { id } = useParams();
  
  // Проверка, что id - число
  const productId = parseInt(id);
  if (isNaN(productId) || productId <= 0) {
    return <NotFoundPage />;
  }
}
```

**2. Проверка существования данных:**
```jsx
function ProductPage() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [loading, setLoading] = useState(true);
  
  useEffect(() => {
    const foundProduct = products.find(p => p.id === parseInt(id));
    
    if (!foundProduct) {
      setLoading(false);
      return;
    }
    
    setProduct(foundProduct);
    setLoading(false);
  }, [id]);
  
  if (!loading && !product) {
    return <NotFoundPage />;
  }
}
```

**3. Использование регулярных выражений в маршрутах:**
```jsx
// Только числовые ID
<Route path="/product/:id(\d+)" element={<ProductPage />} />
```

**4. Проверка формата параметров:**
```jsx
function validateEmail(email) {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email);
}

function UserPage() {
  const { email } = useParams();
  
  if (!validateEmail(email)) {
    return <NotFoundPage />;
  }
}
```

### 4. Как настроить отображение страницы 404 при некорректном маршруте?

**Создание компонента 404:**
```jsx
import { Link } from 'react-router-dom';

function NotFoundPage() {
  return (
    <div className="not-found">
      <h1>404 - Страница не найдена</h1>
      <p>Запрашиваемая страница не существует</p>
      <Link to="/">На главную</Link>
      <button onClick={() => window.history.back()}>
        Назад
      </button>
    </div>
  );
}
```

**Настройка catch-all маршрута:**
```jsx
<Routes>
  <Route path="/" element={<MainLayout />}>
    <Route index element={<HomePage />} />
    <Route path="about" element={<AboutPage />} />
    <Route path="product/:id" element={<ProductPage />} />
    {/* Catch-all маршрут - должен быть последним */}
    <Route path="*" element={<NotFoundPage />} />
  </Route>
</Routes>
```

**Программное перенаправление на 404:**
```jsx
import { Navigate } from 'react-router-dom';

function ProductPage() {
  const { id } = useParams();
  const product = products.find(p => p.id === parseInt(id));
  
  // Если товар не найден, перенаправляем на 404
  if (!product) {
    return <Navigate to="/404" replace />;
  }
  
  return <div>{product.name}</div>;
}
```

### 5. Как использовать useState для управления состоянием?

**useState** - это хук React для добавления состояния в функциональные компоненты.

**Синтаксис:**
```jsx
const [state, setState] = useState(initialValue);
```

**Примеры использования:**

```jsx
// Простое состояние
const [count, setCount] = useState(0);

// Состояние объекта
const [user, setUser] = useState({ name: '', email: '' });

// Состояние массива
const [items, setItems] = useState([]);

// Обновление состояния
setCount(count + 1);                    // Прямое значение
setCount(prevCount => prevCount + 1);   // Функция обновления
```

**В нашем проекте:**
- `selectedSize` в PizzaCard для отслеживания выбранного размера
- `currentSlide` в Slider для текущего слайда
- `pizzas` и `filteredPizzas` в PizzaList для данных

### 2. Как работает useEffect?

**useEffect** - хук для выполнения побочных эффектов в функциональных компонентах.

**Синтаксис:**
```jsx
useEffect(() => {
  // Код эффекта
  return () => {
    // Функция очистки (cleanup)
  };
}, [dependencies]); // Массив зависимостей
```

**Варианты использования:**

```jsx
// Выполняется после каждого рендера
useEffect(() => {
  console.log('После каждого рендера');
});

// Выполняется только при монтировании
useEffect(() => {
  console.log('Только при монтировании');
}, []);

// Выполняется при изменении зависимостей
useEffect(() => {
  console.log('При изменении count');
}, [count]);

// С функцией очистки
useEffect(() => {
  const timer = setInterval(() => {}, 1000);
  return () => clearInterval(timer); // Очистка
}, []);
```

**В нашем проекте:**
- Загрузка данных пицц при монтировании PizzaList
- Автоматическое переключение слайдов в Slider
- Установка и очистка таймеров

### 3. С помощью какого метода можно рендерить списки элементов в React?

**Метод map()** - основной способ рендеринга списков в React.

**Синтаксис:**
```jsx
{array.map((item, index) => (
  <Component key={item.id} data={item} />
))}
```

**Важные правила:**

1. **Обязательный key prop:**
```jsx
// ✅ Правильно - уникальный key
{pizzas.map(pizza => (
  <PizzaCard key={pizza.id} pizza={pizza} />
))}

// ❌ Неправильно - index как key (если порядок может меняться)
{pizzas.map((pizza, index) => (
  <PizzaCard key={index} pizza={pizza} />
))}
```

2. **Условный рендеринг списков:**
```jsx
{pizzas.length > 0 ? (
  pizzas.map(pizza => <PizzaCard key={pizza.id} pizza={pizza} />)
) : (
  <p>Пиццы не найдены</p>
)}
```

3. **Фильтрация перед рендерингом:**
```jsx
{pizzas
  .filter(pizza => pizza.category === 'Мясная')
  .map(pizza => <PizzaCard key={pizza.id} pizza={pizza} />)
}
```

**В нашем проекте используется для:**
- Отображения списка пицц
- Рендеринга кнопок размеров
- Создания слайдов
- Отображения индикаторов слайдера

## 📚 Источники

### Документация
### Руководства по React Router
- [React Router Tutorial](https://reactrouter.com/en/main/start/tutorial) - официальный туториал
- [React Router Concepts](https://reactrouter.com/en/main/start/concepts) - основные концепции
- [React Router v7 Documentation](https://reactrouter.com/en/main) - официальная документация React Router v7
- [Google Fonts](https://fonts.google.com/) - шрифт Inter

## 🔧 Дополнительная информация

### Особенности реализации

1. **Маршрутизация**
   - **React Router v7** для навигации между страницами
   - **Динамические маршруты** с параметрами (например, `/product/:id`)
   - **Layout-компоненты** для общего макета страниц
   - **Валидация параметров** маршрутов с отображением 404
   - **Nested routes** для организации структуры приложения

2. **Адаптивный дизайн**
   - Мобильная навигация с hamburger меню
   - Responsive grid для карточек пицц
   - Оптимизация для различных экранов

3. **Производительность**
   - Оптимизированные изображения
   - Lazy loading (можно добавить)
   - Минимальные перерендеры

4. **Доступность (A11y)**
   - Семантическая разметка
   - ARIA-атрибуты для кнопок
   - Keyboard navigation

5. **Кастомизация Tailwind**
   ```js
   // tailwind.config.js
   theme: {
     extend: {
       colors: {
         pizza: {
           50: '#fef7ed',
           // ... другие оттенки
           900: '#782e0f',
         }
       }
     }
   }
   ```

### Возможные улучшения

- 🛒 **Функциональная корзина** - добавление/удаление товаров, подсчет суммы
- 💳 **Оформление заказа** - форма с данными клиента
- 🔐 **Авторизация** - регистрация и вход пользователей с защищенными маршрутами
- 🔍 **Расширенный поиск** - фильтры по категориям, цене, размерам
- 📱 **PWA** - превращение в Progressive Web App
- 🌐 **Интернационализация** - поддержка нескольких языков
- 📊 **Аналитика** - отслеживание действий пользователей
- 🚀 **Lazy Loading** - подгрузка страниц по требованию
- 🎨 **Темная тема** - переключение между светлой и темной темами
- 📄 **Пагинация** - разбивка каталога на страницы

### Команды разработки

```bash
# Линтинг кода
npm run lint

# Форматирование кода
npm run format

# Тестирование (если настроено)
npm run test

# Анализ bundle size
npm run analyze
```

---

**Автор:** [Ваше имя]  
**Дата создания:** 22 сентября 2024  
**Последнее обновление:** 22 сентября 2024 (добавлена маршрутизация React Router v7)  
**Версия:** 2.0.0