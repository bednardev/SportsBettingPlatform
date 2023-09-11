package Models.SportsOdds;

import Models.Bet;
import Models.Odds;

import java.util.List;

public class TennisOdds extends Odds {

    private float homeTeamAcesOdds; //odd that home player will have over 8.5 service aces in a game
    private float awayTeamAcesOdds; //odd that away player will have over 8.5 service aces in a game

    @Override
    public List<Bet> getOdds() {
        return List.of(
                new Bet("1", super.getHomeTeamOdds()),
                new Bet("2", super.getAwayTeamOdds()),
                new Bet("1 over 8.5 aces", homeTeamAcesOdds),
                new Bet("2 over 8.5 aces", awayTeamAcesOdds)
        );
    }

}
