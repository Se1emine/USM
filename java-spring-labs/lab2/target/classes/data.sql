-- Insert sample leagues
INSERT INTO leagues (name, description, country) VALUES 
('Premier League', 'English Premier League', 'England'),
('La Liga', 'Spanish La Liga', 'Spain'),
('Serie A', 'Italian Serie A', 'Italy');

-- Insert sample coaches
INSERT INTO coaches (first_name, last_name, birth_date, nationality, experience_years) VALUES 
('Pep', 'Guardiola', '1971-01-18', 'Spain', 15),
('Jurgen', 'Klopp', '1967-06-16', 'Germany', 18),
('Carlo', 'Ancelotti', '1959-06-10', 'Italy', 25);

-- Insert sample teams
INSERT INTO teams (name, city, founded_date, stadium, coach_id, league_id) VALUES 
('Manchester City', 'Manchester', '1880-01-01', 'Etihad Stadium', 1, 1),
('Liverpool', 'Liverpool', '1892-01-01', 'Anfield', 2, 1),
('Real Madrid', 'Madrid', '1902-01-01', 'Santiago Bernabeu', 3, 2);

-- Insert sample players
INSERT INTO players (first_name, last_name, birth_date, nationality, position, jersey_number, goals, assists, matches_played, yellow_cards, red_cards, team_id) VALUES 
('Erling', 'Haaland', '2000-07-21', 'Norway', 'FORWARD', 9, 35, 8, 38, 3, 0, 1),
('Kevin', 'De Bruyne', '1991-06-28', 'Belgium', 'MIDFIELDER', 17, 7, 16, 32, 4, 0, 1),
('Mohamed', 'Salah', '1992-06-15', 'Egypt', 'FORWARD', 11, 24, 12, 35, 2, 0, 2),
('Virgil', 'van Dijk', '1991-07-08', 'Netherlands', 'DEFENDER', 4, 3, 2, 34, 1, 0, 2),
('Karim', 'Benzema', '1987-12-19', 'France', 'FORWARD', 9, 31, 6, 32, 3, 0, 3),
('Luka', 'Modric', '1985-09-09', 'Croatia', 'MIDFIELDER', 10, 3, 12, 35, 5, 0, 3);

-- Insert sample matches
INSERT INTO matches (home_team_id, away_team_id, league_id, match_date, home_team_score, away_team_score, status, venue) VALUES 
(1, 2, 1, '2024-01-15 15:00:00', 2, 1, 'FINISHED', 'Etihad Stadium'),
(2, 1, 1, '2024-02-20 17:30:00', 1, 3, 'FINISHED', 'Anfield'),
(3, 1, 1, '2024-03-10 20:00:00', 0, 0, 'SCHEDULED', 'Santiago Bernabeu');
