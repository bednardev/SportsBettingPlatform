package Models.SportsOdds;

import Models.Bet;
import Models.Odds;

import java.util.List;

public class BasketballOdds extends Odds {
    private float homeTeamPoints;  //odd that home team will have over 80.5 points in a game
    private float awayTeamPoints;  //odd that away team will have over 80.5 points in a game

    @Override
    public List<Bet> getOdds() {
        return List.of(
                new Bet("1", super.getHomeTeamOdds()),
                new Bet("2", super.getAwayTeamOdds()),
                new Bet("1 over 80.5 points", homeTeamPoints),
                new Bet("2 over 80.5 points", awayTeamPoints)
        );
    }
}
