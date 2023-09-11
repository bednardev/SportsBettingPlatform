package Models;

import Models.MatchResult;
import Models.SportsOdds.BasketballOdds;
import Models.SportsOdds.SoccerOdds;
import Models.SportsOdds.TennisOdds;
import Models.Team;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

import static Models.Discipline.*;

@Getter
@Setter
public class Match {
    private long id;
    private Discipline discipline;
    private Team homeTeam;
    private Team awayTeam;
    private Instant date;
    private MatchResult result;
    private Odds odds;

    public Match(Discipline discipline, Team homeTeam, Team awayTeam, Instant date) {
        this.discipline = discipline;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        switch (discipline) {
            case SOCCER:
                odds = new SoccerOdds();
                break;
            case BASKETBALL:
                odds = new BasketballOdds();
                break;
            case TENNIS:
                odds = new TennisOdds();
                break;
        }
    }
}