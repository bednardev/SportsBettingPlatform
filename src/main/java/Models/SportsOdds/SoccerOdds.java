package Models.SportsOdds;

import Models.Bet;
import Models.Odds;

import java.util.List;

public class SoccerOdds extends Odds {
    private float drawOdds; //odd that there will be a draw
    private float homeTeamCornersOdds; //odd that home team will have over 5.5 corner kicks in a game
    private float awayTeamCornersOdds; //odd that home team will have over 5.5 corner kicks in a game

    @Override
    public List<Bet> getBets() {
        return List.of(
                new Bet("1", super.getHomeTeamOdds()),
                new Bet("X", drawOdds),
                new Bet("2", super.getAwayTeamOdds()),
                new Bet("1 over 5.5 corners", homeTeamCornersOdds),
                new Bet("2 over 5.5 corners", awayTeamCornersOdds)
        );
    }
}
