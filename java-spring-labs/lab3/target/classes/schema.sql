-- Create tables for Sports Library Management System

-- League table
CREATE TABLE league (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    season VARCHAR(255) NOT NULL
);

-- Coach table
CREATE TABLE coach (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    experience_years INTEGER NOT NULL CHECK (experience_years >= 0),
    nationality VARCHAR(255) NOT NULL
);

-- Team table
CREATE TABLE team (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    founded_year INTEGER NOT NULL CHECK (founded_year > 1800),
    coach_id BIGINT UNIQUE,
    league_id BIGINT NOT NULL,
    FOREIGN KEY (coach_id) REFERENCES coach(id),
    FOREIGN KEY (league_id) REFERENCES league(id)
);

-- Player table
CREATE TABLE player (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    position VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL CHECK (age > 0 AND age < 50),
    team_id BIGINT NOT NULL,
    -- Embedded statistics
    goals INTEGER DEFAULT 0 CHECK (goals >= 0),
    assists INTEGER DEFAULT 0 CHECK (assists >= 0),
    matches_played INTEGER DEFAULT 0 CHECK (matches_played >= 0),
    FOREIGN KEY (team_id) REFERENCES team(id)
);

-- Match table
CREATE TABLE match (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    match_date DATE NOT NULL,
    home_team_score INTEGER DEFAULT 0 CHECK (home_team_score >= 0),
    away_team_score INTEGER DEFAULT 0 CHECK (away_team_score >= 0),
    status VARCHAR(50) NOT NULL,
    home_team_id BIGINT NOT NULL,
    away_team_id BIGINT NOT NULL,
    league_id BIGINT NOT NULL,
    FOREIGN KEY (home_team_id) REFERENCES team(id),
    FOREIGN KEY (away_team_id) REFERENCES team(id),
    FOREIGN KEY (league_id) REFERENCES league(id),
    CHECK (home_team_id != away_team_id)
);
