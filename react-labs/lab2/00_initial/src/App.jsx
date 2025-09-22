import { useState } from 'react'
import Header from './components/Header'
import Card from './components/Card'
import Button from './components/Button'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Header title="Vite + React" subtitle="Базовая версия без стилизации" />
      <Card title="Счётчик">
        <Button onClick={() => setCount((c) => c + 1)}>count is {count}</Button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </Card>
      <Card title="Информация">
        <p>
          Это демонстрация базовых компонентов без дополнительной стилизации
        </p>
      </Card>
    </>
  )
}

export default App
