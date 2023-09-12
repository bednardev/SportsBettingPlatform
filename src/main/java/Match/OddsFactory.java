package Match;

import Coupon.Bet;
import Match.SportsOdds.BasketballOdds;
import Match.SportsOdds.SoccerOdds;
import Match.SportsOdds.TennisOdds;
import java.util.List;
public class OddsFactory {
    private BasketballOdds basketballOdds;
    private SoccerOdds soccerOdds;
    private TennisOdds tennisOdds;
    private Discipline discipline;
    private List<Bet> odds;

    public List<Bet> createOdds(Discipline discipline) {
        return switch (discipline) {
            case SOCCER -> soccerOdds.getOdds();
            case BASKETBALL -> basketballOdds.getOdds();
            case TENNIS -> tennisOdds.getOdds();
        };
    }
}
