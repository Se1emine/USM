import { useState } from 'react'
import './App.scss'
import Header from './components/Header'
import Card from './components/Card'
import Button from './components/Button'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Header title="Vite + React (SCSS)" subtitle="SCSS: переменные, вложенность, миксины" />
      <Card title="Счётчик">
        <Button onClick={() => setCount((c) => c + 1)}>count is {count}</Button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </Card>
      <Card title="Информация">
        <p className="info-text">
          Демонстрация SCSS с переменными и миксинами
        </p>
      </Card>
    </>
  )
}

export default App
