import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { MainLayout } from './components';
import HomePage from './pages/HomePage';
import CartPage from './pages/CartPage';
import AboutPage from './pages/AboutPage';
import ProductPage from './pages/ProductPage';
import AddProductPage from './pages/AddProductPage';
import EditProductPage from './pages/EditProductPage';
import NotFoundPage from './pages/NotFoundPage';

/**
 * Главный компонент приложения с настроенной маршрутизацией
 * @returns {JSX.Element} JSX элемент приложения
 */
function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<MainLayout />}>
          <Route index element={<HomePage />} />
          <Route path="cart" element={<CartPage />} />
          <Route path="about" element={<AboutPage />} />
          <Route path="product/:id" element={<ProductPage />} />
          <Route path="add-product" element={<AddProductPage />} />
          <Route path="edit-product/:id" element={<EditProductPage />} />
          <Route path="*" element={<NotFoundPage />} />
        </Route>
      </Routes>
    </Router>
  );
}

export default App
