import { useState } from 'react'
import Header from './components/Header'
import Card from './components/Card'
import Button from './components/Button'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="container mx-auto p-8">
      <Header title="Vite + React (shadcn/ui)" subtitle="Компонентная библиотека shadcn/ui" />
      <Card title="Счётчик">
        <Button onClick={() => setCount((c) => c + 1)}>count is {count}</Button>
        <p className="mt-2 text-sm text-muted-foreground">
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </Card>
      <Card title="Информация">
        <p className="text-muted-foreground">
          Демонстрация shadcn/ui с готовыми компонентами и темизацией
        </p>
      </Card>
    </div>
  )
}

export default App
