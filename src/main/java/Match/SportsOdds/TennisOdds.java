package Match.SportsOdds;

import Coupon.Bet;
import Match.Odds;

import java.util.List;

public class TennisOdds implements Odds {
    private float homeTeamOdd; //odd that home team/player will win
    private float awayTeamOdd; //odd that away team/player will win

    private float homeTeamAcesOdd; //odd that home player will have over 8.5 service aces in a game
    private float awayTeamAcesOdd; //odd that away player will have over 8.5 service aces in a game

    @Override
    public List<Bet> getOdds() {
        return List.of(
                new Bet("1", homeTeamOdd),
                new Bet("2", awayTeamOdd),
                new Bet("1 over 8.5 aces", homeTeamAcesOdd),
                new Bet("2 over 8.5 aces", awayTeamAcesOdd)
        );
    }

}
