# Лабораторная работа: Методы стилизации React-компонентов

## Описание лабораторной работы

Данная лабораторная работа демонстрирует 6 различных подходов к стилизации React-компонентов с использованием сборщика Vite. Каждый метод реализован в отдельном проекте с одинаковыми компонентами для наглядного сравнения подходов.

### Цели работы:
- Изучить различные методы стилизации React-компонентов
- Сравнить преимущества и недостатки каждого подхода
- Получить практический опыт работы с современными инструментами стилизации
- Понять, когда и какой метод стилизации лучше использовать

## Инструкции по запуску проекта

### Системные требования:
- Node.js версии 16 или выше
- npm или yarn
- Современный браузер

### Запуск конкретной версии:

1. Перейдите в директорию нужной версии:
```bash
cd [00_initial|01_css|02_scss|03_css_modules|04_css_in_js|05_css_framework|06_component_library]
```

2. Установите зависимости:
```bash
npm install
```

3. Запустите dev-сервер:
```bash
npm run dev
```

4. Откройте браузер по адресу `http://localhost:5173`

### Запуск всех версий одновременно:
```bash
# Скрипт для запуска всех версий на разных портах
for dir in 00_initial 01_css 02_scss 03_css_modules 04_css_in_js 05_css_framework 06_component_library; do
  cd $dir && npm install && npm run dev -- --port $((5173 + ${dir:0:2})) &
  cd ..
done
```

## Структура проекта

```
lab2/
├── 00_initial/           # Базовая версия без стилизации
├── 01_css/              # Глобальные CSS-файлы
├── 02_scss/             # SCSS препроцессор
├── 03_css_modules/      # CSS Modules
├── 04_css_in_js/        # styled-components
├── 05_css_framework/    # Tailwind CSS
├── 06_component_library/ # shadcn/ui
└── README.md            # Данный файл
```

### Общие компоненты

Во всех версиях используются одинаковые компоненты:
- **Header** — заголовок с подзаголовком
- **Card** — карточка с заголовком и содержимым  
- **Button** — кнопка с вариантами стилизации (primary/secondary)

## Краткая документация

### 00_initial — Базовая версия
Минимальная реализация без дополнительной стилизации. Используются только inline-стили для демонстрации базовой структуры компонентов.

### 01_css — Глобальные CSS-файлы
Классический подход с отдельными CSS-файлами для каждого компонента:
```
src/components/
├── Header.jsx + Header.css
├── Card.jsx + Card.css
└── Button.jsx + Button.css
```

### 02_scss — SCSS препроцессор
Использует возможности SCSS:
- Переменные в `src/styles/_variables.scss`
- Миксины в `src/styles/_mixins.scss`
- Вложенность и БЭМ-подобные классы

### 03_css_modules — CSS Modules
Локальная инкапсуляция стилей через `*.module.css`:
```javascript
import styles from './Component.module.css'
<div className={styles.container}>
```

### 04_css_in_js — styled-components
Стили описываются в JavaScript:
```javascript
const StyledButton = styled.button`
  background: ${props => props.primary ? '#646cff' : 'white'};
`
```

### 05_css_framework — Tailwind CSS
Utility-first подход с готовыми классами:
```javascript
<button className="px-4 py-2 bg-blue-500 text-white rounded">
```

### 06_component_library — shadcn/ui
Готовые компоненты на основе Tailwind CSS и Radix UI:
```javascript
import { Button } from './ui/button'
<Button variant="default">Click me</Button>
```

## Примеры использования

### Пример компонента Button в разных стилях:

**CSS (01_css):**
```css
/* Button.css */
.btn {
  cursor: pointer;
  padding: 0.5rem 1rem;
  border-radius: 6px;
}
.btn--primary {
  background: #646cff;
  color: white;
}
```

**SCSS (02_scss):**
```scss
// Button.scss
@use '../styles/variables' as *;

.btn {
  @include button-base;
  
  &--primary {
    background: $primary;
    color: white;
  }
}
```

**CSS Modules (03_css_modules):**
```javascript
// Button.jsx
import styles from './Button.module.css'
<button className={`${styles.btn} ${styles.primary}`}>
```

**styled-components (04_css_in_js):**
```javascript
const StyledButton = styled.button`
  cursor: pointer;
  padding: 0.5rem 1rem;
  ${props => props.$variant === 'primary' && css`
    background: #646cff;
    color: white;
  `}
`
```

**Tailwind CSS (05_css_framework):**
```javascript
<button className="cursor-pointer px-4 py-2 bg-indigo-500 text-white rounded-md">
```

**shadcn/ui (06_component_library):**
```javascript
<Button variant="default" size="default">
  Click me
</Button>
```

## Сравнительная таблица методов

| Метод | Сложность | Изоляция | Производительность | Кастомизация | Bundle Size |
|-------|-----------|----------|-------------------|--------------|-------------|
| CSS | Низкая | Нет | Высокая | Средняя | Минимальный |
| SCSS | Средняя | Нет | Высокая | Высокая | Минимальный |
| CSS Modules | Средняя | Да | Высокая | Средняя | Минимальный |
| CSS-in-JS | Высокая | Да | Средняя | Высокая | Средний |
| Tailwind | Низкая | Нет | Высокая | Средняя | Оптимизированный |
| Компонентные библиотеки | Низкая | Да | Высокая | Низкая | Большой |

## Ответы на контрольные вопросы

### 1. Какие методы стилизации предпочтительнее использовать в больших проектах и почему?

**Для больших проектов рекомендуются:**

- **CSS Modules** — обеспечивают изоляцию стилей без runtime overhead
- **Tailwind CSS** — консистентность дизайна, быстрая разработка, оптимизация bundle
- **Компонентные библиотеки** — единообразие UI, готовые решения для accessibility

**Почему:**
- Изоляция стилей предотвращает конфликты в больших командах
- Консистентность дизайн-системы важна для UX
- Производительность критична для больших приложений
- Поддерживаемость кода снижает технический долг

### 2. Преимущества и недостатки CSS-фреймворков

**Преимущества Tailwind CSS:**
- ✅ Быстрая разработка через utility-классы
- ✅ Консистентная дизайн-система из коробки
- ✅ Автоматическое удаление неиспользуемых стилей (purging)
- ✅ Отличная производительность
- ✅ Responsive design через префиксы (`md:`, `lg:`)

**Недостатки:**
- ❌ Длинные строки классов в HTML
- ❌ Кривая обучения для команды
- ❌ Сложность кастомизации сложных компонентов
- ❌ Зависимость от фреймворка

### 3. Отличие CSS Modules от обычных CSS и SCSS

**CSS Modules vs обычный CSS:**
- **Изоляция:** CSS Modules автоматически генерируют уникальные имена классов
- **Конфликты:** исключены благодаря локальной области видимости
- **Импорт:** стили импортируются как JavaScript объекты
- **Типизация:** возможна типизация классов в TypeScript

**CSS Modules vs SCSS:**
- **Препроцессинг:** CSS Modules можно использовать с SCSS (`.module.scss`)
- **Возможности:** SCSS добавляет переменные, миксины, функции
- **Область видимости:** SCSS глобальный, CSS Modules локальный
- **Совместимость:** можно комбинировать оба подхода

**Пример:**
```javascript
// styles.module.scss
$primary: #646cff;

.button {
  background: $primary; // SCSS переменная
  &:hover {
    opacity: 0.8;     // SCSS вложенность
  }
}

// Component.jsx
import styles from './styles.module.scss'
<button className={styles.button}> // CSS Modules изоляция
```

### 4. Преимущества и недостатки CSS-in-JS

**Преимущества styled-components:**
- ✅ Полная изоляция стилей
- ✅ Динамические стили через props
- ✅ Автоматическое удаление неиспользуемых стилей
- ✅ Темизация через ThemeProvider
- ✅ Отличная интеграция с React

**Недостатки:**
- ❌ Runtime overhead (стили генерируются в браузере)
- ❌ Увеличение bundle size
- ❌ Сложность отладки (динамические имена классов)
- ❌ SSR требует дополнительной настройки
- ❌ Производительность хуже статических CSS

**Когда использовать CSS-in-JS:**
- Компоненты с высокой динамикой стилей
- Сложная темизация
- Изолированные UI-библиотеки
- Когда важнее DX чем производительность

## Список использованных источников

1. **Официальная документация:**
   - [React Documentation](https://react.dev/)
   - [Vite Documentation](https://vitejs.dev/)
   - [Tailwind CSS Documentation](https://tailwindcss.com/)
   - [styled-components Documentation](https://styled-components.com/)
   - [Sass Documentation](https://sass-lang.com/)

2. **Библиотеки и инструменты:**
   - [shadcn/ui](https://ui.shadcn.com/) — компонентная библиотека
   - [Radix UI](https://www.radix-ui.com/) — headless UI компоненты
   - [class-variance-authority](https://cva.style/) — утилита для вариантов классов

3. **Статьи и руководства:**
   - [CSS Modules GitHub](https://github.com/css-modules/css-modules)
   - [A Complete Guide to CSS Modules](https://css-tricks.com/css-modules-part-1-need/)
   - [The State of CSS-in-JS](https://2021.stateofcss.com/en-US/technologies/css-in-js/)

## Дополнительные важные аспекты

### Производительность
- **CSS/SCSS/CSS Modules:** минимальный runtime overhead
- **Tailwind CSS:** оптимальный размер bundle благодаря purging
- **CSS-in-JS:** runtime генерация стилей влияет на производительность
- **Компонентные библиотеки:** могут увеличивать bundle size

### Поддержка TypeScript
- **CSS Modules:** поддержка типизации через `*.module.css.d.ts`
- **styled-components:** отличная типизация props и тем
- **Tailwind CSS:** автодополнение через расширения IDE
- **shadcn/ui:** полная поддержка TypeScript из коробки

### Инструменты разработки
- **CSS/SCSS:** стандартные DevTools браузера
- **CSS Modules:** sourcemaps для отладки
- **styled-components:** browser extension для отладки
- **Tailwind CSS:** IntelliSense расширение для VS Code

### Миграция между методами
- Постепенная миграция возможна для большинства методов
- CSS Modules легко интегрируются с существующим CSS
- Tailwind можно внедрять компонент за компонентом
- styled-components требуют полной переписи компонентов

### Рекомендации по выбору

**Для новых проектов:**
- Малые проекты: CSS или Tailwind CSS
- Средние проекты: CSS Modules или Tailwind CSS  
- Большие проекты: Tailwind CSS + компонентная библиотека

**Для существующих проектов:**
- Постепенная миграция на CSS Modules
- Внедрение Tailwind CSS для новых компонентов
- Использование компонентных библиотек для сложных UI элементов
