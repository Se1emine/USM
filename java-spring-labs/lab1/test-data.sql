-- Test Data
-- H2 Console

INSERT INTO leagues (name, country, season) VALUES 
('Serie A', 'Italy', 2024),
('Bundesliga', 'Germany', 2024),
('Ligue 1', 'France', 2024);


INSERT INTO coaches (name, age, nationality, experience_years) VALUES 
('Jose Mourinho', 61, 'Portuguese', 23),
('Jurgen Klopp', 56, 'German', 20),
('Zinedine Zidane', 52, 'French', 8),
('Diego Simeone', 54, 'Argentinian', 13);


INSERT INTO teams (name, city, founded_year, stadium, league_id, coach_id) VALUES 
('Juventus', 'Turin', 1897, 'Allianz Stadium', 3, 5),
('AC Milan', 'Milan', 1899, 'San Siro', 3, 6),
('Bayern Munich', 'Munich', 1900, 'Allianz Arena', 4, NULL),
('Borussia Dortmund', 'Dortmund', 1909, 'Signal Iduna Park', 4, NULL),
('Paris Saint-Germain', 'Paris', 1970, 'Parc des Princes', 5, 7),
('Olympique Marseille', 'Marseille', 1899, 'Stade Velodrome', 5, NULL);


INSERT INTO players (name, age, position, jersey_number, nationality, team_id, goals, assists, yellow_cards, red_cards, matches_played) VALUES 

('Dusan Vlahovic', 24, 'Striker', 9, 'Serbian', 5, 15, 3, 2, 0, 18),
('Federico Chiesa', 27, 'Winger', 7, 'Italian', 5, 8, 6, 3, 0, 16),

('Rafael Leao', 25, 'Winger', 10, 'Portuguese', 6, 12, 8, 1, 0, 19),
('Olivier Giroud', 37, 'Striker', 9, 'French', 6, 14, 4, 2, 0, 17),

('Harry Kane', 30, 'Striker', 9, 'English', 7, 28, 7, 1, 0, 22),
('Jamal Musiala', 21, 'Midfielder', 42, 'German', 7, 9, 11, 2, 0, 20),


('Erling Haaland', 24, 'Striker', 9, 'Norwegian', 8, 22, 5, 3, 0, 19),
('Marco Reus', 35, 'Midfielder', 11, 'German', 8, 6, 9, 4, 0, 18),

('Kylian Mbappe', 25, 'Striker', 7, 'French', 9, 26, 8, 2, 0, 21),
('Neymar Jr', 32, 'Winger', 10, 'Brazilian', 9, 18, 12, 5, 1, 19),

('Pierre-Emerick Aubameyang', 35, 'Striker', 9, 'Gabonese', 10, 16, 3, 3, 0, 18),
('Dimitri Payet', 37, 'Midfielder', 10, 'French', 10, 7, 14, 6, 0, 20);


INSERT INTO matches (match_date, home_team_score, away_team_score, status, round, league_id, home_team_id, away_team_id) VALUES 

('2024-12-15 15:00:00', 2, 1, 'FINISHED', 1, 3, 5, 6),
('2024-12-22 18:00:00', NULL, NULL, 'SCHEDULED', 2, 3, 6, 5),

('2024-12-14 15:30:00', 3, 0, 'FINISHED', 1, 4, 7, 8),
('2024-12-21 15:30:00', NULL, NULL, 'SCHEDULED', 2, 4, 8, 7),

('2024-12-16 20:00:00', 4, 1, 'FINISHED', 1, 5, 9, 10),
('2024-12-23 20:00:00', NULL, NULL, 'SCHEDULED', 2, 5, 10, 9),

('2024-12-28 19:00:00', NULL, NULL, 'SCHEDULED', 1, NULL, 1, 7),
('2024-12-30 16:00:00', NULL, NULL, 'SCHEDULED', 1, NULL, 3, 9);


SELECT t.name as team_name, t.city, l.name as league_name, c.name as coach_name 
FROM teams t 
LEFT JOIN leagues l ON t.league_id = l.id 
LEFT JOIN coaches c ON t.coach_id = c.id;

SELECT p.name, p.goals, t.name as team_name, l.name as league_name 
FROM players p 
JOIN teams t ON p.team_id = t.id 
LEFT JOIN leagues l ON t.league_id = l.id 
ORDER BY p.goals DESC 
LIMIT 10;

SELECT m.match_date, ht.name as home_team, at.name as away_team, l.name as league_name, m.status 
FROM matches m 
JOIN teams ht ON m.home_team_id = ht.id 
JOIN teams at ON m.away_team_id = at.id 
LEFT JOIN leagues l ON m.league_id = l.id 
WHERE m.status = 'SCHEDULED' 
ORDER BY m.match_date;


SELECT m.match_date, ht.name as home_team, m.home_team_score, 
       m.away_team_score, at.name as away_team, l.name as league_name 
FROM matches m 
JOIN teams ht ON m.home_team_id = ht.id 
JOIN teams at ON m.away_team_id = at.id 
LEFT JOIN leagues l ON m.league_id = l.id 
WHERE m.status = 'FINISHED' 
ORDER BY m.match_date DESC;

SELECT t.name as team_name, 
       COUNT(p.id) as total_players,
       SUM(p.goals) as total_goals,
       SUM(p.assists) as total_assists,
       c.name as coach_name
FROM teams t 
LEFT JOIN players p ON t.id = p.team_id 
LEFT JOIN coaches c ON t.coach_id = c.id 
GROUP BY t.id, t.name, c.name;

SELECT c.name, c.age, c.nationality, c.experience_years 
FROM coaches c 
WHERE c.id NOT IN (SELECT DISTINCT coach_id FROM teams WHERE coach_id IS NOT NULL);
SELECT position, COUNT(*) as player_count, AVG(age) as avg_age 
FROM players 
GROUP BY position 
ORDER BY player_count DESC;
