# Sports Library Management System

Spring Boot приложение для управления библиотекой спортивных данных с использованием Spring JDBC.

## Описание

Приложение реализует систему управления спортивными данными со следующими сущностями:
- **Team** (Команда) - связана с тренером (One-to-One), игроками (One-to-Many), матчами (Many-to-Many) и лигой (Many-to-One)
- **Player** (Игрок) - принадлежит команде (Many-to-One), имеет встраиваемую статистику
- **Coach** (Тренер) - работает с одной командой (One-to-One)
- **League** (Лига) - включает команды и матчи (One-to-Many)
- **Match** (Матч) - между двумя командами в рамках лиги

## Технологии

- Spring Boot 3.1.5
- Spring JDBC
- Spring Validation
- H2 Database (в памяти)
- Maven

## Запуск приложения

1. Убедитесь, что у вас установлена Java 17+
2. Перейдите в корневую директорию проекта
3. Выполните команду:
```bash
mvn spring-boot:run
```

Приложение запустится на порту 8080.

## База данных

Приложение использует H2 базу данных в памяти. Консоль H2 доступна по адресу:
- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:sportsdb
- Username: sa
- Password: password

## API Endpoints

### Teams (Команды)
- `GET /api/teams` - получить все команды
- `GET /api/teams/{id}` - получить команду по ID
- `POST /api/teams` - создать новую команду
- `PUT /api/teams/{id}` - обновить команду
- `DELETE /api/teams/{id}` - удалить команду

### Players (Игроки)
- `GET /api/players` - получить всех игроков
- `GET /api/players/{id}` - получить игрока по ID
- `GET /api/players/team/{teamId}` - получить игроков команды
- `POST /api/players` - создать нового игрока
- `PUT /api/players/{id}` - обновить игрока
- `DELETE /api/players/{id}` - удалить игрока

### Matches (Матчи)
- `GET /api/matches` - получить все матчи
- `GET /api/matches/{id}` - получить матч по ID
- `GET /api/matches/league/{leagueId}` - получить матчи лиги
- `GET /api/matches/team/{teamId}` - получить матчи команды
- `POST /api/matches` - создать новый матч
- `PUT /api/matches/{id}` - обновить матч
- `DELETE /api/matches/{id}` - удалить матч

## Примеры запросов

### Создание команды
```json
POST /api/teams
{
    "name": "Arsenal",
    "city": "London",
    "foundedYear": 1886,
    "coachId": 1,
    "leagueId": 1
}
```

### Создание игрока
```json
POST /api/players
{
    "firstName": "Bukayo",
    "lastName": "Saka",
    "position": "Forward",
    "age": 22,
    "teamId": 1,
    "statistics": {
        "goals": 12,
        "assists": 10,
        "matchesPlayed": 32
    }
}
```

### Создание матча
```json
POST /api/matches
{
    "matchDate": "2023-12-01",
    "homeTeamScore": 2,
    "awayTeamScore": 1,
    "status": "FINISHED",
    "homeTeamId": 1,
    "awayTeamId": 2,
    "leagueId": 1
}
```

## Валидация

Приложение включает валидацию:
- Строковые поля не могут быть пустыми
- Числовые поля должны быть в допустимых пределах
- При создании/обновлении проверяется существование связанных ID
- Специальные бизнес-правила (например, тренер может работать только с одной командой)

## Структура проекта

```
src/main/java/com/example/sportslibrary/
├── controller/          # REST контроллеры
├── dto/                # DTO классы
├── entity/             # Entity классы
├── exception/          # Обработка исключений
├── repository/         # Spring JDBC репозитории
├── service/            # Бизнес-логика
└── SportsLibraryApplication.java
```

## Тестовые данные

При запуске приложения автоматически загружаются тестовые данные:
- 3 лиги (Premier League, La Liga, Bundesliga)
- 5 тренеров
- 5 команд
- 15 игроков
- 6 матчей

Вы можете использовать эти данные для тестирования API.
