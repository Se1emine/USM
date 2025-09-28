# Football League Management System

Система управления футбольной лигой, разработанная на Spring Boot с использованием Hibernate для работы с базой данных.

## Описание проекта

Это REST API приложение для управления футбольной лигой, которое включает в себя управление командами, игроками, тренерами, лигами и матчами. Приложение использует архитектуру DAO (Data Access Object) с нативным Hibernate вместо JPA репозиториев.

## Технологический стек

- **Java 17**
- **Spring Boot 3.2.0**
- **Hibernate 6.2.7.Final**
- **H2 Database** (встроенная база данных)
- **Maven** (система сборки)
- **Lombok** (для уменьшения boilerplate кода)
- **Jackson** (для JSON сериализации)

## Архитектура проекта

```
src/main/java/com/example/footballleague/
├── config/
│   └── HibernateConfig.java          # Конфигурация Hibernate
├── controller/
│   ├── TeamController.java           # REST контроллер для команд
│   ├── PlayerController.java         # REST контроллер для игроков
│   └── MatchController.java          # REST контроллер для матчей
├── dao/
│   ├── BaseDAO.java                  # Базовый DAO класс
│   ├── TeamDAO.java                  # DAO для команд
│   ├── PlayerDAO.java                # DAO для игроков
│   ├── CoachDAO.java                 # DAO для тренеров
│   ├── LeagueDAO.java                # DAO для лиг
│   └── MatchDAO.java                 # DAO для матчей
├── dto/
│   ├── TeamDTO.java                  # DTO для команд
│   ├── PlayerDTO.java                # DTO для игроков
│   ├── CoachDTO.java                 # DTO для тренеров
│   ├── LeagueDTO.java                # DTO для лиг
│   ├── MatchDTO.java                 # DTO для матчей
│   └── PlayerStatisticsDTO.java      # DTO для статистики игрока
├── entity/
│   ├── Team.java                     # Сущность команды
│   ├── Player.java                   # Сущность игрока
│   ├── Coach.java                    # Сущность тренера
│   ├── League.java                   # Сущность лиги
│   ├── Match.java                    # Сущность матча
│   └── PlayerStatistics.java        # Встраиваемая сущность статистики
├── mapper/
│   └── EntityMapper.java             # Маппер Entity <-> DTO
├── service/
│   ├── TeamService.java              # Сервис для команд
│   ├── PlayerService.java            # Сервис для игроков
│   └── MatchService.java             # Сервис для матчей
└── FootballLeagueApplication.java    # Главный класс приложения
```

## Модель данных

### Связи между сущностями

1. **Team (Команда)**
   - One-to-One с Coach (один тренер на команду)
   - One-to-Many с Player (много игроков в команде)
   - Many-to-One с League (команда принадлежит одной лиге)
   - One-to-Many с Match (команда участвует в матчах как домашняя или гостевая)

2. **Player (Игрок)**
   - Many-to-One с Team (игрок принадлежит одной команде)
   - Embedded PlayerStatistics (встроенная статистика)

3. **Coach (Тренер)**
   - One-to-One с Team (тренер работает с одной командой)

4. **League (Лига)**
   - One-to-Many с Team (лига включает множество команд)
   - One-to-Many с Match (лига включает множество матчей)

5. **Match (Матч)**
   - Many-to-One с Team (homeTeam и awayTeam)
   - Many-to-One с League (матч принадлежит лиге)

## API Endpoints

### Teams (Команды)
- `POST /api/teams` - Создать команду
- `GET /api/teams` - Получить все команды
- `GET /api/teams/{id}` - Получить команду по ID
- `PUT /api/teams/{id}` - Обновить команду
- `DELETE /api/teams/{id}` - Удалить команду
- `GET /api/teams/search/name/{name}` - Найти команду по имени
- `GET /api/teams/search/city/{city}` - Найти команды по городу
- `GET /api/teams/search/league/{leagueId}` - Найти команды по лиге
- `GET /api/teams/with-players` - Получить команды с игроками
- `GET /api/teams/with-coach` - Получить команды с тренерами

### Players (Игроки)
- `POST /api/players` - Создать игрока
- `GET /api/players` - Получить всех игроков
- `GET /api/players/{id}` - Получить игрока по ID
- `PUT /api/players/{id}` - Обновить игрока
- `DELETE /api/players/{id}` - Удалить игрока
- `GET /api/players/search/team/{teamId}` - Найти игроков по команде
- `GET /api/players/search/position/{position}` - Найти игроков по позиции
- `GET /api/players/search/nationality/{nationality}` - Найти игроков по национальности
- `GET /api/players/top-scorers?limit={limit}` - Получить лучших бомбардиров
- `GET /api/players/search/name?firstName={firstName}&lastName={lastName}` - Найти игроков по имени
- `GET /api/players/search/jersey?jerseyNumber={number}&teamId={teamId}` - Найти игрока по номеру

### Matches (Матчи)
- `POST /api/matches` - Создать матч
- `GET /api/matches` - Получить все матчи
- `GET /api/matches/{id}` - Получить матч по ID
- `PUT /api/matches/{id}` - Обновить матч
- `DELETE /api/matches/{id}` - Удалить матч
- `GET /api/matches/search/team/{teamId}` - Найти матчи команды
- `GET /api/matches/search/league/{leagueId}` - Найти матчи лиги
- `GET /api/matches/search/status/{status}` - Найти матчи по статусу
- `GET /api/matches/search/date-range?startDate={start}&endDate={end}` - Найти матчи по датам
- `GET /api/matches/upcoming` - Получить предстоящие матчи
- `GET /api/matches/finished` - Получить завершенные матчи
- `GET /api/matches/search/between-teams?homeTeamId={id1}&awayTeamId={id2}` - Матчи между командами
- `PATCH /api/matches/{id}/score?homeScore={score1}&awayScore={score2}` - Обновить счет матча

## Примеры запросов

### Создание команды
```json
POST /api/teams
{
    "name": "Manchester United",
    "city": "Manchester",
    "foundedDate": "1878-01-01",
    "stadium": "Old Trafford",
    "leagueId": 1,
    "coachId": 1
}
```

### Создание игрока
```json
POST /api/players
{
    "firstName": "Cristiano",
    "lastName": "Ronaldo",
    "birthDate": "1985-02-05",
    "nationality": "Portugal",
    "position": "FORWARD",
    "jerseyNumber": 7,
    "teamId": 1,
    "statistics": {
        "goals": 25,
        "assists": 8,
        "matchesPlayed": 30,
        "yellowCards": 2,
        "redCards": 0
    }
}
```

### Создание матча
```json
POST /api/matches
{
    "homeTeamId": 1,
    "awayTeamId": 2,
    "leagueId": 1,
    "matchDate": "2024-01-15T15:00:00",
    "status": "SCHEDULED",
    "venue": "Old Trafford"
}
```

## Запуск приложения

### Предварительные требования
- Java 17 или выше
- Maven 3.6 или выше

### Шаги для запуска

1. **Клонирование проекта**
   ```bash
   git clone <repository-url>
   cd football-league-management
   ```

2. **Сборка проекта**
   ```bash
   mvn clean install
   ```

3. **Запуск приложения**
   ```bash
   mvn spring-boot:run
   ```

   Или запуск JAR файла:
   ```bash
   java -jar target/football-league-management-1.0.0.jar
   ```

4. **Проверка работы**
   - Приложение будет доступно по адресу: `http://localhost:8080/api`
   - H2 Console: `http://localhost:8080/api/h2-console`
     - JDBC URL: `jdbc:h2:mem:testdb`
     - Username: `sa`
     - Password: `password`

## Конфигурация

### База данных
Приложение использует встроенную H2 базу данных в режиме in-memory. Конфигурация находится в `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: sa
    password: password
```

### Hibernate
```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true
```

## Особенности реализации

1. **DAO Pattern**: Использование нативного Hibernate SessionFactory вместо JPA репозиториев
2. **DTO Pattern**: Все API endpoints работают с DTO объектами, а не с entity
3. **Entity Mapping**: Автоматическое преобразование между Entity и DTO через EntityMapper
4. **Validation**: Валидация входных данных с помощью Jakarta Validation
5. **Transaction Management**: Декларативное управление транзакциями через @Transactional
6. **Error Handling**: Обработка ошибок с возвратом соответствующих HTTP статусов

## Тестирование API

Для тестирования API можно использовать:
- **Postman** - импортировать коллекцию запросов
- **curl** - командная строка
- **Swagger UI** - если добавить зависимость springdoc-openapi

### Пример тестирования с curl:
```bash
# Получить все команды
curl -X GET http://localhost:8080/api/teams

# Создать команду
curl -X POST http://localhost:8080/api/teams \
  -H "Content-Type: application/json" \
  -d '{"name":"Arsenal","city":"London","stadium":"Emirates Stadium"}'
```

## Возможные улучшения

1. **Безопасность**: Добавить Spring Security для аутентификации и авторизации
2. **Кэширование**: Использовать Redis или Hazelcast для кэширования
3. **Документация**: Интегрировать Swagger/OpenAPI для автоматической документации API
4. **Тестирование**: Добавить unit и integration тесты
5. **Мониторинг**: Интегрировать Actuator для мониторинга приложения
6. **База данных**: Перейти на PostgreSQL или MySQL для production
7. **Логирование**: Улучшить систему логирования с помощью Logback
8. **Валидация**: Расширить валидацию бизнес-правил

## Лицензия

Этот проект создан в учебных целях.
