import { useState } from 'react'
import Header from './components/Header'
import Card from './components/Card'
import Button from './components/Button'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Header title="Vite + React (Tailwind)" subtitle="Стилизация с помощью Tailwind CSS" />
      <Card title="Счётчик">
        <Button onClick={() => setCount((c) => c + 1)}>count is {count}</Button>
        <p className="mt-2 text-sm text-gray-500">
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </Card>
      <Card title="Информация">
        <p className="text-gray-500">
          Демонстрация Tailwind CSS с utility-классами
        </p>
      </Card>
    </>
  )
}

export default App
