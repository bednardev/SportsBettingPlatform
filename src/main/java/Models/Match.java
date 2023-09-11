package Models;

import Models.MatchResult;
import Models.SportsOdds.BasketballOdds;
import Models.SportsOdds.SoccerOdds;
import Models.SportsOdds.TennisOdds;
import Models.Team;
import lombok.Getter;
import lombok.Setter;
import org.springframework.aop.target.dynamic.BeanFactoryRefreshableTargetSource;

import java.time.Instant;
import java.util.List;

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
    private List<Bet> odds;
    private BasketballOdds basketballOdds;
    private SoccerOdds soccerOdds;
    private TennisOdds tennisOdds;

    public Match(Discipline discipline, Team homeTeam, Team awayTeam, Instant date) {
        this.discipline = discipline;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        switch (discipline) {
            case SOCCER:
                odds = soccerOdds.getBets();
                break;
            case BASKETBALL:
                odds = basketballOdds.getBets();
                break;
            case TENNIS:
                odds = tennisOdds.getBets();
                break;
        }
    }
}