package Models;

import Models.SportsOdds.BasketballOdds;
import Models.SportsOdds.SoccerOdds;
import Models.SportsOdds.TennisOdds;
import java.util.List;
public class OddsFactory {
    private BasketballOdds basketballOdds;
    private SoccerOdds soccerOdds;
    private TennisOdds tennisOdds;
    private Discipline discipline;
    private List<Bet> odds;

    public List<Bet> createOdds(Discipline discipline) {
        switch (discipline) {
            case SOCCER:
                return soccerOdds.getOdds();
            case BASKETBALL:
                return basketballOdds.getOdds();
            case TENNIS:
                return tennisOdds.getOdds();
            default:
                return null;
        }
    }
}
