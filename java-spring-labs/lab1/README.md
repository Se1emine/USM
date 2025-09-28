# Football League Management System

Система управления футбольной лигой, разработанная с использованием Spring Boot, JPA и H2 Database.

## Архитектура приложения

### Сущности (Entities)
1. **League** - Лига
2. **Team** - Команда  
3. **Player** - Игрок
4. **Coach** - Тренер
5. **Match** - Матч

### Взаимосвязи между сущностями
- **Team ↔ Coach**: One-to-One (У одной команды один тренер)
- **Team → Player**: One-to-Many (У команды много игроков)
- **Team → League**: Many-to-One (Команда принадлежит одной лиге)
- **League → Team**: One-to-Many (У лиги много команд)
- **League → Match**: One-to-Many (У лиги много матчей)
- **Match → Team**: Many-to-One (Матч связан с двумя командами: домашней и гостевой)
- **Player**: Встроенная статистика (PlayerStatistics)

### Структура проекта
```
src/
├── main/
│   ├── java/com/football/leaguemanagement/
│   │   ├── entity/          # JPA сущности
│   │   ├── dto/             # Data Transfer Objects
│   │   ├── repository/      # JPA репозитории
│   │   ├── service/         # Бизнес-логика
│   │   ├── controller/      # REST контроллеры
│   │   ├── mapper/          # Преобразование Entity ↔ DTO
│   │   ├── config/          # Конфигурация и инициализация данных
│   │   └── LeagueManagementApplication.java
│   └── resources/
│       └── application.properties
```

## Требования

- Java 17+
- Maven 3.6+

## Установка и запуск

### 1. Клонирование и сборка проекта
```bash
mvn clean install
```

### 2. Запуск приложения
```bash
mvn spring-boot:run
```

### 3. Доступ к приложению
- **REST API**: http://localhost:8080/api
- **H2 Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: `password`

## REST API Endpoints

### League Controller (`/api/leagues`)
- `GET /api/leagues` - Получить все лиги
- `GET /api/leagues/{id}` - Получить лигу по ID
- `GET /api/leagues/name/{name}` - Получить лигу по названию
- `GET /api/leagues/country/{country}` - Получить лиги по стране
- `GET /api/leagues/season/{season}` - Получить лиги по сезону
- `POST /api/leagues` - Создать новую лигу
- `PUT /api/leagues/{id}` - Обновить лигу
- `DELETE /api/leagues/{id}` - Удалить лигу
- `GET /api/leagues/{id}/exists` - Проверить существование лиги

### Team Controller (`/api/teams`)
- `GET /api/teams` - Получить все команды
- `GET /api/teams/{id}` - Получить команду по ID
- `GET /api/teams/name/{name}` - Получить команду по названию
- `GET /api/teams/city/{city}` - Получить команды по городу
- `GET /api/teams/league/{leagueId}` - Получить команды лиги
- `POST /api/teams` - Создать новую команду
- `PUT /api/teams/{id}` - Обновить команду
- `DELETE /api/teams/{id}` - Удалить команду
- `GET /api/teams/{id}/exists` - Проверить существование команды
- `GET /api/teams/league/{leagueId}/count` - Количество команд в лиге

### Player Controller (`/api/players`)
- `GET /api/players` - Получить всех игроков
- `GET /api/players/{id}` - Получить игрока по ID
- `GET /api/players/team/{teamId}` - Получить игроков команды
- `GET /api/players/position/{position}` - Получить игроков по позиции
- `GET /api/players/nationality/{nationality}` - Получить игроков по национальности
- `GET /api/players/team/{teamId}/position/{position}` - Получить игроков команды по позиции
- `GET /api/players/top-scorers?minGoals={minGoals}` - Получить лучших бомбардиров
- `GET /api/players/age-range?minAge={minAge}&maxAge={maxAge}` - Получить игроков по возрасту
- `POST /api/players` - Создать нового игрока
- `PUT /api/players/{id}` - Обновить игрока
- `DELETE /api/players/{id}` - Удалить игрока
- `GET /api/players/{id}/exists` - Проверить существование игрока
- `GET /api/players/team/{teamId}/count` - Количество игроков в команде

## Примеры использования API

### 1. Создание лиги
```bash
curl -X POST http://localhost:8080/api/leagues \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Bundesliga",
    "country": "Germany",
    "season": 2024
  }'
```

### 2. Создание команды
```bash
curl -X POST http://localhost:8080/api/teams \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Bayern Munich",
    "city": "Munich",
    "foundedYear": 1900,
    "stadium": "Allianz Arena",
    "leagueId": 1,
    "coachId": 1
  }'
```

### 3. Создание игрока
```bash
curl -X POST http://localhost:8080/api/players \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Thomas Müller",
    "age": 34,
    "position": "Forward",
    "jerseyNumber": 25,
    "nationality": "German",
    "teamId": 1,
    "statistics": {
      "goals": 15,
      "assists": 10,
      "yellowCards": 2,
      "redCards": 0,
      "matchesPlayed": 20
    }
  }'
```

### 4. Получение всех команд лиги
```bash
curl http://localhost:8080/api/teams/league/1
```

### 5. Получение лучших бомбардиров
```bash
curl http://localhost:8080/api/players/top-scorers?minGoals=10
```

## Тестовые данные

При запуске приложения автоматически создаются тестовые данные:

### Лиги:
- Premier League (England, 2024)
- La Liga (Spain, 2024)

### Команды:
- Manchester City (Premier League)
- Liverpool (Premier League)
- Real Madrid (La Liga)
- FC Barcelona (La Liga)

### Игроки:
- Erling Haaland (Manchester City)
- Kevin De Bruyne (Manchester City)
- Mohamed Salah (Liverpool)
- Virgil van Dijk (Liverpool)
- Karim Benzema (Real Madrid)
- Luka Modric (Real Madrid)
- Robert Lewandowski (FC Barcelona)
- Pedri (FC Barcelona)

### Тренеры:
- Pep Guardiola (Manchester City)
- Jurgen Klopp (Liverpool)
- Carlo Ancelotti (Real Madrid)
- Xavi Hernandez (FC Barcelona)

## Особенности реализации

### Валидация
- Все DTO содержат валидационные аннотации
- Проверка уникальности названий лиг и команд
- Проверка уникальности номеров игроков в рамках команды
- Проверка назначения тренера только одной команде

### Обработка ошибок
- Возврат соответствующих HTTP статусов
- Обработка исключений на уровне сервисов
- Валидация входных данных

### База данных
- Использование H2 in-memory database для разработки
- Автоматическое создание схемы при запуске
- Инициализация тестовых данных

## Возможные расширения

1. **Аутентификация и авторизация** - добавление Spring Security
2. **Файловые операции** - загрузка фото игроков/команд
3. **Статистика матчей** - детальная статистика по матчам
4. **Календарь игр** - планирование и управление расписанием
5. **Уведомления** - система уведомлений о матчах
6. **Веб-интерфейс** - добавление фронтенда (React/Angular)
7. **Кэширование** - добавление Redis для кэширования
8. **Документация API** - интеграция с Swagger/OpenAPI

## Логирование

Приложение настроено на подробное логирование:
- SQL запросы выводятся в консоль
- Параметры запросов отображаются для отладки
- Уровень логирования DEBUG для пакета приложения

## Дополнительные контроллеры

### Coach Controller (`/api/coaches`)
- `GET /api/coaches` - Получить всех тренеров
- `GET /api/coaches/{id}` - Получить тренера по ID
- `GET /api/coaches/name/{name}` - Получить тренера по имени
- `GET /api/coaches/nationality/{nationality}` - Получить тренеров по национальности
- `GET /api/coaches/experience/{minExperience}` - Получить тренеров с минимальным опытом
- `GET /api/coaches/age-range?minAge={minAge}&maxAge={maxAge}` - Получить тренеров по возрасту
- `GET /api/coaches/available` - Получить свободных тренеров
- `GET /api/coaches/with-teams` - Получить тренеров с командами
- `POST /api/coaches` - Создать нового тренера
- `PUT /api/coaches/{id}` - Обновить тренера
- `DELETE /api/coaches/{id}` - Удалить тренера

### Match Controller (`/api/matches`)
- `GET /api/matches` - Получить все матчи
- `GET /api/matches/{id}` - Получить матч по ID
- `GET /api/matches/league/{leagueId}` - Получить матчи лиги
- `GET /api/matches/status/{status}` - Получить матчи по статусу
- `GET /api/matches/team/{teamId}` - Получить матчи команды
- `GET /api/matches/team/{teamId}/home` - Получить домашние матчи команды
- `GET /api/matches/team/{teamId}/away` - Получить гостевые матчи команды
- `GET /api/matches/date-range?startDate={start}&endDate={end}` - Получить матчи по датам
- `GET /api/matches/between-teams?team1Id={id1}&team2Id={id2}` - Матчи между командами
- `POST /api/matches` - Создать новый матч
- `PUT /api/matches/{id}` - Обновить матч
- `DELETE /api/matches/{id}` - Удалить матч

## Файлы для тестирования

В проекте созданы дополнительные файлы для тестирования:

1. **`api-examples.http`** - Основные примеры HTTP запросов
2. **`additional-api-examples.http`** - Дополнительные примеры для Coach и Match
3. **`test-data.sql`** - SQL скрипты для ручного тестирования в H2 Console

## Полное тестирование функционала

### 1. Запуск приложения
```bash
mvn spring-boot:run
```

### 2. Проверка H2 Console
Откройте http://localhost:8080/h2-console и выполните запросы из `test-data.sql`

### 3. Тестирование REST API
Используйте файлы `*.http` для тестирования всех endpoint'ов

### 4. Основные сценарии тестирования

#### Создание полной структуры:
1. Создать лигу
2. Создать тренера
3. Создать команду с тренером и лигой
4. Создать игроков для команды
5. Создать матч между командами
6. Обновить результат матча

#### Проверка связей:
- Один тренер может работать только с одной командой
- Игроки не могут иметь одинаковые номера в одной команде
- Матч не может быть между одной и той же командой

## Архитектурные особенности

### Полная реализация включает:
- **5 сущностей**: League, Team, Player, Coach, Match
- **5 контроллеров**: для всех сущностей + дополнительные endpoint'ы
- **5 сервисов**: с полной бизнес-логикой
- **5 репозиториев**: с кастомными запросами
- **5 mappers**: для преобразования Entity ↔ DTO
- **Валидация**: на всех уровнях
- **Обработка ошибок**: с соответствующими HTTP статусами

## Поддержка

При возникновении проблем:
1. Проверьте логи приложения
2. Убедитесь, что порт 8080 свободен
3. Проверьте версию Java (требуется 17+)
4. Убедитесь, что Maven корректно установлен
5. Используйте H2 Console для проверки данных
6. Тестируйте API через предоставленные HTTP файлы
