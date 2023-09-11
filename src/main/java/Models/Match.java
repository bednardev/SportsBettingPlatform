package Models;

import Models.SportsOdds.BasketballOdds;
import Models.SportsOdds.SoccerOdds;
import Models.SportsOdds.TennisOdds;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class Match {
    private long id;
    private Discipline discipline;
    private Team homeTeam;
    private Team awayTeam;
    private Instant date;
    private MatchResult result;
    private List<Bet> odds;
    private OddsFactory oddsFactory;

    public Match(Discipline discipline, Team homeTeam, Team awayTeam, Instant date) {
        this.discipline = discipline;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        odds = oddsFactory.createOdds(discipline);
    }
}