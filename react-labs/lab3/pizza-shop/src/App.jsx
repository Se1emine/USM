import { Header, Footer, Slider, PizzaList } from './components';

/**
 * Главный компонент приложения
 * @returns {JSX.Element} JSX элемент приложения
 */
function App() {
  return (
    <div className="min-h-screen bg-gray-50 flex flex-col">
      <Header />
      <Slider />
      
      <main className="flex-1">
        <PizzaList />
      </main>
      
      <Footer />
    </div>
  )
}

export default App
