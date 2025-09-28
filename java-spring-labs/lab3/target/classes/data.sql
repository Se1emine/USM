-- Insert sample data for Sports Library Management System

-- Insert leagues
INSERT INTO league (name, country, season) VALUES 
('Premier League', 'England', '2023-2024'),
('La Liga', 'Spain', '2023-2024'),
('Bundesliga', 'Germany', '2023-2024');

-- Insert coaches
INSERT INTO coach (first_name, last_name, experience_years, nationality) VALUES 
('Pep', 'Guardiola', 15, 'Spanish'),
('Jurgen', 'Klopp', 12, 'German'),
('Carlo', 'Ancelotti', 25, 'Italian'),
('Mikel', 'Arteta', 4, 'Spanish'),
('Erik', 'ten Hag', 8, 'Dutch');

-- Insert teams
INSERT INTO team (name, city, founded_year, coach_id, league_id) VALUES 
('Manchester City', 'Manchester', 1880, 1, 1),
('Liverpool', 'Liverpool', 1892, 2, 1),
('Arsenal', 'London', 1886, 4, 1),
('Real Madrid', 'Madrid', 1902, 3, 2),
('Manchester United', 'Manchester', 1878, 5, 1);

-- Insert players
INSERT INTO player (first_name, last_name, position, age, team_id, goals, assists, matches_played) VALUES 
-- Manchester City players
('Erling', 'Haaland', 'Forward', 23, 1, 25, 5, 30),
('Kevin', 'De Bruyne', 'Midfielder', 32, 1, 8, 15, 28),
('Ruben', 'Dias', 'Defender', 26, 1, 2, 1, 32),

-- Liverpool players
('Mohamed', 'Salah', 'Forward', 31, 2, 20, 12, 30),
('Sadio', 'Mane', 'Forward', 31, 2, 15, 8, 28),
('Virgil', 'van Dijk', 'Defender', 32, 2, 3, 2, 30),

-- Arsenal players
('Bukayo', 'Saka', 'Forward', 22, 3, 12, 10, 32),
('Martin', 'Odegaard', 'Midfielder', 24, 3, 8, 12, 30),
('William', 'Saliba', 'Defender', 22, 3, 1, 0, 28),

-- Real Madrid players
('Karim', 'Benzema', 'Forward', 35, 4, 18, 8, 25),
('Luka', 'Modric', 'Midfielder', 38, 4, 5, 10, 28),
('Antonio', 'Rudiger', 'Defender', 30, 4, 2, 1, 30),

-- Manchester United players
('Marcus', 'Rashford', 'Forward', 26, 5, 16, 6, 30),
('Bruno', 'Fernandes', 'Midfielder', 29, 5, 10, 12, 32),
('Harry', 'Maguire', 'Defender', 30, 5, 1, 0, 25);

-- Insert matches
INSERT INTO match (match_date, home_team_score, away_team_score, status, home_team_id, away_team_id, league_id) VALUES 
('2023-10-15', 2, 1, 'FINISHED', 1, 2, 1),
('2023-10-22', 1, 3, 'FINISHED', 3, 1, 1),
('2023-10-29', 0, 0, 'FINISHED', 2, 5, 1),
('2023-11-05', 2, 2, 'FINISHED', 5, 3, 1),
('2023-11-12', 3, 1, 'FINISHED', 1, 5, 1),
('2023-11-19', 1, 0, 'SCHEDULED', 2, 3, 1);
