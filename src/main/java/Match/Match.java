package Match;

import Coupon.Bet;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
 class Match {
    private long id;
    private Discipline discipline;
    private Team homeTeam;
    private Team awayTeam;
    private Instant date;
    private MatchResult result;
    private List<Bet> odds;
    private OddsFactory oddsFactory;

     Match(Discipline discipline, Team homeTeam, Team awayTeam, Instant date) {
        this.discipline = discipline;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        odds = oddsFactory.createOdds(discipline);
    }
}