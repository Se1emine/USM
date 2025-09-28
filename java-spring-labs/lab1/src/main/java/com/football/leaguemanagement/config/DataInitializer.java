package com.football.leaguemanagement.config;

import com.football.leaguemanagement.entity.*;
import com.football.leaguemanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;
    private final CoachRepository coachRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;

    @Autowired
    public DataInitializer(LeagueRepository leagueRepository,
                          TeamRepository teamRepository,
                          CoachRepository coachRepository,
                          PlayerRepository playerRepository,
                          MatchRepository matchRepository) {
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
        this.coachRepository = coachRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Leagues
        League premierLeague = new League("Premier League", "England", 2024);
        League laLiga = new League("La Liga", "Spain", 2024);
        leagueRepository.save(premierLeague);
        leagueRepository.save(laLiga);

        // Create Coaches
        Coach coach1 = new Coach("Pep Guardiola", 53, "Spanish", 15);
        Coach coach2 = new Coach("Jurgen Klopp", 56, "German", 20);
        Coach coach3 = new Coach("Carlo Ancelotti", 64, "Italian", 25);
        Coach coach4 = new Coach("Xavi Hernandez", 44, "Spanish", 3);
        coachRepository.save(coach1);
        coachRepository.save(coach2);
        coachRepository.save(coach3);
        coachRepository.save(coach4);

        // Create Teams
        Team manCity = new Team("Manchester City", "Manchester", 1880, "Etihad Stadium");
        manCity.setLeague(premierLeague);
        manCity.setCoach(coach1);
        
        Team liverpool = new Team("Liverpool", "Liverpool", 1892, "Anfield");
        liverpool.setLeague(premierLeague);
        liverpool.setCoach(coach2);
        
        Team realMadrid = new Team("Real Madrid", "Madrid", 1902, "Santiago Bernabeu");
        realMadrid.setLeague(laLiga);
        realMadrid.setCoach(coach3);
        
        Team barcelona = new Team("FC Barcelona", "Barcelona", 1899, "Camp Nou");
        barcelona.setLeague(laLiga);
        barcelona.setCoach(coach4);

        teamRepository.save(manCity);
        teamRepository.save(liverpool);
        teamRepository.save(realMadrid);
        teamRepository.save(barcelona);

        // Create Players for Manchester City
        Player haaland = new Player("Erling Haaland", 24, "Striker", 9, "Norwegian");
        haaland.setTeam(manCity);
        haaland.setStatistics(new PlayerStatistics(25, 5, 2, 0, 20));

        Player debruyne = new Player("Kevin De Bruyne", 32, "Midfielder", 17, "Belgian");
        debruyne.setTeam(manCity);
        debruyne.setStatistics(new PlayerStatistics(8, 15, 3, 0, 18));

        // Create Players for Liverpool
        Player salah = new Player("Mohamed Salah", 31, "Winger", 11, "Egyptian");
        salah.setTeam(liverpool);
        salah.setStatistics(new PlayerStatistics(20, 10, 1, 0, 22));

        Player vanDijk = new Player("Virgil van Dijk", 32, "Defender", 4, "Dutch");
        vanDijk.setTeam(liverpool);
        vanDijk.setStatistics(new PlayerStatistics(2, 1, 4, 0, 20));

        // Create Players for Real Madrid
        Player benzema = new Player("Karim Benzema", 36, "Striker", 9, "French");
        benzema.setTeam(realMadrid);
        benzema.setStatistics(new PlayerStatistics(18, 8, 2, 0, 19));

        Player modric = new Player("Luka Modric", 38, "Midfielder", 10, "Croatian");
        modric.setTeam(realMadrid);
        modric.setStatistics(new PlayerStatistics(3, 12, 3, 0, 21));

        // Create Players for Barcelona
        Player lewandowski = new Player("Robert Lewandowski", 35, "Striker", 9, "Polish");
        lewandowski.setTeam(barcelona);
        lewandowski.setStatistics(new PlayerStatistics(22, 4, 1, 0, 20));

        Player pedri = new Player("Pedri", 21, "Midfielder", 8, "Spanish");
        pedri.setTeam(barcelona);
        pedri.setStatistics(new PlayerStatistics(4, 8, 2, 0, 18));

        playerRepository.save(haaland);
        playerRepository.save(debruyne);
        playerRepository.save(salah);
        playerRepository.save(vanDijk);
        playerRepository.save(benzema);
        playerRepository.save(modric);
        playerRepository.save(lewandowski);
        playerRepository.save(pedri);

        // Create Matches
        Match match1 = new Match(LocalDateTime.now().plusDays(7), manCity, liverpool, premierLeague, 1);
        match1.setStatus("SCHEDULED");

        Match match2 = new Match(LocalDateTime.now().minusDays(3), realMadrid, barcelona, laLiga, 1);
        match2.setStatus("FINISHED");
        match2.setHomeTeamScore(2);
        match2.setAwayTeamScore(1);

        Match match3 = new Match(LocalDateTime.now().plusDays(14), manCity, realMadrid, null, 1);
        match3.setStatus("SCHEDULED");

        matchRepository.save(match1);
        matchRepository.save(match2);
        matchRepository.save(match3);

        System.out.println("Sample data initialized successfully!");
    }
}
