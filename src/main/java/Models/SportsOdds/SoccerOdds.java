package Models.SportsOdds;

import Models.Bet;
import Models.Odds;

import java.util.List;

public class SoccerOdds implements Odds {
    private float homeTeamOdd; //odd that home team/player will win
    private float awayTeamOdd; //odd that away team/player will win
    private float drawOdd; //odd that there will be a draw
    private float homeTeamCornersOdd; //odd that home team will have over 5.5 corner kicks in a game
    private float awayTeamCornersOdd; //odd that home team will have over 5.5 corner kicks in a game

    @Override
    public List<Bet> getOdds() {
        return List.of(
                new Bet("1", homeTeamOdd),
                new Bet("X", drawOdd),
                new Bet("2", awayTeamOdd),
                new Bet("1 over 5.5 corners", homeTeamCornersOdd),
                new Bet("2 over 5.5 corners", awayTeamCornersOdd)
        );
    }
}
